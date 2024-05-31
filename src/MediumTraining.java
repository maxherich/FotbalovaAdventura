public class MediumTraining extends TrainingCommand {
    @Override
    public int execute(Player player, int training) {
        if (training<5){
            player.setRating(player.getRating()+1);
            System.out.println("You gain: +1 rating\n");
        }else {
            System.out.println("It is not training day");
        }
        return training;
    }
}
