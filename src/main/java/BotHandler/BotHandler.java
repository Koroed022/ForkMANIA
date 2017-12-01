package BotHandler;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
        Date date = new Date();
        if (message != null && message.hasText()) {
            String text = message.getText();
            String chatID = message.getChatId().toString();
            DataBaseHandler database = new DataBaseHandler();
            SendMessage sendMessageRequest = new SendMessage();

            switch (text){

                case Commands.startCommand :{

                    database.addUser(chatID, message.getFrom().getFirstName(),message.getFrom().getLastName());
                    sendMessageRequest.setChatId(chatID);
                    sendMessageRequest.setText("Вы добавлены \n" + date.toString() + "\nДля доступа к сайтам команда: /help \nДля VPN команда: /vpn");
                    try {
                        sendMessage(sendMessageRequest);
                    } catch (TelegramApiException e) {
                        System.out.println(e.getMessage());
                    }
                    return;
                }
                case Commands.helpVPN :{
                    sendMessageRequest.setChatId(chatID);
                    sendMessageRequest.setText("Скачиваете по ссылке установщик VPN и устанавливаем: \n" +
                            "https://swupdate.openvpn.org/community/releases/openvpn-install-2.4.4-I601.exe \n" +
                            "Тут скачиваем сервер VPN Нидерланды(самый левый), а также создаем аккаунт: \n" +
                            "https://www.tcpvpn.com/vpn-server-netherlands \n" +
                            "Запускаем приложение OpenVPN GUI и там задаем путь к нашему скаченному серверу Нидерландов\n" +
                            "Раз в 5 дней вам будет необходимо создавать новый аккаунт на этом сайте и подключаться по новой\n" +
                            "Таким образом VPN бесплатен и дает доступ ко всем сайтам");
                    try {
                        sendMessage(sendMessageRequest);
                    } catch (TelegramApiException e) {
                        System.out.println(e.getMessage());
                    }
                    return;
                }
                case Commands.help :{
                    sendMessageRequest.setChatId(chatID);
                    sendMessageRequest.setText("Для доступа к сайтам букмекерских контор вам достаточно скачать расширение для браузера:" +
                            "FriGate и не забыть его включить \n" +
                            "Приятных ставок :)");
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
            }else {
                sendMessageRequest.setChatId(heap.getChatId());
                sendMessageRequest.setText("Уважаемый(ая) " + heap.getName() + " ваш пробный период истек, сейчас вам бы могла прийти еще одна Букмекерская вилка, оплатите скромную плату и получите доступ к МЕСЯЦУ продуктивного пользования Ботом-Вилочником, в ином случае, можете просто заблокировать бота.\n"+"чтобы продолжить пользование Ботом-Вилочником, вам необходимо оплатить 100 российских рублей на Яндекс Кошелек: 410015642443592, а также прикрепить комментарий, где вы укажите свое имя в Телеграмм, для идентификации.");
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
