package PresentationLayer;

public class Game {
    public static void main(String[] args) {
        String path = args[0];
        GameManager gameManager = new GameManager(path);
        gameManager.start();
    }
}
