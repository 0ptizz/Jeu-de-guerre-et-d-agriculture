package board;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class WorkerBoardTest{

  @Before
  public void board(){
    WorkerBoard b = new WorkerBoard(5, 7);
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
    Mountains c = new Mountains(0, 0, 5, 1);
    b.setCase(0, 0, 2);
    assertEquals(c, b.getCase());
  }
}
