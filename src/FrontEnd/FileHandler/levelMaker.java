package FrontEnd.FileHandler;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class levelMaker {
public static char[][] table_maker(File path){
    List<String> line_in_table = new ArrayList<>();
    try{
        BufferedReader line_reader = new BufferedReader(new FileReader(path));
        String next_line = line_reader.readLine();
        while(next_line!=null){
            line_in_table.add(next_line);
            next_line = line_reader.readLine();
        }

    }catch(FileNotFoundException e){
        System.out.println("Exception");

    }catch(IOException e){
        System.out.println("Exception");
    }
    return ArrayMaking(line_in_table);
}

    private static char[][] ArrayMaking(List<String> line_in_table) {
    if(line_in_table.size() ==0)return null;
    char[][] table = new char[line_in_table.size()][line_in_table.get(0).length()];
    int i=0;
    for(String l:line_in_table){
        for(int j=0;j<table[0].length;j++){
            table[i][j] = l.charAt(j);
        }
        i++;
    }
    return table;
    }
}
