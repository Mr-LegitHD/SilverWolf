// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf;

import lu.silverwolf.infos.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Teamlist extends ListenerAdapter
{
    public static JDA jda;
    
    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "teamlist")) {
            final EmbedBuilder info = new EmbedBuilder();
            event.getMessage().delete().queue();
            info.setTitle("\u2728 Our Team");
           /* Owner */ info.addField("Owner","<@750768307333890178>", false);
           /* Admin */ info.addField("Admin","<@!747514278071894086>", false);
           /* Event-Manager */ info.addField("Event-Manager","<@!483957638212747264>", false);
           /* Head-Mod */ info.addField("Head-Mod","<@524581298875138098>", false);
           /* Mod */ info.addField("Mod","<@745273256973566059>\n<@!483957638212747264>\n<@505024573448912898>\n<@343044879418392576>\n<@524581298875138098>", false);
           /* Bot-Developer */ info.addField("Bot-Developer","<@722854351600615465>", false);
            info.setFooter("System");
            info.setThumbnail("https://i.imgur.com/ek2VZ07.png");
            info.setTimestamp(Instant.now());
            info.setColor(Color.ORANGE);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            System.out.println(dateFormat.format(newDate) + " Command -teamlist got used by " + event.getAuthor().getName());
        }
    }
}
