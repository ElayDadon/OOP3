package Tests;

import BackEnd.Enemys.Enemy;
import BackEnd.Enemys.Monster;
import BackEnd.Players.Rogue;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class RogueTest {

    //Rogue details:
    String Name = "Bronn";
    char tile = '@';
    Integer HealthPool = 250;
    Integer HealthAmount = 250;
    Integer AttackPoints = 35;
    Integer DefensePoints = 3;
    Integer Cost = 50;
    private Rogue Bronn;

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

    @BeforeEach
    void setUp() {
        Bronn = new Rogue(Name, tile,HealthPool,HealthAmount,AttackPoints,DefensePoints,Cost);
    }

    @Test
    void levelingUp() {
        Bronn.experience = 75;
        Bronn.CurrentEnergy = 50;
        Bronn.LevelingUp();
        Integer level = Bronn.PlayerLevel;
        Assert.assertEquals("leveling up should changes the level to 2",2, (int)level );
        Assert.assertEquals("leveling up should changes the Current Energy to 100",100 ,(int)Bronn.CurrentEnergy);
        Assert.assertEquals("leveling up should changes the Attack Points to 49",49 ,(int)Bronn.AttackPoints);
    }

    @Test
    void gameTick() {
        Bronn.CurrentEnergy= 60;
        Bronn.GameTick();
        Assert.assertEquals("GameTick should changes the Current Energy to 70",70 ,(int)Bronn.CurrentEnergy);
    }

    @Test
    void abilityCast() {
        Enemy m = new Monster(MonsterName,MonsterTile,HealthPoolMonster, HealthAmountMonster,AttackPointsMonster,DefensePointsMonster,ExperienceMonster,visionRange);
        List<Enemy> enemies = new LinkedList<Enemy>();
        enemies.add(m);
        Bronn.AbilityCast(enemies);
        Assert.assertEquals("Ability cast should changes the Current Energy to 50",50 ,(int)Bronn.CurrentEnergy);
    }
    @Test
    void abilityCastFailed() {
        Enemy m = new Monster(MonsterName,MonsterTile,HealthPoolMonster, HealthAmountMonster,AttackPointsMonster,DefensePointsMonster,ExperienceMonster,visionRange);
        List<Enemy> enemies = new LinkedList<Enemy>();
        enemies.add(m);
        Bronn.CurrentEnergy = 30;
        Bronn.AbilityCast(enemies);
        Assert.assertEquals("Ability cast should changes the Current Energy to 40",40 ,(int)Bronn.CurrentEnergy);
    }
}