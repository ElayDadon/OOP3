package BackEnd.Players;

public class Player extends Unit {
    protected Integer Experience;  // Increased by killing enemies
    protected Integer PlayerLevel; // Increased When Experience reached to 50 X level



    public Player( String Name,char tile, Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints)
    {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints);
        this.Experience = 0;
        this.PlayerLevel = 1;
    }

//    public void LevelingUp()
//    {
//        if (PlayerLevel * 50 <= Experience){
//            Experience =- PlayerLevel*50;
//            PlayerLevel ++;
//            HealthPool =+ 10 * PlayerLevel;
//            HealthAmount = HealthPool;
//            AttackPoints =+4 * PlayerLevel;
//            DefensePoints =+ PlayerLevel;
//        }
//    }
}
