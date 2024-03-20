public class OneBot extends Robot{
    
    public OneBot(){

        code = "O";
        name = code + counter;
        counter ++;
        health = (Math.random() * 0.5 + 0.5); 
        attack = (Math.random() + 4); 
        speed = (Math.random() * 0.5 + 0.5); 
    }

    @Override
    protected void attack(Simulation s) {

        boolean isRedTeam = false;

        for (Robot robot : s.getRedRobots()) {
            if(robot.equals(this)){ isRedTeam =  true; }
        }

        Robot target = s.getLowestAttack(isRedTeam);
        System.out.println(this.getName() + " attacks " + target.getName());
        System.out.printf("%s receives %.3f -> remaining health: %.3f\n",
                  target.getName(), attack, target.getHealth());
        
        if(target.getHitAndIsDestroyed(this.attack)){

            System.out.println(target.getName() + " destroyed.");
            s.removeRobot(target);
        }
    }
}