public abstract class Robot {

    protected String name;
    protected String code;
    protected double health;
    protected double attack;
    protected double speed;
    protected static int counter = 0;

    abstract void attack(Simulation s);

    boolean getHitAndIsDestroyed(double damage){
        this.health = this.health - this.attack;
        if(health < 0){
            this.health = 0;
        }

        if(this.health == 0){
            return true;
        }
        return false;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getHealth() {
        return health;
    }

    public double getAttack() {
        return attack;
    }

    public double getSpeed() {
        return speed;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}       