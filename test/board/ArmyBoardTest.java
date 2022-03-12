package board;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ArmyBoardTest{

    @Before
    public void board(){
        ArmyBoard b = new ArmyBoard(5, 7);
    }

    @Test
    public void initBoardWorks(){
        assertEquals(b.getWidth(), 5);
        assertEquals(b.getHeight(), 7);
        for(int i = 0; i < b.getWidth(); i++){
            for(int j = 0; j < b.getHeight(); j++){
                assertNotNull(b.getCase);
            }
        }
    }

    @Test
    public void setCaseWorks(){
        Mountains c = new Mountains(0, 0, 0, 3);
        b.setCase(0, 0, 2);
        assertEquals(c, b.getCase());
    }
}
