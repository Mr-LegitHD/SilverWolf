// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf.Moderation;

import lu.silverwolf.Private.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AdsCommand extends ListenerAdapter {
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
        if (args[0].equalsIgnoreCase(Secrets.prefix + "access")) {
            String tagged = args[1];
            String query = String.join(" ", (CharSequence[]) Arrays.copyOfRange(args, 2, args.length));
            final Message message = event.getMessage();
            event.getMessage().delete().queue();
            final List<Member> members = message.getMentionedMembers();
            if (!members.isEmpty()) {
                final Member member = members.get(0);
                final Guild guild = member.getGuild();
                final Role role = guild.getRolesByName("Ads Acces", true).get(0);
                member.getGuild().addRoleToMember(member, role).queue(unused -> {


                final EmbedBuilder mute = new EmbedBuilder();
                System.out.println(dateFormat.format(newDate) + " Command -AdsAccess got used by " + event.getAuthor().getName());

            });
                }
            }
        }
    }

