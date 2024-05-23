import java.util.ArrayList;

public class League {
    private String name;
    private ArrayList <Team> teams = new ArrayList<>();
    private int numberOfUCLspots;

    public League(String name, int numberOfUCLspots) {
        this.name = name;

        this.numberOfUCLspots = numberOfUCLspots;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public int getNumberOfUCLspots() {
        return numberOfUCLspots;
    }

    public void addteam (Team team){
        teams.add(team);
    }

}
