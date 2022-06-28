package Tests;

import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Enemys.Monster;
import BackEnd.Players.Player;
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
    char tile = '@';
    Integer HealthPool = 100;
    Integer HealthAmount = 100;
    Integer AttackPoints = 5;
    Integer DefensePoints = 1;
    private Player player;

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

    private List<Enemy> enemies;
    @BeforeEach
    void setUp() {
        player = new Player(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints,"PlayerTesting");
        player.init(new Position(5,3),(msg) -> onMessageCallback(""), () -> onDeathCallback(), (pos) -> onPleaceCallback(pos));
        Position playerP = new Position(3,7);
        String ms = String.format("{0} \t\tHealth: {1}\t\t Attack: {2}",Name,HealthAmount,AttackPoints);;
        Monster = new Monster(MonsterName,MonsterTile,HealthPoolMonster, HealthAmountMonster,AttackPointsMonster,DefensePointsMonster,ExperienceMonster,visionRange);
        Monster.init(new Position(3,1),(msg) -> onMessageCallback(""));
        enemies = new LinkedList<Enemy>();
        enemies.add(Monster);
    }

//    @Test
//    void levelingUp() {
//        player.experience = 75;
//        player.LevelingUp();
//        assertEquals(25, (int)player.experience, "leveling up should changes the experience to 25");
//        Assert.assertEquals("leveling up should changes the level to 2",2, (int)player.PlayerLevel);
//        Assert.assertEquals("leveling up should changes the health pool to 120",120, (int)player.HealthPool);
//        Assert.assertEquals("leveling up should changes the health amount to 120",120, (int)player.HealthAmount);
//        Assert.assertEquals("leveling up should changes the attack points to 120",13, (int)player.AttackPoints);
//        Assert.assertEquals("leveling up should changes the defends points to 120",3, (int)player.DefensePoints);
//
//    }

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
        player.filterRange(enemies,5);
        //TODO: position is missing in constructor
    }

    @Test
    void onDeath() {
        player.HealthAmount = 3;
        Monster.interact(player);

        System.out.println(player.getCurrentHealth());
        System.out.println(Monster.getCurrentHealth());
//        assertEquals( "player health score is not correct");

    }

    @Test
    void battle(){
        Monster.interact(player);
    }

    void onMessageCallback(String msg){
    }
    void onDeathCallback(){}

    void onPleaceCallback(Position position){}
}