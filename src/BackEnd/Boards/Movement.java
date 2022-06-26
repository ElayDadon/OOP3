package BackEnd.Boards;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Movement {
    public static char castAbility = 'e';
    public static char up = 'w';
    public static char down = 's';
    public static char left = 'a';
    public static char right = 'd';
    public static char stay = 'q';

    private static List<Character> moves = Arrays.asList(up, down, left, down, right, stay, castAbility);

    public static List<String> getMoves(){ return moves.stream().map(c -> String.valueOf(c)).collect(Collectors.toList()); }

    public static char randomMovement(){
        Random r = new Random();
        return moves.get((r.nextInt(moves.size() - 1)));
    }

}
