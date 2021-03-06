package BackEnd.Players;

import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Tiles.Unit;
import FrontEnd.Messages.DeathMessage;
import FrontEnd.Messages.MessageCallback;
import FrontEnd.Messages.PlacementCallBack;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Player extends Unit {
    public static char castAbility = 'e';
    public Integer experience = 0;  // Increased by killing enemies
    public Integer PlayerLevel; // Increased When Experience reached to 50 X level
    protected final String ABILITY_NAME;
    public static final char PLAYER_TILE = '@';


    public Player(String Name, Integer HealthPool, Integer AttackPoints, Integer DefensePoints,String ability_name)
    {
        super(Name,PLAYER_TILE,HealthPool,AttackPoints,DefensePoints);
        ABILITY_NAME = ability_name;
        this.experience = 0;
        this.PlayerLevel = 1;
    }

    public void init(Position position, MessageCallback messageCallback, PlacementCallBack placementCallBack){
        DeathMessage deathMessage = () -> System.out.println(String.format("{o} enemy died", super.Name));
        super.initialize(position,messageCallback,deathMessage,placementCallBack);
    }

    public void LevelingUp()
    {
        if (isLevelUp()) {
            experience -= PlayerLevel * 50;
            PlayerLevel += 1;
            HealthPool += 10 * PlayerLevel;
            HealthAmount = HealthPool;
            AttackPoints += 4 * PlayerLevel;
            DefensePoints += PlayerLevel;

            messageCallback.send(String.format("{0} leveling up to {1}",Name,PlayerLevel));
        }
    }

    public boolean isLevelUp(){
        if (PlayerLevel * 50 <= experience)
            return true;
        return false;
    }

    public abstract void tickingGame();
    public abstract void AbilityCast(List<Enemy> enemies);

    @Override
    public void accept(Unit unit) { unit.visit(this); }

    public List<Enemy> filterRange(List<Enemy> enemies, int range){
        return enemies.stream().filter(e -> this.Range(e.getPosition()) < range).collect(Collectors.toList());
    }

    public String getABILITY_NAME(){return ABILITY_NAME;}

    @Override
    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d\t\tspecial ability: %s\t\t", get_Name(), getCurrentHealth(), getAttack(), getDefense(),getABILITY_NAME());
    }

    public abstract String currentDescribe();
    @Override
    public void onDeath() {
        messageCallback.send("You lost.");
        deathMessage.show();
    }

    @Override
    public void visit(Player p) {}

    @Override
    public void visit(Enemy e) {
        super.battle(e);
        if(!e.alive()){
            experience += e.Experience;
            while(this.isLevelUp())
                this.LevelingUp();
        }

    }
}
