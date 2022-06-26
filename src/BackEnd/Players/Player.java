package BackEnd.Players;

import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Tiles.Unit;

import java.util.List;
import java.util.stream.Collectors;

public class Player extends Unit {
    protected int experience = 0;  // Increased by killing enemies
    protected int PlayerLevel; // Increased When Experience reached to 50 X level
    protected final String ABILITY_NAME;
    public static final char PLAYER_TILE = '@';


    public Player( int HealthPool, int HealthAmount, char tile)
    {
        super(tile);
        this.experience = 0;
        this.PlayerLevel = 1;
    }

    public void LevelingUp()
    {
        if (PlayerLevel * 50 <= experience){
            experience =- PlayerLevel*50;
            PlayerLevel ++;
            HealthPool =+ 10 * PlayerLevel;
            HealthAmount = HealthPool;
            AttackPoints =+4 * PlayerLevel;
            DefensePoints =+ PlayerLevel;
        }
    }

    public List<Enemy> filterRange(List<Enemy> enemies, int range){
        return enemies.stream().filter(e -> this.Range(e.getPosition()) < range).collect(Collectors.toList());
    }
}
