import org.telegram.telegrambots.bots.TelegramLongPollingApi;

public class Main {

    public static void main(String[] args) {
        NewsBot newsBot = new NewsBot();
        try {
            TelegramLongPollingApi api = new TelegramLongPollingApi(newsBot);
            api.registerUpdateListener(newsBot);
            api.startPolling();
        } catch (Exception e) {
            System.err.println("Error starting bot: " + e.getMessage());
        }
    }
}