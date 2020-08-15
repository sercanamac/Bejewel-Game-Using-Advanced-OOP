import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Players implements PlayerDAO {
    private static ArrayList<Player> players = new ArrayList<>();

    @Override
    public ArrayList<Player> getALL() {
        return players;
    }

    @Override
    public void add(Player player) {
        players.add(player);
    }

    @Override
    public void sort() {
        Collections.sort(players);
    }

    @Override
    public void loadLeaderBoard() {
        try{
            File file = new File("leaderboard.txt");
            Scanner scan = new Scanner(file);
            int i = 0;
            while(scan.hasNextLine()){
                Player player = new Player();
                String[] line = scan.nextLine().split(" ");
                player.setName(line[0]);
                player.setPoints(Integer.parseInt(line[1]));
                player.setRank(i);
                i++;
                players.add(player);
            }
        }catch(FileNotFoundException ex){

        }

    }

    @Override
    public Player getPlayer(int i) {
        return players.get(i);
    }

    public int getPlayersRank(String name) {
        players.sort(Player::compareTo);
        int index = Collections.binarySearch(players,new Player(name));
        if(index >= 0){
            return players.get(index).getRank();

        }else{
            return -1;
        }
    }
    public void updateRanks(){
        players.sort(Player.c);
        for(Player player : players){
            player.setRank(players.indexOf(player) + 1);
        }
    }
    public void updateLeaderboard(){
        try{
            this.updateRanks();
            File file = new File("leaderboard.txt");
            PrintWriter writer = new PrintWriter(file);
            for(Player player : players){
                writer.println(player.getName() + " " + player.getPoints());
            }
            writer.close();
        }catch(FileNotFoundException ex){

        }
    }

    @Override
    public void sortByPoint() {
        players.sort(Player.c);
    }
}
