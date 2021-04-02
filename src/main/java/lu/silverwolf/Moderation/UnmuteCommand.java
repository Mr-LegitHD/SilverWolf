// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf.Moderation;

import net.dv8tion.jda.api.entities.Guild;
import java.util.List;
import net.dv8tion.jda.api.entities.Message;
import java.text.DateFormat;
import java.awt.Color;
import java.time.Instant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.Member;
import lu.silverwolf.Private.Secrets;
import net.dv8tion.jda.api.Permission;
import java.util.Date;
import java.text.SimpleDateFormat;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class UnmuteCommand extends ListenerAdapter
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
        if (args[0].equalsIgnoreCase(Secrets.prefix + "unmute")) {
            event.getMessage().delete().queue();
            final Message message = event.getMessage();
            final List<Member> members = message.getMentionedMembers();
            if (!members.isEmpty()) {
                final Member member = members.get(0);
                final Guild guild = member.getGuild();
                final Role role = guild.getRolesByName("muted", true).get(0);
                member.getGuild().removeRoleFromMember(member, role).queue(unused -> {
                });

            final EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("\u2728 Universe | Mute");
            mute.setDescription("Member " + args[1] + " got unmuted by " + event.getAuthor().getAsMention());
            mute.setFooter("ID: "+member.getId());
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.GREEN);
            event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
            mute.clear();
            System.out.println(dateFormat.format(newDate) + " Command -unmute got used by " + event.getAuthor().getName());

                //Send Direct Message
                member.getUser().openPrivateChannel().queue((channel) -> {
                    mute.setTitle("\u2728 Universe | Unmute");
                    mute.setDescription("You got unmuted ");
                    mute.setFooter("ID: " + member.getId());
                    mute.setTimestamp(Instant.now());
                    mute.setColor(Color.GREEN);
                    channel.sendMessage(mute.build()).queue();
                    mute.clear();
                });
        }
        }
    }
}
