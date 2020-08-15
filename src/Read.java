import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Read {
    private MapDAO map = new Map(); // to access map
    PlayerDAO players = new Players(); // to access players

    public void read() {
        int i, j;
        Scanner scan = new Scanner(System.in);
        String[] command;
        String string ;
        players.loadLeaderBoard();
        Search search = new Search();
        while (true) {
            System.out.print("Select coordinate or enter E to end the game: ");
            command = scan.nextLine().trim().split(" ");
            System.out.println();
            if (command[0].equals("E")) {
                System.out.println("Total score: " + Search.player.getPoints());
                System.out.print("Enter Name: ");
                string = scan.next();
                players.updateRanks();
                int b = players.getPlayersRank(string);
                if(b  == -1){//It means player didnt play before.Its a new player.
                    Search.player.setName(string);
                    players.add(Search.player);
                    players.updateRanks();
                    i = players.getPlayersRank(string);
                    players.updateRanks();
                    i = players.getPlayersRank(string);
                    players.updateRanks();
                    if(players.getALL().size() == 1){
                        System.out.println("Your rank is "+ i + "/" + players.getALL().size());
                        System.out.println("\nGood bye!");
                        break;
                    }//It checks if its the first player to be added on the list.
                    if(i == 1){//It checks if his/her rank is 1
                        int current = players.getPlayer(i-1).getPoints();
                        int lowerdif = current - players.getPlayer(i).getPoints();
                        String lowerName = players.getPlayer(i).getName();
                        System.out.println("Your rank is "+ i + "/" + players.getALL().size() + ", your score is " + (lowerdif == 0? "equal to " : lowerdif + " points higher than ")   + lowerName);
                        System.out.println("\nGood bye!");


                    }else if(i == players.getALL().size()){ // It checks if his/her rank is last.
                        int current = players.getPlayer(i-1).getPoints();
                        int higherdif = players.getPlayer(i-2).getPoints()-current;
                        String higherName = players.getPlayer(i-2).getName();
                        System.out.println("Your rank is "+ i + "/" + players.getALL().size() + ", your score is " +  (higherdif == 0? "equal to " : higherdif + " points lower than ")  + higherName);
                        System.out.println("\nGood bye!");


                    }else{//It checks if its between 1 and last.
                        int current = players.getPlayer(i-1).getPoints();
                        int lowerdif = current -players.getPlayer(i).getPoints();
                        int higherdif = players.getPlayer(i-2).getPoints()-current;
                        String lowerName = players.getPlayer(i).getName();
                        String higherName = players.getPlayer(i-2).getName();
                        System.out.println("Your rank is "+ i + "/" + players.getALL().size() + ", your score is " + (lowerdif == 0? "equal to " : lowerdif + " points higher than ") + lowerName + " and " +(higherdif == 0? "equal to " : higherdif + " points lower than ") + higherName  );
                        System.out.println("\nGood bye!");
                    }
                }else{//Means the player played before.
                    if(players.getALL().size() == 1){
                        i = players.getPlayersRank(string);
                        if(Search.player.getPoints() > players.getPlayer(i-1).getPoints()){
                            players.getPlayer(b-1).setPoints(Search.player.getPoints());
                        }
                        System.out.println("Your rank is "+ i + "/" + players.getALL().size());
                        System.out.println("\nGood bye!");
                        break;
                    }//If there is only 1 player and he/she played this before check if its the highest score and print according message.
                    players.sortByPoint();
                    if(Search.player.getPoints() > players.getPlayer(b-1).getPoints()){//If player made a higher score update Leaderboard and his/her score.
                        players.getPlayer(b-1).setPoints(Search.player.getPoints());
                        players.updateRanks();
                        i = players.getPlayersRank(string);
                        players.updateRanks();
                        i = players.getPlayersRank(string);
                        players.updateRanks();
                        if(i == 1){
                            int current = players.getPlayer(i-1).getPoints();
                            int lowerdif = current -players.getPlayer(i).getPoints();
                            String lowerName = players.getPlayer(i).getName();
                            System.out.println("Your rank is "+ i + "/" + players.getALL().size() + ", your score is " + (lowerdif == 0? "equal to " : lowerdif + " points higher than ")   + lowerName);
                            System.out.println("\nGood bye!");



                        }else if(i == players.getALL().size()){
                            int current = players.getPlayer(i-1).getPoints();
                            int higherdif = players.getPlayer(i-2).getPoints()-current;
                            String higherName = players.getPlayer(i-2).getName();
                            System.out.println("Your rank is "+ i + "/" + players.getALL().size() + ", your score is " + (higherdif == 0? "equal to " : higherdif + " points lower than ") + higherName);
                            System.out.println("\nGood bye!");


                        }else{
                            int current = players.getPlayer(i-1).getPoints();
                            int lowerdif = current -players.getPlayer(i).getPoints();
                            int higherdif = players.getPlayer(i-2).getPoints()-current;
                            String lowerName = players.getPlayer(i).getName();
                            String higherName = players.getPlayer(i-2).getName();
                            System.out.println("Your rank is "+ i + "/" + players.getALL().size() + ", your score is " + (lowerdif == 0? "equal to " : lowerdif + " points higher than ")  +  lowerName + " and " +(higherdif == 0? "equal to " : higherdif + " points lower than ")+ higherName  );
                            System.out.println("\nGood bye!");

                        }
                    }else{//If player scored lower or equal to his/her highest score than print according messages.
                        players.updateRanks();
                        i = players.getPlayersRank(string);
                        players.updateRanks();
                        if(i == 1){
                            int current = players.getPlayer(i-1).getPoints();
                            int lowerdif = current -players.getPlayer(i).getPoints();
                            String lowerName = players.getPlayer(i).getName();
                            System.out.println("You scored lower or equal to your highest score.Your rank is "+ i + "/" + players.getALL().size() + ", your score is " + (lowerdif == 0? "equal to " : lowerdif + " points higher than ")  + lowerName);
                            System.out.println("\nGood bye!");



                        }else if(i == players.getALL().size()){
                            int current = players.getPlayer(i-1).getPoints();
                            int higherdif = players.getPlayer(i-2).getPoints()-current;
                            String higherName = players.getPlayer(i-2).getName();
                            System.out.println("You scored lower or equal to your highest score.Your  rank is "+ i + "/" + players.getALL().size() + ", your score is " + (higherdif == 0? "equal to " : higherdif + " points lower than ")+ higherName);
                            System.out.println("\nGood bye!");


                        }else{
                            int current = players.getPlayer(i-1).getPoints();
                            int lowerdif = current -players.getPlayer(i).getPoints();
                            int higherdif = players.getPlayer(i-2).getPoints()-current;
                            String lowerName = players.getPlayer(i).getName();
                            String higherName = players.getPlayer(i-2).getName();
                            System.out.println("You scored lower or equal to your highest score.Your  rank is "+ i + "/" + players.getALL().size() + ", your score is " + (lowerdif == 0? "equal to " : lowerdif + " points higher than ")   + lowerName + " and " +(higherdif == 0? "equal to " : higherdif + " points lower than ") + higherName  );
                            System.out.println("\nGood bye!");

                        }
                    }
                }
                break;
            } else {//Read coordinates.
                i = Integer.parseInt(command[0]);
                j = Integer.parseInt(command[1]);
                if( search.isInside(i,j) &&map.getMap()[i][j] != null&& map.getMap()[i][j].scanMap(i,j)){
                    map.updateMap();
                    map.printMap();
                    System.out.println("Score: "+Search.Score + " points.");
                }else{
                    System.out.println("There is no match.");
                }
            }
        }
        players.updateLeaderboard();//Update leaderboard.txt

    }
}