// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf.Help;

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

public class InfoCommand extends ListenerAdapter
{
    public static JDA jda;
    
    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        if (args[0].equalsIgnoreCase(Secrets.prefix + "info")) {
            final EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\u2728 Universe | Informations");
            info.setDescription("Bot by Mr_Legit HD#3358 \n**Library**: JDA \n**Prefix**: - \n[Website](https://www.gino-cicci.social/)");
            info.setFooter("System");
            info.setTimestamp(Instant.now());
            info.setColor(Color.green);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            System.out.println(dateFormat.format(newDate) + " Command -info got used by " + event.getAuthor().getName());
        }
    }
}
