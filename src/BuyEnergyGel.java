import java.util.ArrayList;

public class BuyEnergyGel extends OtherCommand{
    @Override
    public void execute(Player player, ArrayList arrayList) {
        player.setMoney(player.getMoney()-50);
        player.setEnergy(player.getEnergy()+20);
        System.out.println("You have bought energy gel!\nIt cost you: -50$ and you gain: +20 energy\nYour budget is: " + player.getMoney() + "$\n");
    }
}
