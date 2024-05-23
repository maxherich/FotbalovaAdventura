import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SetUp {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
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
        BufferedReader br = new BufferedReader(new FileReader("./src/Teams.txt"));
        while ((text = br.readLine()) != null){
            strings = text.split("\\s+");
            newTeam = new Team(strings[0], Integer.parseInt(strings[3]), strings[2], strings[1]);
            if (Integer.parseInt(strings[3]) == 1){
                newTeam.setSalary(10);
                rating1teams.add(newTeam);
            }else if (Integer.parseInt(strings[3]) == 2){
                newTeam.setSalary(12);
                rating2teams.add(newTeam);
            }else if (Integer.parseInt(strings[3]) == 3){
                newTeam.setSalary(15);
                rating3teams.add(newTeam);
            }else if (Integer.parseInt(strings[3]) == 4){
                newTeam.setSalary(20);
                rating4teams.add(newTeam);
            }else if (Integer.parseInt(strings[3]) == 5){
                newTeam.setSalary(25);
                rating5teams.add(newTeam);
            }else if (Integer.parseInt(strings[3]) == 6){
                newTeam.setSalary(32);
                rating6teams.add(newTeam);
            }else if (Integer.parseInt(strings[3]) == 7){
                newTeam.setSalary(40);
                rating7teams.add(newTeam);
            }
            if (strings[1].equals(PremierLeague.getName())){
                PremierLeague.addteam(newTeam);
            }else if (strings[1].equals(Bundesliga.getName())){
                Bundesliga.addteam(newTeam);
            }else if (strings[1].equals(FortunaLiga.getName())){
                FortunaLiga.addteam(newTeam);
            }
        }
    }

    private ArrayList <Team> teamsWithNewContract = new ArrayList<>();
    public void newContract (Player player){
        teamsWithNewContract.clear();
        if (player.getRating() < 200){
            System.out.println("Rating of these teams is "+ 1 + " and weekly salary is " + 10 + ".\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating1teams.get(random.nextInt(rating1teams.size()));
                teamsWithNewContract.add(team);
                rating1teams.remove(team);
            }
            rating1teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }else if (player.getRating() < 300){
            System.out.println("Rating of these teams is "+ 2 + " and weekly salary is " + 12 + ".\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating2teams.get(random.nextInt(rating2teams.size()));
                teamsWithNewContract.add(team);
                rating2teams.remove(team);
            }
            rating2teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }else if (player.getRating() < 400){
            System.out.println("Rating of these teams is "+ 3 + " and weekly salary is " + 15 + ".\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating3teams.get(random.nextInt(rating3teams.size()));
                teamsWithNewContract.add(team);
                rating3teams.remove(team);
            }
            rating3teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }else if (player.getRating() < 500){
            System.out.println("Rating of these teams is "+ 4 + " and weekly salary is " + 20 + ".\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating4teams.get(random.nextInt(rating4teams.size()));
                teamsWithNewContract.add(team);
                rating4teams.remove(team);
            }
            rating4teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }else if (player.getRating() < 600){
            System.out.println("Rating of these teams is "+ 5 + " and weekly salary is " + 25 + ".\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating5teams.get(random.nextInt(rating5teams.size()));
                teamsWithNewContract.add(team);
                rating5teams.remove(team);
            }
            rating5teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }else if (player.getRating() < 700){
            System.out.println("Rating of these teams is "+ 6 + " and weekly salary is " + 32 + ".\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating6teams.get(random.nextInt(rating6teams.size()));
                teamsWithNewContract.add(team);
                rating6teams.remove(team);
            }
            rating6teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }else {
            System.out.println("Rating of these teams is "+ 7 + " and weekly salary is " + 40 + ".\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating7teams.get(random.nextInt(rating7teams.size()));
                teamsWithNewContract.add(team);
                rating7teams.remove(team);
            }
            rating7teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }
    }

    public String signContract (Player player){
        boolean wrongTeam = false;
        while (!wrongTeam){
            String team = scanner.next();
            for (Team t : teamsWithNewContract) {
                if (t.getName().equals(team)) {
                    player.setTeam(t);
                    player.setWeekSalary(t);
                    wrongTeam = true;
                }
            }
            if (!wrongTeam){
                System.out.println("Your answer does not equal to any option");
            }
        }
        return "You have signed new contract!";
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

    @Override
    public String toString() {
        return teamsWithNewContract + "";
    }
}