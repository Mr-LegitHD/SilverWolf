// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf.Admin;

import lu.silverwolf.Private.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Giveaway extends ListenerAdapter
{
    public static JDA jda;
    
    @Override
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event) {
        //Strings
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        final String[] args = event.getMessage().getContentRaw().split("\\s+");
        String query = String.join(" ", (CharSequence[]) Arrays.copyOfRange(args, 2, args.length));
        String invite = args[1];
        if (args[0].equalsIgnoreCase(Secrets.prefix + "req")) {
            event.getMessage().delete().queue();

            if (!event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) return;
            //Embed
            final EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\uD83C\uDF89 Giveaway Requirements ");
            info.addField("**Join this Server and stay on it and write at least 1 message on it**",invite,false);
            info.addField("**Server Description**",query,false);
            info.setFooter("DM @deadAngel#9923 to get an own giveaway");
            info.setColor(Color.CYAN);
            //Bot sends message
            event.getChannel().sendMessage(info.build()).queue();
            event.getChannel().sendMessage("<@&752676919224565850> | React in <#752674765570834532> to get pinged for future giveaways").queueAfter(1, TimeUnit.SECONDS);
            info.clear();
            //Log
            System.out.println(dateFormat.format(newDate) + " Command -req got used by " + event.getAuthor().getName());
        }
    }
}
