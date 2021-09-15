package lu.silverwolf.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;


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

            //AutoEmbed
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("✨ Universe | Warn");
            mute.setDescription("Member " + event.getMessage().getAuthor().getAsMention() + " got warned by <@752817457231560737>" + "\nReason: Sending forbidden Links");
            mute.setFooter("ID: "+event.getMessage().getAuthor().getId());
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.RED);
            event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
            mute.clear();
        } else
        if(message.toLowerCase().contains("discord.gg/")) {
            event.getMessage().delete().queue();
            //AutoEmbed
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("✨ Universe | Warn");
            mute.setDescription("Member " + event.getMessage().getAuthor().getAsMention() + " got warned by <@752817457231560737>" + "\nReason: Sending forbidden Links");
            mute.setFooter("ID: "+event.getMessage().getAuthor().getId());
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.RED);
            event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
            mute.clear();
        } else
        if(message.toLowerCase().contains("twitch.tv")) {
            event.getMessage().delete().queue();
            //AutoEmbed
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("✨ Universe | Warn");
            mute.setDescription("Member " + event.getMessage().getAuthor().getAsMention() + " got warned by <@752817457231560737>" + "\nReason: Sending forbidden Links");
            mute.setFooter("ID: "+event.getMessage().getAuthor().getId());
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.RED);
            event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
            mute.clear();
        } else
        if(message.toLowerCase().contains("grabify.link")) {
            event.getMessage().delete().queue();
            //AutoEmbed
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("✨ Universe | Warn");
            mute.setDescription("Member " + event.getMessage().getAuthor().getAsMention() + " got warned by <@752817457231560737>" + "\nReason: Sending forbidden Links");
            mute.setFooter("ID: "+event.getMessage().getAuthor().getId());
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.RED);
            event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
            mute.clear();
        } else
        if(message.toLowerCase().contains("zzb.bz")) {
            event.getMessage().delete().queue();
            //AutoEmbed
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("✨ Universe | Warn");
            mute.setDescription("Member " + event.getMessage().getAuthor().getAsMention() + " got warned by <@752817457231560737>" + "\nReason: Sending forbidden Links");
            mute.setFooter("ID: "+event.getMessage().getAuthor().getId());
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.RED);
            event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
            mute.clear();
        } else
        if(message.toLowerCase().contains("adfoc.us")) {
            event.getMessage().delete().queue();
            //AutoEmbed
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("✨ Universe | Warn");
            mute.setDescription("Member " + event.getMessage().getAuthor().getAsMention() + " got warned by <@752817457231560737>" + "\nReason: Sending forbidden Links");
            mute.setFooter("ID: "+event.getMessage().getAuthor().getId());
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.RED);
            event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
            mute.clear();
        } else
        if(message.toLowerCase().contains("ouo.io")) {
            event.getMessage().delete().queue();
            //AutoEmbed
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("✨ Universe | Warn");
            mute.setDescription("Member " + event.getMessage().getAuthor().getAsMention() + " got warned by <@752817457231560737>" + "\nReason: Sending forbidden Links");
            mute.setFooter("ID: "+event.getMessage().getAuthor().getId());
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.RED);
            event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
            mute.clear();
        } else
        if(message.toLowerCase().contains("bc.vc")) {
            event.getMessage().delete().queue();
            //AutoEmbed
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("✨ Universe | Warn");
            mute.setDescription("Member " + event.getMessage().getAuthor().getAsMention() + " got warned by <@752817457231560737>" + "\nReason: Sending forbidden Links");
            mute.setFooter("ID: "+event.getMessage().getAuthor().getId());
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.RED);
            event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
            mute.clear();
        } else
        if(message.toLowerCase().contains("aspedrom.com")) {
            event.getMessage().delete().queue();
            //AutoEmbed
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("✨ Universe | Warn");
            mute.setDescription("Member " + event.getMessage().getAuthor().getAsMention() + " got warned by <@752817457231560737>" + "\nReason: Sending forbidden Links");
            mute.setFooter("ID: "+event.getMessage().getAuthor().getId());
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.RED);
            event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
            mute.clear();
        } else
            if(message.toLowerCase().contains("https://dlscord-app.com")) {
            event.getMessage().delete().queue();
            //AutoEmbed
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("✨ Universe | Warn");
            mute.setDescription("Member " + event.getMessage().getAuthor().getAsMention() + " got warned by <@752817457231560737>" + "\nReason: Sending forbidden Links");
            mute.setFooter("ID: "+event.getMessage().getAuthor().getId());
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.RED);
            event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
            mute.clear();
        } else
        if(message.toLowerCase().contains("gestyy.com")) {
            event.getMessage().delete().queue();
            //AutoEmbed
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("✨ Universe | Warn");
            mute.setDescription("Member " + event.getMessage().getAuthor().getAsMention() + " got warned by <@752817457231560737>" + "\nReason: Sending forbidden Links");
            mute.setFooter("ID: "+event.getMessage().getAuthor().getId());
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.RED);
            event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
            mute.clear();
        } else
        if(message.toLowerCase().contains("discord.io")) {
            event.getMessage().delete().queue();
            //AutoEmbed
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("✨ Universe | Warn");
            mute.setDescription("Member " + event.getMessage().getAuthor().getAsMention() + " got warned by <@752817457231560737>" + "\nReason: Sending forbidden Links");
            mute.setFooter("ID: "+event.getMessage().getAuthor().getId());
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.RED);
            event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
            mute.clear();
        }

    }
}

