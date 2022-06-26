package BackEnd.Tiles;

import BackEnd.Boards.Position;

public abstract class Tile implements Comparable<BackEnd.Tiles.Tile> {

    protected char tile;
    protected Position position;

    protected Tile(char tile){
        this.tile = tile;
    }
    protected Tile(char tile,Position position){
        this.tile = tile;
        this.position = position;
    }

    protected void initialize(Position position){
        this.position = position;
    }

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

    @Override
    public int compareTo(BackEnd.Tiles.Tile tile) {
        return getPosition().compareTo(tile.getPosition());
    }

    @Override
    public String toString() {
        return String.valueOf(tile);
    }

    public double Range(Position other_position)
    {
        return Math.sqrt(Math.pow(other_position.getX() - position.getX(), 2) + Math.pow(other_position.getY() - position.getY(), 2));
    }

}

