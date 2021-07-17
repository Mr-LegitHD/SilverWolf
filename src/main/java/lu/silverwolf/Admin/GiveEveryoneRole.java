// 
// Decompiled by Procyon v0.5.36
// 

package lu.silverwolf.Admin;

import lu.silverwolf.Private.Secrets;
import lu.silverwolf.infos.Colors;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.cache.MemberCacheView;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class GiveEveryoneRole extends ListenerAdapter{

    private final String memberRoleId = "752666816597459034";

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (!Objects.requireNonNull(event.getMember()).hasPermission(Permission.ADMINISTRATOR))
            return;

        final String contentRaw = event.getMessage().getContentRaw();
        if (contentRaw.startsWith("-giveMemberRole")) {
            final Guild guild = event.getGuild();
            final TextChannel channel = event.getChannel();
            final Role memberRole = guild.getRoleById(memberRoleId);

            if (memberRole == null) {
                channel.sendMessageFormat("Member Role is null { id : %s }", memberRoleId).queue();
                return;
            }
            channel.sendMessage("Search for members...").queue();

            final List<Member> membersWithNoRole = guild.getMembers().stream()
                    .filter(member -> !member.getUser().isBot()
                            && findRole(member, memberRoleId) == null)
                    .collect(Collectors.toList());

            channel.sendMessage("Found members with no Member role").queue();

            membersWithNoRole.forEach(member -> guild.addRoleToMember(member, memberRole).queue());

            String greenTick = "✔️";
            channel.sendMessageFormat("Added Member role to** %s **members %s", membersWithNoRole.size(), greenTick).queue();
        }
    }

    private Role findRole(Member member, String id) {
        List<Role> roles = member.getRoles();
        return roles.stream()
                .filter(role -> role.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
