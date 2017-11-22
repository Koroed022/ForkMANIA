public class BetCreate {
    private String team1,team2;
    private double koef1,koef2;
    private String sport, site, page;

    public BetCreate(String team1, String team2, double koef1, double koef2, String site, String sport, String page) {
        this.team1 = team1;
        this.team2 = team2;
        this.koef1 = koef1;
        this.koef2 = koef2;
        this.site = site;
        this.sport = sport;
        this.page = page;
    }
    public String getSite() { return site;}

    public String getSport() { return sport;}

    public String getPage() { return page;}

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public double getKoef1() {
        return koef1;
    }

    public double getKoef2() {
        return koef2;
    }

}