import java.util.ArrayList;

public class BuyBoots extends OtherCommand{
    @Override
    public void execute(Player player, ArrayList arrayList) {
        if (player.getMoney()>=500){
            player.setRating(player.getRating()+10);
            player.setMoney(player.getMoney()-500);
            System.out.println("You have bought new boots!\nIt cost you: -500$ and you gain: +10 rating\nYour budget is: " + player.getMoney() + "$\n");
        }else {
            System.out.println("You dont have enough money for new boots.\n");
        }
    }
}
