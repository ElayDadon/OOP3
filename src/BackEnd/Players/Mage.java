package BackEnd.Players;


public class Mage extends Player{
    Integer ManaPool; //maximal value of mama
    Integer CurrentMama; //current amount of mama
    Integer MamaCost; // ability cost
    Integer SpellPower; // ability scale factor
    Integer HitsCount; // maximal numbers of times a single cast can hit
    Integer AbilityRange;

    public Mage(String Name,char tile, Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints, Integer ManaPool, Integer MamaCost, Integer SpellPower, Integer HitsCount, Integer AbilityRange){
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints);
        this.ManaPool = ManaPool;
        this.CurrentMama = this.ManaPool/4;
        this.MamaCost = MamaCost;
        this.SpellPower = SpellPower;
        this.HitsCount = HitsCount;
        this.AbilityRange = AbilityRange;
    }

    public void LevelingUp(){
        //ToDO: player function
        boolean isLevelingUp = super.LevelingUp();
        if(isLevelingUp){
            this.ManaPool = ManaPool + 25*super.PlayerLevel;
            this.CurrentMama = Math.min(this.CurrentMama +this.ManaPool/4, this.ManaPool);
            this.SpellPower = SpellPower + 10*super.PlayerLevel;
        }
    }
}