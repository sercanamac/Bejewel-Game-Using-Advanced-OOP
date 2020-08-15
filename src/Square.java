import java.util.ArrayList;
import java.util.Arrays;

public class Square extends Shape {
    private ArrayList<String> searches = new ArrayList<String>(Arrays.asList("horizontalRight", "horizontalLeft"));

    public ArrayList<String> getSearches() {
        return searches;
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public int getPoints() {
        return 15;
    }

    public boolean rule(Jewel shape) {
        if (shape.getName().equals(this.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean scanMap(int i, int j) {
        if (search.horizontalLeft(i, j)) {
            return true;
        } else if (search.horizontalRight(i, j)) {
            return true;
        }
        return false;
    }
}