package BackEnd.Tiles;

import BackEnd.Boards.Position;

import javax.print.attribute.standard.Finishings;

public class Empty extends Tile{
protected static char dot = '.';
    public Empty(){
        super(dot);
    }

    public void init(Position position){
        this.setPosition(position);
    }
    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }
    public String toString(){
        return dot+"";
    }
}
