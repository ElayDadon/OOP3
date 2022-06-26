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
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints, ability_name);
        this.Cost = Cost;
        this.CurrentEnergy = 100;
    }

    public void LevelingUp() {
        if(isLevelUp()){
            super.LevelingUp();
            this.CurrentEnergy = 100;
            //ToDO: need t verify if we need to overwrite the super levelingup
            AttackPoints = AttackPoints + 3*super.PlayerLevel;
        }
    }

    public void GameTick(){
        this.CurrentEnergy = Math.min(this.CurrentEnergy+10, 100);
    }

    public void AbilityCast(){
        this.CurrentEnergy = this.CurrentEnergy - this.Cost;
        //TODO: need to implement
    }
}
