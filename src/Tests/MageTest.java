package Tests;

import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Enemys.Monster;
import BackEnd.Players.Mage;
import BackEnd.Players.Rogue;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    //Mage details:
    String Name = "Melisandre";
    Integer HealthPool = 100;
    Integer AttackPoints = 5;
    Integer DefensePoints = 1;
    Integer ManaPool = 300;
    Integer ManaCost = 30;
    Integer SpellPower = 15;
    Integer HitCount = 5;
    Integer Range = 6;
    private Mage Melisandre;

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
        Melisandre = new Mage(Name, HealthPool,DefensePoints,AttackPoints,ManaPool,ManaCost,SpellPower,HitCount,Range);
        Melisandre.init(new Position(3,5),(msg) -> {}, () -> {}, (pos) -> {});
        Monster = new Monster(MonsterName,MonsterTile,HealthPoolMonster,AttackPointsMonster,DefensePointsMonster,ExperienceMonster,visionRange);
        Monster.init(new Position(3,1),(msg) -> {});
        enemies = new LinkedList<Enemy>();
        enemies.add(Monster);
    }

    @Test
    void levelingUp() {
        Melisandre.experience = 75;
        Melisandre.LevelingUp();
        Integer level = Melisandre.PlayerLevel;
        Assert.assertEquals("leveling up should changes the level to 2",2, (int)level);
        Assert.assertEquals("leveling up should changes the Mama pool to 350",350, (int)Melisandre.ManaPool);
        Assert.assertEquals("leveling up should changes the current Mama to 174",162, (int)Melisandre.CurrentMama);
        Assert.assertEquals("leveling up should changes the spell power to 35",35, (int)Melisandre.SpellPower);
    }

    @Test
    void gameTick() {
        Melisandre.tickingGame();
        Assert.assertEquals("game tick should changes the current Mama to 76",76, (int)Melisandre.CurrentMama);
    }

    @Test
    void abilityCast() {
        Melisandre.AbilityCast(enemies);
        Assert.assertEquals("Ability Cast should changes the current Mama to 45",45, (int)Melisandre.CurrentMama);
    }

    @Test
    void abilityCastFailed() {
        Melisandre.CurrentMama = 20;
        Melisandre.AbilityCast(enemies);
        Assert.assertEquals("Ability Cast should changes the current Mama to 21",21, (int)Melisandre.CurrentMama);
    }

}