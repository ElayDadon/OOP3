package Tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import BackEnd.Players.Warrior;
import org.junit.Assert;

import java.util.Optional;

public class WarriorTest {

    Integer abilityCooldown = 3;
    Integer remainingCooldown = 3;
    String Name = "Jon Snow";
    char tile = '@';
    Integer HealthPool = 300;
    Integer HealthAmount = 300;
    Integer AttackPoints = 30;
    Integer DefensePoints = 4;
    private Warrior JonSnow;
    public void beforeAny(){
        JonSnow = new Warrior(abilityCooldown,remainingCooldown,Name,
            tile,HealthPool,HealthAmount,AttackPoints,DefensePoints);}

    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void levelingUpWarrior() {
        Integer level  = JonSnow.PlayerLevel;
        JonSnow.levelingUpWarrior();
        Assert.assertEquals("leveling up should changes the level to 2", Optional.of(level), 1);
    }

    @org.junit.Test
    public void tickingGame() {
    }

    @org.junit.Test
    public void abilityCasting() {
    }
}