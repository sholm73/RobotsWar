package roborsWar;

import org.apache.log4j.Logger;

public class robotsWar {


    public static void main(String[] args) {
        String textFromConsole = "";
        String currentKey = "";
        String robotName = "";
        int robotHealth = 100;
        int currentValue;

        mainWarMenu.welcomeMenu();

//        Создание роботов
        for (int i = 0; i < Robots.NUMBER_OF_ROBOTS; i++) {
            mainWarMenu.printEnterNameMenu();
            if (i == 0) {
                textFromConsole = mainWarMenu.getStrFromConsole();
                ListOfRobots.addRobot(new Robots(textFromConsole));
                robotName = textFromConsole;
            } else {
                do {
                    textFromConsole = mainWarMenu.getStrFromConsole();
                    if (robotName.equalsIgnoreCase(textFromConsole)) {
                       mainWarMenu.logger.info("Запрещено указывать одинаковые имена. Укажите имя еще раз:");
                    } else {
                        ListOfRobots.addRobot(new Robots(textFromConsole));
                    }
                } while (robotName.equalsIgnoreCase(textFromConsole));
            }
        }

//      the game
        do {
            for (int i = 0; i < Robots.NUMBER_OF_ROBOTS; i++) {
                mainWarMenu.actionMenu(i);
                currentKey = mainWarMenu.getStrFromConsole();
                currentValue = ListOfRobots.getListOfRobots().get(i).getKeyValue(currentKey);

                if (!currentKey.trim().equalsIgnoreCase(Robots.QUIT_PROGRAM_KEY)) {
                    if (robotHealth > 0) {
                        switch (currentValue) {
                            case Robots.NOT_ACTIVE:
                                mainWarMenu.logger.info(String.format("Кнопка %s уже не активна. Переход хода", currentKey.toUpperCase()));
                                break;
                            case Robots.KEY_NOT_FOUNT:
                                mainWarMenu.printWrongEnters();
                                break;
                            case 20:
                                ListOfRobots.getListOfRobots().get(i).setRobotHealth(currentValue);
                                ListOfRobots.getListOfRobots().get(i).deactivateKey(currentKey);
//                                System.out.println(ListOfRobots.getListOfRobots().get(i).getActionKeys());
                                robotHealth = ListOfRobots.getListOfRobots().get(i).getRobotHealth();
                                mainWarMenu.printGoodShot();
                                break;
                            case 0:
                                ListOfRobots.getListOfRobots().get(i).deactivateKey(currentKey);
                                break;
                        }
                    } else {
                        mainWarMenu.printWinnerMenu();
                        mainWarMenu.printRoundStatistic();
                    }
                } else {
                    robotHealth = 0;
                    break;
                }
                // статистика раунда после хода 2-го робота
                if (i == Robots.NUMBER_OF_ROBOTS - 1 && robotHealth != 0) {
                    mainWarMenu.printRoundStatistic();
                }
            }
        } while (robotHealth > 0);

        mainWarMenu.logger.info("Конец игры!");
    }

}
