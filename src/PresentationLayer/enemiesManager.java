package PresentationLayer;

import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Players.Player;

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
        for (Enemy enemy : enemies ){
            if(!enemy.alive())
                removeEnemy(enemy);
            else{
               Position p = enemy.OnEnemyTurn(player);
                enemy.interact(bm.getTile(p));
            }

        }
    }

    private void removeEnemy(Enemy e){
        enemies.remove(e);
    }

    public boolean isOver(){
        return enemies.isEmpty();
    }

}
