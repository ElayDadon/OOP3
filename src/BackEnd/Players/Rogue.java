package BackEnd.Players;

import BackEnd.Enemys.Enemy;
import java.util.List;
import java.text.MessageFormat;

public class Rogue extends Player{
    Integer Cost;
    Integer CurrentEnergy;

    public Rogue( String Name,
                  char tile,
                  Integer HealthPool,
                  Integer HealthAmount,
                  Integer AttackPoints,
                  Integer DefensePoints, Integer Cost) {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints, "Fan of Knives");
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

    public void AbilityCast(List<Enemy> enemies){
        if(this.CurrentEnergy>= this.Cost) {
            this.CurrentEnergy = this.CurrentEnergy - this.Cost;
            List<Enemy> EnemyInRange = super.filterRange(enemies, 2);
            for (Enemy enemy : enemies) {
                enemy.HealthAmount = enemy.HealthAmount - super.AttackPoints;
                if(enemy.isAlive())
                    this.HealthAmount = this.HealthAmount - enemy.Defense();
            }
        }
        else{
            GameTick();
            String msg = MessageFormat.format("{0} does not have enough Energy to use the ability.", super.get_Name());
            messageCallback.send(msg);
        }
    }
}
