// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf.Members;

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

public class Vote extends ListenerAdapter
{
    public static JDA jda;
    
    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "vote")) {
            final EmbedBuilder info = new EmbedBuilder();
            event.getMessage().delete().queue();
            info.setTitle("\u2728 Vote");
            info.setDescription("Want to vote for this server? Check out this [link](https://top.gg/servers/752664145580654632/vote)");
            info.setFooter("System");
            info.setThumbnail("https://i.imgur.com/DayFdDP.png");
            info.setTimestamp(Instant.now());
            info.setColor(Color.ORANGE);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            System.out.println(dateFormat.format(newDate) + " Command -teamlist got used by " + event.getAuthor().getName());
        }
    }
}
