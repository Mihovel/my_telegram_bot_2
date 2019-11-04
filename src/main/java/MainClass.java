import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MainClass {

    public static void main(String[] args) {
        System.setProperty("java.net.useSystemProxies", "true");
        System.setProperty("http.proxyHost", "http://proxy.memorynotfound.com");
        System.setProperty("http.proxyPort", "80");
        System.setProperty("http.nonProxyHosts", "localhost|127.0.0.1");

// HTTPS
        System.setProperty("https.proxyHost", "https://proxy.memorynotfound.com");
        System.setProperty("https.proxyPort", "443");
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new ImperorHistoryBotClass());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
