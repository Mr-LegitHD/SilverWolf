// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf.Admin;

import java.text.DateFormat;
import java.awt.Color;
import net.dv8tion.jda.api.EmbedBuilder;
import lu.silverwolf.infos.Secrets;
import java.util.Date;
import java.text.SimpleDateFormat;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Embed extends ListenerAdapter
{
    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
        if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            return;
        }
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        if (args[0].equalsIgnoreCase(Secrets.prefix + "embed")) {
            final EmbedBuilder info = new EmbedBuilder();
            info.setTitle(args[1]);
            info.setDescription(args[2]);
            info.setFooter("System");
            info.setColor(Color.orange);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            System.out.println(dateFormat.format(newDate) + " Command -embed got used by " + event.getAuthor().getName());
        }
    }
}
