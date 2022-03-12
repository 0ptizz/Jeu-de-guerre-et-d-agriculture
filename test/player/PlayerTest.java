package player;
import util.Ressources;
import java.util.*;
import board.tile.*;
import units.*;

import static org.junit.Assert.*;
import org.junit.*;

import jdk.jfr.Timestamp;

public class PlayerTest {

    @Test
    public void dataAreCorrectAtCreation(){
    // Verification des données a la creation
        Player p = new Player("colombiana");
        // score = 0, ressources = 0 units = vide
        assertEquals("colombiana", p.getName());
        assertEquals(0, p.getScore());
        assertEquals(0, p.getRessource(Ressources.Gold));
        assertEquals(0, p.getRessource(Ressources.Wood));
        assertEquals(0, p.getRessource(Ressources.Wheat));
        assertEquals(0, p.getRessource(Ressources.Sand));
        assertEquals(0, p.getRessource(Ressources.Rock));
        assertTrue(p.getUnits().isEmpty());
    }

    @Test
	public void setNewScore() {
        Player p = new Player("colombiana");
        p.setScore(10);
        assertEquals(p.getScore(),10);
        //new score
        p.setScore(-10);
        assertEquals(p.getScore(),-10);
        //score negative
    }

    @Test
    public void addRessourceWorks(){
        Player p = new Player("colombiana");
        p.addRessource(Ressources.Wood, 3);
        assertEquals(p.getRessource(Ressources.Wood), 3);
        p.addRessource(Ressources.Gold, 6);
        assertEquals(p.getRessource(Ressources.Gold), 6);
        p.addRessource(Ressources.Wheat, 15);
        assertEquals(p.getRessource(Ressources.Wheat), 15);
        p.addRessource(Ressources.Sand, 1);
        assertEquals(p.getRessource(Ressources.Sand), 1);
        p.addRessource(Ressources.Rock, 8);
        assertEquals(p.getRessource(Ressources.Rock), 8);
    }
    @Test
    public void setRessourceWorks(){
        Player p = new Player("colombiana");
        p.setRessources(Ressources.Wood, 3);
        assertEquals(p.getRessource(Ressources.Wood), 3);
        p.setRessources(Ressources.Gold, 6);
        assertEquals(p.getRessource(Ressources.Gold), 6);
        p.setRessources(Ressources.Wheat, 15);
        assertEquals(p.getRessource(Ressources.Wheat), 15);
        p.setRessources(Ressources.Sand, 1);
        assertEquals(p.getRessource(Ressources.Sand), 1);
        p.setRessources(Ressources.Rock, 8);
        assertEquals(p.getRessource(Ressources.Rock), 8);
        //test negative
    }

    @Test
    public void unitsStuff(){
        Player p = new Player("colombiana");
        WorkerUnit unit = new WorkerUnit(p, new Case(0,0,1,1));
        List<Unit> list = new ArrayList<>();
        list.add(unit);
        assertEquals(p.getUnits(), list);
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(player.PlayerTest.class);
    }
}
