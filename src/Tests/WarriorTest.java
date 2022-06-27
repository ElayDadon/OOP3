package Tests;

import BackEnd.Enemys.Enemy;
import BackEnd.Enemys.Monster;
import BackEnd.Players.Warrior;
import org.junit.Assert;
import org.junit.Before;

import java.util.LinkedList;
import java.util.List;

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
    Integer HealthAmountMonster = 600;
    Integer AttackPointsMonster = 30;
    Integer DefensePointsMonster = 15;
    Integer ExperienceMonster = 100;
    Integer visionRange = 3;
    private Enemy Monster;

    @Before
    public void beforeAny(){
        JonSnow = new Warrior(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints,abilityCooldown,remainingCooldown);}

    public void setUp() throws Exception {}

    @org.junit.Test
    public void levelingUpWarrior() {
        JonSnow.experience = 75;
        JonSnow.remainingCooldown = 2;
        JonSnow.levelingUpWarrior();
        Integer level  = JonSnow.PlayerLevel;
        Assert.assertEquals("leveling up should changes the level to 2",2, (int)level);
        Assert.assertEquals("leveling up should changes the remaining cooldown to 0", 0,(int)JonSnow.remainingCooldown);
        Assert.assertEquals("leveling up should changes the health pool to 330", 330 ,(int)JonSnow.HealthPool);
        Assert.assertEquals("leveling up should changes the health pool to 42", 42,(int)JonSnow.AttackPoints);
        Assert.assertEquals("leveling up should changes the health pool to 8", 8, (int)JonSnow.DefensePoints);
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
        Enemy m = new Monster(MonsterName,MonsterTile,HealthPoolMonster, HealthAmountMonster,AttackPointsMonster,DefensePointsMonster,ExperienceMonster,visionRange);
        List<Enemy> enemies = new LinkedList<Enemy>();
        enemies.add(m);
        JonSnow.remainingCooldown = 0;
        JonSnow.HealthAmount = 50;
        //TODO: need to check the getPosition because its null
        //null exception in filter range (Player)
        JonSnow.abilityCasting(enemies);
        Assert.assertEquals("remaining cooldown should be 3", (int)JonSnow.remainingCooldown, 3);
        Assert.assertEquals("health amount should be 90", (int)JonSnow.HealthAmount, 90);
    }

    @org.junit.Test
    public void abilityCastingFailed() {
        Enemy m = new Monster(MonsterName,MonsterTile,HealthPoolMonster, HealthAmountMonster,AttackPointsMonster,DefensePointsMonster,ExperienceMonster,visionRange);
        List<Enemy> enemies = new LinkedList<Enemy>();
        enemies.add(m);
        JonSnow.remainingCooldown = 3;
        JonSnow.abilityCasting(enemies);
        Assert.assertEquals("remaining cooldown should be 2", (int)JonSnow.remainingCooldown, 2);
    }
}