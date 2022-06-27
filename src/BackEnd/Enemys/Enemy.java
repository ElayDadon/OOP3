package BackEnd.Enemys;

import BackEnd.Players.Player;
import BackEnd.Tiles.Unit;

import BackEnd.Tiles.Unit;
import FrontEnd.Messages.DeathMessage;

public class Enemy extends Unit {
    public Integer Experience;

    protected Enemy(String Name,char tile,Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints, Integer Experience) {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints);
        this.Experience = Experience;
    }

    public boolean isAlive(){
        if(this.HealthAmount>0)
            return true;
        return false;
    }

    @Override
    public void accept(Unit unit) {

    }

    @Override
    public void onDeath() {
        deathMessage.show();
    }

    @Override
    public void visit(Player p) {
super.battle(p);
    }

    @Override
    public void visit(Enemy e) {}
}
