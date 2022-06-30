package PresentationLayer;

import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Players.Player;
import BackEnd.Tiles.Empty;

import java.util.ArrayList;
import java.util.List;

public class enemiesManager {
    private List<Enemy> enemies;
    private boardManager bm;

    public enemiesManager(){
        this.enemies =new ArrayList<Enemy>();
    }
    public void setBoard(boardManager b){
        bm = b;
    }

    public List<Enemy> getEnemies(){
        return enemies;
    }

    public void addEnemy(Enemy e){
        enemies.add(e);
    }

    public void gameTick(Player player){
        List<Enemy> toRemove= new ArrayList<>();
        for (Enemy enemy : enemies ){
            if(!enemy.alive())
                toRemove.add(enemy);
//                removeEnemy(enemy);
            else{
               Position p = enemy.OnEnemyTurn(player);
                enemy.interact(bm.getTile(p));
            }

        }
        toRemoveEnemies(toRemove,enemies);
    }

    private void toRemoveEnemies(List<Enemy> reomve , List<Enemy> enemies){
        for (Enemy e :reomve){
            Position p = e.getPosition();
            Empty emptyNew = new Empty();
            emptyNew.setPosition(p);
            bm.removeTile(e);
            bm.setTile(emptyNew);
            enemies.remove(e);
        }
    }

    private void removeEnemy(Enemy e){
        enemies.remove(e);
    }

    public boolean isOver(){
        return enemies.isEmpty();
    }

}
