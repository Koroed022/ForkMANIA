import BotHandler.BotHandler;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class TeleBot {
    private static TeleBot ourInstance = new TeleBot();
    private static BotHandler botHandler;

    public static TeleBot getInstance() {
        return ourInstance;
    }

    private TeleBot() {
        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        botHandler = new BotHandler();
        try {
            botHandler.clearWebhook();
            telegramBotsApi.registerBot(new BotHandler());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static BotHandler getBotHandler() {
        return botHandler;
    }
}
