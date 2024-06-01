import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int week;
    private int season;
    private int trainingDay;
    private int UCL;

    private SetUp setUp;
    private Player player;

    public Game (){
        //setting everthing up for game

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        week = 0;
        season = 0;
        trainingDay = 0;
        UCL = 0;

        setUp = new SetUp();
        setUp.setShop();
        player = new Player("", 100, 100, 100);

        while (player.getName().equals("")) {
            System.out.println("Enter name of your player");
            player.setName(scanner.next());
        }
        try {
            setUp.createTeams();
        }catch (IOException e){
            System.out.println(e);
        }
        setUp.addCommands();

        // game starting
        while (season<15){
            System.out.println("NEW SEASON!");
            setUp.newContract(player);
            System.out.println(setUp.signContract(player)); // signing contract for next season

            while (week<40){ //season is long 40 weeks
                if (week>0){ //giving player his weekly salary and asking him to buy something (not in first week of the season)
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
                        }else {
                            if (!shop.equals("shop")) {
                                shopping = false;
                            }
                            System.out.println("You havent bought anything.\n");
                        }
                    }
                }
                while (trainingDay<5){ // in week, you have 5 training days. Choosing diffuculty of training each day and affects players rating and energy
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
                if(week< (player.getTeam().getLeague().getTeams().size())) {//at the end of each week is matchday. Creating and playing match through match commands
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
                }else if (week< (player.getTeam().getLeague().getTeams().size()*2)){ // same but with the same teams again (in every season you play every team twice)
                    System.out.println("Its matchday!");
                    Match match = new Match(player.getTeam(), player.getTeam().getLeague().getTeams().get(week-player.getTeam().getLeague().getTeams().size()),1);
                    match.setNumberOfMinutesPlayed(player);
                    match.setNumberOfGoalChancesBeforeMatch(player);
                    match.setChanceToScore(player);
                    System.out.println("Energy: " + player.getEnergy() + " Rating: " + player.getRating() + "\nThis week you will play against " + match.getAwayTeam());
                    if (player.getEnergy()<30){// if player don't get atleast 30 energy, he won't play that match and his team automatticly lose
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
            for (Team team : setUp.getTeams()){ //setting teams points and league tables
                if (!team.equals(player.getTeam())) {
                    team.setPoints();
                }
                team.getLeague().getTable().add(team);
            }
            setUp.getBundesliga().setTable();
            setUp.getPremierLeague().setTable();
            setUp.getFortunaLiga().setTable();
            System.out.println(player.getTeam().getLeague().showTable());

            for (int i = 0; i < setUp.getPremierLeague().getNumberOfUCLspots(); i++){ // picking teams that have qualified for UCL
                setUp.getUCLteams().add(setUp.getPremierLeague().getTable().get(i));
            }

            for (int i = 0; i < setUp.getBundesliga().getNumberOfUCLspots(); i++){
                setUp.getUCLteams().add(setUp.getBundesliga().getTable().get(i));
            }

            for (int i = 0; i < setUp.getFortunaLiga().getNumberOfUCLspots(); i++){
                setUp.getUCLteams().add(setUp.getFortunaLiga().getTable().get(i));
            }

            Team uclWinner = null;
            if(setUp.getUCLteams().contains(player.getTeam())){ // At the end of the season is UCL played with matches same as league
                setUp.getUCLteams().remove(player.getTeam());
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
                        uclWinner = setUp.getUCLteams().get(random.nextInt(setUp.getUCLteams().size()));
                        UCL = 4;
                    }else {
                        if (UCL == 4){
                            System.out.println("YOU HAVE WON THE CHAMPIONS LEAGUE!\n");
                            uclWinner = player.getTeam();
                        }else {
                            System.out.println("You have won!");
                            System.out.println("You are through to the " + round + "!\n");
                            setUp.getUCLteams().remove(opponent);
                        }
                    }
                }
            }else {
                System.out.println("You didnt qualify for UCL this year.");
                uclWinner = setUp.getUCLteams().get(random.nextInt(setUp.getUCLteams().size()));
            }

            System.out.println("SEASON END!\n"); // sout league tables and ucl winner
            System.out.println("League tables:\n" + setUp.getFortunaLiga().showTable() + "\n");
            System.out.println(setUp.getBundesliga().showTable() + "\n");
            System.out.println(setUp.getPremierLeague().showTable() + "\n");
            System.out.println("UCL winner is " + uclWinner + "\n");


            setUp.getFortunaLiga().getTable().clear();// getting ready for next season
            setUp.getBundesliga().getTable().clear();
            setUp.getPremierLeague().getTable().clear();
            setUp.getUCLteams().clear();
            season++;
            week = 0;
        }



    }
}