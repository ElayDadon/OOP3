package BackEnd.Enemys;

import BackEnd.Boards.Movement;
import BackEnd.Boards.Position;
import BackEnd.Players.Player;
import FrontEnd.Messages.PlacementCallBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster extends Enemy{
    private int vision_range;

    public Monster(String Name, char tile, Integer HealthPool, Integer AttackPoints, Integer DefensePoints, Integer Experience, Integer vision_range)
    {
        super(Name,tile,HealthPool,AttackPoints,DefensePoints,Experience);
        this.vision_range = vision_range;
    }

    //TODO : why on hide?
    @Override
    public Position OnEnemyTurn(Player player){
           if (player.Range(this.position) < vision_range) {
               //placementCallBack.changePlacement(actionsMap.get(playerTrackPattern(player)));
            }
            else {
               return actionsMap.get(Movement.randomMovement()).apply(position);
            }
            return new Position(0,0);
    }

    protected Character playerTrackPattern(Player player){
        int dX= this.position.getX() - player.getPosition().getX();
        int dY= this.position.getY() - player.getPosition().getY();
        return (Math.abs(dX)>Math.abs(dY)) ? (dX > 0) ? Movement.left : Movement.right : (dY > 0) ? Movement.up : Movement.down;
    }

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
