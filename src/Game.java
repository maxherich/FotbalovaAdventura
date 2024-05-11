import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);

    public Game (){
        System.out.println("Enter name of your player");
        Player player = new Player();
        player.setName(scanner.next());



    }
}
