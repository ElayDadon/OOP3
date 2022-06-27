package Tests;

import BackEnd.Enemys.Enemy;
import BackEnd.Enemys.Trap;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class TrapTest {

    //Monster details:
    String TrapName = "Bonus Trap";
    char TrapTile = 'B';
    Integer HealthPool = 1;
    Integer HealthAmount = 1;
    Integer AttackPoints = 1;
    Integer DefensePoints = 1;
    Integer Experience = 250;
    Integer visibilityTime = 1;
    Integer invisibilityTime =5;
    private Trap trap;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        trap = new Trap(TrapName,TrapTile,HealthPool,HealthAmount,AttackPoints,DefensePoints,Experience,invisibilityTime,visibilityTime);
    }

    @org.junit.jupiter.api.Test
    void onEnemyTurnTrue() {
        trap.TicksCount =3;
        Assert.assertTrue("visible should be true", trap.Visible);
    }
    @org.junit.jupiter.api.Test
    void onEnemyTurnFalse() {
        Assert.assertFalse("visible should be false",trap.Visible);
    }

    @org.junit.jupiter.api.Test
     void testToString() {
    }

    @org.junit.jupiter.api.Test
    void visit() {
    }

    @org.junit.jupiter.api.Test
    void testVisit() {
    }
}