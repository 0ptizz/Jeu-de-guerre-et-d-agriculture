package actions;
import player.*;
import board.tile.*;
import util.*;
import static org.junit.Assert.*;
import org.junit.*;
import units.*;


public class ActionsWorkerTest{
    private WorkerPlayer player;
    private ActionsWorker actions;
    @Before
    public void createStuff(){
        this.player = new WorkerPlayer("Sabine");
        this.actions = new ActionsWorker(player);
    }

    @Test
    public void init(){
        assertTrue(player.getUnits().isEmpty());
    }

    @Test
    public void addUnitsWorks(){
        actions.setUnit(new Plain(0,0,1,1), 1);
        assertEquals(player.getUnits().size(), 1);
    }

    @Test
    public void salaryWorksWhenNoMoney(){
        Case test = new Plain(0,0,1,1);
        actions.setUnit(test, 1);
        assertTrue(test.isBusy());
        player.setRessources(Ressources.Gold, 0);
        assertEquals(player.getRessource(Ressources.Gold), 0);
        actions.salary();
        assertEquals(player.getRessource(Ressources.Gold), 0);
        assertTrue(player.getUnits().isEmpty());
    }

    @Test
    public void salaryWhenMoney(){
        Case test = new Plain(0,0,1,1);
        assertFalse(test.isBusy());
        actions.setUnit(test, 1);
        assertTrue(test.isBusy());
        assertEquals(player.getRessource(Ressources.Gold), 15);
        actions.salary();
        assertEquals(player.getRessource(Ressources.Gold), 14);
        assertEquals(player.getUnits().size(), 1);
    }

    @Test
    public void exchangeWorks(){
        player.setRessources(Ressources.Wheat, 3);
        player.setRessources(Ressources.Sand, 1);
        player.setRessources(Ressources.Rock, 2);
        player.setRessources(Ressources.Wood, 4);

        actions.exchange();
        // 15 + 3*2 + 5*1 + 2*8 + 4*2 = 50
        assertEquals(player.getRessource(Ressources.Gold), 50);
        assertEquals(player.getRessource(Ressources.Wheat), 0);
        assertEquals(player.getRessource(Ressources.Rock), 0);
        assertEquals(player.getRessource(Ressources.Sand), 0);
        assertEquals(player.getRessource(Ressources.Wood), 0);

    }

    @Test
    public void nothingWorks(){
        actions.setUnit(new Desert(0,0,1,1), 1);
        actions.nothing();
        // + 2 - salary = + 2 - cost(Desert) = +2-1;
        assertEquals(player.getRessource(Ressources.Gold), 16);
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(actions.ActionsWorkerTest.class);
    }
}