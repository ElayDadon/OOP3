package BackEnd.Enemys;

import BackEnd.Players.Player;

import java.util.List;

public class Trap extends Enemy{
    public Integer VisibilityTime; // Amount of ticks that the trap remains visible
    public Integer InvisibilityTime; // Amount of ticks that the trap remains invisible
    public Integer TicksCount; // Counts the number of ticks since last visibility state change
    public boolean Visible; // Whether a trap is currently visible

    public Trap(String Name,char tile,Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints, Integer Experience,Integer invisibilityTime, Integer visibilityTime)
    {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints,Experience);
        this.Visible = true;
        this.TicksCount = 0;
        this.InvisibilityTime = invisibilityTime;
        this.VisibilityTime = visibilityTime;
    }

    public void OnEnemyTurn(Player player){
        Visible=TicksCount<VisibilityTime;
        TicksCount = (TicksCount == (VisibilityTime + InvisibilityTime)) ? 0 : TicksCount + 1;
        if(this.Range(player.getPosition())<2) {
            battle(player);
        }
    }

    @Override
    public String toString(){
        return (Visible) ? super.toString() : ".";
    }

}
