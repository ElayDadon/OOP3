package BackEnd.Tiles;
import BackEnd.Boards.Movement;
import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Players.Player;
import FrontEnd.Messages.DeathMessage;
import FrontEnd.Messages.MessageCallback;
import FrontEnd.Messages.PlacementCallBack;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import java.*;
import java.util.function.Supplier;

public abstract class Unit extends Tile {
    protected Map<Character, Supplier<Position>> actionsMap = new HashMap<>(){
        {
            put(Movement.down, () -> getPosition().Down());
            put(Movement.up, () -> getPosition().Up());
            put(Movement.right, () -> getPosition().Right());
            put(Movement.left, () -> getPosition().Left());
            put(Movement.stay, () -> getPosition().NoOperation());
        }
    };
    public String Name;
    protected MessageCallback messageCallback;
    protected DeathMessage deathMessage;
    protected PlacementCallBack placementCallBack;
    public Integer HealthPool;
    public Integer HealthAmount;
    public Integer AttackPoints;
    public Integer DefensePoints;
    protected Position position;
    private static Random l = (new Random());


    protected Unit(String Name, char tile, Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints) {
        super(tile);
        this.Name = Name;
        this.HealthPool = HealthPool;
        this.HealthAmount = HealthAmount;
        this.AttackPoints = AttackPoints;
        this.DefensePoints = DefensePoints;
    }
    protected Unit(String Name,Position position, char tile, Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints) {
        super(tile, position);
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

    public void interact(Tile t){
        t.accept(this);
    }
    public boolean alive(){
        return getCurrentHealth()>0;
    }
    public abstract void visit(Player p);
    public abstract void visit(Enemy e);
    public void set_Position(Position position){
        this.position = position;
    }
    public void visit(Empty e){

    }
    protected void SwapPositions(Tile tile){
        int resX = position.getX();
        int resY = position.getY();
position.set(tile.position.getX(),tile.position.getY());
tile.position.set(resX,resY);
    }

    /*
    // Should be automatically called once the unit finishes its turn
    public abstract void processStep();


    // This unit attempts to interact with another tile.
    public void visit(Empty e){
		...
    }
*/
    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", get_Name(), getCurrentHealth(), getAttack(), getDefense());
    }


}
