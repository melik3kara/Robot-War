import java.util.ArrayList;

/**
 * Simulation
 * @author Melike
 */

public class Simulation {

    public ArrayList<Robot> redRobots = new ArrayList<Robot>();
    public ArrayList<Robot> blueRobots = new ArrayList<Robot>();

    protected void initialize(int teamSize) {

        creatingRobots(teamSize, redRobots);
        creatingRobots(teamSize, blueRobots);

        sortingRobots(redRobots);
        sortingRobots(blueRobots);
    }

    protected void simulate(){
        
        ArrayList<Robot> firstStart;
        ArrayList<Robot> lastStart;
        boolean gameContinue = true;

        if(sumOfSpeeds(redRobots) > sumOfSpeeds(blueRobots)){
            System.out.println("Red starts first.");
            firstStart = redRobots;
            lastStart = blueRobots;
        }
        else{
            System.out.println("Blue starts first.");
            firstStart = blueRobots;
            lastStart = redRobots;
        }
        int i = 0;
        while(gameContinue){
            
            firstStart.get(i).attack(this);
            lastStart.get(i).attack(this);
            int j = 0;

            if(getBlueRobots().isEmpty() || getRedRobots().isEmpty() ){
                if(getBlueRobots().isEmpty()){
                    System.out.print("\nRed team wins, remaining robots:\n");
                    for (Robot robot : redRobots) {
                        System.out.printf("%s Health: %.3f Attack: %.3f Speed: %.3f\n",
                            robot.getName(), robot.getHealth(), robot.getAttack(), robot.getSpeed());
                        j++;
                    }
                }
                else{
                    System.out.print("\nBlue team wins, remaining robots:\n");
                    for (Robot robot : blueRobots) {
                        System.out.printf("%s Health: %.3f Attack: %.3f Speed: %.3f\n",
                            robot.getName(), robot.getHealth(), robot.getAttack(), robot.getSpeed());
                        j++;
                    }
                }
                gameContinue = false;
            }
        }
    }

    protected Robot getRandomTarget(boolean isRedTeam){
        int index;
        if(isRedTeam){
            index = (int)(Math.random() * redRobots.size()) ;
        }
        else{
            index = (int)(Math.random() * blueRobots.size()) ;
        }
        

        if(isRedTeam){
            return redRobots.get(index);
        }
        return blueRobots.get(index);
    }

    protected Robot getHighestHealth(boolean isRedTeam){

        ArrayList<Robot> robotsArray;

        if(isRedTeam){

            robotsArray = redRobots;
        }
        else{
            robotsArray = blueRobots;
        }

        Robot healtyRobot = robotsArray.get(0);

        for (Robot robot : robotsArray) {
            if(robot.getHealth() > healtyRobot.getHealth()){
                healtyRobot = robot;
            }
        }

        return healtyRobot;
    }

    protected Robot getLowestHealth(boolean isRedTeam){

        ArrayList<Robot> robotsArray;

        if(isRedTeam){

            robotsArray = redRobots;
        }
        else{
            robotsArray = blueRobots;
        }

        Robot lowHealtyRobot = robotsArray.get(0);

        for (Robot robot : robotsArray) {
            if(robot.getHealth() < lowHealtyRobot.getHealth()){
                lowHealtyRobot = robot;
            }
        }

        return lowHealtyRobot;
    }

    protected Robot getLowestSpeed(boolean isRedTeam){

        ArrayList<Robot> robotsArray;

        if(isRedTeam){

            robotsArray = redRobots;
        }
        else{
            robotsArray = blueRobots;
        }

        Robot lowSpeedRobot = robotsArray.get(0);

        for (Robot robot : robotsArray) {
            if(robot.getSpeed() < lowSpeedRobot.getSpeed()){
                lowSpeedRobot = robot;
            }
        }

        return lowSpeedRobot;
    }

    protected Robot getLowestAttack(boolean isRedTeam){

        ArrayList<Robot> robotsArray;

        if(isRedTeam){

            robotsArray = redRobots;
        }
        else{
            robotsArray = blueRobots;
        }

        Robot lowAttackRobot = robotsArray.get(0);

        for (Robot robot : robotsArray) {
            if(robot.getAttack() < lowAttackRobot.getAttack()){
                lowAttackRobot = robot;
            }
        }

        return lowAttackRobot;
    }

    protected Robot[] getLowestSpeed3(boolean isRedTeam){

        ArrayList<Robot> robotsArray;

        if(isRedTeam){

            robotsArray = redRobots;
        }
        else{
            robotsArray = blueRobots;
        }

        Robot[] lowSpeedRobot = new Robot[3];
        Robot lowest1 = robotsArray.get(0);
        Robot lowest2 = robotsArray.get(1);
        Robot lowest3 = robotsArray.get(2);
        for (Robot robot : robotsArray) {
            if(robot.getHealth() < lowest1.getSpeed()){
                lowest3 = lowest2;
                lowest2 = lowest1;
                lowest1 = robot;
            }
        }
        lowSpeedRobot[0] = lowest1;
        lowSpeedRobot[1] = lowest2;
        lowSpeedRobot[2] = lowest3;

        return lowSpeedRobot;
    }

    protected void removeRobot(Robot r){

        ArrayList<Robot> robots = blueRobots;

        for (Robot robot : getRedRobots()) {

            if(robot.equals(r)){robots = redRobots;}
        }
        robots.remove(r);
    }

    //other necessary methods

    private void creatingRobots(int teamSize, ArrayList<Robot> robotsArray){

        for (int i = 0; i < teamSize; i++) {
            
        int num = (int)(Math.random() * 6) ;

        if(num == 0){
            Robot r = new SimpleBot();
            robotsArray.add(r);}
        if(num == 1){
            Robot r = new PredatorBot();
            robotsArray.add(r);}
        if(num == 2){
            Robot r = new DefenceBot();
            robotsArray.add(r);}
        if(num == 3){
            Robot r = new SpeedBot();
            robotsArray.add(r);}
        if(num == 4){
            Robot r = new SpreadBot();
            robotsArray.add(r);}
        if(num == 5){
            Robot r = new OneBot();
            robotsArray.add(r);}
        }
    }

    private void sortingRobots(ArrayList<Robot> robotsArray){
        int n = robotsArray.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (robotsArray.get(j).getSpeed() > robotsArray.get(j + 1).getSpeed()) {
                    // Swap array[j] and array[j+1]
                    Robot temp = robotsArray.get(j);
                    robotsArray.set(j, robotsArray.get(j+1));
                    robotsArray.set(j + 1, temp);
                }
            }
        }
    }

    protected int sumOfSpeeds(ArrayList<Robot> robotsArray){
         
        int sumOfSpeed = 0;

        for (int i = 0; i < robotsArray.size(); i++) {
            sumOfSpeed += robotsArray.get(i).getSpeed();
        }

        return sumOfSpeed;
    }

    //getter methods
    public ArrayList<Robot> getRedRobots() {
        return redRobots;
    }

    public ArrayList<Robot> getBlueRobots() {
        return blueRobots;
    }
}