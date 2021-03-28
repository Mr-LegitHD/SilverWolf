package lu.silverwolf;

import lu.silverwolf.infos.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Report extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {

        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        final Message message = event.getMessage();
        final List<Member> members = message.getMentionedMembers();
        final Member member = members.get(0);
        final Guild guild = member.getGuild();
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        String query = String.join(" ", (CharSequence[]) Arrays.copyOfRange(args, 2, args.length));
        if (args[0].equalsIgnoreCase(Secrets.prefix + "report")) {

            //Embedbuilder
            final EmbedBuilder report = new EmbedBuilder();
            event.getMessage().delete().queue();
            report.setTitle("❗ New Report");
            report.addField("**Reported User**",member.getUser().getAsTag(), false);
            report.addField("**Reason**",query, false);
            report.addField("**Reported by**",event.getAuthor().getAsTag(), false);
            report.setThumbnail("https://i.imgur.com/r2rp4sY.png");
            report.setColor(Color.ORANGE);
            report.setTimestamp(Instant.now());
            event.getGuild().getTextChannelById("825451882599546940").sendMessage(report.build()).queue();
            report.clear();


        }
    }
}

