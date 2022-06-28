package Tests;

import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Enemys.Monster;
import BackEnd.Players.Player;
import BackEnd.Tiles.Empty;
import BackEnd.Tiles.Tile;
import BackEnd.Tiles.Unit;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    //Player details:
    String Name = "Player";
    char tile = '@';
    Integer HealthPool = 100;
    Integer HealthAmount = 100;
    Integer AttackPoints = 5;
    Integer DefensePoints = 1;
    private Player player;

    String MonsterName = "Wright";
    char MonsterTile = 'z';
    Integer HealthPoolMonster = 600;
    Integer HealthAmountMonster = 450;
    Integer AttackPointsMonster = 30;
    Integer DefensePointsMonster = 15;
    Integer ExperienceMonster = 100;
    Integer visionRange = 3;
    private Enemy monster;
    @BeforeEach
    void setUp() {
        monster = new Monster(MonsterName,MonsterTile,HealthPoolMonster, HealthAmountMonster,AttackPointsMonster,DefensePointsMonster,ExperienceMonster,visionRange);
        monster.init(new Position(3,1),(msg) -> onMessageCallback(msg));
        player = new Player(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints,"PlayerTesting");
        player.init(new Position(5,3),(msg) -> onMessageCallback(msg), () -> onDeathCallback(), (pos) -> onPleaceCallback(pos));
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
    void defense() {
        Integer defenseVal = player.Defense();
        if(defenseVal > player.DefensePoints)
            throw new RuntimeException("defense vallue is out of range");
    }

    @Test
    void getAttack() { Assert.assertEquals((int)monster.getAttack(),30); }

    @Test
    void getDefense() { Assert.assertEquals((int)monster.getDefense(),15); }


    @Test
    void interact() {
        monster.interact(player);
        if(monster.getCurrentHealth()== monster.getMaxHealth() && player.getCurrentHealth() == player.getMaxHealth())
            throw new RuntimeException("interact didn't change current health to enemy or player");
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

    void onMessageCallback(String msg){
    }
    void onDeathCallback(){}

    void onPleaceCallback(Position position){}
}