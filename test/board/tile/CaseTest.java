package board.tile;

import player.*;
import static org.junit.Assert.*;
import org.junit.*;
import board.*;

import jdk.jfr.Timestamp;

public class CaseTest{

  @Test
  public void initCaseWorks(){
    Desert c = new Desert(0, 2, 5, 6);
    assertEquals(c.getPosX(), 0);
    assertEquals(c.getPosY(), 2);
    assertEquals(c.getCost(), 5);
    assertEquals(c.getCapacity(), 6);
    assertNull(c.getPlayer());

  }

  @Test
  public void playerRelatedMethods(){
    Case c = new Case(0, 2, 5, 6);
    assertFalse(c.isBusy());
    Player p = new Player("Jamy");
    c.setPlayer(p);
    assertEquals(p, c.getPlayer());
    assertTrue(c.isBusy());
  }

  @Test
  public void caseEquals(){
    Desert c1 = new Desert(0,0,5,2);
    Desert c2 = new Desert(0,0,5,2);
    assertTrue(c1.equals(c2));
  }

  public static junit.framework.Test suite(){
    return new junit.framework.JUnit4TestAdapter(board.tile.CaseTest.class);
  }
}
