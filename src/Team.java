public class Team {
    private String name;
    private int teamRating;
    private String teamStyle;
    private League league;
    private int salary;
    private int serialNumber;
    private double leaguePoints;

    public Team(String name, int teamRating, String teamStyle, League league, int serialNumber) {
        this.name = name;
        this.teamRating = teamRating;
        this.teamStyle = teamStyle;
        this.league = league;
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public int getTeamRating() {
        return teamRating;
    }

    public String getTeamStyle() {
        return teamStyle;
    }

    public League getLeague() {
        return league;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public double getLeaguePoints() {
        return leaguePoints;
    }

    @Override
    public String toString() {
        return name + "";
    }
}
