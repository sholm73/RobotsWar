package roborsWar;


public class mainWarMenu extends ReadConsole {


    public static void welcomeMenu() {
        logger.info("======================================================");
        logger.info("     == Добро пожаловать в игру Война роботов ==");
        logger.info("======================================================");
        logger.info("   Правила игры : ");
        logger.info("1. Необходимо по очереди ввести имена 2-х роботов");
        logger.info("2. Далее по очереди для каждого робота выбираем одну из 9ти букв");
        logger.info("    ---- Q - W - E - A - S - D - Z - X - C ----");
        logger.info("  Для каждой буквы назначен произвольно урон 0 или 20");
        logger.info("  У каждого робота своя комбинация клавиш с уроном");
        logger.info("  Этот урон будет отниматься от здоровья ");
        logger.info("  При повторном выборе буквы ход переходит к другому роботу ");
        logger.info("3. Проигрывает тот робот, у когорого здоровье будет равно или меньше 0");
    }

    public static void printEnterNameMenu() {
        logger.info("Enter robot name : ");
    }

    public static void actionMenu(int robotNumber) {
        logger.info("Для выхода нажмите L");
        logger.info("Выстрел по роботу : " + ListOfRobots.getListOfRobots().get(robotNumber).getRobotName());
        logger.info("Your step: press key (QWEASDZXC) : ");
    }

    public static void printWrongEnters() {
        logger.info("Wrong enters. Use only one key from QWEASDZXC keys");
    }

    public static void printGoodShot() {
        logger.info("Good shot!! BaBah. -20");
    }

    public static void printRoundStatistic() {
        String robotName = "";
        int robotHealth = 0;

        logger.info("------------");
        for (int i = 0; i < ListOfRobots.getListOfRobots().size(); i++) {
            robotName = ListOfRobots.getListOfRobots().get(i).getRobotName();
            robotHealth = ListOfRobots.getListOfRobots().get(i).getRobotHealth();
            if (robotHealth > 0) {
                logger.info(robotName + ", " + robotHealth);
            }
        }
        logger.info("------------\n");
    }

    public static void printWinnerMenu() {
        String winnerMsg = "";
        String loserMsg = "";
        for (int i = 0; i < ListOfRobots.getListOfRobots().size(); i++) {
            if (ListOfRobots.getListOfRobots().get(i).getRobotHealth() <= 0) {
                loserMsg = ListOfRobots.getListOfRobots().get(i).getRobotName() + " was killed";
            } else {
                winnerMsg = ListOfRobots.getListOfRobots().get(i).getRobotName() + " - Выиграл!!!!";
            }
        }
        logger.info(loserMsg);
        logger.info(winnerMsg);
    }

}
