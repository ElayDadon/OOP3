package FrontEnd.FileHandler;

import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Enemys.Monster;
import BackEnd.Enemys.Trap;
import BackEnd.Players.Mage;
import BackEnd.Players.Player;
import BackEnd.Players.Rogue;
import BackEnd.Players.Warrior;
import BackEnd.Players.Hunter;
import BackEnd.Tiles.Empty;
import BackEnd.Tiles.Wall;
import FrontEnd.Messages.MessageCallback;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class tileFactory {
    private List<Supplier<Player>> playersList;
    private Map<Character, Supplier<Enemy>> enemiesMap;
    private Player selected;

    public tileFactory(){
        playersList = initPlayers();
        enemiesMap = initEnemies();
    }

    private Map<Character, Supplier<Enemy>> initEnemies() {
        List<Supplier<Enemy>> enemies = Arrays.asList(
                () -> new Monster("Lannister Solider",'s' , 80, 8, 3,25, 3),
                () -> new Monster("Lannister Knight",'k', 200, 14, 8, 50,   4),
                () -> new Monster("Queen's Guard",'q',  400, 20, 15, 100,  5),
                () -> new Monster("Wright",'z',  600, 30, 15,100, 3),
                () -> new Monster("Bear-Wright",'b',  1000, 75, 30, 250,  4),
                () -> new Monster("Giant-Wright",'g', 1500, 100, 40,500,   5),
                () -> new Monster("White Walker",'w',  2000, 150, 50, 1000, 6),
//                () -> new Boss('M', "The Mountain", 1000, 60, 25,  500, 6, 5),
//                () -> new Boss('C', "Queen Cersei", 100, 10, 10,1000, 1, 8),
//                () -> new Boss('K', "Night's King", 5000, 300, 150, 5000, 8, 3),
                () -> new Trap("Bonus Trap",'B',  1, 1, 1, 250,  1, 10),
                () -> new Trap("Queen's Trap",'Q',  250, 50, 10, 100, 3, 10),
                () -> new Trap("Death Trap",'D',  500, 100, 20, 250, 1, 10)
        );

        return enemies.stream().collect(Collectors.toMap(s -> s.get().getTile(), Function.identity()));
    }

    private List<Supplier<Player>> initPlayers() {
        return Arrays.asList(
                () -> new Warrior("Jon Snow", 300, 30, 4, 3),
                () -> new Warrior("The Hound", 400, 20, 6, 5),
                () -> new Mage("Melisandre", 100, 5, 1, 300, 30, 15, 5, 6),
                () -> new Mage("Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4),
                () -> new Rogue("Arya Stark", 150, 40, 2, 20),
                () -> new Rogue("Bronn", 250, 35, 3, 50),
                () -> new Hunter("Ygritte", 220, 30, 2, 6)
        );
    }

    public List<Player> listPlayers(){
        return playersList.stream().map(Supplier::get).collect(Collectors.toList());
    }

    public Enemy produceEnemy(char tile, Position position, MessageCallback messageCallback) {
        Enemy enemy = initEnemies().get(tile).get();
        enemy.init(position,messageCallback);
        return enemy;
    }

    public Player producePlayer(int idx){
		return initPlayers().get(idx).get();
    }

    public Empty produceEmpty(Position position){
        Empty empty = new Empty();
        empty.init(position);
        return empty;
    }

    public Wall produceWall(Position position){
        Wall wall = new Wall();
        wall.init(position);
        return wall;
    }
}