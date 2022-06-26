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
        return attack;
    }
    protected Integer Defense(){
        Random rand = new Random();
        Integer upperBound = DefensePoints;
        Integer Defense = (Integer) (rand.nextInt(upperBound+1));
        return Defense;
    }

    public Integer getAttack(){return AttackPoints;}
    public Integer getDefense(){return DefensePoints;}

    public abstract void onDeath();

    public Integer getHealthAmount(){
        return this.HealthAmount;
    }

    public void setHealthAmount(Integer value){
        this.HealthAmount = value;
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


}
