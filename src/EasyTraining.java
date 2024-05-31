public class EasyTraining extends TrainingCommand {
    @Override
    public int execute(Player player, int training) {
        if (training<5){
            player.setEnergy(player.getEnergy()+20);
            System.out.println("You gain: +20 energy\n");
        }else {
            System.out.println("It is not training day");
        }
        return training;
    }
}
