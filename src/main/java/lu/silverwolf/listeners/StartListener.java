package lu.silverwolf.listeners;

import java.text.DateFormat;
import java.time.Instant;
import java.awt.Color;
import lu.silverwolf.Private.Secrets;
import lu.silverwolf.infos.Colors;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class StartListener extends ListenerAdapter
{

    @Override
    public void onReady(final ReadyEvent event) {
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();
        String botname = event.getJDA().getSelfUser().getAsTag();

        System.out.println(Colors.ANSI_RED+dateFormat.format(newDate) + Colors.ANSI_GREEN+" Logging into "+botname);
        System.out.println(Colors.ANSI_RED+dateFormat.format(newDate) + Colors.ANSI_YELLOW+" Building SilverWolf.jar");
        System.out.println(Colors.ANSI_RED+dateFormat.format(newDate) + Colors.ANSI_YELLOW+" Starting Version "+Secrets.Version);
        String out = "\n" +Colors.ANSI_RED +dateFormat.format(newDate) + Colors.ANSI_YELLOW+" Server Status: \n";
        for (final Guild g : event.getJDA().getGuilds()) {
            out = out +"- "+ g.getName() + " (" +Colors.ANSI_BLUE+ g.getMemberCount() + Colors.ANSI_YELLOW+") Members \n";
        }


        final EmbedBuilder join = new EmbedBuilder();
        join.setColor(Color.ORANGE.getRGB());
        join.setTitle("Universe \u2728");
        join.addField("**Bot Status**","Online",true);
        join.addField("**Ping**","**"+event.getJDA().getGatewayPing()+ "**ms!",true);
        join.addField("**Version**",Secrets.Version,true);
        join.setFooter("System");
        join.setTimestamp(Instant.now());
        event.getJDA().getTextChannelById("752825347866624021").sendMessage(join.build()).queue();
        System.out.println(Colors.ANSI_RED+dateFormat.format(newDate) +Colors.ANSI_YELLOW+ " Loading...Loading");
        System.out.println(Colors.ANSI_RED+dateFormat.format(newDate) +Colors.ANSI_YELLOW +" Universe started successful");
        System.out.println(Colors.ANSI_RED+dateFormat.format(newDate) +Colors.ANSI_YELLOW+ " Ping: " + event.getJDA().getGatewayPing() + "ms!");
        System.out.println(Colors.ANSI_YELLOW+out);

        System.out.println(Colors.ANSI_PURPLE+"  _    _       _                         \n | |  | |     (_)                        \n | |  | |_ __  ___   _____ _ __ ___  ___ \n | |  | | '_ \\| \\ \\ / / _ \\ '__/ __|/ _ \\\n | |__| | | | | |\\ V /  __/ |  \\__ \\  __/\n  \\____/|_| |_|_| \\_/ \\___|_|  |___/\\___|\n                                         ");
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            System.out.println("Ping -> "+event.getJDA().getGatewayPing());
            //System.out.println(Secrets.ANSI_YELLOW+"[Info]"+Secrets.ANSI_RESET+Secrets.ANSI_BLUE+" Reloaded ServerCount on "+Secrets.ANSI_CYAN+"Top.gg"+Secrets.ANSI_RESET+" ✔️");
            try {
                Thread.sleep(900000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ping -> "+event.getJDA().getGatewayPing());
            //System.out.println(Secrets.ANSI_YELLOW+"[Info]"+Secrets.ANSI_RESET+Secrets.ANSI_BLUE+" Reloaded ServerCount on "+Secrets.ANSI_CYAN+"Top.gg"+Secrets.ANSI_RESET+" ✔️");
        };

        executor.scheduleWithFixedDelay(task, 0, 15, TimeUnit.MINUTES);

    }
}
