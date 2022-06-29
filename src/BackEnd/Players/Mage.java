package BackEnd.Players;

import FrontEnd.Messages.MessageCallback;
import BackEnd.Enemys.Enemy;
import java.text.MessageFormat;
import java.util.*;

public class Mage extends Player{
    public Integer ManaPool; //maximal value of mama
    public Integer CurrentMama; //current amount of mama
    public Integer MamaCost; // ability cost
    public Integer SpellPower; // ability scale factor
    public Integer HitsCount; // maximal numbers of times a single cast can hit
    Integer AbilityRange;

    public Mage(String Name, Integer HealthPool, Integer AttackPoints, Integer DefensePoints, Integer ManaPool, Integer MamaCost, Integer SpellPower, Integer HitsCount, Integer AbilityRange){
        super(Name,HealthPool,AttackPoints,DefensePoints, "Blizzard");
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
            this.ManaPool += 25*super.PlayerLevel;
            this.CurrentMama = Math.min(this.CurrentMama +this.ManaPool/4, this.ManaPool);
            this.SpellPower += 10*super.PlayerLevel;
        }
    }

    public void tickingGame(){
        this.CurrentMama = Math.min(this.ManaPool, (this.CurrentMama+this.PlayerLevel ));
    }

    //Mage can't use the ability if mama cost > current mama
    private boolean canCostTheAbility(){
        if(this.CurrentMama > this.MamaCost)
            return true;
        return false;
    }

    public void AbilityCast(List<Enemy> enemies){
        //TODO: need to implement
        if(canCostTheAbility()){
            this.CurrentMama -= this.MamaCost;
            Integer hits =0;
            List<Enemy> EnemyInRange = super.filterRange(enemies,this.AbilityRange);
            Random rand = new Random();
            while ((hits < this.HitsCount) && !EnemyInRange.isEmpty()){
                Enemy enemyAttack = EnemyInRange.get(rand.nextInt(EnemyInRange.size()));
                enemyAttack.HealthAmount -= this.SpellPower;
                hits++;
                if(!enemyAttack.isAlive())
                    EnemyInRange.remove(enemyAttack);
                else{
                    this.HealthAmount -= enemyAttack.Defense();
                }
            }
        }
        else {
            tickingGame();
            String msg = MessageFormat.format("{0} does not have enough Mama to use the ability.", super.get_Name());
            messageCallback.send(msg);
        }

    }
}