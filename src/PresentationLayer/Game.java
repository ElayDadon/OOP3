package PresentationLayer;

import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Enemys.Monster;

public class Game {
    public static void main(String[] args) {
        String path = "/Users/amitlewinz/Downloads/levels_dir3";//args[0];
        GameManager gameManager = new GameManager(path);
        gameManager.start();
    }
}
