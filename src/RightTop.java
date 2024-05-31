public class RightTop extends MatchCommand{
    @Override
    public String execute(Player player, Match match) {
        if (match.getGoalSpots().get(4) == 1){
            System.out.println("You have scored!");
            match.setHomeTeamsGoals(match.getHomeTeamsGoals()+1);
            match.setNumberOfGoalChances(match.getNumberOfGoalChances()-1);
        }else {
            System.out.println("You have missed.");
            match.setNumberOfGoalChances(match.getNumberOfGoalChances()-1);
        }
        if (match.getNumberOfGoalChances()>0){
            return "Match score is " + match.getHomeTeamsGoals() + ":" + match.getAwaysTeamsGoals();
        }
        return "";
    }
}
