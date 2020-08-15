
import java.io.File;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        try{
            HashMap<String, Jewel> dict = new HashMap<String, Jewel>();
            File path = new File("Jewel.java");
            String path1 = path.getAbsolutePath();
            path1 = path1.substring(0,path1.lastIndexOf("/"));
            File file = new File(path1);
            ArrayList<String> classNames = new ArrayList<>();
            for(File file1:file.listFiles()){
                if(file1.getName().contains("class")){
                    classNames.add(file1.getName().substring(0,file1.getName().lastIndexOf(".")));
                }

            }
            for(String string : classNames){
                Class clzz= Class.forName(string);
                if(!Modifier.isAbstract(clzz.getModifiers()) && !Modifier.isInterface(clzz.getModifiers()) && Jewel.class.isAssignableFrom(Class.forName(string))){
                    dict.put(((Jewel)clzz.newInstance()).getName().substring(0,1), ((Jewel) clzz.newInstance()));
                }
            }//to create a hashmap for initiliazing map.It makes program dynamic and flexible.
            MapDAO map = new Map();
            map.setRowCol();
            map.mapInit(dict);
            System.out.println("Game grid:\n");
            map.printMap();
            Read reader = new Read();
            reader.read();
        }catch(ClassNotFoundException ex){

        }catch(IllegalAccessException ex){

        }catch(InstantiationException ex){

        }catch(NullPointerException ex){

        }

    }
}
