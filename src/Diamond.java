import java.util.ArrayList;
import java.util.Arrays;

public class Diamond extends Shape {
    private ArrayList<String> searches = new ArrayList<String>(Arrays.asList("leftDiagonalDown","leftDiagonalUp","rightDiagonalUp","rightDiagonalDown"));

    public ArrayList<String> getSearches() {
        return searches;
    }
    @Override
    public String getName() {
        return "Diamond";
    }

    @Override
    public int getPoints() {
        return 30;
    }
    @Override
    public boolean rule(Jewel shape) {
        if(this.getName().equals(shape.getName())){
            return true;
        }
        return false;
    }
    @Override
    public boolean scanMap(int i,int j) {


        if (search.leftDiagonalUp(i, j)) {
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
