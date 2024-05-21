public class EasyTraining extends Command{
    @Override
    public void execute(Player player, int training) {
        if (training<5){
            player.setEnergy(player.getEnergy()+20);
            System.out.println("You gain: +20 energy");
        }else {
            System.out.println("It is not training day");
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
