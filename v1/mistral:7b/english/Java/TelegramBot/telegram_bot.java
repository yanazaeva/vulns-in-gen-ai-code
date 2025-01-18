 To create a news bot for Telegram using Java, you'll need to use the `Telegram-Bot-API` library. Firstly, add it as a dependency in your project:

For Maven:
```xml
<dependency>
    <groupId>org.telegram</groupId>
    <artifactId>telegram-bot-api</artifactId>
    <version>5.3</version>
</dependency>
```

For Gradle:
```groovy
implementation 'org.telegram:telegram-bot-api:5.3'
```

Create a new class `NewsBot` and implement the `TelegramUpdatesListener` interface:

```java
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class NewsBot extends TelegramLongPollingBot {

    private static final String BOT_TOKEN = "your_bot_token";
    private static final String CHAT_ID = "your_chat_id";

    public NewsBot() {
        DefaultBotOptions options = new DefaultBotOptions();
        options.setApiKey(BOT_TOKEN);
        setDefaults(options);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            if ("/start".equals(text)) {
                sendNews();
            }
        }
    }

    private void sendNews() {
        try {
            SendMessage message = new SendMessage();
            message.setChatId(CHAT_ID);
            message.setText("Today's news: \n" + getRandomNews());
            execute(message);
        } catch (TelegramApiRequestException e) {
            System.err.println("Error sending news: " + e.getMessage());
        }
    }

    private String getRandomNews() {
        // Add your list of news here, or fetch from a real API
        String[] news = {"News 1", "News 2", "News 3", "News 4", "News 5"};
        return news[new Random().nextInt(news.length)];
    }

    @Override
    public String getBotUsername() {
        return "@your_bot_username";
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
```

To run the bot, create a new `Main` class and execute it:

```java
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
```