package BackEnd.Players;

import BackEnd.Unit;

public class Player extends Unit {
    protected int Experience;  // Increased by killing enemies
    protected int PlayerLevel; // Increased When Experience reached to 50 X level



    public Player(int Experience, int PlayerLevel, int HealthPool, int HealthAmount)
    {
        super();
        this.Experience = Experience;
        this.PlayerLevel = PlayerLevel;
    }

    public Player()
    {
        //super();
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
