package BackEnd.Players;

import BackEnd.Enemys.Enemy;
import java.util.List;
import java.text.MessageFormat;

public class Rogue extends Player{
    Integer Cost;
    public Integer CurrentEnergy;

    public Rogue( String Name,
                  Integer HealthPool,
                  Integer AttackPoints,
                  Integer DefensePoints, Integer Cost) {
        super(Name,HealthPool,AttackPoints,DefensePoints,  "Fan of Knives");
        this.Cost = Cost;
        this.CurrentEnergy = 100;
    }

    @Override
    public String currentDescribe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %s\t\tDefense: %s\t\tspecial ability: %s \n experience:%s/%s" +
                "\t\tcurrentEnergy: %s\t\t cost:%s",
                get_Name(), getCurrentHealth(), getAttack(), getDefense(),getABILITY_NAME(),this.experience,this.PlayerLevel*50,CurrentEnergy,Cost);
    }


    public void LevelingUp() {
        if(isLevelUp()){
            super.LevelingUp();
            this.CurrentEnergy = 100;
            AttackPoints += 3*super.PlayerLevel;
        }
    }

    public void tickingGame(){
        this.CurrentEnergy = Math.min(this.CurrentEnergy+10, 100);
    }

    public void AbilityCast(List<Enemy> enemies){
        if(this.CurrentEnergy>= this.Cost) {
            this.CurrentEnergy -= this.Cost;
            List<Enemy> EnemyInRange = super.filterRange(enemies, 2);
            for (Enemy enemy : enemies) {
                int defence = enemy.Defense();
                int health =  Math.max(super.AttackPoints - defence,0);
                if(enemy.alive())
                   enemy.HealthAmount -= health;
                else {
                    enemy.onDeath();
                    enemies.remove(enemy);
                }
            }
        }
        else{
            String msg = MessageFormat.format("{0} does not have enough Energy to use the ability.", super.get_Name());
            messageCallback.send(msg);
        }
    }
}
