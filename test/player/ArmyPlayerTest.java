package player;
import util.Ressources;
import java.util.*;
import board.tile.*;
import units.*;

import static org.junit.Assert.*;
import org.junit.*;

import jdk.jfr.Timestamp;

public class ArmyPlayerTest {

    @Test
    public void dataAreCorrectAtCreation(){
    // Verification des données a la creation
        ArmyPlayer p = new ArmyPlayer("colombiana");
        // score = 0, food = 0 units = 30
        assertEquals("colombiana", p.getName());
        assertEquals(0, p.getScore());
        assertEquals(10, p.getRessource(Ressources.Food));
        assertEquals(30, p.getNbUnits());
    }


    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(player.ArmyPlayerTest.class);
    }
}