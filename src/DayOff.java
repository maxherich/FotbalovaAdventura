public class DayOff extends TrainingCommand {


    @Override
    public int execute(Player player, int training) {
        if (training<5){
            player.setEnergy(player.getEnergy()+50);
            player.setRating(player.getRating()-2);
            System.out.println("You gain: +50 energy and -2 rating\n");
        }else {
            System.out.println("It is not training day");
        }
        return training;
    }
}
