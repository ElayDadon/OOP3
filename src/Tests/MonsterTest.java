package Tests;

import BackEnd.Enemys.Enemy;
import BackEnd.Enemys.Monster;
import BackEnd.Enemys.Trap;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    //Monster details:
    String MonsterName = "Wright";
    char MonsterTile = 'z';
    Integer HealthPoolMonster = 600;
    Integer HealthAmountMonster = 600;
    Integer AttackPointsMonster = 30;
    Integer DefensePointsMonster = 15;
    Integer ExperienceMonster = 100;
    Integer visionRange = 3;
    private Monster monster;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        monster = new Monster(MonsterName,MonsterTile,HealthPoolMonster, HealthAmountMonster,AttackPointsMonster,DefensePointsMonster,ExperienceMonster,visionRange);
    }

    @Test
    void isAliveTestTrue(){
        Assert.assertTrue(monster.isAlive());
    }

    @Test
    void isAliveTestFalse(){
        monster.HealthAmount = 0;
        Assert.assertFalse(monster.isAlive());
    }
    @Test
    void onEnemyTurn() {
    }

    @Test
    void playerTrackPattern() {
    }

    @Test
    void visit() {
    }

    @Test
    void testVisit() {
    }
}