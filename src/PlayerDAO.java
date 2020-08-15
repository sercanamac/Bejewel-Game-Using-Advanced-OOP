import java.lang.reflect.Array;
import java.util.ArrayList;

public interface PlayerDAO {
    void loadLeaderBoard();
    //it loads the leaderboard from leaderboard.txt
    public int getPlayersRank(String name);
    //it gets the players rank by using his/her name via binarySearch.
    public void updateRanks();
    //It updates the ranks after a player added.
    void sort();
    //It sorts the players by their names.
    ArrayList<Player> getALL();
    //It returns all the players.
    void add(Player player);
    //It adds a new player to the list.
    Player getPlayer(int i);
    //It returns a player by its index on the list.
    public void updateLeaderboard();
    //It updates the leaderboard.txt
    void sortByPoint();
    //It sorts players list by thir points.
}
