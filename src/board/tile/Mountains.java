package board.tile;

public class Mountains extends Case {
    
    public Mountains(int x, int y, int Cost, int Capacity) {
        super(x,y,Cost,Capacity);
    }

    public String toString(){
        return "M";
    }

}
