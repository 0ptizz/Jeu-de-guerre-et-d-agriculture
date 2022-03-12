package board.tile;


public class Desert extends Case {
    
    public Desert(int x, int y, int Cost, int Capacity) {
        super(x,y,Cost,Capacity);
    }

    public String toString(){
        return "D";
    }
    
}
