import java.util.Random;

public class Team implements Comparable<Team> {
    private String name;
    private int teamRating;
    private String teamStyle;
    private League league;
    private int salary; // weekly money player will get to play for this team
    private int leaguePoints;

    public Team(String name, int teamRating, String teamStyle, League league) {
        this.name = name;
        this.teamRating = teamRating;
        this.teamStyle = teamStyle;
        this.league = league;
    }

    public void setPoints (){ //setting points for teams that are not controled based on their quality and league
        Random random = new Random();
        if (teamRating == 1){
            this.leaguePoints = random.nextInt(20)+11;
        }else if (teamRating == 2){
            if (league.getName().equals("FortunaLiga")){
                this.leaguePoints = random.nextInt(30)+21;
            }else if (league.getName().equals("Bundesliga")){
                this.leaguePoints = random.nextInt(20)+11;
            }
        }else if (teamRating == 3){
            if (league.getName().equals("FortunaLiga")){
                this.leaguePoints = random.nextInt(30)+31;
            }else if (league.getName().equals("Bundesliga")){
                this.leaguePoints = random.nextInt(20)+21;
            }else if (league.getName().equals("PremierLeague")){
                this.leaguePoints = random.nextInt(30)+11;
            }
        }else if (teamRating == 4){
            if (league.getName().equals("FortunaLiga")){
                this.leaguePoints = random.nextInt(30)+51;
            }else if (league.getName().equals("Bundesliga")){
                this.leaguePoints = random.nextInt(20)+31;
            }else if (league.getName().equals("PremierLeague")){
                this.leaguePoints = random.nextInt(20)+31;
            }
        }else if (teamRating == 5){
            if (league.getName().equals("Bundesliga")){
                this.leaguePoints = random.nextInt(30)+41;
            }else if (league.getName().equals("PremierLeague")){
                this.leaguePoints = random.nextInt(20)+41;
            }
        }else if (teamRating == 6){
            if (league.getName().equals("Bundesliga")){
                this.leaguePoints = random.nextInt(20)+61;
            }else if (league.getName().equals("PremierLeague")){
                this.leaguePoints = random.nextInt(30)+51;
            }
        }else if (teamRating == 7){
            if (league.getName().equals("Bundesliga")){
                this.leaguePoints = random.nextInt(20)+71;
            }else if (league.getName().equals("PremierLeague")){
                this.leaguePoints = random.nextInt(30)+71;
            }
        }
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
    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    @Override
    public String toString() {
        return name + " - (league: " + league + " - teamStyle: " + teamStyle + ")";
    }

    @Override
    public int compareTo(Team o) {
        return Integer.compare(o.leaguePoints, this.leaguePoints);
    }
}
