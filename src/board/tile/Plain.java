package board.tile;

public class Plain extends Case {
    
    public Plain(int x, int y, int Cost, int Capacity) {
        super(x,y,Cost,Capacity);
    }

    public String toString(){
        return "P";
    }

}
