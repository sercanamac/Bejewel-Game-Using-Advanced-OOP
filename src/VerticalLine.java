import java.util.ArrayList;
import java.util.Arrays;

public class VerticalLine extends MathSymbol {
    private ArrayList<String> searches = new ArrayList<String>(Arrays.asList("verticalUp", "verticalDown"));

    public ArrayList<String> getSearches() {
        return searches;
    }

    @Override
    public String getName() {
        return "|";

    }

    @Override
    public int getPoints() {
        return 20;
    }

    @Override
    public boolean rule(Jewel shape) {
        if (MathSymbol.class.isAssignableFrom(shape.getClass())) {
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