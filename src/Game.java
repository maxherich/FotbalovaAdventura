import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public Game (){
        int week = 0;
        int season = 0;
        int trainingDay = 0;
        int UCL = 0;

        SetUp setUp = new SetUp();
        setUp.setShop();

        System.out.println("Enter name of your player");
        Player player = new Player(scanner.next(), 100,100, 100);
        try {
            setUp.createTeams();
        }catch (IOException e){
            System.out.println(e);
        }
        setUp.addCommands();

        while (season<15){
            setUp.newContract(player);
            System.out.println(setUp.signContract(player));



            while (week<40){
                if (week>0){
                    player.setMoney(player.getMoney() + player.getWeekSalary());
                    System.out.println("You gain +" + player.getWeekSalary() + "$ this week and your budget is: " + player.getMoney() + "$" + "\nDo you want see buy something? (shop)");
                    boolean shopping = true;
                    while (shopping) {
                        String shop = scanner.next();
                        shop = shop.toLowerCase();
                        if (setUp.getOtherCommands().containsKey(shop)) {
                            setUp.getOtherCommands().get(shop).execute(player, setUp.getShop());
                            if (!shop.equals("shop")) {
                                shopping = false;
                            }
                        } else {
                            if (!shop.equals("shop")) {
                                shopping = false;
                            }
                            System.out.println("You havent bought anything.\n");
                        }
                    }
                }
                while (trainingDay<5){
                    System.out.println("Its training day number " + (trainingDay+1)+ "/5\nEnergy: "+ player.getEnergy() + " Rating: " + player.getRating() +  "\nChoose difficulty of todays training\n[DayOff, Easy, Medium, Hard]");
                    String training = scanner.next();
                    training = training.toLowerCase();
                    if (setUp.getTrainingCommands().containsKey(training)) {
                        trainingDay = setUp.getTrainingCommands().get(training).execute(player, trainingDay);
                    }else {
                        System.out.println("Difficulty not found\n");
                        trainingDay--;
                    }

                    trainingDay++;
                }
                if(week< (player.getTeam().getLeague().getTeams().size())) {
                    System.out.println("Its matchday!");
                    Match match = new Match(player.getTeam(), player.getTeam().getLeague().getTeams().get(week), 1);
                    match.setNumberOfMinutesPlayed(player);
                    match.setNumberOfGoalChancesBeforeMatch(player);
                    match.setChanceToScore(player);
                    System.out.println("Energy: " + player.getEnergy() + " Rating: " + player.getRating() + "\nThis week you will play against " + match.getAwayTeam());
                    if (player.getEnergy()<30){
                        System.out.println("You dont have enough energy to play this match.\n");
                    }else {
                        System.out.println("You will play " + match.getNumberOfMinutesPlayed() + " minutes\nYou will get " + match.getNumberOfGoalChances() + " chances to score\nYour chance to score is " + match.getChanceToScore() + "/6\n");
                    }
                    while (match.getNumberOfGoalChances() > 0) {
                        match.goalChanceAction();
                        String spot = scanner.next();
                        spot = spot.toLowerCase();
                        if (setUp.getMatchCommands().containsKey(spot)) {
                            System.out.println(setUp.getMatchCommands().get(spot).execute(player, match));
                        } else {
                            System.out.println("Spot not found");
                        }
                    }
                    match.matchResult();
                    player.setEnergy(player.getEnergy() - match.getNumberOfMinutesPlayed());
                }else if (week< (player.getTeam().getLeague().getTeams().size()*2)){
                    System.out.println("Its matchday!");
                    Match match = new Match(player.getTeam(), player.getTeam().getLeague().getTeams().get(week-player.getTeam().getLeague().getTeams().size()),1);
                    match.setNumberOfMinutesPlayed(player);
                    match.setNumberOfGoalChancesBeforeMatch(player);
                    match.setChanceToScore(player);
                    System.out.println("Energy: " + player.getEnergy() + " Rating: " + player.getRating() + "\nThis week you will play against " + match.getAwayTeam());
                    if (player.getEnergy()<30){
                        System.out.println("You dont have enough energy to play this match.\n");
                    }else {
                        System.out.println("You will play " + match.getNumberOfMinutesPlayed() + " minutes\nYou will get " + match.getNumberOfGoalChances() + " chances to score\nYour chance to score is " + match.getChanceToScore() + "/6\n");
                    }
                    while (match.getNumberOfGoalChances() > 0) {
                        match.goalChanceAction();
                        String spot = scanner.next();
                        spot = spot.toLowerCase();
                        if (setUp.getMatchCommands().containsKey(spot)) {
                            System.out.println(setUp.getMatchCommands().get(spot).execute(player, match));
                        } else {
                            System.out.println("Spot not found");
                        }
                    }
                    match.matchResult();
                    player.setEnergy(player.getEnergy() - match.getNumberOfMinutesPlayed());
                }else {
                    System.out.println("Your league season ended.\nYou will now only train\n");
                }

                week++;
                trainingDay = 0;
            }
            player.setEnergy(100);
            for (Team team : setUp.getTeams()){
                if (!team.equals(player.getTeam())) {
                    team.setPoints();
                }
                team.getLeague().getTable().add(team);
            }
            setUp.getBundesliga().setTable();
            setUp.getPremierLeague().setTable();
            setUp.getFortunaLiga().setTable();
            System.out.println(player.getTeam().getLeague().showTable());

            for (int i = 0; i < setUp.getPremierLeague().getNumberOfUCLspots(); i++){
                setUp.getUCLteams().add(setUp.getPremierLeague().getTable().get(i));
            }

            for (int i = 0; i < setUp.getBundesliga().getNumberOfUCLspots(); i++){
                setUp.getUCLteams().add(setUp.getBundesliga().getTable().get(i));
            }

            for (int i = 0; i < setUp.getFortunaLiga().getNumberOfUCLspots(); i++){
                setUp.getUCLteams().add(setUp.getFortunaLiga().getTable().get(i));
            }

            if(setUp.getUCLteams().contains(player.getTeam())){
                System.out.println("\nYou have qualified for this years Champions League!\n");
                while (UCL < 4) {
                    Team opponent = setUp.getUCLteams().get(random.nextInt(setUp.getUCLteams().size()));
                    setUp.getUCLteams().remove(opponent);
                    String round = "";
                    if (UCL == 0){
                        round = "Round 1/16";
                    }else if (UCL == 1){
                        round = "QuaterFinal";
                    }else if (UCL == 2){
                        round = "SemiFinal";
                    }else if (UCL == 3){
                        round = "Final";
                    }
                    System.out.println("In " + round + " you will play against " + opponent);

                    Match match = new Match(player.getTeam(), opponent,1);
                    match.setNumberOfMinutesPlayed(player);
                    match.setNumberOfGoalChancesBeforeMatch(player);
                    match.setChanceToScore(player);

                    System.out.println("You will play " + match.getNumberOfMinutesPlayed() + " minutes\nYou will get " + match.getNumberOfGoalChances() + " chances to score\nYour chance to score is " + match.getChanceToScore() + "/6\n");

                    while (match.getNumberOfGoalChances() > 0) {
                        match.goalChanceAction();
                        String spot = scanner.next();
                        spot = spot.toLowerCase();
                        if (setUp.getMatchCommands().containsKey(spot)) {
                            System.out.println(setUp.getMatchCommands().get(spot).execute(player, match));
                        }else {
                            System.out.println("Spot not found");
                        }
                    }
                    System.out.println("Final score is " + match.getHomeTeamsGoals() + ":" + match.getAwaysTeamsGoals() + "\n");

                    UCL++;

                    if (match.getHomeTeamsGoals()<= match.getAwaysTeamsGoals()){
                        System.out.println("You have lost.\nYou have been knocked out of the UCL\n");
                        UCL = 4;
                    }else {
                        if (UCL == 4){
                            System.out.println("YOU HAVE WON THE CHAMPIONS LEAGUE!\n");
                        }else {
                            System.out.println("You have won!");
                            System.out.println("You are through to the " + round + "!\n");
                        }
                    }
                }
            }else {
                System.out.println("You didnt qualify for UCL this year.");
                System.out.println("Winner is " + setUp.getUCLteams().get(random.nextInt(setUp.getUCLteams().size())));
            }

            System.out.println("SEASON END!\n");
            season++;
            week = 0;
        }



    }
}