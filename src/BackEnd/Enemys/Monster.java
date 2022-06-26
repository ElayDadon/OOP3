package BackEnd.Enemys;

public class Monster extends Enemy{

    protected Monster(String Name,char tile, Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints,Integer Experience)
    {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints,Experience);
    }
}
