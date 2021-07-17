package lu.silverwolf.Log;

import lu.silverwolf.Private.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.awt.*;
import java.time.Instant;

public class Logging extends ListenerAdapter {

    //message delete
    @Override
    public void onGuildMessageDelete(final GuildMessageDeleteEvent event) {
        String channelid = event.getChannel().getId();
        if (event.getChannel().getId().equals("829358295785013289")) return;
        if (event.getChannel().getId().equals("827456453065179156")) return;
        if (event.getChannel().getId().equals("803350440330264666")) return;
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
    //Voice Join
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
        event.getJDA().getGuildById(Secrets.Guildid).getTextChannelById("830050961140482070").sendMessage(info.build()).queue();
        info.clear();


    }
    //Voice Leave
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
        event.getJDA().getGuildById(Secrets.Guildid).getTextChannelById("830050961140482070").sendMessage(info.build()).queue();
        info.clear();

    }
    //message send
    public void onGuildMessageReceived (final GuildMessageReceivedEvent event) {
        String channelid = event.getChannel().getId();
        String member = event.getMessage().getAuthor().getAsTag();
        String message = event.getMessage().getContentRaw();
        String messageid = event.getMessageId();
        String jumpurl = event.getMessage().getJumpUrl();

        if (event.getChannel().getId().equals("829358295785013289")) return;
        if (event.getChannel().getId().equals("830040805489901608")) return;
        if (event.getChannel().getId().equals("827456453065179156")) return;
        if (event.getChannel().getId().equals("803350440330264666")) return;
        if (event.getMessage().getAuthor().getId().equals("752817457231560737")) return;
        final EmbedBuilder info = new EmbedBuilder();
        info.setTitle("\u2728 Log | Message Send");
        info.addField("**Member **",member,false);
        info.addField("**Channel **","<#"+channelid+">",false);
        info.addField("**Message ID **",messageid,false);
        info.addField("**Message **",message,false);
        info.addField("**Click **","[Click to jump to message]("+jumpurl+")",false);
        info.setFooter("User ID | "+event.getMember().getUser().getId());
        info.setTimestamp(Instant.now());
        info.setColor(new Color(88,167,233));
        event.getJDA().getGuildById(Secrets.Guildid).getTextChannelById("830040805489901608").sendMessage(info.build()).queue();
        info.clear();

    }
    //message update
    public void onGuildMessageUpdate (final GuildMessageUpdateEvent event) {
        String channelid = event.getChannel().getId();
        String member = event.getMember().getUser().getAsMention();
        String message = event.getMessage().getContentRaw();
        String messageid = event.getMessageId();

        if (event.getChannel().getId().equals("829358295785013289")) return;
        if (event.getChannel().getId().equals("830040805489901608")) return;
        if (event.getChannel().getId().equals("827456453065179156")) return;
        if (event.getChannel().getId().equals("803350440330264666")) return;
        if (event.getMessage().getAuthor().getId().equals("752817457231560737")) return;
        final EmbedBuilder info = new EmbedBuilder();
        info.setTitle("\u2728 Log | Message Updated");
        info.addField("**Member **",member,false);
        info.addField("**Channel **","<#"+channelid+">",false);
        info.addField("**Message ID **",messageid,false);
        info.addField("**New Message **",message,false);
        info.setFooter("System");
        info.setTimestamp(Instant.now());
        info.setColor(new Color(88,167,233));
        event.getJDA().getGuildById(Secrets.Guildid).getTextChannelById("830040805489901608").sendMessage(info.build()).queue();
        info.clear();

    }
    //member moved
    public void onGuildVoiceMove (final GuildVoiceMoveEvent event) {
        String member = event.getMember().getUser().getAsMention();
        String newchannel = event.getNewValue().getName();
        String oldchannel = event.getOldValue().getName();

        final EmbedBuilder info = new EmbedBuilder();
        info.setTitle("\u2728 Log | Member Moved");
        info.addField("**Member **",member,false);
        info.addField("**New Channel**", newchannel,false);
        info.addField("**Old Channel**", oldchannel,false);
        info.setFooter("System");
        info.setTimestamp(Instant.now());
        info.setColor(new Color(234,147,14));
        event.getJDA().getGuildById(Secrets.Guildid).getTextChannelById("830050961140482070").sendMessage(info.build()).queue();
        info.clear();

    }
}
