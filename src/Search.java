
public class Search {
    private MapDAO map = new Map();
    public static Player player = new Player();//Current player
    public static int Score;//last Score from last match
    boolean leftDiagonalUp(int i, int j){
        if(isInside(i-1,j-1)){
            if(map.getMap()[i][j].rule(map.getMap()[i-1][j-1])){
                if(isInside(i-2,j-2)){
                    if(map.getMap()[i-1][j-1].getSearches().contains("leftDiagonalUp") && map.getMap()[i-1][j-1].rule(map.getMap()[i-2][j-2])){
                        Score = map.getMap()[i][j].getPoints() + map.getMap()[i-1][j-1].getPoints() + map.getMap()[i-2][j-2].getPoints();
                        player.setPoints(player.getPoints() + Score);
                        System.out.println(map.getMap()[i][j].getPoints() + map.getMap()[i-1][j-1].getPoints() + map.getMap()[i-2][j-2].getPoints());
                        map.getMap()[i][j] = null;
                        map.getMap()[i-1][j-1] = null;
                        map.getMap()[i-2][j-2] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean rightDiagonalUp(int i , int j){
        if(isInside(i-1,j+1)){
            if(map.getMap()[i][j].rule(map.getMap()[i-1][j+1])){
                if(isInside(i-2,j+2)){
                    if(map.getMap()[i-1][j+1].getSearches().contains("rightDiagonalUp") && map.getMap()[i-1][j+1].rule(map.getMap()[i-2][j+2])){
                        Score = map.getMap()[i][j].getPoints() + map.getMap()[i-1][j+1].getPoints() + map.getMap()[i-2][j+2].getPoints();
                        player.setPoints(player.getPoints() + Score);
                        map.getMap()[i][j] = null;
                        map.getMap()[i-1][j+1] = null;
                        map.getMap()[i-2][j+2] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean verticalUp(int i , int j){
        if(isInside(i-1,j)){
            if(map.getMap()[i][j].rule(map.getMap()[i-1][j])){
                if(isInside(i-2,j)){
                    if(map.getMap()[i-1][j].getSearches().contains("verticalUp") && map.getMap()[i-1][j].rule(map.getMap()[i-2][j])){
                        Score = map.getMap()[i][j].getPoints() + map.getMap()[i-1][j].getPoints() + map.getMap()[i-2][j].getPoints();
                        player.setPoints(player.getPoints() + Score);
                        map.getMap()[i][j] = null;
                        map.getMap()[i-1][j] = null;
                        map.getMap()[i-2][j] = null;
                        return true;
                    }
                }
            }
        }
        return false;

    }
    boolean horizontalLeft(int i , int j) {
        if (isInside(i, j - 1)) {
            if (map.getMap()[i][j].rule(map.getMap()[i][j - 1])) {
                if (isInside(i, j - 2)) {
                    if (map.getMap()[i][j-1].getSearches().contains("horizontalLeft") && map.getMap()[i][j - 1].rule(map.getMap()[i][j - 2])) {
                        Score = map.getMap()[i][j].getPoints() + map.getMap()[i][j-1].getPoints() + map.getMap()[i][j-2].getPoints();
                        player.setPoints(player.getPoints() + Score);
                        map.getMap()[i][j] = null;
                        map.getMap()[i][j - 1] = null;
                        map.getMap()[i][j - 2] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean horizontalRight(int i , int j){
        if(isInside(i,j+1)){
            if(map.getMap()[i][j].rule(map.getMap()[i][j+1])){
                if(isInside(i,j+2)){
                    if(map.getMap()[i][j+1].getSearches().contains("horizontalRight") && map.getMap()[i][j+1].rule(map.getMap()[i][j+2])){
                        Score = map.getMap()[i][j].getPoints() + map.getMap()[i][j+1].getPoints() + map.getMap()[i][j+2].getPoints();
                        player.setPoints(player.getPoints() + Score );
                        map.getMap()[i][j] = null;
                        map.getMap()[i][j+1] = null;
                        map.getMap()[i][j+2] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean verticalDown(int i , int j){
        if(isInside(i+1,j)){
            if( map.getMap()[i][j].rule(map.getMap()[i+1][j])){
                if(isInside(i+2,j)){
                    if( map.getMap()[i+1][j].getSearches().contains("verticalDown") && map.getMap()[i+1][j].rule(map.getMap()[i+2][j])){
                        Score = map.getMap()[i][j].getPoints() + map.getMap()[i+1][j].getPoints() + map.getMap()[i+2][j].getPoints();
                        player.setPoints(player.getPoints() +Score );
                        map.getMap()[i][j] = null;
                        map.getMap()[i+1][j] = null;
                        map.getMap()[i+2][j] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean isInside(int i , int j){
        try{
            if(map.getMap()[i][j] == null){
                return false;
            }
            map.getMap()[i][j].getName();
            return true;
        }catch(ArrayIndexOutOfBoundsException ex){
            return false;
        }
    }
    boolean leftDiagonalDown(int i , int j){
        if(isInside(i+1,j+1)){
            if(map.getMap()[i][j].rule(map.getMap()[i+1][j+1])){
                if(isInside(i+2,j+2)){
                    if(map.getMap()[i+1][j+1].getSearches().contains("leftDiagonalDown") && map.getMap()[i+1][j+1].rule(map.getMap()[i+2][j+2])){
                        Score = map.getMap()[i][j].getPoints() + map.getMap()[i+1][j+1].getPoints() + map.getMap()[i+2][j+2].getPoints();
                        player.setPoints(player.getPoints() + Score);
                        map.getMap()[i][j] = null;
                        map.getMap()[i+1][j+1] = null;
                        map.getMap()[i+2][j+2] = null;
                        return true;
                    }
                }
            }

        }
        return false;

    }
    boolean rightDiagonalDown(int i , int j){
        if(isInside(i+1,j-1)){
            if(map.getMap()[i][j].rule(map.getMap()[i+1][j-1])){
                if(isInside(i+2,j-2)){
                    if(map.getMap()[i+1][j-1].getSearches().contains("rightDiagonalDown") && map.getMap()[i+1][j-1].rule(map.getMap()[i+2][j-2])){
                        Score = map.getMap()[i][j].getPoints() + map.getMap()[i+1][j-1].getPoints() + map.getMap()[i+2][j-2].getPoints();
                        player.setPoints(player.getPoints() + Score);
                        map.getMap()[i][j] = null;
                        map.getMap()[i+1][j-1] = null;
                        map.getMap()[i+2][j-2] = null;
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
