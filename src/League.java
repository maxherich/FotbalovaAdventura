import java.util.*;

public class League {
    private String name;
    private ArrayList <Team> teams = new ArrayList<>();
    private ArrayList<Team> table = new ArrayList<>();
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

    public String showTable(){
        String string = name;
        for (Team team : table){
            string = string + "\n" + team.getName() + " " + team.getLeaguePoints() + "p";
        }
        return string + "";
    }
    public ArrayList<Team> getTable() {
        return table;
    }

    public int getNumberOfUCLspots() {
        return numberOfUCLspots;
    }

    public void addTeam (Team team){
        teams.add(team);
    }
    public void addTeamToTable (Team team){
        table.add(team);
    }

    public void setTable() {
        Collections.sort(table);
    }

    @Override
    public String toString() {
        return name + "";
    }
}
