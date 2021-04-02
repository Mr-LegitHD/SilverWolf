package lu.silverwolf.Members;

import net.dv8tion.jda.api.events.emote.EmoteAddedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReactionAdd extends ListenerAdapter {
    public void onEmoteAdded(EmoteAddedEvent event) {
        if (event.getEmote().getName().equals("❌")){

        }

    }
}
