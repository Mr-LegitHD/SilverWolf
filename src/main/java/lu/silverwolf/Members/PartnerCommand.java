package lu.silverwolf.Members;

import lu.silverwolf.Private.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class PartnerCommand extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "partner")) {
            final EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\u2728 Partner");
            info.setDescription("Hello future partners :blob_aww: , if you want to partner your server with our you just need to meet this few requirements:\n" +
                    "- Your server must have at least 500 users\n" +
                    "- Your server must not contain any NSFW content\n" +
                    "\n" +
                    "so you see it's pretty easy. If you meet these requirements you can just DM a @Partner-Manager and you're good :smile: :heart:");
            info.setFooter("System");
            info.setTimestamp(Instant.now());
            info.setColor(Color.ORANGE);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            System.out.println(dateFormat.format(newDate) + " Command -partner got used by " + event.getAuthor().getName());
        }
    }
}
