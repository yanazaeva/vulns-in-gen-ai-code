
//Código: https://gist.github.com/anonymous/6c2385b4802561f780b9e991aebd9785
//Ayuda: 

import java.util.Scanner;
import java.text.*;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.events.message.*;
import net.dv8tion.jda.core.hooks.*;
import javax.security.auth.login.*;
import java.util.*;

public class Discord_bot extends ListenerAdapter {

	static MessageChannel channel;
	static JDA jda = null;
	static Scanner scanner = new Scanner(System.in);
	static String text;
	static final String token = "NzM2OTg0MTU1MDk3OTEyNDc4.X8GWRA.RHQp769BhVKt1IuqJjr0YTxFZbQ"; //Pon tu propio token de Discord
	static DateFormat date = new SimpleDateFormat("HH:mm:ss");

	public static void main(String[] args) {
		try {
			if (jda == null) {
				jda = new JDABuilder(AccountType.BOT).setToken(token).addEventListener(new Discord_bot()).build();
			} else {
				System.out.println("JDA ya esta activo");
			}
		} catch (LoginException e) {
			e.printStackTrace();
		}
		while (true) {
			String line = scanner.nextLine();
			if (line.equals("salir"))
				System.exit(0);
			else if (line.startsWith("mensaje ")) {
				text = line.substring(9);
			} else if (line.equals("posteo")) {
				channel.sendMessage(text + "\n\n" + date.format(new Date())).queue();
				System.out.println("Mensaje posteado");
			}
		}
	}

	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if (event.getAuthor().isBot())
			return;
		String message = event.getMessage().getContentDisplay();
		System.out.println("[" + date.format(new Date()) + "] " + event.getMember().getEffectiveName() + ": " + message);
		if (message.startsWith("!canal")) {
			String[] tokens = message.split(" ");
			if (tokens[1].equals("obtener")) {
				channel = event.getGuild().getTextChannelById(Long.parseLong(tokens[2]));
			} else if (tokens[1].equals("modificar")) {
				channel = event.getGuild().getTextChannelsByName(tokens[2], true).get(0);
			} else {
				event.getChannel().sendMessage("Uso: !canal obtener ID | !canal modificar nombre del canal").queue();
			}
		}
	}
