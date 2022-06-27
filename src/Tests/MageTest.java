package Tests;

import BackEnd.Enemys.Enemy;
import BackEnd.Players.Mage;
import BackEnd.Players.Rogue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    //Mage details:
    String Name = "Melisandre";
    char tile = '@';
    Integer HealthPool = 100;
    Integer HealthAmount = 100;
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
    Integer HealthAmountMonster = 600;
    Integer AttackPointsMonster = 30;
    Integer DefensePointsMonster = 15;
    Integer ExperienceMonster = 100;
    Integer visionRange = 3;
    private Enemy Monster;

    @BeforeEach
    void setUp() {
        Melisandre = new Mage(Name, tile,HealthPool,HealthAmount,AttackPoints,DefensePoints,ManaPool,ManaCost,SpellPower,HitCount,Range);
    }

    @Test
    void levelingUp() {
        Melisandre.experience = 75;
        Melisandre.LevelingUp();

    }

    @Test
    void gameTick() {
    }

    @Test
    void abilityCast() {
    }
}