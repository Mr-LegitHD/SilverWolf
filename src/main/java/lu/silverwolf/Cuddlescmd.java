// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf;

import java.awt.Color;
import java.time.temporal.TemporalAccessor;
import java.time.Instant;
import net.dv8tion.jda.api.EmbedBuilder;
import lu.silverwolf.infos.Secrets;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Cuddlescmd extends ListenerAdapter
{
    DateFormat dateFormat;
    Date newDate;
    
    public Cuddlescmd() {
        this.dateFormat = new SimpleDateFormat("[H:m]");
        this.newDate = new Date();
    }
    
    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
        if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            return;
        }
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "ineedcuddles")) {
            final EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\u2728 Universe | Cuddles\u2764\ud83d\ude18");
            info.setDescription("Dein Baby deen dech iwwer alles liebt w\u00e4rt dech ganz vill knuddlen wei en teddy\ud83e\uddf8 \u2764 ");
            info.setFooter("Dein Baby\u2764");
            info.setTimestamp(Instant.now());
            info.setColor(Color.magenta);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            System.out.println(this.dateFormat.format(this.newDate) + " Command -cuddles  got used by " + event.getAuthor().getName());
        }
    }
}
