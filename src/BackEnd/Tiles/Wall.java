package BackEnd.Tiles;

import BackEnd.Boards.Position;

public class Wall extends Tile{

    public static final char Wall = '#';

    public Wall(Position position){
        super(Wall,position);
    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }
}
