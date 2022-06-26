package BackEnd.Enemys;

import BackEnd.Tiles.Unit;

public class Enemy extends Unit {
    public Integer Experience;

    protected Enemy(String Name,char tile,Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints, Integer Experience) {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints);
        this.Experience = Experience;
    }
}
