import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DiscordBot extends ListenerAdapter {
    private final JDA jda;

    public DiscordBot(String token) {
        this.jda = JDABuilder.createDefault(token).build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // Your message processing logic here
    }

    public static void main(String[] args) throws Exception {
        String token = "your-bot-token"; // Replace with your bot's token
        DiscordBot discordBot = new DiscordBot(token);
        discordBot.jda.addEventListener(discordBot);
        discordBot.jda.awaitReady();
    }
}
@Override
public void onMessageReceived(MessageReceivedEvent event) {
    Message message = event.getMessage();
    String content = message.getContentRaw(); // Get the raw message content

    // Check if the message matches a certain condition (e.g., contains a specific word) and respond accordingly
    if (content.contains("Hello")) {
        event.getChannel().sendMessage("Hello there!").queue();
    }
}
