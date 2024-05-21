public class MediumTraining extends Command{
    @Override
    public void execute(Player player, int training) {
        if (training<5){
            player.setRating(player.getRating()+1);
            System.out.println("You gain: +1 rating");
        }else {
            System.out.println("It is not training day");
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
