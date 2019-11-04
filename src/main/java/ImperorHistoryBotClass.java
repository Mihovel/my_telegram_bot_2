import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class ImperorHistoryBotClass extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

    }

    public String getBotUsername() {
        return "imperor_history_bot";
    }

    public String getBotToken() {
        return "1005113234:AAHg9rfkOYfiftC_sOmISYX5vWpk7Xen7Pg";
    }
}
