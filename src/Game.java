import java.io.IOException;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    public Game (){
        int week = 0;
        int season = 0;
        int trainingDay = 0;

        SetUp setUp = new SetUp();
        setUp.setShop();

        System.out.println("Enter name of your player");
        Player player = new Player(scanner.next(), 100,100, 0);
        try {
            setUp.createTeams();
        }catch (IOException e){
            System.out.println(e);
        }
        setUp.addCommands();

        while (season<15){
            setUp.newContract(player);
            System.out.println(setUp.signContract(player));
            System.out.println(player.getTeam().getLeague().getTeams().size());

            while (week<40){

                while (trainingDay<5){
                    System.out.println("Its training day number " + (trainingDay+1)+ "/5\nEnergy: "+ player.getEnergy() + " Rating: " + player.getRating() +  "\nChoose difficulty of todays training\n[DayOff, Easy, Medium, Hard]");
                    String training = scanner.next();
                    training = training.toLowerCase();
                    if (setUp.getTrainingCommands().containsKey(training)) {
                        trainingDay = setUp.getTrainingCommands().get(training).execute(player, trainingDay);
                    }else {
                        System.out.println("Difficulty not found");
                        trainingDay--;
                    }

                    trainingDay++;
                }
                if(week< (player.getTeam().getLeague().getTeams().size()/2)) {
                    Match match = new Match(player.getTeam(), player.getTeam().getLeague().getTeams().get(week),1);
                    match.setNumberOfMinutesPlayed(player);
                    match.setNumberOfGoalChances(player);
                }else {
                    Match match = new Match(player.getTeam(), player.getTeam().getLeague().getTeams().get(week-player.getTeam().getLeague().getTeams().size()/2),1);
                    match.setNumberOfMinutesPlayed(player);
                    match.setNumberOfGoalChances(player);
                }

                week++;
                trainingDay = 0;
            }


            season++;
            week = 0;
        }



    }
}