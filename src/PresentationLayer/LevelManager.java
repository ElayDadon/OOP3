package PresentationLayer;

import BackEnd.Boards.Position;
import BackEnd.Players.Player;
import BackEnd.Tiles.Empty;
import BackEnd.Tiles.Tile;
import FrontEnd.Messages.MessageCallback;
import FrontEnd.FileHandler.tileFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LevelManager {

    Player player;
    List<String> levelLines;
    public LevelManager(Player player, List<String> lines){
        this.player = player;
        this.levelLines = lines;
    }

    private void loadLevel(List<String> lines){
        List<Tile> board = new ArrayList<>();
        tileFactory tileFactory = new tileFactory();
        int height = lines.size();
        int width = lines.get(0).length();
        int x = 0;
        int y = 0;
        Iterator<String> iter = lines.iterator();
        while (iter.hasNext()){
            String line = iter.next();
            for(int i = 0; i < line.length(); i++){
                Position point = new Position(x,y);
                MessageCallback messageCallback = (msg) -> System.out.println(msg);
                if(line.charAt(i)=='@') {
                    player.setPosition(new Position(x, y));
                    board.add(player);
                }
                if(line.charAt(i)=='.'){
                    board.add(tileFactory.produceEmpty(new Position(x,y)));
                }
            }
        }
    }

}
