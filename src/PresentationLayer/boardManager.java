package PresentationLayer;

import BackEnd.Tiles.Tile;

import java.util.ArrayList;
import java.util.List;

public class boardManager {
    private List<Tile> board;
    private int height;
    private int width;

    public boardManager(List<Tile> board, int height, int width){
        this.board = board;
        this.height = height;
        this.width = width;
    }

    //TODO
    public void SortBoard(){
        List<Tile> sortedBoard = new ArrayList<>();
        for(Tile tile : board){

        }
    }
}
