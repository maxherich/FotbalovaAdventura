import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void setEnergy() {
        Player player = new Player("",101,0,0);
        player.setEnergy(player.getEnergy());
        assertEquals(100,player.getEnergy());
    }

    @Test
    void setRating() {
        Player player = new Player("",0,-1,0);
        player.setRating(player.getRating());
        assertEquals(0,player.getRating());
    }
}