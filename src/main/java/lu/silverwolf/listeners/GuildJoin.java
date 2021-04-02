// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf.listeners;

import java.text.DateFormat;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import java.util.Collection;
import java.awt.Color;
import net.dv8tion.jda.api.EmbedBuilder;
import java.util.Date;
import java.text.SimpleDateFormat;

import net.dv8tion.jda.api.events.guild.GuildUnbanEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildJoin extends ListenerAdapter
{
    String message;
    public GuildJoin() {
        this.message = "Welcome **[member]** to The New Universe, you're the **[count]** \u2728 ";
    }
    @Override
    public void onGuildMemberJoin(final GuildMemberJoinEvent event) {
        int guildcount = event.getGuild().getMemberCount();

        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        System.out.println(dateFormat.format(newDate) + " " + event.getMember().getUser().getName() + " joined and got his role");
        final EmbedBuilder join = new EmbedBuilder();
        join.setColor(Color.CYAN.getRGB());
        join.setTitle("**New Member**");
        join.setFooter("System");
        join.setThumbnail(event.getUser().getAvatarUrl());
        join.setDescription("Welcome **"+event.getUser().getAsTag()+"** to the Server, you're the **"+guildcount+"**th Member \u2728 ");
        event.getGuild().getTextChannelById("752814038819405864").sendMessage(join.build()).queue();
        event.getGuild().modifyMemberRoles(event.getMember(), event.getGuild().getRolesByName("Member", true)).complete();

        //Send Direct Message
        event.getUser().openPrivateChannel().queue((channel) -> {
            channel.sendMessage("Hello and welcome to **The Great Universe** Server. Enjoy our community and our daily nitro giveaways <3 ").queue();
            System.out.println("Private Message send successfully");
        });
    }
}
