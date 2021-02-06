package lu.silverwolf;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class OneWordStory extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        final TextChannel channel = event.getChannel();
        if (channel.getId().equals("805440860946694155")) {
            final Message message = event.getMessage();
            String[] args = event.getMessage().getContentRaw().split("\\s+");

            channel.getHistory().retrievePast(2)
                    .map(messages -> messages.get(1))
                    .queue(msg -> {
                            if (message.getAuthor().equals(msg.getAuthor()))
                                message.delete().queue();
                        System.out.println("Same author");

                    });
            if (args.length > 1){
                System.out.println("Message to short");
                message.delete().queue();
            }
        }
    }
}


