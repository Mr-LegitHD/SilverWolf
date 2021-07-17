// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf.Moderation;

import java.util.Arrays;
import java.util.List;
import net.dv8tion.jda.api.entities.Message;
import java.text.DateFormat;
import java.awt.Color;
import java.time.Instant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import lu.silverwolf.Private.Secrets;
import net.dv8tion.jda.api.Permission;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BanCommand extends ListenerAdapter
{
    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        if (event.getAuthor().isBot()) {
            return;
        }
        if (!event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
            return;
        }
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "ban")) {
            if (args.length < 3) {
                event.getMessage().delete().queue();
                //Embed Builder
                EmbedBuilder mute = new EmbedBuilder();
                mute.setTitle("Error");
                mute.setDescription("Correct Usage: -ban <@user> <Reason>");
                mute.setFooter("System");
                mute.setTimestamp(Instant.now());
                mute.setColor(Color.RED);
                event.getChannel().sendMessage(mute.build()).queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                mute.clear();
                return;
            }
            String query = String.join(" ", (CharSequence[]) Arrays.copyOfRange(args, 2, args.length));
            event.getMessage().delete().queue();
            final Message message = event.getMessage();
            //Get Member
            final List<Member> members = message.getMentionedMembers();
            if (!members.isEmpty()) {
                final Member member = members.get(0);
                //Ban Member
                event.getGuild().ban(member, 1,query).queue();

                final EmbedBuilder mute = new EmbedBuilder();
                mute.setTitle("\u2728 Universe | Ban");
                mute.setDescription("Member " + args[1] + " got banned by " + event.getAuthor().getAsMention() + "\nReason: " + query);
                mute.setFooter("ID: "+member.getId());
                mute.setTimestamp(Instant.now());
                mute.setColor(Color.RED);
                event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
                event.getGuild().getTextChannelById("793554880273973298").sendMessage("Member **"+member.getUser().getAsTag()+"** got banned for **"+query+"**").queue();
                mute.clear();
                System.out.println(dateFormat.format(newDate) + " Command -ban got used by " + event.getAuthor().getName());
                //Send Direct Message
                member.getUser().openPrivateChannel().queue((channel) -> {
                    mute.setTitle("\u2728 Universe | Ban");
                    mute.setDescription("You got banned by " + event.getAuthor().getAsMention() + " for the Reason **" + query + "**");
                    mute.setFooter("ID: " + member.getId());
                    mute.setTimestamp(Instant.now());
                    mute.setColor(Color.RED);
                    channel.sendMessage(mute.build()).queue();
                    mute.clear();
                });
            }
        }
    }
}
