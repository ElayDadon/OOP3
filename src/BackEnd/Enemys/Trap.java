package BackEnd.Enemys;

import BackEnd.Boards.Position;
import BackEnd.Players.Player;

import java.util.List;

public class Trap extends Enemy{
    public Integer VisibilityTime; // Amount of ticks that the trap remains visible
    public Integer InvisibilityTime; // Amount of ticks that the trap remains invisible
    public Integer TicksCount; // Counts the number of ticks since last visibility state change
    public boolean Visible; // Whether a trap is currently visible

    public Trap(String Name,char tile,Integer HealthPool, Integer AttackPoints, Integer DefensePoints, Integer Experience,Integer invisibilityTime, Integer visibilityTime)
    {
        super(Name,tile,HealthPool,AttackPoints,DefensePoints,Experience);
        this.Visible = true;
        this.TicksCount = 0;
        this.InvisibilityTime = invisibilityTime;
        this.VisibilityTime = visibilityTime;
    }

    @Override
    public Position OnEnemyTurn(Player player){
        Visible=TicksCount<VisibilityTime;
        TicksCount = (TicksCount == (VisibilityTime + InvisibilityTime)) ? 0 : TicksCount + 1;
        if(this.Range(player.getPosition())<2) {
            battle(player);
        }
        return position;
    }

    @Override
    public String toString(){
        return (Visible) ? super.toString() : ".";
    }

    @Override
    public void visit(Player p) {

    }

    @Override
    public void visit(Enemy e) {

    }
}
