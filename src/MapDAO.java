import java.util.HashMap;

public interface MapDAO {
    void mapInit(HashMap<String, Jewel> hashMap);
    // It initiliazes the map using gameGrid.txt
    void updateMap();
    //It updates the map if there is a match.
    Jewel[][] getMap();
    //It returns the map object itself.
    void setRowCol();
    //It sets rows and columns of the Map array.
    void printMap();
    //It prints the map.
    int getColumns();
    //It returns the columns.
    int getRows();
    //It returns the rows.
}
