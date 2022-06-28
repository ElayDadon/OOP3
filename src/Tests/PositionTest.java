package Tests;

import BackEnd.Boards.Position;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    Position pointTest;
    @BeforeEach
    void setUp() {
        pointTest = new Position(5,8);
    }

    @Test
    void set() {
        pointTest.set(4,3);
        Assert.assertEquals("After set x should be 4",4,pointTest.getX());
        Assert.assertEquals("After set y should be 3",3,pointTest.getY());
    }

    @Test
    void compareTo() {
        Position point2 = new Position(5,8);
        Assert.assertEquals("positions should be equales",0,pointTest.compareTo(point2));
        point2.set(5,9);
        Assert.assertEquals("position not should be equales",-1,pointTest.compareTo(point2));
    }

    @Test
    void getX() {
        Assert.assertEquals("x should be 5",5,pointTest.getX());
    }

    @Test
    void getY() {
        Assert.assertEquals("y should be 8",8,pointTest.getY());
    }

    @Test
    void up() {
        Position p = pointTest.Up();
        Assert.assertEquals("y should be 7",7,p.getY());
    }

    @Test
    void down() {
        Position p = pointTest.Down();
        Assert.assertEquals("y should be 9",9,p.getY());
    }

    @Test
    void left() {
        Position p = pointTest.Left();
        Assert.assertEquals("x should be 4",4 ,p.getX());
    }

    @Test
    void right() {
        Position p = pointTest.Right();
        Assert.assertEquals("x should be 6",6 ,p.getX());
    }

    @Test
    void noOperation() {
        Position p = pointTest.NoOperation();
        Assert.assertEquals("x should be 5",5,p.getX());
        Assert.assertEquals("y should be 8",8,p.getY());
    }
}