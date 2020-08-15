import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Map implements MapDAO {
    private static Jewel[][] map; //gridMap
    private static int rows;
    private static int columns;
    @Override
    public int getRows() {
        return rows;
    }
    @Override
    public int getColumns() {

        return columns;
    }

    @Override
    public void setRowCol() {
        rows = 0;
        columns = 0;
        try{
            File file = new File("gameGrid.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String[] line = scan.nextLine().trim().split(" ");
                rows += 1;
                columns = line.length;
            }
            map = new Jewel[rows][columns];
        }catch(FileNotFoundException ex){
            System.out.println("File not found");
        }

    }//It sets rows and columns of the map

    @Override
    public void mapInit(HashMap<String, Jewel> hashMap) {
        try{
            int i = 0;
            File file = new File("gameGrid.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String[] line = scan.nextLine().split(" ");
                for(int j =0;j<line.length;j++){
                    map[i][j] =  hashMap.get(line[j]).getClass().newInstance();
                }
                i++;
            }
        }catch(FileNotFoundException ex){
            System.out.println("File not found");
        }catch(InstantiationException ex){
            System.out.println("dalga");
        }catch(IllegalAccessException ex){
            System.out.println("Bomba");

        }

    }//It initializes the map using gameGrid.txt and HashMap created in main.

    @Override
    public void printMap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (map[i][j] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(map[i][j].getName().charAt(0) + " ");
                }
            }
            System.out.println();
        }
        System.out.println();

    }//it prints the map
    @Override
    public void updateMap() {
        boolean flag = true;
        boolean flag1 = false;
        while(flag){
            for(int i= 0;i<rows-1;i++){
                for(int j=0;j<columns;j++){
                    if(map[i][j] == null){
                        continue;
                    }
                    if (map[i+1][j] == null){
                        map[i+1][j] = map[i][j];
                        map[i][j] = null;
                        flag1 = true;
                    }
                }
            }
            if(!flag1){
                flag = false;
            }
            flag1 = false;
        }


    }
    @Override
    public Jewel[][] getMap(){

        return map;
    }
}
