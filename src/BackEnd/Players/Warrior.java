package BackEnd.Players;

public class Warrior extends Player{
    Integer abilityCooldown; // number of game ticks required to pass before using the ability.
    Integer remainingCooldown;  //number of ticks remained until the warrior can use its special ability.

    public Warrior(int abilityCooldown, char remainingCooldown)
    {
        super();
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = 0;
    }

    public void levelingUpWarrior()
    {
        super.LevelingUp();
        this.remainingCooldown = 0;
        super.HealthPool =+ 5* super.HealthPool;
        super.AttackPoints =+ 2* super.PlayerLevel;
        super.DefensePoints =+ super.DefensePoints;
    }

    public void tickingGame(){
        this.remainingCooldown = this.remainingCooldown -1;
    }

    public void abilityCasting(){ // Avenger's Shield
        remainingCooldown = abilityCooldown;
        super.HealthAmount = Math.min(super.HealthAmount + 10* super.DefensePoints, super.HealthPool);
    }
}
