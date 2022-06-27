package BackEnd.Players;

import BackEnd.Enemys.Enemy;
import BackEnd.Tiles.Unit;
import FrontEnd.Messages.MessageCallback;

import java.util.List;
import java.util.stream.Collectors;

public class Player extends Unit {
    public Integer experience = 0;  // Increased by killing enemies
    public Integer PlayerLevel; // Increased When Experience reached to 50 X level
    protected final String ABILITY_NAME;
    public static final char PLAYER_TILE = '@';
    MessageCallback messageCallback;



    public Player(String Name, char tile, Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints, String ability_name)
    {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints);
        ABILITY_NAME = ability_name;
        this.experience = 0;
        this.PlayerLevel = 1;
    }

    public void LevelingUp()
    {
        if (isLevelUp()) {
            experience = experience-PlayerLevel * 50;
            PlayerLevel++;
            HealthPool = HealthPool +10 * PlayerLevel;
            HealthAmount = HealthPool;
            AttackPoints = AttackPoints +4 * PlayerLevel;
            DefensePoints = DefensePoints +PlayerLevel;
            messageCallback.send(String.format("{0} leveling up to {1}",Name,PlayerLevel));
        }
    }

    public boolean isLevelUp(){
        if (PlayerLevel * 50 <= experience)
            return true;
        return false;
    }


    @Override
    public void accept(Unit unit) {

    }

    public List<Enemy> filterRange(List<Enemy> enemies, int range){
        return enemies.stream().filter(e -> this.Range(e.getPosition()) < range).collect(Collectors.toList());
    }

    @Override
    public void onDeath() {
        messageCallback.send("You lost.");
    }

    @Override
    public void visit(Player p) {

    }

    @Override
    public void visit(Enemy e) {

    }
}
