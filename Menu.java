import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        System.out.print("Team Size: ");
        int teamSize = inp.nextInt();
        Simulation s = new Simulation();
        s.initialize(teamSize);

        System.out.println("Red Robots: ");

        for (int i = 0; i < teamSize; i++) {
            Robot r = s.getRedRobots().get(i);
            System.out.printf("%s Health: %.3f Attack: %.3f Speed: %.3f\n",
                r.getName(), r.getHealth(), r.getAttack(), r.getSpeed());
           
        }
        System.out.println();

        System.out.println("Blue Robots: ");
        for (int i = 0; i < teamSize; i++) {
            Robot r = s.getBlueRobots().get(i);
            System.out.printf("%s Health: %.3f Attack: %.3f Speed: %.3f\n",
                r.getName(), r.getHealth(), r.getAttack(), r.getSpeed());
           
        }
        System.out.println();

        System.out.print("Speed sum of red: " + s.sumOfSpeeds(s.getRedRobots()) + "\n");
        System.out.print("Speed sum of blue: " + s.sumOfSpeeds(s.getBlueRobots()) + "\n");

        s.simulate();
    }
}