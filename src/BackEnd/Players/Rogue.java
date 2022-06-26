package BackEnd.Players;

public class Rogue extends Player{
    public Rogue( String Name,
                  char tile,
                  Integer HealthPool,
                  Integer HealthAmount,
                  Integer AttackPoints,
                  Integer DefensePoints) {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints);
    }
}
