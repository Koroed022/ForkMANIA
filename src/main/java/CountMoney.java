import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class CountMoney {
    public static void ForAllBets(ArrayList<BetCreate> bet1,ArrayList<BetCreate> bet2,ArrayList<BetCreate> bet3,ArrayList<BetCreate> bet4) throws IOException {
        int i = 0, j = 0, k = 0, l = 0;
        for (i = 0; i < bet1.size();i++) {
            if (bet2.size() != 0) {
                for (j = 0; j < bet2.size(); j++) {
                    if (bet1.get(i).getTeam1().equals(bet2.get(j).getTeam1()) &&
                            bet1.get(i).getTeam2().equals(bet2.get(j).getTeam2())) {
                        if (bet3.size() != 0) {
                            for (k = 0; k < bet3.size(); k++) {
                                if (bet1.get(i).getTeam1().equals(bet2.get(j).getTeam1()) &&
                                        bet1.get(i).getTeam2().equals(bet2.get(j).getTeam2()) &&
                                        bet1.get(i).getTeam1().equals(bet3.get(k).getTeam1()) &&
                                        bet1.get(i).getTeam2().equals(bet3.get(k).getTeam2())) {
                                    for (l = 0; l < bet4.size(); l++) {
                                        if (bet1.get(i).getTeam1().equals(bet2.get(j).getTeam1()) &&
                                                bet1.get(i).getTeam2().equals(bet2.get(j).getTeam2()) &&
                                                bet1.get(i).getTeam1().equals(bet3.get(k).getTeam1()) &&
                                                bet1.get(i).getTeam2().equals(bet3.get(k).getTeam2()) &&
                                                bet1.get(i).getTeam1().equals(bet4.get(l).getTeam1()) &&
                                                bet1.get(i).getTeam2().equals(bet4.get(l).getTeam2())) {
                                            CountMoney.RandomCountCoefs(bet1, bet2, bet3, bet4, "1234", i, j, k, l);
                                        } else {
                                            CountMoney.RandomCountCoefs(bet1, bet2, bet3, bet4, "123", i, j, k, l);
                                        }
                                    }
                                } else {
                                    for (l = 0; l < bet4.size(); l++) {
                                        if (bet1.get(i).getTeam1().equals(bet2.get(j).getTeam1()) &&
                                                bet1.get(i).getTeam2().equals(bet2.get(j).getTeam2()) &&
                                                bet1.get(i).getTeam1().equals(bet4.get(l).getTeam1()) &&
                                                bet1.get(i).getTeam2().equals(bet4.get(l).getTeam2())) {
                                            CountMoney.RandomCountCoefs(bet1, bet2, bet3, bet4, "124", i, j, k, l);
                                        } else {
                                            CountMoney.RandomCountCoefs(bet1, bet2, bet3, bet4, "12", i, j, k, l);
                                        }
                                    }
                                }
                            }
                        }else{
                            for (l = 0; l < bet4.size(); l++) {
                                if (bet1.get(i).getTeam1().equals(bet2.get(j).getTeam1()) &&
                                        bet1.get(i).getTeam2().equals(bet2.get(j).getTeam2()) &&
                                        bet1.get(i).getTeam1().equals(bet4.get(l).getTeam1()) &&
                                        bet1.get(i).getTeam2().equals(bet4.get(l).getTeam2())) {
                                    CountMoney.RandomCountCoefs(bet1, bet2, bet3, bet4, "124", i, j, k, l);
                                } else {
                                    CountMoney.RandomCountCoefs(bet1, bet2, bet3, bet4, "12", i, j, k, l);
                                }
                            }
                        }
                    } else {
                        for (k = 0; k < bet3.size(); k++) {
                            if (bet1.get(i).getTeam1().equals(bet3.get(k).getTeam1()) &&
                                    bet1.get(i).getTeam2().equals(bet3.get(k).getTeam2())) {
                                for (l = 0; l < bet4.size(); l++) {
                                    if (bet1.get(i).getTeam1().equals(bet3.get(k).getTeam1()) &&
                                            bet1.get(i).getTeam2().equals(bet3.get(k).getTeam2()) &&
                                            bet1.get(i).getTeam1().equals(bet4.get(l).getTeam1()) &&
                                            bet1.get(i).getTeam2().equals(bet4.get(l).getTeam2())) {
                                        CountMoney.RandomCountCoefs(bet1, bet2, bet3, bet4, "134", i, j, k, l);
                                    } else {
                                        CountMoney.RandomCountCoefs(bet1, bet2, bet3, bet4, "13", i, j, k, l);
                                    }
                                }
                            } else {
                                for (l = 0; l < bet4.size(); l++) {
                                    if (bet1.get(i).getTeam1().equals(bet4.get(l).getTeam1()) &&
                                            bet1.get(i).getTeam2().equals(bet4.get(l).getTeam2())) {
                                        CountMoney.RandomCountCoefs(bet1, bet2, bet3, bet4, "14", i, j, k, l);
                                    }
                                }
                            }
                        }
                    }
                }
            }else {
                for (k = 0; k < bet3.size(); k++) {
                    if (bet1.get(i).getTeam1().equals(bet3.get(k).getTeam1()) &&
                            bet1.get(i).getTeam2().equals(bet3.get(k).getTeam2())) {
                        for (l = 0; l < bet4.size(); l++) {
                            if (bet1.get(i).getTeam1().equals(bet3.get(k).getTeam1()) &&
                                    bet1.get(i).getTeam2().equals(bet3.get(k).getTeam2()) &&
                                    bet1.get(i).getTeam1().equals(bet4.get(l).getTeam1()) &&
                                    bet1.get(i).getTeam2().equals(bet4.get(l).getTeam2())) {
                                CountMoney.RandomCountCoefs(bet1, bet2, bet3, bet4, "134", i, j, k, l);
                            } else {
                                CountMoney.RandomCountCoefs(bet1, bet2, bet3, bet4, "13", i, j, k, l);
                            }
                        }
                    } else {
                        for (l = 0; l < bet4.size(); l++) {
                            if (bet1.get(i).getTeam1().equals(bet4.get(l).getTeam1()) &&
                                    bet1.get(i).getTeam2().equals(bet4.get(l).getTeam2())) {
                                CountMoney.RandomCountCoefs(bet1, bet2, bet3, bet4, "14", i, j, k, l);
                            }
                        }
                    }
                }
            }
        }
    }
    public static void RandomCountCoefs(ArrayList<BetCreate> bet1,ArrayList<BetCreate> bet2,ArrayList<BetCreate> bet3,ArrayList<BetCreate> bet4,
                                        String condition, int i, int j, int k, int l) throws IOException {

        if(condition.equals("12")){
            MaxLeftRight.Max2(bet1,bet2,"12", i, j);
        }
        if(condition.equals("13")){
            MaxLeftRight.Max2(bet1,bet3,"13", i, k);
        }
        if(condition.equals("14")){
            MaxLeftRight.Max2(bet1,bet4,"14", i, l);
        }
        if(condition.equals("123")) {
            MaxLeftRight.Max2(
                    MaxLeftRight.MaxLeft3(bet1,bet2,bet3,"123", i, j, k).getKey(),
                    MaxLeftRight.MaxRight3(bet1,bet2,bet3,"123", i, j, k).getKey(),
                    "123",
                    MaxLeftRight.MaxLeft3(bet1,bet2,bet3,"123", i, j, k).getValue(),
                    MaxLeftRight.MaxRight3(bet1,bet2,bet3,"123", i, j, k).getValue());

        }
        if(condition.equals("124")) {
            MaxLeftRight.Max2(
                    MaxLeftRight.MaxLeft3(bet1,bet2,bet4,"124", i, j, l).getKey(),
                    MaxLeftRight.MaxRight3(bet1,bet2,bet4,"124", i, j, l).getKey(),
                    "124",
                    MaxLeftRight.MaxLeft3(bet1,bet2,bet4,"124", i, j, l).getValue(),
                    MaxLeftRight.MaxRight3(bet1,bet2,bet4,"124", i, j, l).getValue());
        }
        if(condition.equals("134")) {
            MaxLeftRight.Max2(
                    MaxLeftRight.MaxLeft3(bet1,bet3,bet4,"134", i, k, l).getKey(),
                    MaxLeftRight.MaxRight3(bet1,bet3,bet4,"134", i, k, l).getKey(),
                    "134",
                    MaxLeftRight.MaxLeft3(bet1,bet3,bet4,"134", i, k, l).getValue(),
                    MaxLeftRight.MaxRight3(bet1,bet3,bet4,"134", i, k, l).getValue());
        }
        if(condition.equals("2134")) {
            MaxLeftRight.Max2(
                    MaxLeftRight.MaxLeft4(bet1,bet2,bet3,bet4,"1234", i, j, k, l).getKey(),
                    MaxLeftRight.MaxRight4(bet1,bet2,bet3,bet4,"1234", i, j, k, l).getKey(),
                    "1234",
                    MaxLeftRight.MaxLeft4(bet1,bet2,bet3,bet4,"1234", i, j, k, l).getValue(),
                    MaxLeftRight.MaxRight4(bet1,bet2,bet3,bet4,"1234", i, j, k, l).getValue());
        }
    }
    public static String TwoCoefs(Double coef1, Double coef2, int stavka) {

        if (Math.pow(coef1, -1) + Math.pow(coef2, -1) < 1  && coef1 != coef2) {
            int stavkaonFirst;
            double allStavka, stavkaonSecond;
            stavkaonFirst = stavka;
            allStavka = coef1 * stavkaonFirst;
            stavkaonSecond = allStavka - stavkaonFirst;
            return coef1 + "\t" + coef2 + "\n" + stavkaonFirst + "\t" + stavkaonSecond;
        }
        else return "Коефы не подходят";
    }

    public static void Inverse2(ArrayList<BetCreate> bet1, ArrayList<BetCreate> bet2, String what) throws IOException {
        FileWriter writer1 = new FileWriter("C:\\Users\\Vlad\\Desktop\\sportBets.txt", true);
        PrintWriter fileout1 = new PrintWriter(writer1, true);
        ArrayList<BetCreate> Bets1 = bet1;
        ArrayList<BetCreate> Bets2 = bet2;
        String name1 = null, name2 = null;
        for (int i = 0; i < Bets1.size(); i++) {
            for (int j = 0; j < Bets2.size(); j++) {
                if (Bets1.get(i).getTeam1().equals(Bets2.get(j).getTeam1()) && Bets1.get(i).getTeam2().equals(Bets2.get(j).getTeam2()) && !Bets1.get(i).getTeam1().equals("")) {
                    //System.out.println(BetsW.get(i).getTeam1() + " " + BetsS.get(j).getTeam1() + "\n" + BetsW.get(i).getTeam2() + " " + BetsS.get(j).getTeam2());
                    /////дальше дичь, утром праввить, ищем максиммум из них, дальше считаем(возможно надо прикрутить ссылку)
                    double maxAnother = 0;
                    boolean key;
                    double max = Math.max(Bets1.get(i).getKoef2(), Bets2.get(j).getKoef2());
                    if (max == Bets2.get(j).getKoef2()) {
                        name1 = Bets2.get(j).getTeam2();
                        maxAnother = Bets1.get(i).getKoef1();
                        key = true;
                    } else {
                        name1 = Bets1.get(i).getTeam2();
                        maxAnother = Bets2.get(j).getKoef1();
                        key = false;
                    }
                    if (Math.pow(max, -1) + Math.pow(maxAnother, -1) < 1 && max != maxAnother) {
                        if (key)
                            name2 = Bets1.get(i).getTeam1();
                        else
                            name2 = Bets2.get(j).getTeam1();
                        String sport = bet1.get(i).getSport();
                        int stavkaonFirst = 0;
                        double allStavka = 0, stavkaonSecond = 0;
                        for (int k = 1; max * k  < FormClass.maxI; k++) {
                            stavkaonFirst = k ;
                            allStavka = max * stavkaonFirst;
                            stavkaonSecond = allStavka - stavkaonFirst;
                        }
                        if(!name1.equals(name2)) {
                            fileout1.printf(sport + what + "\n" + name1 + "\t" + name2 + "\n" + max + "\t" + maxAnother + "\n" + stavkaonFirst + "\t\t" + stavkaonSecond + "\n");
                            System.out.println(sport + what + "\n"  + name1 + "\t" + name2 + "\n" + max + "\t" + maxAnother + "\n" + stavkaonFirst + "\t\t" + stavkaonSecond);
                        }

                    }
                }

            }
        }
    }
    public synchronized static void Coefcount(Elements e, int max) throws Exception {
        int i = 0, count = 1, j = 0;
        float maxleft, maxright;
        FileWriter writer = new FileWriter("C:\\Users\\Vlad\\Desktop\\tobets.txt",true);
        PrintWriter fileout = new PrintWriter(writer,true);

        while (i < e.size()) {
            while (j < 6) {
                //System.out.println(e.eq(i).attr("href"));
                if (e.eq(i).attr("href").equals(e.eq(i + 1).attr("href"))) {
                    //if (count != 2)
                    count++;
                } else {
                    break;
                }
                j++;
                i++;
            }
            if (e.eq(i).toString().split("result", -1).length - 1 < 1)

                if (count > 1) {

                    ArrayList<Float> listleft = new ArrayList<Float>();
                    ArrayList<Float> listright = new ArrayList<Float>();
                    ArrayList<Float> listleftNew = new ArrayList<Float>();
                    ArrayList<Float> listrightNew = new ArrayList<Float>();

                    for (int c = i - count + 1; c <= i; c++) {
                        listleft.add(Float.parseFloat(e.eq(c).toString().split("bet1\">\\(")[1].split("\\)</span> <span class=\"vs\"")[0]));
                    }

                    maxleft = Collections.max(listleft);
                    for (int c = i - count + 1; c <= i; c++) {
                        if (e.eq(c).toString().split(maxleft + "", -1).length - 1 < 1)
                            listright.add(Float.parseFloat(e.eq(c).toString().split("bet2\">\\(")[1].split("\\)</span> </span> <span>")[0]));
                    }if (listright.size() != 0)
                        maxright = Collections.max(listright);
                    else maxright = 0;
                    if (maxleft > maxright && Math.pow(maxleft, -1) + Math.pow(maxright, -1) < 1  && maxleft != maxright) {
                        int stavkaonFirst = 0;
                        float allStavka = 0,stavkaonSecond = 0;
                        for (int k = 1; max * k * 60 < FormClass.maxI; k++) {
                            stavkaonFirst = k * 60;
                            allStavka = maxleft * stavkaonFirst;
                            stavkaonSecond = allStavka - stavkaonFirst;
                        }
                        fileout.print("http://game-tournaments.com" + e.eq(i).attr("href") + "\tставишь тут на две команды" + "\n" + maxleft + "\t" + maxright + "\n" + stavkaonFirst + "\t" + stavkaonSecond + "\n");
                        System.out.println(maxleft + "\t" + maxright + "\n" + stavkaonFirst + "\t" + stavkaonSecond);
                    }
                    else {
                        for (int c = i - count + 1; c <= i; c++) {
                            listrightNew.add(Float.parseFloat(e.eq(c).toString().split("bet2\">\\(")[1].split("\\)</span> </span> <span>")[0]));
                        }
                        maxright = Collections.max(listrightNew);
                        for (int c = i - count + 1; c <= i; c++) {
                            if (e.eq(c).toString().split(maxright + "", -1).length - 1 < 1) {
                                listleftNew.add(Float.parseFloat(e.eq(c).toString().split("bet1\">\\(")[1].split("\\)</span> <span class=\"vs\"")[0]));
                            }
                        }if (listleftNew.size() != 0)
                            maxleft = Collections.max(listleftNew);
                        else maxleft = 0;
                        if (maxright > maxleft && Math.pow(maxleft, -1) + Math.pow(maxright, -1) < 1  && maxleft != maxright) {
                            int stavkaonFirst = 0;
                            float allStavka = 0,stavkaonSecond = 0;
                            for (int k = 1; max * k  < max; k++) {
                                stavkaonFirst = k ;
                                allStavka = max * stavkaonFirst;
                                stavkaonSecond = allStavka - stavkaonFirst;
                            }
                            fileout.print("http://game-tournaments.com" + e.eq(i).attr("href") + "\tставишь тут на две команды" + "\n" + maxright + "\t" + maxleft + "\n" + stavkaonFirst + "\t" + stavkaonSecond + "\n");
                            System.out.println(maxright + "\t" + maxleft + "\n" + stavkaonFirst + "\t" + stavkaonSecond);
                        }
                    }
                }
            i++;
            j = 0;
            count = 1;
        }
        fileout.close();
    }
}
