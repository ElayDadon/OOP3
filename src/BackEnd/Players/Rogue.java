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

    public void LevelingUp() {
        if(isLevelUp()){
            super.LevelingUp();
            this.CurrentEnergy = 100;
            //ToDO: need t verify if we need to overwrite the super levelingup
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
                enemy.HealthAmount -=  super.AttackPoints;
                if(enemy.isAlive())
                    this.HealthAmount -= enemy.Defense();
            }
        }
        else{
            tickingGame();
            String msg = MessageFormat.format("{0} does not have enough Energy to use the ability.", super.get_Name());
            messageCallback.send(msg);
        }
    }
}
