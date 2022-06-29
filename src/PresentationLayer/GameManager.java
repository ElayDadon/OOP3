package PresentationLayer;

import BackEnd.Players.Player;
import BackEnd.Tiles.Tile;
import FrontEnd.FileHandler.tileFactory;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GameManager {
    private String path;
    private int level;
    private int levelsNum;
    private Player player;

    public GameManager(String path) {
        this.path = path;
        level = 1;
        File directory = new File(path);
        levelsNum = directory.list().length;
    }

    public void start() {
        player = choosePlayer();
        List<Tile> boardList;
        while (level <= levelsNum & player.alive()) {
            List<String> lines = loadLevel();
            LevelManager levelManager = new LevelManager(player, lines);
            levelManager.start();
        }
        if(player.alive())
            System.out.println("you won");
        else
            System.out.println("you lost");
    }

    private List<String> loadLevel() {
        String levelPath = String.format(path + "/level%d.txt", level++);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(levelPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }


    public Player choosePlayer() {
        Scanner scanner = new Scanner(System.in);
        tileFactory tiles = new tileFactory();
        System.out.println("Select player:");
        int i = 1;
        List<Player> players = tiles.listPlayers();
        for (Player p : players) {
            System.out.println((i) + ".  " + p.describe());
            i++;
        }
        int selectedP = scanner.nextInt();
        try {
            return player = tiles.producePlayer(selectedP-1);
        } catch (Exception e) {
            throw new RuntimeException("chosen index out of range, please try again");
        }


    }
}