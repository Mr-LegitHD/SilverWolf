//
// Decompiled by Procyon v0.5.36
//

package lu.silverwolf.listeners;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AntiDankmemer extends ListenerAdapter
{
    public static JDA jda;

    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        TextChannel channel = event.getChannel();
        if (event.getMessage().getAuthor().getId().equals("270904126974590976")) {
            if (!channel.getId().equals("752808524555223060")) {
                event.getMessage().delete().queue();
                return;
            }

        } return;
    }
}
