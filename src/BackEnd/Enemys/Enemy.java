package BackEnd.Enemys;

import BackEnd.Boards.Position;
import BackEnd.Players.Player;
import BackEnd.Tiles.Unit;

import BackEnd.Tiles.Unit;
import FrontEnd.Messages.DeathMessage;
import FrontEnd.Messages.MessageCallback;
import FrontEnd.Messages.PlacementCallBack;

import java.util.List;

public abstract class Enemy extends Unit {
    public Integer Experience;

    protected Enemy(String Name,char tile,Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints, Integer Experience) {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints);
        this.Experience = Experience;
    }

    public void init(Position position, MessageCallback messageCallback){
        super.initialize(position,messageCallback,deathMessage,placementCallBack);
    }

    public boolean isAlive(){
        return this.HealthAmount > 0;
    }

    @Override
    public void accept(Unit unit) { unit.visit(this);

    }

    @Override
    public void onDeath() {
        deathMessage.show();
    }

    public abstract void OnEnemyTurn(Player player);

    @Override
    public void visit(Player p) {
        super.battle(p);
        if(!p.alive()){
            p.onDeath();
        }
    }

    @Override
    public void visit(Enemy e) {

    }
}
