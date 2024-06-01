import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SetUpTest {

    @Test
    void addCommands() {
        var setup = new SetUp();
        setup.addCommands();
        assertEquals(4, setup.getTrainingCommands().size());
    }

    @Test
    void createTeams() throws IOException {
        var setup = new SetUp();
        setup.createTeams();
        assertEquals(54,setup.getTeams().size());
    }

    @Test
    void newContract() throws IOException {
        var setup = new SetUp();
        Player player = new Player("", 0,100,0);
        setup.createTeams();
        setup.newContract(player);
        assertEquals(3,setup.getTeamsWithNewContract().size());
    }
}