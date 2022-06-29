package BackEnd.Players;

import BackEnd.Enemys.Enemy;
import BackEnd.Tiles.Empty;

import java.text.MessageFormat;
import java.util.List;

public class Hunter extends Player{
    Integer range;
    Integer arrowsCount;
    Integer ticks;

    public Hunter(String Name,
                   Integer HealthPool,
                   Integer AttackPoints,
                   Integer DefensePoints,
                   Integer range)
    {
        super(Name,HealthPool,AttackPoints,DefensePoints,"Shoot");
        this.range = range;
        this.arrowsCount = 10*PlayerLevel;
        this.ticks =0;
    }

    @Override
    public void tickingGame() {
        if(this.ticks == 10) {
            arrowsCount += PlayerLevel;
            this.ticks =0;
        }
        else
            ticks +=1;
    }


    public void LevelingUp()
    {
        super.LevelingUp();
        arrowsCount += 10*PlayerLevel;
        AttackPoints += 2*PlayerLevel;
        DefensePoints +=PlayerLevel;
    }

    private Enemy findTheClosest(List<Enemy> enemies) {
        double minRange = Double.POSITIVE_INFINITY;
        Enemy returnEnemy = null;
        for(Enemy enemy : enemies){
            double ramgeVal = this.Range(enemy.getPosition());
            if(ramgeVal<minRange){
                returnEnemy = enemy;
                minRange = ramgeVal;
            }

        }
        return returnEnemy;
    }

    @Override
    public void AbilityCast(List<Enemy> enemies) {
        List<Enemy> EnemyInRange = super.filterRange(enemies, range);
        if(arrowsCount != 0 && !EnemyInRange.isEmpty()){
            arrowsCount -= 1;
            Enemy attackEnemy = findTheClosest(enemies);
            if(attackEnemy!=null) {
                int defence = attackEnemy.Defense();
                int health = Math.max(super.AttackPoints - defence, 0);
                if (attackEnemy.alive())
                    attackEnemy.HealthAmount -= health;
                else {
                    attackEnemy.onDeath();
                    enemies.remove(attackEnemy);
                }
            }

        }
        else{
            String msg = MessageFormat.format("{0} does not have enough arrows to use the ability, or there are no enemies around ", super.get_Name());
            messageCallback.send(msg);
        }

    }

    @Override
    public String currentDescribe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %s\t\tDefense: %s\t\tspecial ability: %s \n experience:%s/%s" +
                        "\t\trangeValue: %s\t\tarrows count: %s\t\tcurrent ticks: %s",
                get_Name(), getCurrentHealth(), getAttack(), getDefense(),getABILITY_NAME(),this.experience,this.experience*this.PlayerLevel*50,range,arrowsCount,ticks);
    }
}
