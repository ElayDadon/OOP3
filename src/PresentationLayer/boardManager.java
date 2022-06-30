package PresentationLayer;

import BackEnd.Boards.Position;
import BackEnd.Tiles.Tile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class boardManager {
    private List<Tile> board;
    private int height;
    private int width;

    public boardManager(List<Tile> board, int height, int width){
        this.board = board;
        this.height = height;
        this.width = width;
    }

    private void SortBoard(){
        Comparator<Tile> comperT = new Comparator<Tile>() {
            @Override
            public int compare(Tile o1, Tile o2) {
                int y1 = 0;
                int y2 = 0;
                try{
                    y1 = o1.getPosition().getY();
                    y2 = o2.getPosition().getY();
                }
                catch (Exception e){
                    System.out.println();
                }
                if(y1<y2)
                    return -1;
                else if(y2<y1)
                    return 1;
                else {
                    int x1 = o1.getPosition().getX();
                    int x2 = o2.getPosition().getX();
                    if(x1<x2)
                        return -1;
                    else if(x1 > x2)
                        return 1;
                    else
                        return 0;
                }
            }
        };
        board = board.stream().sorted(comperT).collect(Collectors.toList());
    }

    public String toString(){
        SortBoard();
        int counterWidth =0;
        int counterTiles =0;
        String output = "";
        while (counterTiles < width*height){
            output += board.get(counterTiles).getTile();
            counterTiles++;
            if(counterWidth == width-1){
                counterWidth =0;
                output += "\n";
            }
            else
                counterWidth++;
        }
        return output;
    }

    public Tile getTile(Position p){
        for (Tile tile: board) {
            if(tile.getPosition().compareTo(p) == 0)
                return tile;
        }
        return null;
    }
    public void setTile(Tile t){
        board.add(t);
    }

    public void removeTile(Tile t){
        board.remove(t);
    }

}
