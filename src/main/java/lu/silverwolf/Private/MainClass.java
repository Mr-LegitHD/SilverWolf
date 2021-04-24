package lu.silverwolf.Private;

import javax.security.auth.login.LoginException;
import javax.swing.*;

import lu.silverwolf.Admin.Embed;
import lu.silverwolf.Admin.PingCommand;
import lu.silverwolf.ExtraChannels.Couting;
import lu.silverwolf.ExtraChannels.ExtraChains;
import lu.silverwolf.ExtraChannels.OneWordStory;
import lu.silverwolf.Help.HelpCommand;
import lu.silverwolf.Help.InfoCommand;
import lu.silverwolf.Help.ModHelp;
import lu.silverwolf.Log.Logging;
import lu.silverwolf.Members.*;
import lu.silverwolf.Moderation.*;
import lu.silverwolf.listeners.StartListener;
import lu.silverwolf.infos.Uptime;
import lu.silverwolf.listeners.*;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.sharding.DefaultShardManager;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;

public class MainClass {
    public static JDA jda;

    public static void main(final String[] args) throws LoginException {
        //Starting Up
        final JDABuilder builder = JDABuilder.createDefault(Secrets.TOKENTest);
        builder.setAutoReconnect(true);
        builder.setActivity(Activity.watching("to the Universe \u2728"));
        builder.setStatus(OnlineStatus.ONLINE);

        //Gateaway
        for (final GatewayIntent gatewayIntent : GatewayIntent.values()) {
            builder.enableIntents(gatewayIntent, new GatewayIntent[0]);
        }
        //Listeners
        builder.addEventListeners(new StartListener());
       // builder.addEventListeners(new Changelog());
        builder.addEventListeners(new GuildJoin());
        builder.addEventListeners(new Memberleave());
        builder.addEventListeners(new PingCommand());
        builder.addEventListeners(new HelpCommand());
        builder.addEventListeners(new InfoCommand());
        builder.addEventListeners(new MuteCommand());
        builder.addEventListeners(new UnmuteCommand());
        builder.addEventListeners(new Embed());
        builder.addEventListeners(new KickCommand());
        builder.addEventListeners(new BanCommand());
        builder.addEventListeners(new ModHelp());
        builder.addEventListeners(new Automod());
        builder.addEventListeners(new Clear());
        builder.addEventListeners(new Warn());
        builder.addEventListeners(new Uptime());
        builder.addEventListeners(new Userinfo());
        builder.addEventListeners(new MemberUnbanned());
        builder.addEventListeners(new OneWordStory());
        builder.addEventListeners(new SelfAdvertising());
        builder.addEventListeners(new Vote());
        builder.addEventListeners(new AntiDankmemer());
        builder.addEventListeners(new AdsCommand());
        builder.addEventListeners(new Report());
        builder.addEventListeners(new PartnerCommand());
        builder.addEventListeners(new Shutdown());
        builder.addEventListeners(new Couting());
        builder.addEventListeners(new ExtraChains());
        builder.addEventListeners(new Logging());
        //builder.addEventListeners(new GuildMessageReactionAdd());
        builder.build();
    }
}
