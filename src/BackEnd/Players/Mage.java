package BackEnd.Players;


import BackEnd.Enemys.Enemy;

import java.util.*;

public class Mage extends Player{
    Integer ManaPool; //maximal value of mama
    Integer CurrentMama; //current amount of mama
    Integer MamaCost; // ability cost
    Integer SpellPower; // ability scale factor
    Integer HitsCount; // maximal numbers of times a single cast can hit
    Integer AbilityRange;

    public Mage(String Name,char tile, Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints, Integer ManaPool, Integer MamaCost, Integer SpellPower, Integer HitsCount, Integer AbilityRange){
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints, ability_name);
        this.ManaPool = ManaPool;
        this.CurrentMama = this.ManaPool/4;
        this.MamaCost = MamaCost;
        this.SpellPower = SpellPower;
        this.HitsCount = HitsCount;
        this.AbilityRange = AbilityRange;
    }

    public void LevelingUp(){
        if(isLevelUp()){
            super.LevelingUp();
            this.ManaPool = ManaPool + 25*super.PlayerLevel;
            this.CurrentMama = Math.min(this.CurrentMama +this.ManaPool/4, this.ManaPool);
            this.SpellPower = SpellPower + 10*super.PlayerLevel;
        }
    }

    public void GameTick(){
        this.CurrentMama = Math.min(this.ManaPool, (this.CurrentMama +1))*PlayerLevel;
    }

    //Mage can't use the ability if mama cost > current mama
    private boolean canCostTheAbility(){
        if(this.CurrentMama > this.MamaCost)
            return true;
        return false;
    }

    public void AbilityCast(Player player, List<Enemy> enemies){
        //TODO: need to implement
        if(canCostTheAbility()){
            this.CurrentMama = this.CurrentMama - this.MamaCost;
            Integer hits =0;
            List<Enemy> EnemyInRange;
            Random rand = new Random();
            while ((hits < this.HitsCount) && !EnemyInRange.isEmpty()){
                Enemy enemyAttack = EnemyInRange.get(rand.nextInt(EnemyInRange.size()));
                //enemyAttack.HealthAmount;
                hits++;
            }
        }
        else {
            //TODO: send  message with an error
        }

    }
}