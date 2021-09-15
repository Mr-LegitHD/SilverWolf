package lu.silverwolf.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

public class Suggestions extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if (!event.getChannel().getId().equals("780843082983145522")) return;
        String[] args = event.getMessage().getContentRaw().split("");

        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        String query = String.join("", (CharSequence[]) Arrays.copyOfRange(args, 0, args.length));

            //Embed Builder
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\ud83d\udcad **Suggestion by** " + event.getMessage().getAuthor().getAsTag());
            info.setDescription(query);
            info.setColor(new Color(0, 255, 247));
            info.setFooter("System");
            info.setTimestamp(Instant.now());
            event.getChannel().sendMessage(info.build()).queue(message -> {
                message.addReaction(":upvote:767349104728211517").queue();
                message.addReaction(":downvote:767349118418288640").queue();
            });
            info.clear();
            event.getMessage().delete().queue();
            System.out.println(dateFormat.format(newDate) + " Command +suggestion got used by " + event.getAuthor().getName());


    }
}
