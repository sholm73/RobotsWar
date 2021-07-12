package roborsWar;

import java.util.Scanner;
import org.apache.log4j.Logger;

abstract public class ReadConsole {
   static Logger logger = Logger.getLogger("robotsWar.class");

    public static String getStrFromConsole(){
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.next();
        } catch (Exception e) {
            return "Error";
        }
    }
}
