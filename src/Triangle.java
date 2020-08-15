import java.util.ArrayList;
import java.util.Arrays;

public class Triangle  extends Shape {
    private ArrayList<String> searches = new ArrayList<String>(Arrays.asList("verticalUp", "verticalDown"));

    public ArrayList<String> getSearches() {
        return searches;
    }

    @Override
    public String getName() {
        return "Triangle";
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
        if (search.verticalUp(i, j)) {
            return true;
        } else if (search.verticalDown(i, j)) {
            return true;
        }
        return false;
    }
}