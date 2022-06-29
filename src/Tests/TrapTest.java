package Tests;

import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Enemys.Monster;
import BackEnd.Enemys.Trap;
import org.junit.Assert;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TrapTest {

    //Trap details:
    String TrapName = "Bonus Trap";
    char TrapTile = 'B';
    Integer HealthPool = 1;
    Integer AttackPoints = 1;
    Integer DefensePoints = 1;
    Integer Experience = 250;
    Integer visibilityTime = 1;
    Integer invisibilityTime =5;
    private Trap trap;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        trap = new Trap(TrapName,TrapTile,HealthPool,AttackPoints,DefensePoints,Experience,invisibilityTime,visibilityTime);
        trap.init(new Position(3,1),(msg) -> {});
    }

    @org.junit.jupiter.api.Test
    void onEnemyTurnTrue() {
        trap.TicksCount =3;
        Assert.assertTrue("visible should be true", trap.Visible);
    }
//    @org.junit.jupiter.api.Test
//    void onEnemyTurnFalse() {
//        Assert.assertFalse("visible should be false",trap.Visible);
//    }

    @org.junit.jupiter.api.Test
     void testToString() throws Exception {
        trap.TicksCount =3;
        if(trap.toString().equals(trap.getTile()))
            throw new Exception("toString failed");
    }

}