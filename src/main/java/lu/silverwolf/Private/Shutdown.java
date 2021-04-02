package lu.silverwolf.Private;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.tools.JavaCompiler;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Shutdown extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        User user = event.getAuthor();
        if (event.getAuthor().isBot()) return;
        if(!event.getAuthor().getId().equals("766775723406524496")) return;

        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "shutdown")) {

            //Embedbuilder
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\ud83d\udcad System | Shutdown");
            info.setDescription("Bot shutting down");
            info.setFooter("System");
            info.setColor(Color.red);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            event.getMessage().delete().queue();
            event.getJDA().shutdown();
            System.exit(0);
            System.out.println(dateFormat.format(newDate) + "Bot Shutdown by " + event.getAuthor().getName());
        }
    }
}


