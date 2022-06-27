package Tests;

import BackEnd.Players.Player;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    //Player details:
    String Name = "Player";
    char tile = '@';
    Integer HealthPool = 100;
    Integer HealthAmount = 100;
    Integer AttackPoints = 5;
    Integer DefensePoints = 1;
    private Player player;
    @BeforeEach
    void setUp() {
        player = new Player(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints,"PlayerTesting");
    }

    @Test
    void levelingUp() {
        player.experience = 75;
        player.LevelingUp();
        Assert.assertEquals("leveling up should changes the experience to 25",25, (int)player.experience);
        Assert.assertEquals("leveling up should changes the level to 2",2, (int)player.PlayerLevel);
        Assert.assertEquals("leveling up should changes the health pool to 120",120, (int)player.HealthPool);
        Assert.assertEquals("leveling up should changes the health amount to 120",120, (int)player.HealthAmount);
        Assert.assertEquals("leveling up should changes the attack points to 120",13, (int)player.AttackPoints);
        Assert.assertEquals("leveling up should changes the defends points to 120",3, (int)player.DefensePoints);

    }

    @Test
    void isLevelUpTrue() {
        player.experience = 75;
        Assert.assertTrue("Player can level up >> true", player.isLevelUp());
    }

    @Test
    void isLevelUpFalse() {
        Assert.assertFalse("Player need more expriencr >> false", player.isLevelUp());
    }

    @Test
    void accept() {
    }

    @Test
    void filterRange() {
    }

    @Test
    void onDeath() {
    }

    @Test
    void visit() {
    }

    @Test
    void testVisit() {
    }
}