// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf.Help;

import lu.silverwolf.Private.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class HelpMath extends ListenerAdapter
{
    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "math")) {
            final EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\u2728 Universe | Math Commands");
            info.setDescription("-calc | Basic calculations \n-delta | Calculate Δ for you");
            info.setFooter("System");
            info.setTimestamp(Instant.now());
            info.setColor(Color.blue);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            System.out.println(dateFormat.format(newDate) + " Command -help got used by " + event.getAuthor().getName());
        }
    }
}
