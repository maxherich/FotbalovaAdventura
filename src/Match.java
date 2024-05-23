public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private int homeTeamsGoals;
    private int awaysTeamsGoals;
    private int numberOfMinutesPlayed;
    private int numberOfGoalChances;

    public Match(Team homeTeam, Team awayTeam, int awaysTeamsGoals) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.awaysTeamsGoals = awaysTeamsGoals;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getNumberOfGoalChances() {
        return numberOfGoalChances;
    }

    public void setNumberOfMinutesPlayed(Player player) {
        if (player.getEnergy()>90){
            this.numberOfMinutesPlayed = 90;
        }else if (player.getEnergy()<90 && player.getEnergy()>=60){
            this.numberOfMinutesPlayed = 60;
        }else if(player.getEnergy()<60 && player.getEnergy()>=30){
            this.numberOfMinutesPlayed = 30;
        }else if (player.getEnergy()<30){
            this.numberOfMinutesPlayed = 0;
        }
    }

    public void setNumberOfGoalChances(Player player) {
        if (homeTeam.getTeamStyle().equals("Deffensive") && awayTeam.getTeamStyle().equals("Deffensive")){
            this.numberOfGoalChances = 4;
        }else if ((homeTeam.getTeamStyle().equals("Offensive") && awayTeam.getTeamStyle().equals("Deffensive")) || (homeTeam.getTeamStyle().equals("Deffensive") && awayTeam.getTeamStyle().equals("Offensive"))){
            this.numberOfGoalChances = 5;
        }else if (homeTeam.getTeamStyle().equals("Offensive") && awayTeam.getTeamStyle().equals("Offensive")){
            this.numberOfGoalChances = 6;
        }

        if (numberOfMinutesPlayed<90 && numberOfMinutesPlayed>=60){
            this.numberOfGoalChances--;
        }else if (numberOfMinutesPlayed<60 && numberOfMinutesPlayed>=30){
            this.numberOfGoalChances -= 2;
        }else if (numberOfMinutesPlayed<30){
            this.numberOfGoalChances = 0;
        }
    }
}