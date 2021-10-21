package lu.silverwolf.Math;

import lu.silverwolf.Private.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class Delta extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {


        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Secrets.prefix + "delta")) {
            if (args.length < 3) {
                event.getMessage().delete().queueAfter(5, TimeUnit.SECONDS);
                //Embed Builder
                EmbedBuilder mute = new EmbedBuilder();
                event.getChannel().sendMessage("Use the following Syntax: `-delta a b c`").queue();
                mute.clear();
                return;
            }

            int b = Integer.parseInt(args[2]);
            int a = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[3]);

            int b2 = (int) Math.pow(b,2);

            int solution = b2-4*a*c;
            System.out.println(solution);
            event.getChannel().sendMessage("Δ = **" + solution+"**").queue();
        }
    }
}
