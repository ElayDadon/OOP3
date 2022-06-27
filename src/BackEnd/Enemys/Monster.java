package BackEnd.Enemys;

import BackEnd.Boards.Movement;
import BackEnd.Players.Player;
import FrontEnd.Messages.PlacementCallBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster extends Enemy{
    private int vision_range;

    public Monster(String Name, char tile, Integer HealthPool, Integer HealthAmount, Integer AttackPoints, Integer DefensePoints, Integer Experience, Integer vision_range)
    {
        super(Name,tile,HealthPool,HealthAmount,AttackPoints,DefensePoints,Experience);
        this.vision_range = vision_range;
    }

    //TODO : why on hide?
    @Override
    public void OnEnemyTurn(Player player){
//            if (player.Range(this.position) < vision_range) {
//                PlacementCallBack.Move(actionsMap.get(playerTrackPattern(player)).get());
//            }
//            else {
//                PlacementCallBack.Move(actionsMap.get(Movement.randomMovement()).get());
//            }
    }

    protected Character playerTrackPattern(Player player){
        int dX= this.position.getX() - player.getPosition().getX();
        int dY= this.position.getY() - player.getPosition().getY();
        return (Math.abs(dX)>Math.abs(dY)) ? (dX > 0) ? Movement.left : Movement.right : (dY > 0) ? Movement.up : Movement.down;
    }

    @Override
    public void visit(Player p) {

    }

    @Override
    public void visit(Enemy e) {

    }


}
