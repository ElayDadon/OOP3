package BackEnd.Players;

import BackEnd.Unit;

public class Player extends Unit {
    protected Integer Experience;  // Increased by killing enemies
    protected Integer PlayerLevel; // Increased When Experience reached to 50 X level



    public Player( String Name,char tile, Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints)
    {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints);
        this.Experience = 0;
        this.PlayerLevel = 1;
    }

    public void LevelingUp()
    {
        if (isLevelUp()) {
            Experience = Experience-PlayerLevel * 50;
            PlayerLevel++;
            HealthPool = +10 * PlayerLevel;
            HealthAmount = HealthPool;
            AttackPoints = +4 * PlayerLevel;
            DefensePoints = +PlayerLevel;
        }
    }

    public boolean isLevelUp(){
        if (PlayerLevel * 50 <= Experience)
            return true;
        return false;
    }
    @Override
    public void accept(Unit unit) {

    }
}
