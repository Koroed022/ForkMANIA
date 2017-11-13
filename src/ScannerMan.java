import java.awt.*;

public class ScannerMan implements Runnable {
    private static Robot robot;
    String page,site;
    int max;
    public ScannerMan(String page, String site, int max) {
        this.page = page;
        this.site = site;
        this.max = max;

    }

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
        }

    }

    public synchronized void run() {
        if(site.equals("1XBET")){
            try {
                Scanning.Scan1X(page);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(site.equals("Game-Tour")){
            try {
                Scanning.ScanGameTour(page,max);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(site.equals("WePlay")){
            try {
                Scanning.ScanWePlay(page);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(site.equals("SNG")){
            try {
                Scanning.ScanSNG(page);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(site.equals("GG")){
            try {
                Scanning.ScanGGBet(page);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(site.equals("GG")){
            try {
                Scanning.ScanGGBet(page);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(site.equals("BetFair")){
            try {
                Scanning.ScanBetFair(page);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
