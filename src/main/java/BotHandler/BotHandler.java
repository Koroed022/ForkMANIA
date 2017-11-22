package BotHandler;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


import java.util.ArrayList;

public class BotHandler extends TelegramLongPollingBot{
    


    public void onUpdateReceived(Update update) {
        try {
            handleUpdate(update);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void handleUpdate(Update update){
        Message message = update.getMessage();

        if (message != null && message.hasText()) {
            String text = message.getText();
            String chatID = message.getChatId().toString();
            DataBaseHandler database = new DataBaseHandler();
            SendMessage sendMessageRequest = new SendMessage();

            switch (text){

                case Commands.startCommand :{
                    if (database.getState(chatID) != null) break;
                    database.addUser(chatID, message.getFrom().getFirstName(),message.getFrom().getLastName());
                    sendMessageRequest.setChatId(chatID);
                    sendMessageRequest.setText("Добавлен ..");
                    try {
                        sendMessage(sendMessageRequest);
                    } catch (TelegramApiException e) {
                        System.out.println(e.getMessage());
                    }
                    return;
                }


            }

        }

    }
    public void sendAll(String messToSend){
        DataBaseHandler database = new DataBaseHandler();
        ArrayList<Heap> h = database.selectAll();
        SendMessage sendMessageRequest = new SendMessage();

        for (Heap heap :
             h) {
            if (heap.getifSend()){
                sendMessageRequest.setChatId(heap.getChatId());
                sendMessageRequest.setText(messToSend);
                try {
                    sendMessage(sendMessageRequest);
                } catch (TelegramApiException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public String getBotUsername() {
        return Token.USERNAME;
    }

    public String getBotToken() {
        return Token.TOKEN;
    }
}
