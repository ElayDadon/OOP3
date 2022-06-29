package PresentationLayer;

import BackEnd.Boards.Movement;
import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Players.Player;
import BackEnd.Tiles.Empty;
import BackEnd.Tiles.Tile;
import FrontEnd.Messages.DeathMessage;
import FrontEnd.Messages.MessageCallback;
import FrontEnd.FileHandler.tileFactory;
import FrontEnd.Messages.PlacementCallBack;

import java.util.*;
import java.util.function.Function;

public class LevelManager {

    Player player;
    List<String> levelLines;
    boardManager BM;
    enemiesManager EM;
    public LevelManager(Player player, List<String> lines){
        this.player = player;
        this.levelLines = lines;
        EM = new enemiesManager();
        loadLevel();
    }

    public void start(){
        while (!EM.isOver() & player.alive()){
            System.out.println(BM);
            System.out.println(player);
            Tick();
        }
    }


    private void loadLevel(){
        List<Tile> board = new ArrayList<>();
        tileFactory tileFactory = new tileFactory();
        int height = levelLines.size();
        int width = levelLines.get(0).length();
        List<Character> enemiesChar = new ArrayList<Character>(List.of('s','k','q','z','b','g','w','B','Q','D'));
        int x = 0;
        int y = 0;
        Iterator<String> iter = levelLines.iterator();
        while (iter.hasNext()){
            String line = iter.next();
            for(int i = 0; i < width; i++){
                Position point = new Position(x,y);
                MessageCallback messageCallback = (msg) -> System.out.println(msg);
                DeathMessage deathMessage = () -> System.out.println("You died :(");
                PlacementCallBack placementCallBack = (pos) -> player.setPosition(pos);
                if(line.charAt(i)=='@') {
                    player.init(new Position(x, y),messageCallback,deathMessage,placementCallBack);
                    board.add(player);
                }
                if(line.charAt(i)=='.'){
                    board.add(tileFactory.produceEmpty(new Position(x,y)));
                }
                if(line.charAt(i)=='#'){
                    board.add(tileFactory.produceWall(new Position(x,y)));
                }
                if(enemiesChar.contains(line.charAt(i))){
                    Enemy enemy = tileFactory.produceEnemy(line.charAt(i),new Position(x,y),messageCallback);
                    board.add(enemy);
                    EM.addEnemy(enemy);
                }
                x++;
            }

            y++;
        }
        BM = new boardManager(board,height,width);
    }

    public void Tick(){
        playerTick();
        EM.gameTick(player);
    }

    private void playerTick(){
        Position p = move();
        player.interact(BM.getTile(p));
        player.tickingGame();
        player.LevelingUp();
    }

    private Position move(){
        Scanner scanner = new Scanner(System.in);
        List<Character> keys = Arrays.asList(Movement.up,Movement.down,Movement.left,Movement.right,Movement.stay,Player.castAbility);
        String s = scanner.next();
        while (s.length() != 1 || !keys.contains(s.charAt(0))){
            System.out.println("please choose a valid key");
            s = scanner.next();
        }
        char key = s.charAt(0);
        if (key == 'e') {
            player.AbilityCast();
            return player.getPosition();
        }
        else{
            Function<Position,Position> move = Movement.movements.get(key);
            return move.apply(player.getPosition());
        }
    }
}
