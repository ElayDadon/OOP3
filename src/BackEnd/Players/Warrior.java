package BackEnd.Players;

import BackEnd.Enemys.Enemy;
import java.util.List;
import java.util.Random;

public class Warrior extends Player{
    public static final int MAX_RANGE = 3;
    Integer abilityCooldown; // number of game ticks required to pass before using the ability.
    public Integer remainingCooldown;  //number of ticks remained until the warrior can use its special ability.

    public Warrior(String Name,
                   Integer HealthPool,
                   Integer AttackPoints,
                   Integer DefensePoints,
                   Integer abilityCooldown)
    {
        super(Name,HealthPool,AttackPoints,DefensePoints,"Avenger's Shield");
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = abilityCooldown;
    }


    public void LevelingUp()
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


    public void AbilityCast(List<Enemy> enemies){ // Avenger's Shield
        if(remainingCooldown == 0){
            remainingCooldown = abilityCooldown; // After casting ability, should wait again
            super.HealthAmount = Math.min(super.HealthAmount + 10* super.DefensePoints, super.HealthPool);
            List<Enemy> inRange = this.filterRange(enemies, MAX_RANGE);
            messageCallback.send(String.format("%s cast %s healing for %d", get_Name(), super.ABILITY_NAME, super.HealthAmount));
            if(!inRange.isEmpty()){
                Random rand = new Random();
                Enemy e = inRange.get(rand.nextInt(inRange.size()));
                int defence = e.Defense();
                int health = super.HealthPool/10 - defence;
                e.HealthAmount -= health;
                if(!e.alive())
                    e.onDeath();
                else {
                    e.onDeath();
                    enemies.remove(e);
                }
            }
        } else {
            messageCallback.send(String.format("%s tried to cast %s, but don't have enough resources", get_Name(),super.ABILITY_NAME));
        }
    }

    @Override
    public String currentDescribe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %s\t\tDefense: %s\t\tspecial ability: %s \nexperience:%s/%s\t\t CooldDown:%s/%s",
                get_Name(), getCurrentHealth(), getAttack(), getDefense(),this.ABILITY_NAME,this.experience,this.PlayerLevel*50,remainingCooldown,abilityCooldown);
    }



}
