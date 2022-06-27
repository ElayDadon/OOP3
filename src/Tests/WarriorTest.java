package Tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import BackEnd.Enemys.Enemy;
import BackEnd.Enemys.Monster;
import BackEnd.Players.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class WarriorTest {
    //Worrior details:
    Integer abilityCooldown = 3;
    Integer remainingCooldown = 3;
    String Name = "Jon Snow";
    char tile = '@';
    Integer HealthPool = 300;
    Integer HealthAmount = 300;
    Integer AttackPoints = 30;
    Integer DefensePoints = 4;
    private Warrior JonSnow;

    //Monster details:
    String MonsterName = "Wright";
    char MonsterTile = 'z';
    Integer HealthPoolMonster = 600;
    Integer HealtAmountMonster = 600;
    Integer AttackPointsMonster = 30;
    Integer DefensePointsMonster = 15;
    Integer ExperienceMonster = 100;
    Integer visionRange = 3;
    private Enemy Monster;

    @Before
    public void beforeAny(){
        JonSnow = new Warrior(abilityCooldown,remainingCooldown,Name,
            tile,HealthPool,HealthAmount,AttackPoints,DefensePoints);}

    public void setUp() throws Exception {}

    @org.junit.Test
    public void levelingUpWarrior() {
        JonSnow.experience = 75;
        JonSnow.levelingUpWarrior();
        Integer level  = JonSnow.PlayerLevel;
        Assert.assertEquals("leveling up should changes the level to 2", (int)level, 2);
    }

    @org.junit.Test
    public void tickingGame() {
        JonSnow.remainingCooldown = 2;
        JonSnow.tickingGame();
        Integer remainingCooldownVal = JonSnow.remainingCooldown;
        Assert.assertEquals("remaining cooldown should be 2", (int)remainingCooldownVal, 1);
    }

    @org.junit.Test
    public void abilityCasting() {
        Enemy m = new Monster(MonsterName,MonsterTile,HealthPoolMonster,HealtAmountMonster,AttackPointsMonster,DefensePointsMonster,ExperienceMonster,visionRange);
        List<Enemy> enemies = new LinkedList<Enemy>();
        enemies.add(Monster);
        JonSnow.remainingCooldown = 0;
        JonSnow.HealthAmount = 50;
        //TODO: need to check the getPosition because its null
        JonSnow.abilityCasting(enemies);
        Assert.assertEquals("remaining cooldown should be 3", (int)JonSnow.remainingCooldown, 3);
        Assert.assertEquals("healt amount should be 90", (int)JonSnow.HealthAmount, 90);
    }

    @org.junit.Test
    public void abilityCastingFailed() {
        Enemy m = new Monster(MonsterName,MonsterTile,HealthPoolMonster,HealtAmountMonster,AttackPointsMonster,DefensePointsMonster,ExperienceMonster,visionRange);
        List<Enemy> enemies = new LinkedList<Enemy>();
        enemies.add(Monster);
        JonSnow.remainingCooldown = 3;
        JonSnow.abilityCasting(enemies);
        Assert.assertEquals("remaining cooldown should be 2", (int)JonSnow.remainingCooldown, 2);
    }
}