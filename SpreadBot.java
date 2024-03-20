public class SpreadBot extends Robot{
    
    public SpreadBot(){

        code = "K";
        name = code + counter;
        counter ++;
        health = (Math.random() + 2); 
        attack = (Math.random() * 0.5 + 0.5); 
        speed = (Math.random() + 0.5); 
    }

    @Override
    protected void attack(Simulation s) {
        
        boolean isRedTeam = false;

        for (Robot robot : s.getRedRobots()) {
            if(robot.equals(this)){ isRedTeam =  true; }
        }

        Robot[] target = s.getLowestSpeed3(isRedTeam);
        System.out.println(this.getName() + " attacks following targets: \n" + target[0].getName() 
            + ", " + target[1].getName() + ", " + target[2].getName());

        System.out.printf("%s receives %.3f -> remaining health: %.3f\n",
                target[0].getName(), attack, target[0].getHealth());
        if(target[0].getHitAndIsDestroyed(this.attack)){

            System.out.println(target[0].getName() + " destroyed.");
            s.removeRobot(target[0]);
        }
        System.out.printf("%s receives %.3f -> remaining health: %.3f\n",
                target[1].getName(), attack, target[1].getHealth());
        if(target[1].getHitAndIsDestroyed(this.attack)){

            System.out.println(target[1].getName() + " destroyed.");
            s.removeRobot(target[1]);
        }
        System.out.printf("%s receives %.3f -> remaining health: %.3f\n",
                  target[2].getName(), attack, target[2].getHealth());
        if(target[2].getHitAndIsDestroyed(this.attack)){

            System.out.println(target[2].getName() + " destroyed.");
            s.removeRobot(target[2]);
        }
    }
}