import java.util.ArrayList;
import java.util.Arrays;

public class Wildcard extends Shape {
    private ArrayList<String> searches = new ArrayList<String>(Arrays.asList("leftDiagonalDown","leftDiagonalUp","rightDiagonalUp","rightDiagonalDown","verticalUp","verticalDown","horizontalRight","horizontalLeft"));

    public ArrayList<String> getSearches() {
        return searches;
    }

    @Override
    public String getName() {
        return "Wildcard";

    }

    @Override
    public int getPoints() {
        return 10;
    }

    @Override
    public boolean rule(Jewel shape) {
        if (Jewel.class.isAssignableFrom(shape.getClass())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean scanMap(int i, int j) {
        if (search.verticalUp(i, j)) {
            return true;
        }else if(search.verticalDown(i ,j)){
            return true;
        } else if (search.horizontalLeft(i, j)) {
            return true;
        } else if (search.horizontalRight(i, j)) {
        return true;
        }else if (search.leftDiagonalUp(i, j)) {
            return true;
        }else if(search.leftDiagonalDown(i,j)){
            return true;
        }else if (search.rightDiagonalUp(i, j)) {
            return true;
        }else if(search.rightDiagonalDown(i,j)){
            return true;
        }
        return false;
    }
}