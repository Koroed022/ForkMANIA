
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class MaxLeftRight {

    public synchronized static void Max2(ArrayList<BetCreate> bet1, ArrayList<BetCreate> bet2,
                            String condition, int i, int j) throws IOException {
        Date date = new Date();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream("C:\\Users\\Vlad\\Desktop\\proverka.txt"), "UTF-8"));

            String strLine, strline2;
            Boolean proverka = true;

            FileWriter writer1 = new FileWriter("C:\\Users\\Vlad\\Desktop\\EsportBets.txt", true);
            FileWriter writer2 = new FileWriter("C:\\Users\\Vlad\\Desktop\\proverka.txt", true);
            PrintWriter fileout1 = new PrintWriter(writer1, true);
            PrintWriter fileProv = new PrintWriter(writer2, true);
            //System.out.println("Выводись ссука");
            if (Math.pow(bet1.get(i).getKoef1(), -1) + Math.pow(bet2.get(j).getKoef2(), -1) < 1 &&
                    bet1.get(i).getKoef1() != bet2.get(j).getKoef2()) {
                
                double win1 = 0, win2 = 0, stavkaonSecond = 0, stavkaonFirst = 0, priz1 = 0, priz2 = 0;

                for (int g = 1; bet1.get(i).getKoef1() * g  < FormClass.maxI; g++) {
                    stavkaonFirst = g ;
                    win1 = bet1.get(i).getKoef1() * stavkaonFirst;
                    stavkaonSecond = win1 - stavkaonFirst;
                    win2 = bet2.get(j).getKoef2() * stavkaonSecond;
                }
                while(win1 >= stavkaonFirst + stavkaonSecond && stavkaonFirst + stavkaonSecond <= win2 && Math.abs(win2 - win1) > 2)
                {
                    stavkaonSecond = stavkaonSecond - 0.5;
                    win2 = bet2.get(j).getKoef2() * stavkaonSecond;
                }
                strline2 = bet1.get(i).getSite() + " " + bet2.get(j).getSite() + " " +
                        bet1.get(i).getTeam1() + " " + bet2.get(j).getTeam2();
                while ((strLine = br.readLine()) != null) {
                    if (strLine.equals(strline2)) {
                        proverka = false;
                        break;
                    }
                }
                priz1 = win1 - (stavkaonFirst + stavkaonSecond);
                priz2 = win2 - (stavkaonFirst + stavkaonSecond);
                double percent = priz1 * 100 / win1;
                //System.out.println(priz1 * 100 / win1);
                //System.out.println("Выводись");
                if (proverka && percent > 1) {
                    fileout1.printf(date.toString() + "\n"  +
                                    bet1.get(i).getPage() + "\n" + bet2.get(j).getPage() + "\n" +
                                    bet1.get(i).getTeam1() + "\t" + bet2.get(j).getTeam2() + "\n" +
                                    bet1.get(i).getKoef1() + "\t" + bet2.get(j).getKoef2() + "\n" +
                                    stavkaonSecond + "\t" + stavkaonFirst + "\n" +
                                    "Победа:" + priz1 + "\t" + priz2 + "\n" );
                    System.out.println("EEEEE BOYYYYYYYYYYYYYYYYYYYYYY");
                    fileProv.printf(
                            bet1.get(i).getSite() + " " + bet2.get(j).getSite() + " " +
                                    bet1.get(i).getTeam1() + " " + bet2.get(j).getTeam2() + "\n");

                    JsonOut.setJson(bet1.get(i).getSite(), bet2.get(j).getSite(),
                            bet1.get(i).getPage(), bet2.get(j).getPage(),
                            bet1.get(i).getTeam1(), bet2.get(j).getTeam2(),
                            bet1.get(i).getKoef1(), bet2.get(j).getKoef2(),
                            stavkaonSecond, stavkaonFirst ,//////////////////ВНИМАНИЕ !!!!! ИЗМЕНИЛ
                            percent);
                }
        }
        }catch(Exception e){
            e.getMessage();
        }
    }

    public synchronized static Pair MaxLeft3(ArrayList<BetCreate> bet1, ArrayList<BetCreate> bet2, ArrayList<BetCreate> bet3,
                                                               String condition, int i, int j, int k) {

        double maxLeftFrom3;
        if (bet1.get(i).getKoef1() > bet2.get(j).getKoef1()) {
            if (bet2.get(j).getKoef1() > bet3.get(k).getKoef1()) {
                maxLeftFrom3 = bet1.get(i).getKoef1();
                return new Pair(bet1, i);
            } else {
                if (bet1.get(i).getKoef1() > bet3.get(k).getKoef1()) {
                    maxLeftFrom3 = bet1.get(i).getKoef1();
                    return new Pair(bet1, i);
                } else {
                    maxLeftFrom3 = bet3.get(k).getKoef1();
                    return new Pair(bet3, k);
                }
            }
        } else {
            if (bet1.get(i).getKoef1() > bet3.get(k).getKoef1()) {
                maxLeftFrom3 = bet2.get(j).getKoef1();
                return new Pair(bet2, j);
            } else {
                if (bet2.get(j).getKoef1() > bet3.get(k).getKoef1()) {
                    maxLeftFrom3 = bet3.get(k).getKoef1();
                    return new Pair(bet2, j);
                } else {
                    maxLeftFrom3 = bet3.get(k).getKoef1();
                    return new Pair(bet3, k);
                }
            }
        }
    }

    public synchronized static Pair MaxRight3(ArrayList<BetCreate> bet1, ArrayList<BetCreate> bet2, ArrayList<BetCreate> bet3,
                                                                String condition, int i, int j, int k) {

        double maxrightFrom3;
        if (bet1.get(i).getKoef2() > bet2.get(j).getKoef2()) {
            if (bet2.get(j).getKoef2() > bet3.get(k).getKoef2()) {
                maxrightFrom3 = bet1.get(i).getKoef2();
                return new Pair(bet1, i);
            } else {
                if (bet1.get(i).getKoef2() > bet3.get(k).getKoef2()) {
                    maxrightFrom3 = bet1.get(i).getKoef2();
                    return new Pair(bet1, i);
                } else {
                    maxrightFrom3 = bet3.get(k).getKoef2();
                    return new Pair(bet3, k);
                }
            }
        } else {
            if (bet1.get(i).getKoef2() > bet3.get(k).getKoef2()) {
                maxrightFrom3 = bet2.get(j).getKoef2();
                return new Pair(bet2, j);
            } else {
                if (bet2.get(j).getKoef2() > bet3.get(k).getKoef2()) {
                    maxrightFrom3 = bet3.get(k).getKoef2();
                    return new Pair(bet2, j);
                } else {
                    maxrightFrom3 = bet3.get(k).getKoef2();
                    return new Pair(bet3, k);
                }
            }
        }
    }

    public synchronized static Pair MaxLeft4(ArrayList<BetCreate> bet1, ArrayList<BetCreate> bet2, ArrayList<BetCreate> bet3,
                                                               ArrayList<BetCreate> bet4, String condition, int i, int j, int k, int l) {
        //return new Pair(bet3,k);
        double maxLeftFrom4;
        if (bet1.get(i).getKoef1() > bet2.get(j).getKoef1()) {
            if (bet1.get(i).getKoef1() > bet3.get(k).getKoef1()) {
                if (bet1.get(i).getKoef1() > bet4.get(l).getKoef1()) {
                    maxLeftFrom4 = bet1.get(i).getKoef1();
                    return new Pair(bet1, i);
                } else {maxLeftFrom4 = bet4.get(l).getKoef1();return new Pair(bet4, l);}
            } else {
                if (bet3.get(k).getKoef1() > bet4.get(l).getKoef1()) {
                    maxLeftFrom4 = bet3.get(k).getKoef1();
                    return new Pair(bet3, k);
                } else {maxLeftFrom4 = bet4.get(l).getKoef1();return new Pair(bet4, l);}
            }
        } else {
            if (bet2.get(j).getKoef1() > bet3.get(k).getKoef1()) {
                if (bet2.get(j).getKoef1() > bet4.get(l).getKoef1()) {
                    maxLeftFrom4 = bet2.get(j).getKoef1();
                    return new Pair(bet2, j);
                } else {maxLeftFrom4 = bet4.get(l).getKoef1();return new Pair(bet4, l);}
            } else {
                if (bet3.get(k).getKoef1() > bet4.get(l).getKoef1()) {
                    maxLeftFrom4 = bet3.get(l).getKoef1();
                    return new Pair(bet3, k);
                } else {maxLeftFrom4 = bet4.get(l).getKoef1();return new Pair(bet4, l);}
            }
        }
    }
    public synchronized static Pair MaxRight4(ArrayList<BetCreate> bet1, ArrayList<BetCreate> bet2, ArrayList<BetCreate> bet3,
                                                               ArrayList<BetCreate> bet4, String condition, int i, int j, int k, int l) {
        //return new Pair(bet3,k);
        double maxRightFrom4;
        if (bet1.get(i).getKoef2() > bet2.get(j).getKoef2() ) {
            if (bet1.get(i).getKoef2()  > bet3.get(k).getKoef2() ) {
                if (bet1.get(i).getKoef2()  > bet4.get(l).getKoef2() ) {
                    maxRightFrom4 = bet1.get(i).getKoef2();
                    return new Pair(bet1, i);
                } else { maxRightFrom4 = bet4.get(l).getKoef2();return new Pair(bet4, l);}
            } else {
                if (bet3.get(k).getKoef2() > bet4.get(l).getKoef2() ) {
                    maxRightFrom4 = bet3.get(k).getKoef2();
                    return new Pair(bet3, k);
                } else { maxRightFrom4 = bet4.get(l).getKoef2();return new Pair(bet4, l);}
            }
        } else {
            if (bet2.get(j).getKoef2()  > bet3.get(k).getKoef2() ) {
                if (bet2.get(j).getKoef2()  > bet4.get(l).getKoef2() ) {
                    maxRightFrom4 = bet2.get(j).getKoef2();
                    return new Pair(bet2, j);
                } else { maxRightFrom4 = bet4.get(l).getKoef2();return new Pair(bet4, l);}
            } else {
                if (bet3.get(k).getKoef2()  > bet4.get(l).getKoef2() ) {
                    maxRightFrom4 = bet3.get(l).getKoef2();
                    return new Pair(bet3, k);
                } else { maxRightFrom4 = bet4.get(l).getKoef2();return new Pair(bet4, l);}
            }
        }
    }
}
