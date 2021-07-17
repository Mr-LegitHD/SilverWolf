package lu.silverwolf.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildUnbanEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;


public class MemberBanned extends ListenerAdapter {

    @Override
    public void onGuildUnban(GuildUnbanEvent event) {
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        User member = event.getUser();

        //Embed
        final EmbedBuilder mute = new EmbedBuilder();
        mute.setTitle("\u2728 Universe | Ban");
        mute.setDescription("**"+member.getAsTag()+"** got banned");
        mute.setFooter("ID: "+member.getId());
        mute.setTimestamp(Instant.now());
        mute.setColor(Color.RED);
        event.getGuild().getTextChannelById("752818053410193510").sendMessage(mute.build()).queue();
        mute.clear();
        System.out.println(dateFormat.format(newDate) + "Member banned with the id"+member.getId());


    }
}


