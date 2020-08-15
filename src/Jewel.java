import java.util.ArrayList;

public interface Jewel {
    //@returns the string that describes the object.
    String getName();
    //Scans surroindings returns true if there is a match false if not.
    boolean scanMap(int i ,int j);
    //Returns the point of that jewel.
    int getPoints();
    //Returns true if the current surrounding object obeys the rule false if not.
    boolean rule(Jewel shape);
    //Returns the Arraylist containing which directions that jewel can look for.
    ArrayList<String> getSearches();
}
