package roborsWar;

import java.util.HashMap;
import java.util.Random;

abstract public class ActionKeys {
    private String alphabet = "QWEASDZXC";
    private HashMap<String, Integer> listOfLetters = new HashMap<>();
    private String actionKey;

    public final static int NOT_ACTIVE = -1;
    public final static int KEY_NOT_FOUNT = 404;
    public final static int NUMBER_OF_ROBOTS = 2;
    public final static String QUIT_PROGRAM_KEY = "L";

    public void setActionKey() {
        for (int i = 0; i < 9; i++) {
            int dmg = 0;
            int randIndex = new Random().nextInt(alphabet.length());
            char randChar = this.alphabet.charAt(randIndex);
            if (i < 5) {
                dmg = 20;
            }
            String val = String.valueOf(randChar);
            this.listOfLetters.put(val, dmg);
            this.alphabet = this.alphabet.replace(String.valueOf(randChar), "");
        }
    }

    public int getKeyValue(String actionKey) {
        int keyVal = KEY_NOT_FOUNT;
        if (this.listOfLetters.containsKey(actionKey.toUpperCase())) {
            keyVal = this.listOfLetters.get(actionKey.toUpperCase());
        }
        return keyVal;
    }

    public HashMap<String, Integer> getActionKeys() {
        return this.listOfLetters;
    }

    public void deactivateKey(String actionKey) {
        this.listOfLetters.replace(actionKey.toUpperCase(), -1);
    }

}
