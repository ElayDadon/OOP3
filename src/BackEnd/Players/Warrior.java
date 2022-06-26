package BackEnd.Players;

import BackEnd.Enemys.Enemy;
import java.util.List;

public class Warrior extends Player{
    public static final int MAX_RANGE = 3;
    Integer abilityCooldown; // number of game ticks required to pass before using the ability.
    Integer remainingCooldown;  //number of ticks remained until the warrior can use its special ability.

    public Warrior(int abilityCooldown, char remainingCooldown)
    {
        super();
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = 0;
    }

    public void levelingUpWarrior()
    {
        super.LevelingUp();
        this.remainingCooldown = 0;
        super.HealthPool =+ 5* super.HealthPool;
        super.AttackPoints =+ 2* super.PlayerLevel;
        super.DefensePoints =+ super.DefensePoints;
    }

    public void tickingGame(){
        this.remainingCooldown = Math.max(this.remainingCooldown -1, 0);
    }

    public void abilityCasting(List<Enemy> enemies){ // Avenger's Shield
        if(remainingCooldown == 0){
            remainingCooldown = abilityCooldown;
            super.HealthAmount = Math.min(super.HealthAmount + 10* super.DefensePoints, super.HealthPool);
            List<Enemy> inRange = this.filterRange(enemies, MAX_RANGE);
            if(!inRange.isEmpty()){

            }
        } else {
            tickingGame();
        }
    }
}
