package BackEnd.Tiles;

import BackEnd.Boards.Position;

public class Empty extends Tile{
protected static char dot = '.';
    public Empty(Position position){
        super(dot,position);
    }
    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }
    public String toString(){
        return dot+"";
    }
}
