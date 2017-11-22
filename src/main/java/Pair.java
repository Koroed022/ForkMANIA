import java.util.ArrayList;

public class Pair {
    private ArrayList<BetCreate> list;
    private int inter;

    public Pair(ArrayList<BetCreate> list, int inter) {
        this.list = list;
        this.inter = inter;
    }
    public ArrayList<BetCreate> getList() { return list;}
    public int getInt() { return inter;}

}