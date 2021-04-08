package lu.silverwolf.Log;

import lu.silverwolf.Private.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.awt.*;
import java.time.Instant;

public class Logging extends ListenerAdapter {

    @Override
    public void onGuildMessageDelete(final GuildMessageDeleteEvent event) {
        String channelid = event.getChannel().getId();

        //Embedbuilder
        final EmbedBuilder delete = new EmbedBuilder();
        delete.setTitle("\u2728 Log | Message Deleted");
        delete.addField("**Message ID**",event.getMessageId(),false);
        delete.addField("**Channel ID**","<#"+channelid+">",false);
        delete.setFooter("System");
        delete.setTimestamp(Instant.now());
        delete.setColor(new Color(255,165,0));
        event.getGuild().getTextChannelById(Secrets.Log).sendMessage(delete.build()).queue();
        delete.clear();


    }
    public void onGuildVoiceJoin (final GuildVoiceJoinEvent event) {
        String channel = event.getChannelJoined().getName();
        String member = event.getEntity().getAsMention();
        int members = event.getNewValue().getMembers().size();

        final EmbedBuilder info = new EmbedBuilder();
        info.setTitle("\u2728 Log | Voice Join");
        info.addField("**Member **",member,false);
        info.addField("**Voicechannel **",channel,false);
        info.addField("**Members **", String.valueOf(members)+"/"+event.getNewValue().getUserLimit(),false);
        info.setFooter("System");
        info.setTimestamp(Instant.now());
        info.setColor(new Color(14,255,0));
        event.getJDA().getGuildById(Secrets.Guildid).getTextChannelById(Secrets.Log).sendMessage(info.build()).queue();
        info.clear();


    }
    public void onGuildVoiceLeave (final GuildVoiceLeaveEvent event) {
        String channel = event.getChannelLeft().getName();
        String member = event.getEntity().getAsMention();
        int dd = event.getOldValue().getMembers().size();

        final EmbedBuilder info = new EmbedBuilder();
        info.setTitle("\u2728 Log | Voice Leave");
        info.addField("**Member **",member,false);
        info.addField("**Voicechannel **",channel,false);
        info.setFooter("System");
        info.setTimestamp(Instant.now());
        info.setColor(new Color(255,0,0));
        event.getJDA().getGuildById(Secrets.Guildid).getTextChannelById(Secrets.Log).sendMessage(info.build()).queue();
        info.clear();

    }
}
