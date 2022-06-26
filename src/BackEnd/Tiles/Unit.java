package BackEnd.Tiles;

public abstract class Unit extends Tile {

    public String Name;
    public Integer HealthPool;
    public Integer HealthAmount;
    public Integer AttackPoints;
    public Integer DefensePoints;

    protected Unit(String Name, char tile, Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints) {
        super(tile);
        this.Name = Name;
        this.HealthPool = HealthPool;
        this.HealthAmount = HealthAmount;
        this.AttackPoints = AttackPoints;
        this.DefensePoints = DefensePoints;
    }

    @Override
    public int compareTo(Tile tile) {
        return 0;
    }
/*
    protected Unit(char tile, String name, Integer healthCapacity, Integer attack, Integer defense) {
        super(tile);
        ...
    }

    protected void initialize(Position position, MessageCallback messageCallback){
        ...
    }

    protected Integer attack(){
		...
    }

    public Integer defend(){
        ...
    }

    // Should be automatically called once the unit finishes its turn
    public abstract void processStep();

    // What happens when the unit dies
    public abstract void onDeath();

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
