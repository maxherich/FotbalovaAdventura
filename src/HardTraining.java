public class HardTraining extends Command{
    @Override
    public void execute(Player player, int training) {
        if (training<5){
            player.setEnergy(player.getEnergy()-30);
            player.setRating(player.getRating()+3);
            System.out.println("You gain: -30 energy and +3 rating");
        }else {
            System.out.println("It is not training day");
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
