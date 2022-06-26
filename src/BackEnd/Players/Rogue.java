package BackEnd.Players;

public class Rogue extends Player{
    Integer Cost;
    Integer CurrentEnergy;

    public Rogue( String Name,
                  char tile,
                  Integer HealthPool,
                  Integer HealthAmount,
                  Integer AttackPoints,
                  Integer DefensePoints, Integer Cost) {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints);
        this.Cost = Cost;
        this.CurrentEnergy = 100;
    }

    public void LevelingUp() {
        if(isLevelUp()){
            super.LevelingUp();
            this.CurrentEnergy = 100;
            //ToDO: need t verify if we need to overwrite the super levelingup
            super.AttackPoints = super.AttackPoints + 3*super.PlayerLevel;
        }

    }
}
