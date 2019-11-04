import net.sourceforge.jwbf.core.contentRep.Article;
import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class ImperorHistoryBotClass extends AbilityBot {
    @Override
    public int creatorId() {
        return 0;
    }

    protected ImperorHistoryBotClass(String botToken, String botUsername, DefaultBotOptions options) {
        super(botToken, botUsername, options);
    }

    public String getBotUsername() {
        return "imperor_history_bot";
    }

    public String getBotToken() {
        return "1005113234:AAHg9rfkOYfiftC_sOmISYX5vWpk7Xen7Pg";
    }
    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();

        MediaWikiBot wikiBot = new MediaWikiBot("https://en.wikipedia.org/w/");
        Article article = wikiBot.getArticle("42");
        System.out.println(article.getText().substring(5, 42));


        sendMsg(update.getMessage().getChatId().toString(), article.getText().substring(5, 42));
    }

    /**
     * Метод для настройки сообщения и его отправки.
     * @param chatId id чата
     * @param message Строка, которую необходимот отправить в качестве сообщения.
     */
    public synchronized void sendMsg(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println(e.toString());
        }
    }
}
