package BackEnd.Tiles;
import BackEnd.Boards.Position;
import FrontEnd.Messages.DeathMessage;
import FrontEnd.Messages.MessageCallback;
import FrontEnd.Messages.PlacementCallBack;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import java.*;
import java.util.function.Supplier;

public abstract class Unit extends Tile {

    public String Name;
    protected MessageCallback messageCallback;
    protected DeathMessage deathMessage;
    protected PlacementCallBack placementCallBack;
    public Integer HealthPool;
    public Integer HealthAmount;
    public Integer AttackPoints;
    public Integer DefensePoints;
    private static Random l = (new Random());
//creating the map for the moves,if up or down or left or right, a key will be there
//    protected Map<Character, Supplier<Position>> clickOn = new HashMap<>(){
//        {
//            put(Movement.down, () -> getPosition().Down());
//        }
//    };

    protected Unit(String Name, char tile, Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints) {
        super(tile);
        this.Name = Name;
        this.HealthPool = HealthPool;
        this.HealthAmount = HealthAmount;
        this.AttackPoints = AttackPoints;
        this.DefensePoints = DefensePoints;
    }
public String get_Name(){
        return Name;
    }
    public Integer getMaxHealth(){
        return HealthPool;
    }
    public Integer getCurrentHealth(){
        return HealthAmount;
    }

    protected void initialize(Position position, MessageCallback messageCallback, DeathMessage deathMessage, PlacementCallBack placementCallBack){
        super.initialize(position);
        this.deathMessage = deathMessage;
        this.messageCallback = messageCallback;
        this.placementCallBack = placementCallBack;
    }
    protected Integer attack(){
		Random rand = new Random();
        Integer upperBound = AttackPoints;
        Integer attack = (Integer) (rand.nextInt(upperBound+1));
        messageCallback.send(String.format("%s rolled %d attack points", get_Name(),(int)(attack)));
        return attack;
    }
    protected Integer Defense(){
        Random rand = new Random();
        Integer upperBound = DefensePoints;
        Integer Defense = (Integer) (rand.nextInt(upperBound+1));
        messageCallback.send(String.format("%s rolled %d Defense points", get_Name(),(int)(Defense)));
        return Defense;
    }

    public Integer getAttack(){return AttackPoints;}
    public Integer getDefense(){return DefensePoints;}

    public abstract void onDeath();
    protected void battle(Unit u){
        messageCallback.send(String.format("%s is fighting %s \n%s \n%s ",get_Name(),u.get_Name(),describe(),u.describe()));
        int dealt = Math.max(attack()-u.Defense(),0);
        messageCallback.send(String.format("%s done %d damage to %s ",get_Name(),dealt,u.get_Name()));
        u.Reduce_Amount(dealt);
    }

    private void Reduce_Amount(int i){
        this.HealthAmount = this.HealthAmount-i;
    }
    private void setCurrentHealth(int i) {
        this.HealthAmount = i;
    }

    /*
    // Should be automatically called once the unit finishes its turn
    public abstract void processStep();


    // This unit attempts to interact with another tile.
    public void interact(Tile tile){
		...
    }

    public void visit(Empty e){
		...
    }

    public abstract void visit(Player p);
    public abstract void visit(Enemy e);

    // Combat against another unit.
    protected void battle(Unit u){
        ...
    }


    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getHealth(), getAttack(), getDefense());
    }*/
    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", get_Name(), getCurrentHealth(), getAttack(), getDefense());
    }


}
