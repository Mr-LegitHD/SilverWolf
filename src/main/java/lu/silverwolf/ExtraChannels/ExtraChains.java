package lu.silverwolf.ExtraChannels;

import lu.silverwolf.Private.Secrets;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ExtraChains extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        final TextChannel channel = event.getChannel();

        if (channel.getId().equals("823540883844235274")) {
            if (!args[0].equalsIgnoreCase("aep")) { event.getMessage().delete().queue();}

            final Message message = event.getMessage();
            channel.getHistory().retrievePast(2)
                    .map(messages -> messages.get(1))
                    .queue(msg -> {
                        if (message.getAuthor().equals(msg.getAuthor()))
                            message.delete().queue();
                        System.out.println("Same author");

                    });
            if (args.length > 1) {
                System.out.println("Message too short");
                message.delete().queue();
            }


        }
    }
}


