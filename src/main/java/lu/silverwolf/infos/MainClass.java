package lu.silverwolf.infos;

import javax.security.auth.login.LoginException;
import lu.silverwolf.*;
import lu.silverwolf.listeners.*;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

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
        builder.addEventListeners(new Cuddlescmd());
        builder.addEventListeners(new Uptime());
        builder.addEventListeners(new Userinfo());
        builder.addEventListeners(new MemberUnbanned());
        builder.addEventListeners(new OneWordStory());
        builder.addEventListeners(new SelfAdvertising());
        builder.addEventListeners(new Teamlist());
        builder.addEventListeners(new Vote());
        builder.addEventListeners(new AntiDankmemer());
        builder.build();
    }
}
