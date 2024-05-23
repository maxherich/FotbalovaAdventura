public class HardTraining extends Command{
    @Override
    public int execute(Player player, int training) {
        if (training < 5 && player.getEnergy() > 30) {
            player.setEnergy(player.getEnergy() - 30);
            player.setRating(player.getRating() + 3);
            System.out.println("You gain: -30 energy and +3 rating");
        }else if (training>4){
            System.out.println("It is not training day");
        }else{
            training--;
            System.out.println("You dont have enough energy for this training");
        }
        return training;
    }

}

