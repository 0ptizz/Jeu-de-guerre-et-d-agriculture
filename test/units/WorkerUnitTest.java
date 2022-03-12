package units;
import player.*;
import board.tile.*;
import util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class WorkerUnitTest{
    private WorkerPlayer player;
    private WorkerUnit unit;
    private Case tile;

    @Before
    public void setup(){
        this.player = new WorkerPlayer ("Marcel");
        this.tile = new Plain(0,0,1,1);
        this.unit = new WorkerUnit (player, this.tile);
    }

    @Test
    public void init(){
        assertEquals(unit.getPlayer().getName(), "Marcel");
        assertEquals(unit.getCase(), this.tile);
    }

    @Test
    public void ProduceRessourcesWorks(){
        assertEquals(player.getRessource(Ressources.Wheat), 0);
        unit.produceRessources();
        assertEquals(player.getRessource(Ressources.Wheat), 1);
    }

    @Test
    public void getSalaryWorks(){
        assertEquals(unit.getSalary(), tile.getCost());
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(units.WorkerUnitTest.class);
    }

}
