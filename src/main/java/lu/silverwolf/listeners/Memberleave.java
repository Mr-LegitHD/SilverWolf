package lu.silverwolf.listeners;

import java.text.DateFormat;
import java.awt.Color;
import net.dv8tion.jda.api.EmbedBuilder;

import java.time.Instant;
import java.util.Date;
import java.text.SimpleDateFormat;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
public class Memberleave extends ListenerAdapter {
    String message;
    
    public Memberleave() {
        this.message = "**[member]** left the server \u2728";
    }
    @Override
    public void onGuildMemberRemove(final GuildMemberRemoveEvent event) {
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        System.out.println(dateFormat.format(newDate) + " " + event.getUser().getName() + " left the server");
        final EmbedBuilder leave = new EmbedBuilder();
        leave.setColor(Color.ORANGE);
        leave.setFooter("System");
        leave.setDescription(this.message.replace("[member]", event.getUser().getAsTag()));
        event.getGuild().getTextChannelById("752825347866624021").sendMessage(leave.build()).queue();

    }
}
