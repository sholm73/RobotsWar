package roborsWar;

public class Robots extends ActionKeys {


    private String robotName;
    private int robotHealth;

    public Robots( String robotName) {
        String val;
        this.robotHealth = 100;
        this.robotName = robotName;
        setActionKey();
    }

    public String getRobotName() {
        return robotName;
    }

    public int getRobotHealth() {
        return this.robotHealth;
    }

    public void setRobotHealth(int damage) {
        this.robotHealth = this.robotHealth - damage;
    }

}
