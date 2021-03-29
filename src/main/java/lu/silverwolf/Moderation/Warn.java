package lu.silverwolf.Moderation;

import lu.silverwolf.infos.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Warn extends ListenerAdapter {
    public Warn() {
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (!event.getAuthor().isBot()) {
            String[] args = event.getMessage().getContentRaw().split("\\s+");
            if (args[0].equalsIgnoreCase(Secrets.prefix + "warn")) { ;
                if(!event.getGuild().getId().equals("752664145580654632")) return;

                if (!event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
                    event.getChannel().sendMessage("You need the `Ban Members` permission to use this command").queue();

                    return;
                }
                if (args.length < 2) {
                    event.getMessage().delete().queue();
                    //Embed Builder
                    EmbedBuilder mute = new EmbedBuilder();
                    mute.setTitle("Error");
                    mute.setDescription("Correct Usage: -warn <@user> <Reason>");
                    mute.setFooter("System");
                    mute.setTimestamp(Instant.now());
                    mute.setColor(Color.RED);
                    event.getChannel().sendMessage(mute.build()).queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                    mute.clear();
                } else
                if (args.length < 3) {
                    event.getMessage().delete().queue();
                    //Embed Builder
                    EmbedBuilder mute = new EmbedBuilder();
                    mute.setTitle("Error");
                    mute.setDescription("Correct Usage: -warn <@user> <Reason>");
                    mute.setFooter("System");
                    mute.setTimestamp(Instant.now());
                    mute.setColor(Color.RED);
                    event.getChannel().sendMessage(mute.build()).queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                    mute.clear();
                    return;
                }
                String query = String.join(" ", (CharSequence[])Arrays.copyOfRange(args, 2, args.length));
                Message message = event.getMessage();
                List<Member> members = message.getMentionedMembers();
                event.getMessage().delete().queue();
                if (!members.isEmpty()) {
                    Member member1 = (Member) members.get(0);


                    EmbedBuilder mute = new EmbedBuilder();
                    mute.setTitle("✨ Universe | Warn");
                    mute.setDescription("Member " + args[1] + " got warned by " + event.getAuthor().getAsMention() + "\nReason: " + query);
                    mute.setFooter("ID: "+member1.getId());
                    mute.setTimestamp(Instant.now());
                    mute.setColor(Color.RED);
                    event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
                    mute.clear();
                    System.out.println(dateFormat.format(newDate) + " Command -warn got used by " + event.getAuthor().getName());
                    //Send Direct Message
                    member1.getUser().openPrivateChannel().queue((channel) -> {
                        mute.setTitle("\u2728 Universe | Warn");
                        mute.setDescription("You got warned by " + event.getAuthor().getAsMention() + " for the Reason **" + query + "**");
                        mute.setFooter("ID: " + member1.getId());
                        mute.setTimestamp(Instant.now());
                        mute.setColor(Color.RED);
                        channel.sendMessage(mute.build()).queue();
                        mute.clear();
                    });
                    }
                }
            }


        }
    }

