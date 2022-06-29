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


    public String currentDescribe(){
        return String.format("%s\t\tHealth: %s\t\tAttack: %s\t\tDefense: %s\t\tspecial ability: %s \n experience:%s/%s" +
                "\t\tMama: %s/%s\t\t MamaCost: %s \t\t SpellPower: %s\t\t HitsCount: %s\t\t AbilityRange: %s",
                get_Name(), getCurrentHealth(), getAttack(), getDefense(),this.ABILITY_NAME,this.experience,this.experience*this.PlayerLevel*50,CurrentMama,ManaPool,MamaCost,SpellPower,HitsCount,AbilityRange);

    }

    //Mage can't use the ability if mama cost > current mama
    private boolean canCostTheAbility(){
        if(this.CurrentMama > this.MamaCost)
            return true;
        return false;
    }

    public void AbilityCast(List<Enemy> enemies){
        if(canCostTheAbility()){
            this.CurrentMama -= this.MamaCost;
            Integer hits =0;
            List<Enemy> EnemyInRange = super.filterRange(enemies,this.AbilityRange);
            Random rand = new Random();
            while ((hits < this.HitsCount) && !EnemyInRange.isEmpty()){
                Enemy enemyAttack = EnemyInRange.get(rand.nextInt(EnemyInRange.size()));
                int defence = enemyAttack.Defense();
                int health =  Math.max(this.SpellPower - defence,0);
                hits++;
                if(!enemyAttack.alive()) {
                    enemyAttack.onDeath();
                    EnemyInRange.remove(enemyAttack);
                }
                else{
                    enemyAttack.HealthAmount -= health;
                }
            }
        }
        else {
            String msg = MessageFormat.format("{0} does not have enough Mama to use the ability.", super.get_Name());
            messageCallback.send(msg);
        }

    }
}