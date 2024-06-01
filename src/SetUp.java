import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SetUp {
    private HashMap<String, TrainingCommand> trainingCommands = new HashMap<>();
    private HashMap<String, MatchCommand> matchCommands = new HashMap<>();
    private HashMap<String, OtherCommand> otherCommands = new HashMap<>();
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Team> rating1teams = new ArrayList<>();
    private ArrayList<Team> rating2teams = new ArrayList<>();
    private ArrayList<Team> rating3teams = new ArrayList<>();
    private ArrayList<Team> rating4teams = new ArrayList<>();
    private ArrayList<Team> rating5teams = new ArrayList<>();
    private ArrayList<Team> rating6teams = new ArrayList<>();
    private ArrayList<Team> rating7teams = new ArrayList<>();
    private League FortunaLiga = new League("FortunaLiga", 3);
    private League Bundesliga = new League("Bundesliga", 5);
    private League PremierLeague = new League("PremierLeague", 8);
    private ArrayList <Team> UCLteams = new ArrayList<>(); // teams that qualified for UCL

    private ArrayList <Product> shop = new ArrayList<>();
    private Product energyGel = new Product("energyGel", 50);
    private Product boots = new Product("boots", 500);

    public void addCommands () { // adding commands to arraylist of commands
        trainingCommands.put("dayoff", new DayOff());
        trainingCommands.put("easy",new EasyTraining());
        trainingCommands.put("medium",new MediumTraining());
        trainingCommands.put("hard", new HardTraining());

        matchCommands.put("lefttop",new LeftTop());
        matchCommands.put("leftbottom", new LeftBottom());
        matchCommands.put("midtop",new MidTop());
        matchCommands.put("midbottom",new MidBottom());
        matchCommands.put("righttop", new RightTop());
        matchCommands.put("rightbottom", new RightBottom());

        otherCommands.put("shop",new Shop());
        otherCommands.put("boots", new BuyBoots());
        otherCommands.put("energygel", new BuyEnergyGel());
    }

    private String text;
    private String[] strings;
    private Team newTeam;
    public void createTeams ()throws IOException{ //creating teams from text file
        BufferedReader br = new BufferedReader(new FileReader("C:/PROGRAMOVÁNÍ/FotbalovaAdventura/src/Teams.txt"));
        while ((text = br.readLine()) != null){
            strings = text.split("\\s+");
            if (strings[1].equals(FortunaLiga.getName())){
                newTeam = new Team(strings[0], Integer.parseInt(strings[3]), strings[2], FortunaLiga);
            }else if (strings[1].equals(Bundesliga.getName())){
                newTeam = new Team(strings[0], Integer.parseInt(strings[3]), strings[2], Bundesliga);
            }else if (strings[1].equals(PremierLeague.getName())){
                newTeam = new Team(strings[0], Integer.parseInt(strings[3]), strings[2], PremierLeague);
            }
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
                PremierLeague.addTeam(newTeam);
            }else if (strings[1].equals(Bundesliga.getName())){
                Bundesliga.addTeam(newTeam);
            }else if (strings[1].equals(FortunaLiga.getName())){
                FortunaLiga.addTeam(newTeam);
            }
            teams.add(newTeam);
        }
    }

    private ArrayList <Team> teamsWithNewContract = new ArrayList<>(); // teams that are offering player a new contract
    public void newContract (Player player){ //setting teams that will offer player a new contract based on his raitng
        Random random = new Random();
        teamsWithNewContract.clear();
        if (player.getRating() < 200){
            System.out.println("Rating of these teams is "+ 1 + " and weekly salary is " + 10 + "$\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating1teams.get(random.nextInt(rating1teams.size()));
                teamsWithNewContract.add(team);
                rating1teams.remove(team);
            }
            rating1teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }else if (player.getRating() < 300){
            System.out.println("Rating of these teams is "+ 2 + " and weekly salary is " + 12 + "$\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating2teams.get(random.nextInt(rating2teams.size()));
                teamsWithNewContract.add(team);
                rating2teams.remove(team);
            }
            rating2teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }else if (player.getRating() < 400){
            System.out.println("Rating of these teams is "+ 3 + " and weekly salary is " + 15 + "$\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating3teams.get(random.nextInt(rating3teams.size()));
                teamsWithNewContract.add(team);
                rating3teams.remove(team);
            }
            rating3teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }else if (player.getRating() < 500){
            System.out.println("Rating of these teams is "+ 4 + " and weekly salary is " + 20 + "$\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating4teams.get(random.nextInt(rating4teams.size()));
                teamsWithNewContract.add(team);
                rating4teams.remove(team);
            }
            rating4teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }else if (player.getRating() < 600){
            System.out.println("Rating of these teams is "+ 5 + " and weekly salary is " + 25 + "$\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating5teams.get(random.nextInt(rating5teams.size()));
                teamsWithNewContract.add(team);
                rating5teams.remove(team);
            }
            rating5teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }else if (player.getRating() < 700){
            System.out.println("Rating of these teams is "+ 6 + " and weekly salary is " + 32 + "$\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating6teams.get(random.nextInt(rating6teams.size()));
                teamsWithNewContract.add(team);
                rating6teams.remove(team);
            }
            rating6teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }else {
            System.out.println("Rating of these teams is "+ 7 + " and weekly salary is " + 40 + "$\nWrite name of that team you want to play in next season.");
            for (int i = 0; i < 3; i++){
                Team team = rating7teams.get(random.nextInt(rating7teams.size()));
                teamsWithNewContract.add(team);
                rating7teams.remove(team);
            }
            rating7teams.addAll(teamsWithNewContract);
            System.out.println(teamsWithNewContract);
        }
    }

    public String signContract (Player player){ // method to choose one of the teams and sign a contract
        Scanner scanner = new Scanner(System.in);
        boolean wrongTeam = false;
        while (!wrongTeam){
            String team = scanner.next();
            team = team.toLowerCase();
            for (Team t : teamsWithNewContract) {
                if (t.getName().toLowerCase().equals(team)) {
                    if (player.getTeam()!=null){
                        t.getLeague().getTeams().add(player.getTeam());
                    }
                    player.setTeam(t);
                    player.setWeekSalary(t);
                    t.getLeague().getTeams().remove(t);
                    wrongTeam = true;
                }
            }
            if (!wrongTeam){
                System.out.println("Your answer does not equal to any option");
            }
        }
        return "You have signed new contract!\n";
    }

    public void setShop() {
        shop.add(energyGel);
        shop.add(boots);
    }

    public ArrayList<Product> getShop() {
        return shop;
    }

    public HashMap<String, TrainingCommand> getTrainingCommands() {
        return trainingCommands;
    }

    public HashMap<String, MatchCommand> getMatchCommands() {
        return matchCommands;
    }

    public HashMap<String, OtherCommand> getOtherCommands() {
        return otherCommands;
    }
    public ArrayList<Team> getTeams() {
        return teams;
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

    public ArrayList<Team> getUCLteams() {
        return UCLteams;
    }

    public ArrayList<Team> getTeamsWithNewContract() {
        return teamsWithNewContract;
    }
}
