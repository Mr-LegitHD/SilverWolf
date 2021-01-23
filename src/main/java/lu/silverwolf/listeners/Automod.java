package lu.silverwolf.listeners;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Automod extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;
        if (!event.getGuild().getId().equals("752664145580654632")) return;
        //#self-advertising
        if (event.getChannel().getId().equals("752811933178003477")) return;
        if(event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) return;

        String message = event.getMessage().getContentRaw();
        if(message.toLowerCase().contains("https://discord.gg/")) {
            event.getMessage().delete().queue();
        } else
        if(message.toLowerCase().contains("discord.gg/")) {
            event.getMessage().delete().queue();
        } else
        if(message.toLowerCase().contains("twitch.tv/")) {
            event.getMessage().delete().queue();
        } else
        if(message.toLowerCase().contains("grabify.link/")) {
            event.getMessage().delete().queue();
        } else
        if(message.toLowerCase().contains("zzb.bz/")) {
            event.getMessage().delete().queue();
        } else
        if(message.toLowerCase().contains("adfoc.us/")) {
            event.getMessage().delete().queue();
        } else
        if(message.toLowerCase().contains("ouo.io/")) {
            event.getMessage().delete().queue();
        } else
        if(message.toLowerCase().contains("bc.vc/")) {
            event.getMessage().delete().queue();
        } else
        if(message.toLowerCase().contains("aspedrom.com/")) {
            event.getMessage().delete().queue();
        } else
        if(message.toLowerCase().contains("gestyy.com")) {
            event.getMessage().delete().queue();
        }

    }
}

