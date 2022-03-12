package actions;
import player.*;
import board.tile.*;
import jdk.jfr.Timestamp;
import util.*;
import static org.junit.Assert.*;
import org.junit.*;
import units.*;
import board.*;


public class ActionsArmyTest{
    private ArmyPlayer player;
    private ActionsArmy actions;
    private Case tile1;
    private ArmyUnit unit1;
    private Board board;
    
    @Before
    public void createStuff(){
        this.player = new ArmyPlayer("Colombiana");
        this.board = new ArmyBoard (3,3);
        this.actions = new ActionsArmy(player, board);
        this.tile1 = new Desert(0,0,1,5);
        this.unit1 = new ArmyUnit (player, tile1,1);
    }

    @Test
    public void init(){
        assertEquals(player.getNbPersonalUnits(),1);
        assertEquals(player.getUnits().size(), 1);
        assertEquals(unit1.getSize(), 1);
  }
    
    @Test
    public void addUnitsArmy(){
        actions.setUnit(new Plain(0,1,1,5),4);
        assertEquals(player.getUnits().size(), 2);
        ArmyUnit test = (ArmyUnit) player.getUnits().get(1);
        assertEquals(test.getSize(), 4);
        assertEquals(player.getNbPersonalUnits(), 2);
    }

    @Test
    public void salaryWorksWhenNoMoney(){
        Case test = new Plain(0,2,1,1);
        actions.setUnit(test, 1);
        player.setRessources(Ressources.Food, 0);
        assertEquals(player.getNbPersonalUnits(),2);
        actions.salary();
        assertEquals(player.getRessource(Ressources.Food), 0);
        assertEquals(player.getNbPersonalUnits(), 2); //car il a posé deux unités
        assertTrue(player.getUnits().isEmpty());
    }

    @Test
    public void salaryWhenMoney(){
        Case test = new Plain(0,2,1,5);
        actions.setUnit(test, 1);
        assertEquals(player.getRessource(Ressources.Food), 10);
        actions.salary();
        assertEquals(player.getRessource(Ressources.Food), 7);
        assertEquals(player.getUnits().size(), 2);
    }

    @Test
    public void exchangeWorks(){
        player.setRessources(Ressources.Wheat, 3);
        player.setRessources(Ressources.Wood, 4);
        actions.exchange();
        // 10 + 3*5 + 4*1 = 29
        assertEquals(player.getRessource(Ressources.Food), 29);
        assertEquals(player.getRessource(Ressources.Wheat), 0);
        assertEquals(player.getRessource(Ressources.Wood), 0);

    }

    @Test
    public void nothingWorks(){
        assertEquals(player.getRessource(Ressources.Food), 10);
        actions.nothing();
        // salary : 10 - 2 + exchange : 0 = 8
        assertEquals(player.getRessource(Ressources.Food), 8);
    }

    @Test
    public void conquestTakeEnnemieUnit() {
        /*Parametre Plateau */
        board.setCase(1,2,3);   /*Plain */
        board.setCase(2,2,3);   /*Plain */
        /*Parametre du joueur 2 */
        ArmyPlayer autre = new ArmyPlayer("Benjamin");
        ActionsArmy actionsAutre = new ActionsArmy(autre, board);
        Case casAutre = board.getCase(1,2);
        actionsAutre.setUnit(casAutre,1);
        /*Parametre du joueur 1 */
        Case title2 = board.getCase(2,2);
        /* Verification du joueur 2 avant conquest et de l'or du joueur 1*/
        assertEquals(board.getCase(1,2).getPlayer(), autre);
        assertEquals(player.getRessource(Ressources.Gold), 0);
        actions.setUnit(title2,5);
        /*Normalement le joueur 1 a pris la case du joueur 2 et gagné 2 d'or*/
        assertEquals(board.getCase(1,2).getPlayer(),player);
        assertEquals(player.getRessource(Ressources.Gold), 2);
    }

    @Test
    public void conquestReduceEnnemieUnit() {
        /*Parametre Plateau */
        board.setCase(1,2,3);   /*Plain */
        board.setCase(2,2,3);   /*Plain */
        /*Parametre du joueur 2 */
        ArmyPlayer autre = new ArmyPlayer("Benjamin");
        ActionsArmy actionsAutre = new ActionsArmy(autre, board);
        Case casAutre = board.getCase(1,2);
        actionsAutre.setUnit(casAutre,2);
        /*Parametre du joueur 1 */
        Case title2 = board.getCase(2,2);
        /* Verification du joueur 2 avant conquest*/
        assertEquals(board.getCase(1,2).getPlayer(),autre);
        ArmyUnit test = (ArmyUnit) autre.getUnits().get(0);
        assertEquals(test.getSize(), 2);
        actions.setUnit(title2,5);
        /*Normalement le joueur 1 a diminué le nombre d'unité du joueur 2*/
        test = (ArmyUnit) autre.getUnits().get(0);
        assertEquals(test.getSize(),1);
    }

    @Test
    public void conquestIncreaseFriendUnit() {
        /*Parametre Plateau */
        board.setCase(1,2,3);   /*Plain */
        board.setCase(2,2,3);   /*Plain */
        /*Parametre du joueur 1 */
        Case title2 = board.getCase(1,2);
        Case title3 = board.getCase(2,2);
        actions.setUnit(title2,2);
        /*Vérification avant conquest */
        ArmyUnit test = (ArmyUnit) player.getUnits().get(0);
        assertEquals(test.getSize(),1);
        assertEquals(player.getRessource(Ressources.Gold),0);
        /*Vérification aprés conquest */
        actions.setUnit(title3,5);
        test = (ArmyUnit) player.getUnits().get(1);
        assertEquals(test.getSize(),3);
        assertEquals(player.getRessource(Ressources.Gold), 1);
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(actions.ActionsArmyTest.class);
    }
}