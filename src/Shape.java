public abstract class Shape implements Jewel {
     Search search = new Search();
     @Override
     public abstract int getPoints();

     @Override
     public abstract boolean rule(Jewel shape);

     @Override
     public abstract String getName();

     @Override
     public abstract boolean scanMap(int i , int j);
}
