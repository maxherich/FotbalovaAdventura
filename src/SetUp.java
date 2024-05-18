import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

public class SetUp {
    HashMap<String, Command> commands = new HashMap<>();
    ArrayList<Team> rating1teams = new ArrayList<>();
    ArrayList<Team> rating2teams = new ArrayList<>();
    ArrayList<Team> rating3teams = new ArrayList<>();
    ArrayList<Team> rating4teams = new ArrayList<>();
    ArrayList<Team> rating5teams = new ArrayList<>();
    ArrayList<Team> rating6teams = new ArrayList<>();
    ArrayList<Team> rating7teams = new ArrayList<>();
    League FortunaLiga = new League("FortunaLiga", 3);
    League Bundesliga = new League("Bundesliga", 5);
    League PremierLeague = new League("PremierLeague", 8);

    private String text;
    private String[] strings;
    private Team newTeam;
    public void createTeams ()throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("Teams.txt"));
        while ((text = br.readLine()) != null){
            strings = text.split("\\s+");
            newTeam = new Team(strings[0], Integer.parseInt(strings[3]), strings[2], strings[1]);
            if (strings[1].equals(PremierLeague.getName())){
                PremierLeague.addteam(newTeam);
            }else if (strings[1].equals(Bundesliga.getName())){
                Bundesliga.addteam(newTeam);
            }else if (strings[1].equals(FortunaLiga.getName())){
                FortunaLiga.addteam(newTeam);
            }
            if (Integer.parseInt(strings[3]) == 1){
                rating1teams.add(newTeam);
            }else if (Integer.parseInt(strings[3]) == 2){
                rating2teams.add(newTeam);
            }else if (Integer.parseInt(strings[3]) == 3){
                rating3teams.add(newTeam);
            }else if (Integer.parseInt(strings[3]) == 4){
                rating4teams.add(newTeam);
            }else if (Integer.parseInt(strings[3]) == 5){
                rating5teams.add(newTeam);
            }else if (Integer.parseInt(strings[3]) == 6){
                rating6teams.add(newTeam);
            }else if (Integer.parseInt(strings[3]) == 7){
                rating7teams.add(newTeam);
            }
        }
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public ArrayList<Team> getRating1teams() {
        return rating1teams;
    }

    public ArrayList<Team> getRating2teams() {
        return rating2teams;
    }

    public ArrayList<Team> getRating3teams() {
        return rating3teams;
    }

    public ArrayList<Team> getRating4teams() {
        return rating4teams;
    }

    public ArrayList<Team> getRating5teams() {
        return rating5teams;
    }

    public ArrayList<Team> getRating6teams() {
        return rating6teams;
    }

    public ArrayList<Team> getRating7teams() {
        return rating7teams;
    }

    public League getFortunaLiga() {
        return FortunaLiga;
    }

    public League getBundesliga() {
        return Bundesliga;
    }

    public League getPremierLeague() {
        return PremierLeague;
    }
}
