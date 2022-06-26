package BackEnd.Boards;

public class Position implements Comparable<Position>{
    private int x;
    private int y;

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
}
