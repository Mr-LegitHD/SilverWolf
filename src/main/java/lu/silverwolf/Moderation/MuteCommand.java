// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf.Moderation;

import net.dv8tion.jda.api.entities.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.text.DateFormat;
import java.awt.Color;
import java.time.temporal.TemporalAccessor;
import java.time.Instant;
import net.dv8tion.jda.api.EmbedBuilder;
import lu.silverwolf.infos.Secrets;
import net.dv8tion.jda.api.Permission;
import java.util.Date;
import java.text.SimpleDateFormat;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MuteCommand extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        User user = event.getAuthor();

        if (event.getAuthor().isBot()) {
            return;
        }
        if (!event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
            return;
        }
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "mute")) {
            String tagged = args[1];
            String query = String.join(" ", (CharSequence[]) Arrays.copyOfRange(args, 2, args.length));
            final Message message = event.getMessage();
            event.getMessage().delete().queue();
            final List<Member> members = message.getMentionedMembers();
            if (!members.isEmpty()) {
                final Member member = members.get(0);
                final Guild guild = member.getGuild();
                final Role role = guild.getRolesByName("muted", true).get(0);
                member.getGuild().addRoleToMember(member, role).queue(unused -> {


                final EmbedBuilder mute = new EmbedBuilder();
                mute.setTitle("\u2728 Universe | Mute");
                mute.setDescription("Member " + args[1] + " got muted by " + event.getAuthor().getAsMention() + "\nReason: " + query);
                mute.setFooter("ID: " + member.getId());
                mute.setTimestamp(Instant.now());
                mute.setColor(Color.RED);
                event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
                mute.clear();
                System.out.println(dateFormat.format(newDate) + " Command -mute got used by " + event.getAuthor().getName());

                        //Send Direct Message
                        member.getUser().openPrivateChannel().queue((channel) -> {
                            mute.setTitle("\u2728 Universe | Mute");
                            mute.setDescription("You got muted by " + event.getAuthor().getAsMention() + " for the Reason **" + query + "**");
                            mute.setFooter("ID: " + member.getId());
                            mute.setTimestamp(Instant.now());
                            mute.setColor(Color.RED);
                            channel.sendMessage(mute.build()).queue();
                            channel.sendMessage("https://i.imgur.com/zAQCvlC.png").queue();
                            mute.clear();
                        });
            });
                }
            }
        }
    }

