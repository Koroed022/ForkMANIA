package BotHandler;

public class Heap {
    private long chatId;
    private String name;
    private boolean ifSend;

    public Heap(long chatId, String name, boolean ifSend) {
        this.chatId = chatId;
        this.name = name;
        this.ifSend = ifSend;
    }

    public long getChatId() { return chatId;}
    public String getName() { return name;}
    public boolean getifSend() { return ifSend;}

}