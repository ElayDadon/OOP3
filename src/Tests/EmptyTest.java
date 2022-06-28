package Tests;

import BackEnd.Boards.Position;
import BackEnd.Tiles.Empty;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyTest {

    Empty empty;
    @BeforeEach
    void setUp() {
        Position position = new Position(3,4);
        empty = new Empty(position);
    }

    @Test
    void testToString() {
        if(!empty.toString().equals("."))
            throw new RuntimeException("toString in 'empty' not equale to expected");
    }
}