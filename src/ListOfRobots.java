package roborsWar;

import java.util.ArrayList;


public class ListOfRobots {

    private static ArrayList<Robots> listOfRobots = new ArrayList<>();

    public static void addRobot(Robots robot){
        listOfRobots.add(robot);
    }

    public static ArrayList<Robots> getListOfRobots(){
        return listOfRobots;
    }

}
