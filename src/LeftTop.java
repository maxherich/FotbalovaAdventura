public class LeftTop extends MatchCommand {

    @Override
    public void execute(Player player, Match match) {
        if (match.getGoalSpots().get(0) == 1){
            System.out.println("You have scored!");
            match.setHomeTeamsGoals(match.getHomeTeamsGoals()+1);
            match.setNumberOfGoalChances(match.getNumberOfGoalChances()-1);
        }else {
            System.out.println("You have missed.");
            match.setNumberOfGoalChances(match.getNumberOfGoalChances()-1);
        }
    }
}
