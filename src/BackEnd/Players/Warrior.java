package BackEnd.Players;

public class Warrior extends Player{
    Integer abilityCooldown; // number of game ticks required to pass before using the ability.
    Integer remainingCooldown;  //number of ticks remained until the warrior can use its special ability.

    public Warrior(String Name,
                   char tile,
                   Integer HealthPool,
                   Integer HealthAmount,
                   Integer AttackPoints,
                   Integer DefensePoints,
                   int abilityCooldown)
    {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints);
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = 0;
    }

    public void levelingUpWarrior()
    {

    }
}
