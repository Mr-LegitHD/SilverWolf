// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf.Admin;

import java.text.DateFormat;
import java.awt.Color;
import java.time.temporal.TemporalAccessor;
import java.time.Instant;
import net.dv8tion.jda.api.EmbedBuilder;
import lu.silverwolf.infos.Secrets;
import java.util.Date;
import java.text.SimpleDateFormat;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter
{
    public static JDA jda;
    
    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "ping")) {
            final EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\u2728 Universe | Ping");
            info.setDescription("My Ping is **" + event.getJDA().getGatewayPing() + "**ms!");
            info.setFooter("System");
            info.setTimestamp(Instant.now());
            info.setColor(Color.ORANGE);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            System.out.println(dateFormat.format(newDate) + " Command -ping got used by " + event.getAuthor().getName());
        }
    }
}
