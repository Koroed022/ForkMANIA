
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

                for (int g = 1; bet1.get(i).getKoef1() * g < FormClass.maxI; g++) {
                    stavkaonFirst = g;
                    win1 = bet1.get(i).getKoef1() * stavkaonFirst;
                    stavkaonSecond = win1 - stavkaonFirst;
                    win2 = bet2.get(j).getKoef2() * stavkaonSecond;
                }
                while (win1 >= stavkaonFirst + stavkaonSecond && stavkaonFirst + stavkaonSecond <= win2 && Math.abs(win2 - win1) > 1) {
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
                double percent = (priz1) * 100 / (stavkaonFirst + stavkaonSecond);
                //System.out.println(priz1 * 100 / win1);
                //System.out.println("Выводись");
                if (proverka && percent > 1) {
                    fileout1.printf(date.toString() + "\n" +
                            bet1.get(i).getPage() + "\n" + bet2.get(j).getPage() + "\n" +
                            bet1.get(i).getTeam1() + "\t" + bet2.get(j).getTeam2() + "\n" +
                            bet1.get(i).getKoef1() + "\t" + bet2.get(j).getKoef2() + "\n" +
                            stavkaonSecond + "\t" + stavkaonFirst + "\n" +
                            "Победа:" + priz1 + "\t" + priz2 + "\n");
                    System.out.println("EEEEE BOYYYYYYYYYYYYYYYYYYYYYY");
                    fileProv.printf(
                            bet1.get(i).getSite() + " " + bet2.get(j).getSite() + " " +
                                    bet1.get(i).getTeam1() + " " + bet2.get(j).getTeam2() + "\n");

                    JsonOut.setJson(bet1.get(i).getSite(), bet2.get(j).getSite(),
                            bet1.get(i).getPage(), bet2.get(j).getPage(),
                            bet1.get(i).getTeam1(), bet2.get(j).getTeam2(),
                            bet1.get(i).getKoef1(), bet2.get(j).getKoef2(),
                            stavkaonFirst, stavkaonSecond,
                            percent);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}