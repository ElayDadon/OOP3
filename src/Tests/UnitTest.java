package Tests;

import BackEnd.Boards.Position;
import BackEnd.Enemys.Monster;
import BackEnd.Tiles.Empty;
import BackEnd.Tiles.Tile;
import BackEnd.Tiles.Unit;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    String MonsterName = "Wright";
    char MonsterTile = 'z';
    Integer HealthPoolMonster = 600;
    Integer HealthAmountMonster = 450;
    Integer AttackPointsMonster = 30;
    Integer DefensePointsMonster = 15;
    Integer ExperienceMonster = 100;
    Integer visionRange = 3;
    private Unit monster;
    @BeforeEach
    void setUp() {
        monster = new Monster(MonsterName,MonsterTile,HealthPoolMonster, HealthAmountMonster,AttackPointsMonster,DefensePointsMonster,ExperienceMonster,visionRange);

    }

    @Test
    void get_Name() {
        Assert.assertEquals(monster.get_Name(),"Wright");
    }

    @Test
    void getMaxHealth() {
        Assert.assertEquals((int)monster.getMaxHealth(),600);
    }

    @Test
    void getCurrentHealth() {
        Assert.assertEquals((int)monster.getCurrentHealth(),450);    }

    @Test
    void attack() {   }

    @Test
    void defense() {
    }

    @Test
    void getAttack() { Assert.assertEquals((int)monster.getAttack(),30); }

    @Test
    void getDefense() { Assert.assertEquals((int)monster.getDefense(),15); }

    @Test
    void battle() {
    }

    @Test
    void interact() {
    }

    @Test
    void alive() { Assert.assertTrue(monster.alive()); }

    @Test
    void set_Position() {
        Position pTest =new Position(3,2);
        monster.set_Position(pTest);
        Position monP = monster.getPosition();
        Assert.assertEquals(monP.compareTo(pTest),0);
    }


    @Test
    void describe() {
       String expectedString = String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", MonsterName, HealthAmountMonster, AttackPointsMonster, DefensePointsMonster);
        String monsterDescribe = monster.describe();
        if(!expectedString.equals(monsterDescribe)){
            throw new RuntimeException("descrive results is not as expected");
        }
    }
}