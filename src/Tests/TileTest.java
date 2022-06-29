package Tests;

import BackEnd.Boards.Position;
import BackEnd.Tiles.Empty;
import BackEnd.Tiles.Tile;
import BackEnd.Tiles.Wall;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    Tile tile1;
    Tile tile2;
    Position p;

    @BeforeEach
    void setUp() {
        p= new Position(5,7);
        tile1 = new Wall();
        tile1.setPosition(p);
        tile2 = new Empty();
        tile2.setPosition(new Position(9,4));
    }

    @Test
    void getTile() {
        Assert.assertEquals('#',tile1.getTile());
    }

    @Test
    void getPosition() {
        Assert.assertEquals(p,tile1.getPosition());
    }

    @Test
    void setPosition() {
        Position pSet = new Position(6,8);
        tile1.setPosition(pSet);
        Assert.assertEquals(pSet,tile1.getPosition());
    }

    @Test
    void testToString() {
        Assert.assertEquals("#",tile1.toString());
    }

    @Test
    void testComperTo(){
//        Tile tileComper =  new Empty(new Position(5,7));
//        Assert.assertEquals(tile1.compareTo(tileComper),0);
//        Assert.assertEquals(tile1.compareTo(tile2),-1);
    }

    @Test
   void range() {
//        Position tile2P = tile2.getPosition();
//        Assert.assertEquals(tile1.Range(tile2P),5.0,0);
    }
}