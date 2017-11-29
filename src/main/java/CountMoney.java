import org.jsoup.select.Elements;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class CountMoney {
    public synchronized static void ForAllBets(ArrayList<BetCreate> bet1,ArrayList<BetCreate> bet2,ArrayList<BetCreate> bet3,ArrayList<BetCreate> bet4) throws IOException {
        int i = 0, j = 0, k = 0, l = 0;
        for (i = 0; i < bet1.size(); i++) {
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
            } else {
                if (bet3.size() != 0) {
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
    public synchronized static void RandomCountCoefs(ArrayList<BetCreate> bet1,ArrayList<BetCreate> bet2,ArrayList<BetCreate> bet3,ArrayList<BetCreate> bet4, String condition, int i, int j, int k, int l) throws IOException {

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
                    MaxLeftRight.MaxLeft3(bet1,bet2,bet3,"123", i, j, k).getList(),
                    MaxLeftRight.MaxRight3(bet1,bet2,bet3,"123", i, j, k).getList(),
                    "123",
                    MaxLeftRight.MaxLeft3(bet1,bet2,bet3,"123", i, j, k).getInt(),
                    MaxLeftRight.MaxRight3(bet1,bet2,bet3,"123", i, j, k).getInt());

        }
        if(condition.equals("124")) {
            MaxLeftRight.Max2(
                    MaxLeftRight.MaxLeft3(bet1,bet2,bet4,"124", i, j, l).getList(),
                    MaxLeftRight.MaxRight3(bet1,bet2,bet4,"124", i, j, l).getList(),
                    "124",
                    MaxLeftRight.MaxLeft3(bet1,bet2,bet4,"124", i, j, l).getInt(),
                    MaxLeftRight.MaxRight3(bet1,bet2,bet4,"124", i, j, l).getInt());
        }
        if(condition.equals("134")) {
            MaxLeftRight.Max2(
                    MaxLeftRight.MaxLeft3(bet1,bet3,bet4,"134", i, k, l).getList(),
                    MaxLeftRight.MaxRight3(bet1,bet3,bet4,"134", i, k, l).getList(),
                    "134",
                    MaxLeftRight.MaxLeft3(bet1,bet3,bet4,"134", i, k, l).getInt(),
                    MaxLeftRight.MaxRight3(bet1,bet3,bet4,"134", i, k, l).getInt());
        }
        if(condition.equals("2134")) {
            MaxLeftRight.Max2(
                    MaxLeftRight.MaxLeft4(bet1,bet2,bet3,bet4,"1234", i, j, k, l).getList(),
                    MaxLeftRight.MaxRight4(bet1,bet2,bet3,bet4,"1234", i, j, k, l).getList(),
                    "1234",
                    MaxLeftRight.MaxLeft4(bet1,bet2,bet3,bet4,"1234", i, j, k, l).getInt(),
                    MaxLeftRight.MaxRight4(bet1,bet2,bet3,bet4,"1234", i, j, k, l).getInt());
        }
    }
    public synchronized static void Inverse2(ArrayList<BetCreate> bet1, ArrayList<BetCreate> bet2, String what) throws IOException {
        Date date = new Date();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream("C:\\Users\\Vlad\\Desktop\\proverka.txt"), "UTF-8"));

            String strLine, strline2;
            Boolean proverka = true;

            FileWriter writer1 = new FileWriter("C:\\Users\\Vlad\\Desktop\\sportBets.txt", true);
            FileWriter writer2 = new FileWriter("C:\\Users\\Vlad\\Desktop\\proverka.txt", true);
            PrintWriter fileout1 = new PrintWriter(writer1, true);
            PrintWriter fileProv = new PrintWriter(writer2, true);
            ArrayList<BetCreate> Bets1 = bet1;
            ArrayList<BetCreate> Bets2 = bet2;
            String name1,
                    name2;
            for (int i = 0; i < Bets1.size(); i++) {
                for (int j = 0; j < Bets2.size(); j++) {
                    if ((Bets1.get(i).getTeam1().equals(Bets2.get(j).getTeam1()) && Bets1.get(i).getTeam2().equals(Bets2.get(j).getTeam2())) ||
                            (Bets1.get(i).getTeam1().equals(Bets2.get(j).getTeam2()) && Bets1.get(i).getTeam2().equals(Bets2.get(j).getTeam1())))  {
                        //System.out.println(BetsW.get(i).getTeam1() + " " + BetsS.get(j).getTeam1() + "\n" + BetsW.get(i).getTeam2() + " " + BetsS.get(j).getTeam2());
                        /////дальше дичь, утром праввить, ищем максиммум из них, дальше считаем(возможно надо прикрутить ссылку)
                        double maxAnother;
                        boolean key;
                        double max = Math.max(Bets1.get(i).getKoef2(), Bets2.get(j).getKoef2()),priz1,priz2;
                        if (max == Bets2.get(j).getKoef2()) {
                            name1 = Bets2.get(j).getTeam2();
                            maxAnother = Bets1.get(i).getKoef1();
                            key = true;
                        } else {
                            name1 = Bets1.get(i).getTeam2();
                            maxAnother = Bets2.get(j).getKoef1();
                            key = false;
                        }
                        //System.out.println(max + " " + maxAnother);
                        if (Math.pow(max, -1) + Math.pow(maxAnother, -1) < 1) {
                            if (key)
                                name2 = Bets1.get(i).getTeam1();
                            else
                                name2 = Bets2.get(j).getTeam1();
                            String sport = bet1.get(i).getSport();
                            int stavkaonFirst = 0;
                            double win1 = 0, stavkaonSecond = 0, win2 = 0;
                            for (int k = 1; max * k < FormClass.maxI; k++) {
                                stavkaonFirst = k;
                                win1 = max * stavkaonFirst;
                                stavkaonSecond = win1 - stavkaonFirst;

                            }
                            while(win1 >= stavkaonFirst + stavkaonSecond && stavkaonFirst + stavkaonSecond <= win2 && Math.abs(win2 - win1) > 2)
                            {
                                stavkaonSecond = stavkaonSecond - 0.5;
                                win2 = maxAnother * stavkaonSecond;
                            }
                            strline2 = sport + what + " " + name1 + " " + name2;
                            while ((strLine = br.readLine()) != null) {
                                if (strLine.equals(strline2)) {
                                    proverka = false;
                                    break;
                                }
                            }
                            priz1 = win1 - (stavkaonFirst + stavkaonSecond);
                            priz2 = win2 - (stavkaonFirst + stavkaonSecond);
                            double percent = priz1 * 100 / win1;
                            if (proverka && percent > 1) {
                                fileout1.printf(date.toString() + "\n"  + sport + what + "\n" + name1 + "\t" + name2 + "\n" + max + "\t" + maxAnother + "\n" + stavkaonFirst + "\t\t" + stavkaonSecond + "\n");
                                fileProv.printf(sport + what + " " + name1 + " " + name2 + "\n");
                                JsonOut.setJson(bet1.get(i).getSite(), bet2.get(j).getSite(),
                                        bet1.get(i).getPage(), bet2.get(j).getPage(),
                                        name1, name2,
                                        max, maxAnother,
                                        stavkaonFirst, stavkaonSecond,
                                        percent);
                                System.out.println(sport + "\n" + what + "\n" + name1 + "\t" + name2 + "\n" + max + "\t" + maxAnother + "\n" + stavkaonFirst + "\t" + stavkaonSecond + "\n" + priz1 + "\t" + priz2);
                            }

                        }
                    }

                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public synchronized static void Coefcount(Elements e) throws Exception {
        int i = 0, count = 1, j = 0;
        Date date = new Date();
        double maxleft, maxright;
        String name1;
        String name2;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream("C:\\Users\\Vlad\\Desktop\\proverka.txt"), "UTF-8"));

            String strLine, strline2;
            Boolean proverka = true;

            FileWriter writer1 = new FileWriter("C:\\Users\\Vlad\\Desktop\\EsportBets.txt", true);
            FileWriter writer2 = new FileWriter("C:\\Users\\Vlad\\Desktop\\proverka.txt", true);
            PrintWriter fileout1 = new PrintWriter(writer1, true);
            PrintWriter fileProv = new PrintWriter(writer2, true);

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
                if (e.eq(i).toString().split("result", -1).length - 1 < 1) {
                     name1 = e.eq(i).toString().split("title=\"")[1].split(" против")[0];
                     name2 = e.eq(i).toString().split("против ")[1].split("\" class=\"mlink\">")[0];
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
                        }
                        if (listright.size() != 0)
                            maxright = Collections.max(listright);
                        else maxright = 0;
                        if (Math.pow(maxleft, -1) + Math.pow(maxright, -1) < 1 && maxleft != maxright) {
                            int stavkaonFirst = 0;
                            double win1 = 0, win2 = 0, stavkaonSecond = 0, priz1, priz2;
                            for (int g = 1; maxleft * g < FormClass.maxI; g++) {
                                stavkaonFirst = g;
                                win1 = maxleft * stavkaonFirst;
                                stavkaonSecond = win1 - stavkaonFirst;
                                win2 = maxright * stavkaonSecond;
                            }
                            while (win1 >= stavkaonFirst + stavkaonSecond && stavkaonFirst + stavkaonSecond <= win2 && Math.abs(win2 - win1) > 2) {
                                stavkaonSecond = stavkaonSecond - 0.5;
                                win2 = maxright * stavkaonSecond;
                            }
                            strline2 = "http://game-tournaments.com" + e.eq(i).attr("href");
                            while ((strLine = br.readLine()) != null) {
                                if (strLine.equals(strline2)) {
                                    proverka = false;
                                    break;
                                }
                            }
                            priz1 = win1 - (stavkaonFirst + stavkaonSecond);
                            priz2 = win2 - (stavkaonFirst + stavkaonSecond);
                            double percent = (priz1) * 100 / (stavkaonFirst + stavkaonSecond);
                            //System.out.println("Выводись");
                            if (proverka && percent > 1) {
                                fileout1.print(date.toString() + "\n" + "http://game-tournaments.com" + e.eq(i).attr("href") + "\tставишь тут на две команды" + "\n" + maxleft + "\t" + maxright + "\n" + stavkaonFirst + "\t" + stavkaonSecond + "\n");
                                fileProv.print("http://game-tournaments.com" + e.eq(i).attr("href") + "\n");
                                System.out.println(maxleft + "\t" + maxright + "\n" + stavkaonFirst + "\t" + stavkaonSecond + "\n" + priz1 + "\t" + priz2);
                                JsonOut.setJson("Смотреть на САЙТЕ",
                                        "-",
                                        "http://game-tournaments.com" + e.eq(i).attr("href"),
                                        "-",
                                        name1,
                                        name2,
                                        maxleft,
                                        maxright,
                                        stavkaonFirst,
                                        stavkaonSecond,
                                        percent);
                            }
                        }
                    }
                }
                i++;
                j = 0;
                count = 1;
            }
            fileout1.close();
            fileProv.close();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }
    public synchronized static String TwoCoefs(Double coef1, Double coef2, int stavka) {

        if (Math.pow(coef1, -1) + Math.pow(coef2, -1) < 1  && coef1 != coef2) {
            int stavkaonFirst;
            double win1, win2, stavkaonSecond,priz1,priz2;
            stavkaonFirst = stavka;
            win1 = coef1 * stavkaonFirst;
            stavkaonSecond = win1 - stavkaonFirst;
            win2 = coef2 * stavkaonSecond;
            while(win1 >= stavkaonFirst + stavkaonSecond && stavkaonFirst + stavkaonSecond <= win2 && Math.abs(win2 - win1) > 2)
            {
                stavkaonSecond = stavkaonSecond - 0.5;
                win2 = coef2 * stavkaonSecond;
            }
            priz1 = win1 - (stavkaonFirst + stavkaonSecond);
            priz2 = win2 - (stavkaonFirst + stavkaonSecond);
            return coef1 + "\t" + coef2 + "\n" + stavkaonFirst + "\t" + stavkaonSecond + "\n" + priz1 + "\t" + priz2;
        }
        else return "Коефы не подходят";
    }
}
