package BackEnd.Players;

import BackEnd.Enemys.Enemy;
import java.util.List;
import java.util.Random;

public class Warrior extends Player{
    public static final int MAX_RANGE = 3;
    Integer abilityCooldown; // number of game ticks required to pass before using the ability.
    public Integer remainingCooldown;  //number of ticks remained until the warrior can use its special ability.

    public Warrior(String Name,
                   char tile,
                   Integer HealthPool,
                   Integer HealthAmount,
                   Integer AttackPoints,
                   Integer DefensePoints,
                   Integer abilityCooldown,
                   Integer remainingCooldown)
    {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints,"Avenger's Shield");
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = remainingCooldown;
    }

    public void levelingUpWarrior()
    {
        super.LevelingUp();
        this.remainingCooldown = 0;
        super.HealthPool += 5* super.PlayerLevel;
        super.AttackPoints += 2* super.PlayerLevel;
        super.DefensePoints += super.PlayerLevel;
    }

    public void tickingGame(){
        this.remainingCooldown = Math.max(this.remainingCooldown -1, 0);
    }

    public void abilityCasting(List<Enemy> enemies){ // Avenger's Shield
        if(remainingCooldown == 0){
            remainingCooldown = abilityCooldown; // After casting ability, should wait again
            super.HealthAmount = Math.min(super.HealthAmount + 10* super.DefensePoints, super.HealthPool);
            List<Enemy> inRange = this.filterRange(enemies, MAX_RANGE);
            messageCallback.send(String.format("%s cast %s healing for %d", get_Name(), super.ABILITY_NAME, super.HealthAmount));
            if(!inRange.isEmpty()){
                Random rand = new Random();
                Enemy e = inRange.get(rand.nextInt(inRange.size()));
                e.HealthAmount =  e.HealthAmount - super.HealthPool/10;
                if(e.isAlive())
                    this.HealthAmount = this.HealthAmount - e.Defense();
            }
        } else {
            messageCallback.send(String.format("%s tried to cast %s, but don't have enough resources", get_Name(),super.ABILITY_NAME));
            tickingGame();
        }
    }
}
