package PresentationLayer;

import BackEnd.Boards.Position;
import BackEnd.Enemys.Enemy;
import BackEnd.Enemys.Monster;

public class Game {
    public static void main(String[] args) {
//        String path = "C:/Users/saada/Desktop/OrStudys/OOP_game/levels_dir";
        GameManager gameManager = new GameManager(args[0]);
        gameManager.start();
    }
}
