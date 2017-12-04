
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import java.util.ArrayList;


public class Scanning implements Runnable{

    public static ArrayList<BetCreate> Bets1X = new ArrayList<BetCreate>();



    public static void Scan(String com1, String com2) throws Exception {




        while (true) {
            try {
                //////sport
                System.out.println("Спорт");
                Scan1X("https://1xbet26.com/line/eSports/");
                Scan1X("https://1xbet26.com/us/line/Tennis/");
                Scan1X("https://1xbet26.com/us/line/FootBall/");
                Scan1X("https://1xbet26.com/us/line/Basketball/");
                Scan1X("https://1xbet26.com/us/line/Volleyball/");
                Scan1X("https://1xbet26.com/us/line/Baseball/");
                Scan1X("https://1xbet26.com/us/line/Darts/");
                Scan1X("https://1xbet26.com/us/line/Snooker/");
                Scan1X("https://1xbet26.com/us/line/Sumo/");

                //Вставить действия стратегии

                Bets1X.clear();
                Thread.sleep(300000);

            } catch (Exception epta) {
                System.out.println(epta.toString());
            }
        }
    }

    //CountMoney.ForAllBets(BetsBetFair,Bets1X,BetsSNG,BetsWEPLAY);


    public static synchronized void Scan1X(String site) throws Exception {
        System.out.println("1xBET");
        try {
            Document doc = Jsoup
                    .connect(site)
                    // .cookies(login.cookies()) //use this with any page you parse. it will log you in
                    .get();
            //System.out.println(doc.toString());
            String manyInf[]  = doc.toString().split("<div class=\"c-events__favorite\" data-type=\"1\"");
            String manycoefs[];

            //System.out.println(manyInf);
              String sport = site.split("line/")[1].replaceAll("/","");
            int i = 1,betCount;
            betCount = manyInf.length;
            String coef1,coef2,name1,name2,names,page;
            while(i < betCount) {
                while (manyInf[i].split(" — ", -1).length - 1 < 1) {
                    i++;
                }
                page ="https://1xbet26.com/line/" + manyInf[i].split("<a href=\"line/")[1].split("\" class=\"c-events")[0];
                names = manyInf[i].split("span class=\"n\" title=\"")[1].split("   \"> ")[0];
                name1 = names.split(" —")[0];
                name1 = name1.replaceAll(" Game ", "map")
                        .replaceAll("aAa","Team aAa")
                        .replaceAll("Ninjas in Pyjamas","NiP")
                        .replaceAll("MoF","MidOrFeed")
                        .replaceAll("XctN","Execration")
                        .replaceAll("HR","HellRaisers")
                        .replaceAll("Gambit Gaming","Gambit")
                        .replaceAll("fnatic","Fnatic")
                        .replaceAll("LGD.FY","LGD.Forever Young")
                        .replaceAll("Na’Vi","Natus Vincere")
                        .replaceAll("Empire","Team Empire")
                        .replaceAll("DC","Digital Chaos")
                        .replaceAll("BP","Blue Pikachu")
                        .replaceAll("Vega","Vega Squadron")
                        .replaceAll(" Esports","")
                        .replaceAll(" Gaming","")
                        .replaceAll(" Game","")
                        .replaceAll(" Team","")
                        .replaceAll("Team ","");

                name2 = names.split(" — ")[1];
                name2 = name2.replaceAll(" Game ", "map")
                        .replaceAll("aAa","Team aAa")
                        .replaceAll("Ninjas in Pyjamas","NiP")
                        .replaceAll("MoF","MidOrFeed")
                        .replaceAll("XctN","Execration")
                        .replaceAll("HR","HellRaisers")
                        .replaceAll("Gambit Gaming","Gambit")
                        .replaceAll("fnatic","Fnatic")
                        .replaceAll("LGD.FY","LGD.Forever Young")
                        .replaceAll("Na’Vi","Natus Vincere")
                        .replaceAll("Empire","Team Empire")
                        .replaceAll("DC","Digital Chaos")
                        .replaceAll("BP","Blue Pikachu")
                        .replaceAll("Vega","Vega Squadron")
                        .replaceAll(" Esports","")
                        .replaceAll(" Gaming","")
                        .replaceAll(" Game","")
                        .replaceAll(" Team","")
                        .replaceAll("Team ","");



                manycoefs = manyInf[i].split("data-coef=\"");
                coef1 = manycoefs[1].split("\" data-evid=\"")[0];
                coef2 = manycoefs[2].split("\" data-evid=\"")[0];
                if (coef1.equals("-")) {
                    coef1 = "0";
                    coef2 = "0";
                }
                //System.out.println(" " + coef1 + " " + coef2 + "\t" + name1 + " " + name2 );
                Bets1X.add(new BetCreate(
                        name1,
                        name2,
                        Double.parseDouble(coef1),
                        Double.parseDouble(coef2),
                        "1XBET",
                        sport,
                        page));
                i++;
            }
        }catch (Exception e) {
            e.getMessage();
        }
    }



    public void run() {
        try {
            Scan(FormClass.com1, FormClass.com2);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
