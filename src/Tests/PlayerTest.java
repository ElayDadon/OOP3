package Tests;

import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Enemys.Monster;
import BackEnd.Players.Player;
import BackEnd.Players.Warrior;
import FrontEnd.Messages.MessageCallback;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    //Player details:
    String Name = "Player";
    Integer HealthPool = 100;
    Integer AttackPoints = 5;
    Integer DefensePoints = 1;
    Integer abilityCooldown = 3;
    private Player player;

    //Monster details:
    String MonsterName = "Wright";
    char MonsterTile = 'z';
    Integer HealthPoolMonster = 600;
    Integer AttackPointsMonster = 30;
    Integer DefensePointsMonster = 15;
    Integer ExperienceMonster = 100;
    Integer visionRange = 3;
    private Enemy Monster;

    private List<Enemy> enemies;
    @BeforeEach
    void setUp() {
        player = new Warrior(Name,HealthPool,AttackPoints,DefensePoints,abilityCooldown);
        player.init(new Position(5,3),(msg) -> {}, () -> {}, (pos) -> {});
        Position playerP = new Position(3,7);
        String ms = String.format("{0} \t\tHealth: {1}\t\t Attack: {2}",Name,player.getCurrentHealth(),AttackPoints);;
        Monster = new Monster(MonsterName,MonsterTile,HealthPoolMonster, AttackPointsMonster,DefensePointsMonster,ExperienceMonster,visionRange);
        Monster.init(new Position(3,1),(msg) -> {});
        enemies = new LinkedList<Enemy>();
        enemies.add(Monster);
    }

    @Test
    void levelingUp() {
        player.experience = 75;
        player.LevelingUp();
        assertEquals(25, (int)player.experience, "leveling up should changes the experience to 25");
        Assert.assertEquals("leveling up should changes the level to 2",2, (int)player.PlayerLevel);
        Assert.assertEquals("leveling up should changes the health pool to 120",120, (int)player.HealthPool);
        Assert.assertEquals("leveling up should changes the health amount to 120",120, (int)player.HealthAmount);
        Assert.assertEquals("leveling up should changes the defends points to 120",3, (int)player.DefensePoints);
        Assert.assertEquals("leveling up should changes the attack points to 120",13, (int)player.AttackPoints);
    }

    @Test
    void isLevelUpTrue() {
        player.experience = 75;
        Assert.assertTrue("Player can level up >> true", player.isLevelUp());
    }

    @Test
    void isLevelUpFalse() {
        Assert.assertFalse("Player need more experience >> false", player.isLevelUp());
    }


    @Test
    void filterRange() {
        player.filterRange(enemies,5);
        //TODO: position is missing in constructor
    }

    @Test
    void onDeath() {
        player.HealthAmount = 1;
        Monster.interact(player);
        Assert.assertFalse("user should be died", player.alive());
        Assert.assertEquals(0,(int)player.getCurrentHealth());
    }



}