package PresentationLayer;

import BackEnd.Enemys.Enemy;
import BackEnd.Players.Player;

import java.util.ArrayList;
import java.util.List;

public class enemiesManager {
    List<Enemy> enemies;

    public enemiesManager(){
        this.enemies =new ArrayList<Enemy>();
    }

    public void addEnemy(Enemy e){
        enemies.add(e);
    }

    public void gameTick(Player player){
        for (Enemy enemy : enemies ){
            if(!enemy.alive())
                removeEnemy(enemy);
            else
                enemy.OnEnemyTurn(player);
        }
    }

    private void removeEnemy(Enemy e){
        enemies.remove(e);
    }

    public boolean isOver(){
        return enemies.isEmpty();
    }

}
