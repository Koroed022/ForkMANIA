
import org.json.simple.JSONObject;
import BotHandler.BotHandler;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

public class JsonOut {
    public static void setJson(String site1, String site2, String page1, String page2, String name1, String name2, Double coef1, Double coef2, double stavka1, double stavka2, double percent){
        JSONObject Json = new JSONObject();
        Json.put("site1",site1);
        Json.put("site2",site2);
        Json.put("page1",page1);
        Json.put("page2",page2);
        Json.put("name1",name1);
        Json.put("name2",name2);
        Json.put("coef1",coef1);
        Json.put("coef2",coef2);
        Json.put("stavka1",stavka1);
        Json.put("stavka2",stavka2);
        Json.put("percent",percent);

        System.out.println("MessBot Sending...");
        TeleBot.getInstance().
                getBotHandler().
                sendAll(Json.get("site1") + "\t" + Json.get("site2") + "\n"
                + Json.get("page1") + "\n" + Json.get("page2") + "\n"
                + Json.get("name1") + "\t" + Json.get("name2") + "\n"
                + "Коэф 1 :" + Json.get("coef1") + "\n"
                + "Коэф 2 :"  + Json.get("coef2") + "\n"
                + "Ставка 1 :" + Json.get("stavka1") + "\n"
                + "Ставка 2 :" + Json.get("stavka2")+ "\n"
                + "Процент выигрыша примерно:" + Json.get("percent"));
       // bot.sendToAll(Json.toString());
    }
}
