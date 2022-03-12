package board.tile;

public class Forest extends Case{
    
    public Forest(int x, int y, int Cost, int Capacity) {
        super(x,y,Cost,Capacity);
    }

    public String toString(){
        return "F";
    }

}
