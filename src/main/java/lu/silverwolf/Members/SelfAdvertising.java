// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf.Members;

import lu.silverwolf.Private.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class SelfAdvertising extends ListenerAdapter
{
    public static JDA jda;
    
    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "ads")) {
            final EmbedBuilder info = new EmbedBuilder();
            event.getMessage().delete().queue();
            info.setTitle("\u2728 Self-advertising");
            info.setDescription("To get acces to <#752811933178003477> just dm an Admin and tell him what you want to advertise. Nothing more \uD83D\uDE00 ");
            info.setFooter("System");
            info.setTimestamp(Instant.now());
            info.setColor(Color.ORANGE);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            System.out.println(dateFormat.format(newDate) + " Command -ads got used by " + event.getAuthor().getName());
        }
    }
}
