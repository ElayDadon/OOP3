package BackEnd.Tiles;

import BackEnd.Boards.Position;

import javax.print.attribute.standard.Finishings;

public class Wall extends Tile{

    public static final char Wall = '#';

    public Wall(){
        super(Wall);
    }

    public void init(Position position){
        this.setPosition(position);
    }
    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }
}
