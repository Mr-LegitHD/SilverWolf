package lu.silverwolf.Math;


import lu.silverwolf.Private.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class Prozent extends ListenerAdapter {


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {


        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Secrets.prefix + "perc")) {
            if (args.length < 3) {
                event.getMessage().delete().queueAfter(5, TimeUnit.SECONDS);
                //Embed Builder
                EmbedBuilder mute = new EmbedBuilder();
                event.getChannel().sendMessage("Use one of the following operators: `+ -` \nUse the following Syntax: `-perc <Number1> <operator> <Percent>`").queue();
                mute.clear();
                return;
            }

            int zahl1 = Integer.parseInt(args[1]);
            int zahl2 = Integer.parseInt(args[3]);

            switch (args[2]) {
                case "+": {
                    int sum = zahl1*zahl2*100;
                    event.getChannel().sendMessage("The result is **"+sum+"%**").queue();
                    break;
                }
                case "-": {
                    int sum = zahl1*zahl2/100;
                    event.getChannel().sendMessage("The result is **"+sum+"%**").queue();
                    break;
                }
            }



        }

    }
}

