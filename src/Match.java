import java.util.ArrayList;
import java.util.Collections;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private int homeTeamsGoals;
    private int awaysTeamsGoals;
    private int numberOfMinutesPlayed;
    private int numberOfGoalChances;
    private int chanceToScore; // what is chance out of 6, to score
    private ArrayList <Integer> goalSpots = new ArrayList<>();

    public Match(Team homeTeam, Team awayTeam, int awaysTeamsGoals) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.awaysTeamsGoals = awaysTeamsGoals;
    }

    public void setHomeTeamsGoals(int homeTeamsGoals) {
        this.homeTeamsGoals = homeTeamsGoals;
    }

    public int getHomeTeamsGoals() {
        return homeTeamsGoals;
    }

    public int getAwaysTeamsGoals() {
        return awaysTeamsGoals;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getNumberOfMinutesPlayed() {
        return numberOfMinutesPlayed;
    }

    public int getNumberOfGoalChances() {
        return numberOfGoalChances;
    }

    public void setNumberOfMinutesPlayed(Player player) { //setting minutes that will player play based on his energy
        if (player.getEnergy()>=90){
            this.numberOfMinutesPlayed = 90;
        }else if (player.getEnergy()<90 && player.getEnergy()>=60){
            this.numberOfMinutesPlayed = 60;
        }else if(player.getEnergy()<60 && player.getEnergy()>=30){
            this.numberOfMinutesPlayed = 30;
        }else if (player.getEnergy()<30){
            this.numberOfMinutesPlayed = 0;
        }
    }

    public int getChanceToScore() {

        return chanceToScore;
    }

    public void setChanceToScore(Player player) { //setting chance to score based on teams quality
        if (homeTeam.getTeamRating()+2 <= awayTeam.getTeamRating()){
            this.chanceToScore = 1;
        }else if (homeTeam.getTeamRating()+1 == awayTeam.getTeamRating() || homeTeam.getTeamRating() == awayTeam.getTeamRating() || homeTeam.getTeamRating()-1 == awayTeam.getTeamRating()){
            this.chanceToScore = 2;
        }else if (homeTeam.getTeamRating()-2 == awayTeam.getTeamRating() || homeTeam.getTeamRating()-3 == awayTeam.getTeamRating()){
            this.chanceToScore = 3;
        }else if (homeTeam.getTeamRating()-4 >= awayTeam.getTeamRating()){
            this.chanceToScore = 4;
        }
    }

    public void setNumberOfGoalChances(int numberOfGoalChances) {
        this.numberOfGoalChances = numberOfGoalChances;
    }

    public void setNumberOfGoalChancesBeforeMatch(Player player) { //setting number of chances that will player get to score
        if (homeTeam.getTeamStyle().equals("Deffensive") && awayTeam.getTeamStyle().equals("Deffensive")){
            this.numberOfGoalChances = 4;
        }else if ((homeTeam.getTeamStyle().equals("Offensive") && awayTeam.getTeamStyle().equals("Deffensive")) || (homeTeam.getTeamStyle().equals("Deffensive") && awayTeam.getTeamStyle().equals("Offensive"))){
            this.numberOfGoalChances = 5;
        }else if (homeTeam.getTeamStyle().equals("Offensive") && awayTeam.getTeamStyle().equals("Offensive")){
            this.numberOfGoalChances = 6;
        }

        if (numberOfMinutesPlayed<90 && numberOfMinutesPlayed>=60){ //setting how minutes played affect the game fewer minutes = fewer chances
            this.numberOfGoalChances--;
        }else if (numberOfMinutesPlayed<60 && numberOfMinutesPlayed>=30){
            this.numberOfGoalChances -= 2;
        }else if (numberOfMinutesPlayed<30){
            this.numberOfGoalChances = 0;
        }
    }

    public ArrayList<Integer> getGoalSpots() {
        return goalSpots;
    }

    public void goalChanceAction(){ //setting how many spots are goals based on players chance to score
        goalSpots.clear();
        for (int i = 0; i < chanceToScore; i++){
            goalSpots.add(1);
        }
        while (goalSpots.size() < 6){
            goalSpots.add(0);
        }
        Collections.shuffle(goalSpots);
        System.out.println("Choose spot you want to shoot in\n __________________________\n|L-Top      M-Top     R-Top|\n|                          |\n|L-Bott    M-Bott    R-Bott|\n");
    }

    public void matchResult(){ //sout match result
        System.out.println("Final score is " + homeTeamsGoals + ":" + awaysTeamsGoals + "\n");
        if (homeTeamsGoals>awaysTeamsGoals){
            homeTeam.setLeaguePoints(homeTeam.getLeaguePoints()+3);
            System.out.println("You have won!\nYou gain 3 points for this match\nYour teams league points is: " + homeTeam.getLeaguePoints() + "\n");
        }else if (homeTeamsGoals<awaysTeamsGoals){
            System.out.println("You have lost.\nYou gain 0 points for this match\nYour teams league points is: " + homeTeam.getLeaguePoints() + "\n");
        }else {
            homeTeam.setLeaguePoints(homeTeam.getLeaguePoints()+1);
            System.out.println("Its draw.\nYou gain 1 point for this match\nYour teams league points is: " + homeTeam.getLeaguePoints() + "\n");
        }
    }

}