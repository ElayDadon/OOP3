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

import java.util.function.Supplier;

public abstract class Unit extends Tile {
    protected Map<Character, Function<Position,Position>> actionsMap = new HashMap<>(){
        {
            put(Movement.down, (position) -> position.Down());
            put(Movement.up, (position) -> position.Up());
            put(Movement.right, (position) -> position.Right());
            put(Movement.left, (position) -> position.Left());
            put(Movement.stay, (position) -> position.NoOperation());
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


    protected Unit(String Name, char tile, Integer HealthPool,  Integer AttackPoints, Integer DefensePoints) {
        super(tile);
        this.Name = Name;
        this.HealthPool = HealthPool;
        this.HealthAmount = HealthPool;
        this.AttackPoints = AttackPoints;
        this.DefensePoints = DefensePoints;
    }
    public Position getPosition(){
        return position;
    }

//    protected Unit(String Name,Position position, char tile, Integer HealthPool, Integer AttackPoints, Integer DefensePoints) {
//        super(tile, position);
//        this.Name = Name;
//        this.HealthPool = HealthPool;
//        this.HealthAmount = HealthPool;
//        this.AttackPoints = AttackPoints;
//        this.DefensePoints = DefensePoints;
//    }
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
        this.position = position;
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
    public Integer Defense(){
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
        int dealt = attack()-u.Defense();
        messageCallback.send(String.format("%s done %d damage to %s ",get_Name(),dealt,u.get_Name()));
        u.Reduce_Amount(dealt);
    }

    private void Reduce_Amount(int i){
        this.HealthAmount = Math.max(this.HealthAmount-i,0);
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
        super.position = position;
    }
    public void visit(Empty e){
SwapPositions(e);
    }
    public void  visit(Wall w){}
    protected void SwapPositions(Tile tile){
        int resX = position.getX();
        int resY = position.getY();
position.set(tile.position.getX(),tile.position.getY());
tile.position.set(resX,resY);
    }

    public void setMessageCallback(MessageCallback messageCallback) {
        this.messageCallback = messageCallback;
    }
    public void setPlacementCallBack(PlacementCallBack positionCallback) { this.placementCallBack = positionCallback; }
    public void setDeathCallback(DeathMessage deathCallback) {
        this.deathMessage = deathCallback;
    }

    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", get_Name(), getCurrentHealth(), getAttack(), getDefense());
    }

    public double Range(Position other_position)
    {
        return Math.sqrt(Math.pow(other_position.getX() - position.getX(), 2) + Math.pow(other_position.getY() - position.getY(), 2));
    }

}
