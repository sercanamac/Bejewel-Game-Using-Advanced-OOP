import java.util.Comparator;

public class Player implements Comparable<Player> {
    private int rank;
    private int points;

    public Player() {
    }

    public Player(int rank, int points, String name) {
        this.rank = rank;
        this.points = points;
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;

    }

    static Comparator<Player> c = new Comparator<Player>() {
        public int compare(Player o1, Player o2) {
            return o2.getPoints()-o1.getPoints();
        }
    };//to sort by points descending.

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(Player o) {
        o = (Player)o;
        return this.name.compareTo(o.name);
    }//to sort by name

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
