package BackEnd.Boards;

public class Position implements Comparable<Position>{
    private int x;
    private int y;
public Position(int x,int y){
    this.x = x;
    this.y = y;
}
public void set(int x, int y){
    this.x = x;
    this.y = y;
}
    @Override
    public int compareTo(Position position) {
        if(x == position.getX() && y == position.getY()){
            return 0;
        } else
            return -1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position Up(){
        return new Position(getX(), getY() - 1);
    }

    public Position Down(){
        return new Position(getX(), getY() + 1);
    }

    public Position Left(){
        return new Position(getX() - 1, getY());
    }

    public Position Right(){
        return new Position(getX() + 1, getY());
    }

    public Position NoOperation(){
        return new Position(getX() , getY());
    }
}
