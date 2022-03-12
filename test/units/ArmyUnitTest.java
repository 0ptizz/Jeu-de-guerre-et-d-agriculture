package units;
import player.*;
import util.Ressources;
import java.util.*;
import board.tile.*;
import units.*;

import static org.junit.Assert.*;
import org.junit.*;

import jdk.jfr.Timestamp;

public class ArmyUnitTest {
    private ArmyPlayer player;
    private ArmyUnit unit1;
    private ArmyUnit unit2;
    private Case tile1;
    private Case tile2;

    @Before
    public void setup(){
        this.player = new ArmyPlayer ("Marcel");
        this.tile1 = new Plain(0,0,1,5);
        this.tile2 = new Desert(0,1,1,3);
        this.unit1 = new ArmyUnit (player, this.tile1,3);
        this.unit2 = new ArmyUnit (player, this.tile2,2);
    }

    @Test
    public void getSizeTest(){
        assertEquals(this.unit1.getSize(), 3);
        assertEquals(this.unit2.getSize(), 2);
    }

    @Test
    public void changeSizeTest() {
        assertEquals(this.unit1.getSize(), 3);
        this.unit1.changeSize(4);
        assertEquals(this.unit1.getSize(), 4);
    }

    @Test
    public void produceRessourcesArmyOnRightTile(){
        assertEquals(this.player.getRessource(Ressources.Wheat), 0);
        this.unit1.produceRessources();
        assertEquals(player.getRessource(Ressources.Wheat), 1);
    }

    @Test
    public void produceRessourcesArmyOnWrongTile(){
        assertEquals(this.player.getRessource(Ressources.Sand), 0);
        this.unit2.produceRessources();
        assertEquals(player.getRessource(Ressources.Sand), 0);
    }

    @Test
    public void salaryTest() {
        assertEquals(this.unit1.getSalary(), 3);
        assertEquals(this.unit2.getSalary(), 4);
    }

    


    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(units.ArmyUnitTest.class);
    }
}
