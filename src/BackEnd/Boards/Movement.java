package BackEnd.Boards;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Movement {

    public static char up = 'w';
    public static char down = 's';
    public static char left = 'a';
    public static char right = 'd';
    public static char stay = 'q';

    public static HashMap<Character, Function<Position,Position>> movements = new HashMap<>(){
        {
            put(up, (position) -> new Position(position.getX(),position.getY() - 1));
            put(down,(position) -> new Position(position.getX(),position.getY() + 1));
            put(left,(position) -> new Position(position.getX() - 1,position.getY()));
            put(right, (position) -> new Position(position.getX() + 1,position.getY()));
            put(stay,(position) -> new Position(position.getX(),position.getY()));
        }
    };

    private static List<Character> moves = Arrays.asList(up, down, left, down, right, stay);

    public static List<String> getMoves(){ return moves.stream().map(c -> String.valueOf(c)).collect(Collectors.toList()); }

    public static char randomMovement(){
        Random r = new Random();
        return moves.get((r.nextInt(moves.size() - 1)));
    }

}
