
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;

public class DiscordBot {
    public static void main(String[] args) throws Exception {
        // Token del bot
        String token = "{your_bot_token}";

        // ID del canal en donde enviar el mensaje
        Long channelId = Long.parseLong("{your_channel_id}");

        JDA jda = new JDABuilder(token).build();

        TextChannel channel = jda.getGuildById(1234567890L) // ID del servidor de discord (en este caso ejemplo 1234567890L)
                .getChannelById(channelId)
                .complete();

        // Envía el mensaje al canal específico (reemplaza el texto por el que desees enviar)
        channel.sendMessage("¡Hola Discord!").queue();

        jda.awaitReady();
    }
}
