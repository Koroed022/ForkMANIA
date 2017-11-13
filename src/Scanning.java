import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Scanning {

    public static ArrayList<BetCreate> BetsSNG = new ArrayList<BetCreate>();
    public static ArrayList<BetCreate> Bets1X = new ArrayList<BetCreate>();
    public static ArrayList<BetCreate> BetsWEPLAY = new ArrayList<BetCreate>();
    public static ArrayList<BetCreate> BetsGG = new ArrayList<BetCreate>();
    public static ArrayList<BetCreate> BetsBetFair = new ArrayList<BetCreate>();


    public static void Scan(String key, String m, String coef) throws Exception {
        int maxI = 100;
        double coef1,coef2;
        if (coef.equals(""))
            maxI = Integer.parseInt(m);
        else {
            coef1 = Double.parseDouble(m);
            coef2 = Double.parseDouble(coef);
        }
        Thread OneXGame = new Thread(new ScannerMan("https://1xbet26.com/line/eSports/","1XBET",0));
        Thread OneX1 = new Thread(new ScannerMan("https://1xbet26.com/us/line/Tennis/","1XBET",0));
        Thread OneX2 = new Thread(new ScannerMan("https://1xbet26.com/us/line/Volleyball/","1XBET",0));
        Thread OneX3 = new Thread(new ScannerMan("https://1xbet26.com/us/line/Baseball/","1XBET",0));
        Thread OneX4 = new Thread(new ScannerMan("https://1xbet26.com/us/line/Darts/","1XBET",0));
        Thread OneX5 = new Thread(new ScannerMan("https://1xbet26.com/us/line/Snooker/","1XBET",0));
        Thread OneX6 = new Thread(new ScannerMan("https://1xbet26.com/us/line/Sumo/","1XBET",0));
        Thread SNGGame = new Thread(new ScannerMan("https://sng.cybbet.com","SNG",0));
        Thread WePlay = new Thread(new ScannerMan("https://weplay.tv/bets/ls","WePlay",0));
        Thread GGGame1 = new Thread(new ScannerMan("http://game-tournaments.com/dota-2/matches","GG",0));
        Thread GGGame2 = new Thread(new ScannerMan("http://game-tournaments.com/csgo/matches","GG",0));
        Thread BetFair1 = new Thread(new ScannerMan("https://www.betfair.com/sport/tennis","BetFair",0));
        Thread BetFair2 = new Thread(new ScannerMan("https://www.betfair.com/sport/darts","BetFair",0));
        Thread BetFair3 = new Thread(new ScannerMan("https://www.betfair.com/sport/snooker","BetFair",0));
        Thread BetFair4 = new Thread(new ScannerMan("https://www.betfair.com/sport/table-tennis","BetFair",0));
        Thread BetFair5 = new Thread(new ScannerMan("https://www.betfair.com/sport/volleyball","BetFair",0));
        Thread GameTour1 = new Thread(new ScannerMan("http://game-tournaments.com/dota-2/bets","Game-Tour",maxI));
        Thread GameTour2 = new Thread(new ScannerMan("http://game-tournaments.com/csgo/bets","Game-Tour",maxI));
        Thread GameTour3 = new Thread(new ScannerMan("http://game-tournaments.com/hearthstone/bets","Game-Tour",maxI));
        Thread GameTour4 = new Thread(new ScannerMan("http://game-tournaments.com/lol/bets","Game-Tour",maxI));
        Thread GameTour5 = new Thread(new ScannerMan("http://game-tournaments.com/overwatch/bets","Game-Tour",maxI));

        if (key.equals("game-tour")){
            GameTour1.start();
            if(!GameTour1.isAlive())
            GameTour2.start();
            if(!GameTour2.isAlive())
            GameTour3.start();
            if(!GameTour3.isAlive())
            GameTour4.start();
            if(!GameTour4.isAlive())
            GameTour5.start();
            //ScanGameTour("http://game-tournaments.com/dota-2/bets", maxI);
            //ScanGameTour("http://game-tournaments.com/csgo/bets", maxI);
            //ScanGameTour("http://game-tournaments.com/hearthstone/bets", maxI);
            //ScanGameTour("http://game-tournaments.com/lol/bets", maxI);
            //ScanGameTour("http://game-tournaments.com/overwatch/bets", maxI);

        }
        if(key.equals("esport")) {
            OneXGame.start();
            WePlay.start();
            GGGame1.start();
            if(!GGGame1.isAlive())
            GGGame2.start();
            SNGGame.start();
            //Scan1X("https://1xbet26.com/line/eSports/");
            //ScanWePlay("https://weplay.tv/bets/ls");
            //ScanSNG("https://sng.cybbet.com");
            //ScanGGBet("http://game-tournaments.com/csgo/matches");
            //ScanGGBet("http://game-tournaments.com/dota-2/matches");
            while (true) {
                if (!SNGGame.isAlive() && !WePlay.isAlive() && !GGGame1.isAlive() && !GGGame2.isAlive() && !OneXGame.isAlive()) {
                    System.out.println("усе блять");
                    CountMoney.ForAllBets(BetsWEPLAY, BetsSNG, BetsGG, Bets1X);
                    break;
                }
            }
        }


        if(key.equals("sport")) {
            OneX1.start();
            if(!OneX1.isAlive())
            OneX2.start();
            if(!OneX2.isAlive())
            OneX3.start();
            if(!OneX3.isAlive())
            OneX4.start();
            if(!OneX4.isAlive())
            OneX5.start();
            if(!OneX5.isAlive())
            OneX6.start();
            BetFair1.start();
            if(!BetFair1.isAlive())
            BetFair2.start();
            if(!BetFair2.isAlive())
            BetFair3.start();
            if(!BetFair3.isAlive())
            BetFair4.start();
            if(!BetFair4.isAlive())
            BetFair5.start();
            //ScanBetFair("https://www.betfair.com/sport/tennis");
            //ScanBetFair("https://www.betfair.com/sport/volleyball");
            //ScanBetFair("https://www.betfair.com/sport/darts");
            //ScanBetFair("https://www.betfair.com/sport/snooker");
            //ScanBetFair("https://www.betfair.com/sport/table-tennis");
            //Scan1X("https://1xbet26.com/us/line/Tennis/");
            //Scan1X("https://1xbet26.com/us/line/Volleyball/");
            //Scan1X("https://1xbet26.com/us/line/Baseball/");
            //Scan1X("https://1xbet26.com/us/line/Darts/");
            //Scan1X("https://1xbet26.com/us/line/Snooker/");
            //Scan1X("https://1xbet26.com/us/line/Sumo/");
            while (true) {
                if (!OneX1.isAlive() &&
                        !OneX2.isAlive() &&
                        !OneX3.isAlive() &&
                        !OneX4.isAlive() &&
                        !OneX5.isAlive() &&
                        !OneX6.isAlive() &&
                        !BetFair1.isAlive() &&
                        !BetFair2.isAlive() &&
                        !BetFair3.isAlive() &&
                        !BetFair4.isAlive() &&
                        !BetFair5.isAlive()){

                    System.out.println("усе блять");
                    CountMoney.Inverse2(BetsBetFair, Bets1X, "Sport_1X+LEON");
                    break;
                }
            }
            //CountMoney.ForAllBets(BetsBetFair,Bets1X,BetsSNG,BetsWEPLAY);
        }
    }
    public static synchronized void Scan1X(String site) throws Exception {
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
                page ="https://1xxxc.xyz/line/" + manyInf[i].split("<a href=\"line/")[1].split("\" class=\"c-events")[0];
                names = manyInf[i].split("span class=\"n\" title=\"")[1].split("   \"> ")[0];
                name1 = names.split(" —")[0];
                name1 = name1.replaceAll(" Game ", "map");

                name2 = names.split(" — ")[1];
                name2 = name2.replaceAll(" Game ", "map");


                manycoefs = manyInf[i].split("data-coef=\"");
                coef1 = manycoefs[1].split("\" data-evid=\"")[0];
                coef2 = manycoefs[2].split("\" data-evid=\"")[0];
                if (coef1.equals("-")) {
                    coef1 = "0";
                    coef2 = "0";
                }
                System.out.println(" " + coef1 + " " + coef2 + "\t" + name1 + " " + name2 );
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
    public static synchronized void ScanSNG(String site) throws Exception {
        try {
            String sport = "game";
            Document doc = Jsoup
                    .connect(site)
                    // .cookies(login.cookies()) //use this with any page you parse. it will log you in
                    .get();
            //System.out.println(doc.toString());
            String manyInf[]  = doc.toString().split("\" data-name-game=\"");
            String manycoefs[];
            //System.out.println(manyInf);

            int i = 1,betCount;
            betCount = doc.toString().split("data-name-game=\"", -1).length - 1;
            String coef1,coef2,time,name1,name2,names;
            while(i < betCount){
                names = manyInf[i].split("\"data-time-event")[0];
                name1 = names.split(" vs")[0];
                name1 = name1.replaceAll("Game","map")
                        .replaceAll("MoF","MidOrFeed")
                        .replaceAll("XctN","Execration")
                        .replaceAll("HR","HellRaisers")
                        .replaceAll("Gambit Gaming","Gambit")
                        .replaceAll("fnatic","Fnatic")
                        .replaceAll("LGD.FY","LGD.Forever Young")
                        .replaceAll("Vega","Vega Squadron");
                name2 = names.split("vs ")[1].split("\" data-time-event=\"")[0];
                name2 = name2.replaceAll("Game","map")
                .replaceAll("MoF","MidOrFeed")
                        .replaceAll("XctN","Execration")
                        .replaceAll("HR","HellRaisers")
                        .replaceAll("Gambit Gaming","Gambit")
                        .replaceAll("fnatic","Fnatic")
                        .replaceAll("LGD.FY","LGD.Forever Young")
                        .replaceAll("Vega","Vega Squadron");

                manycoefs = manyInf[i].split(" - Ставка на\" href");
                coef1 = manycoefs[1].split("<i class=\"fa fa-arrow-down\" style=\"color:red;display:none\"></i>\n" +
                        "                         <i class=\"fa fa-arrow-up\" style=\"color:green;display:none\"></i>\n" +
                        "                         <span>")[1].split(" </span>\n" +
                        "                        </div></a></td>")[0];
                coef2 = manycoefs[1].split("<i class=\"fa fa-arrow-down\" style=\"color:red;display:none\"></i>\n" +
                        "                  <i class=\"fa fa-arrow-up\" style=\"color:green;display:none\"></i>\n" +
                        "                  <span>")[1].split(" </span>\n" +
                        "                 </div></a></td>")[0];
                if (coef1.equals("-")){
                            coef1 = "0";
                            coef2 = "0";
                        }
                System.out.println(" " + coef1 + " " + coef2 + "\t" + name1 +" "+ name2 );
                BetsSNG.add(new BetCreate(
                        name1,
                        name2,
                        Double.parseDouble(coef1),
                        Double.parseDouble(coef2),
                        "SNG",
                        sport,
                        "page"));
                i++;
            }
        }catch (Exception e) {
            e.getMessage();
        }

    }
    public static synchronized void  ScanGGBet(String site) throws Exception {
        try {
            String sport = "game";
            Document doc = Jsoup
                    .connect(site)
                    // .cookies(login.cookies()) //use this with any page you parse. it will log you in
                    .get();
            //System.out.println(doc.toString());
            String gotov =  doc.toString().split("<div id=\"block_matches_current\">")[1];
            String manyInf[] = gotov.split("title=\"Матч ");
            String manycoefs[];
            //System.out.println(manyInf);

            int i = 1,betCount;
            betCount = doc.toString().split("tresult", -1).length - 1;
            String coef1,coef2,name1,name2,names;
            while(i < 20){
                names = manyInf[i].split("\" class=\"mlink")[0];
                name1 = names.split(" против")[0]
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
                        .replaceAll("Vega","Vega Squadron");
                name2 = names.split("против ")[1]
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
                        .replaceAll("Vega","Vega Squadron");
                coef1 = manyInf[i].split("bet-percentage bet1\">")[1].split("</span> <span class=\"vs\"> ")[0];
                coef1 = coef1.replaceAll("\\(","").replaceAll("\\)","");
                coef2 = manyInf[i].split("bet-percentage bet2\">")[1].split("</span> </span> <span>")[0];
                coef2 = coef2.replaceAll("\\)","").replaceAll("\\(","");
                if (coef1.equals("")){
                    coef1 = "0";
                    coef2 = "0";
                }
                System.out.println(" " + coef1 + " " + coef2 + "\t" + name1 +" "+ name2 + "\t" );
                BetsGG.add(new BetCreate(
                        name1,
                        name2,
                        Double.parseDouble(coef1),
                        Double.parseDouble(coef2),
                        "GGBET",
                        sport,
                        "page"));
                i++;
            }
        }catch (Exception e) {
            e.getMessage();
        }
    }
    public static synchronized void ScanBetFair(String site) throws Exception {
        try {

            Document doc = Jsoup
                    .connect(site)
                    .get();
            String manyInf[] = null;
//System.out.println(doc.toString());
            int bliaHZ = 0;
            if(site.split("https://www.betfair.com/sport/")[1].equals("tennis") ||
                    site.split("https://www.betfair.com/sport/")[1].equals("table-tennis"))
                bliaHZ = 1;
            if(site.split("https://www.betfair.com/sport/")[1].equals("volleyball") ||
                    site.split("https://www.betfair.com/sport/")[1].equals("darts") ||
                    site.split("https://www.betfair.com/sport/")[1].equals("snooker"))
                bliaHZ = 2;

            if(site.split("https://www.betfair.com/sport/")[1].equals("table-tennis"))
                System.out.println("nashol");

            if (bliaHZ == 1)
                manyInf = doc.toString().split("<div class=\"ui-market-handicap-values\"> ");
            if (bliaHZ == 2)
                manyInf = doc.toString().split("<div class=\"avb-col avb-col-markets\">");
            String manypodInf[],manycoefs[];

            int i = 1;
            String coef1 = "0",coef2 = "0",name1,name2,names,page,sport = null;
            while(i < manyInf.length){

                if(manyInf[i].split("data-market=\"Match Betting\" data-event=\"").length - 1 < 1)
                    manypodInf = manyInf[i].split(" data-market=\"Match Odds\" data-event=\"");
                else
                    manypodInf = manyInf[i].split("data-market=\"Match Betting\" data-event=\"");

                if(bliaHZ == 1)
                    sport = manypodInf[1].split("data-sport=\"")[1].split("\" data-competition")[0];

                if(bliaHZ == 2)
                    sport = manypodInf[0].split("data-sport=\"")[1].split("\" data-competition")[0];


                names = manypodInf[1].split("\" data-sport-id=\"")[0];
                page = site.split("sport")[0] + "sport" + manypodInf[0].split("<a href=\"/sport")[1].split("\" class=\"ui-nav markets")[0];
                name1 = names.split(" v ")[0];
                name2 = names.split(" v ")[1];
                manycoefs = manyInf[i].split(" <li class=\"selection sel-. \"> ");
                if(manyInf[i].split(" <li class=\"selection sel-. \"> ").length - 1 == 2) {
                    coef1 = manycoefs[1].split(" \"> ")[1].split(" </span> </a> </li> ")[0];
                    coef2 = manycoefs[2].split(" \"> ")[1].split(" </span> </a> </li> ")[0];
                }
                if (manyInf[i].split(" <li class=\"selection sel-. \"> ").length - 1 == 6) {
                    coef1 = manycoefs[5].split(" \"> ")[1].split(" </span> </a> </li> ")[0];
                    coef2 = manycoefs[6].split(" \"> ")[1].split(" </span> </a> </li> ")[0];
                }
                if (manyInf[i].split(" <li class=\"selection sel-. \"> ").length - 1 == 4) {
                    coef1 = manycoefs[3].split(" \"> ")[1].split(" </span> </a> </li> ")[0];
                    coef2 = manycoefs[4].split(" \"> ")[1].split(" </span> </a> </li> ")[0];
                }
                if (coef1.equals("&nbsp;") || coef2.equals("&nbsp;")){
                    coef1 = "0";
                    coef2 = "0";
                }
                System.out.println(" " + coef1 + " " + coef2 + "\t" + name1 +" "+ name2 + "\t" );
                BetsBetFair.add(new BetCreate(
                        name1,
                        name2,
                        Double.parseDouble(coef1),
                        Double.parseDouble(coef2),
                        "BetFair",
                        sport,
                        page));
                i++;
            }
        }catch (Exception e) {
            e.getMessage();
        }
    }
    public static synchronized void ScanWePlay(String site) throws Exception {
        try {
            String sport = "game";
            Document doc = Jsoup
                    .connect(site)
                    // .cookies(login.cookies()) //use this with any page you parse. it will log you in
                    .get();
            //System.out.println(doc + "\n JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ");
            String allPlayers = doc.toString().split("<script id=\"tbl_content\" type=\"text/template\">\n" +
                    "    \\[")[1].split("<script id=\"max_express\" type=\"text/template\">")[0];
            //System.out.println(allPlayers);
            String manyInf[] = allPlayers.split("event_id");
            int i = 1;
            String coef1,coef2,time,name1,name2;
            while(i < manyInf.length ){
                name1 = manyInf[i].split("\"player1\":\"")[1].split("\",\"player2")[0]
                        .replaceAll("MoF","MidOrFeed")
                        .replaceAll("XctN","Execration")
                        .replaceAll("HR","HellRaisers")
                        .replaceAll("Gambit Gaming","Gambit")
                        .replaceAll("fnatic","Fnatic")
                        .replaceAll("LGD.FY","LGD.Forever Young")
                        .replaceAll("Vega","Vega Squadron");
                name2 = manyInf[i].split("player2\":\"")[1].split("\",\"pic1")[0]
                        .replaceAll("MoF","MidOrFeed")
                        .replaceAll("XctN","Execration")
                        .replaceAll("HR","HellRaisers")
                        .replaceAll("Gambit Gaming","Gambit")
                        .replaceAll("fnatic","Fnatic")
                        .replaceAll("LGD.FY","LGD.Forever Young")
                        .replaceAll("Vega","Vega Squadron");
                coef1 = manyInf[i].split("results\":\\{\"1\":\\{\"coefficient\":\"")[1].split("\"},\"3\":\\{\"coefficient\":\"")[0];
                coef2 = manyInf[i].split("\"},\"3\":\\{\"coefficient\":\"")[1];
                time = manyInf[i].split("day\":\"")[1].split("\",\"tm_stamp")[0].replaceAll("\",\"time\":\""," ");
                System.out.println(" " + coef1.split("\",\"result_nm")[0] + " " + coef2.split("\",\"result_nm")[0] + "\t" + manyInf[i].split("\"player1\":\"")[1].split("\",\"player2")[0] +" "+ manyInf[i].split("player2\":\"")[1].split("\",\"pic1")[0] + "\t" + time);
                BetsWEPLAY.add(new BetCreate(
                        name1,
                        name2,
                        Double.parseDouble(coef1.split("\",\"result_nm")[0]),
                        Double.parseDouble(coef2.split("\",\"result_nm")[0]),
                        "WePlay",
                        sport,
                        "page"));
                i++;
            }
        }catch (NoClassDefFoundError er){
            System.out.println(er);
        }
    }
    public static synchronized void ScanGameTour(String site, int max) throws Exception {
        try {
            Document doc = Jsoup
                    .connect(site)
                    // .cookies(login.cookies()) //use this with any page you parse. it will log you in
                    .get();

        Elements elements = doc.select("a.mlink");
        //Thread.sleep(50);
        CountMoney.Coefcount(elements, max);
        }catch (NoClassDefFoundError er){
            System.out.println(er);
        }

        //System.out.println(doc.toString());
    }


}
