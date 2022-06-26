package BackEnd.Enemys;

public class Trap extends Enemy{
    public Integer VisibilityTime;
    public Integer InvisibilityTime;
    public Integer TicksCount;
    public boolean Visible;

    public Trap(String Name,char tile,Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints, Integer Experience,Integer invisibilityTime, Integer visibilityTime)
    {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints,Experience);
        this.Visible = true;
        this.TicksCount = 0;
        this.InvisibilityTime = invisibilityTime;
        this.VisibilityTime = visibilityTime;
    }
}
