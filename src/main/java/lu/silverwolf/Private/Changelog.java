package lu.silverwolf.Private;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Changelog extends ListenerAdapter {
    @Override
    public void onReady(final ReadyEvent event) {
        final DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        final Date newDate = new Date();

        final EmbedBuilder join = new EmbedBuilder();
        join.setColor(new Color(255,156,0));
        join.setTitle("Universe | Changelog "+Secrets.Version+" \u2728");
        join.setDescription("- Added autowarn System");
        join.setFooter("System");
        join.setTimestamp(Instant.now());
        event.getJDA().getTextChannelById("827456453065179156").sendMessage(join.build()).queue();
      }
}
