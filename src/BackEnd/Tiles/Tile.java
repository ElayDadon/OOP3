package BackEnd.Tiles;

import BackEnd.Boards.Position;

public abstract class Tile {

    protected char tile;
    protected Position position;

    protected Tile(char tile){
        this.tile = tile;
    }
//    protected Tile(char tile,Position position){
//        this.tile = tile;
//        this.position = position;
//    }


    public char getTile() {
        return tile;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    protected void switch_Places(Tile place){
        Position res = place.position;
        place.position = position;
        position = res;
    }

    public abstract void accept(Unit unit);


//    public int compareTo(BackEnd.Tiles.Tile tile) {
//        return getPosition().compareTo(tile.getPosition());
//    }

    @Override
    public String toString() {
        return String.valueOf(tile);
    }



}

