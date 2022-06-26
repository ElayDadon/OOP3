package BackEnd.Enemys;

import BackEnd.Players.Player;
import BackEnd.Tiles.Unit;

import BackEnd.Tiles.Unit;
import FrontEnd.Messages.DeathMessage;

import java.util.List;

public abstract class Enemy extends Unit {
    public Integer Experience;

    protected Enemy(String Name,char tile,Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints, Integer Experience) {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints);
        this.Experience = Experience;
    }

    public boolean isAlive(){
        return this.HealthAmount > 0;
    }

    @Override
    public void accept(Unit unit) {

    }

    @Override
    public void onDeath() {
        deathMessage.show();
    }

    public abstract void OnEnemyTurn(Player player);
}
