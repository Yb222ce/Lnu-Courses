package yb222ce_assign3;

public class MoonsMain {
	 public static void main(String[] args) {
	        Planet mars = new Planet("Mars", 2, 0, 0.0, 0.0);
	        Moon Phobos = new Moon("Phobos", 0);
	        Moon Deimos = new Moon("Deimos", 0);

	        mars.addMoon(Deimos);
	        mars.addMoon(Phobos);

	        System.out.println("Moons of " + mars.getName() + ":");

	        for (int i = 0; i < mars.getNumOfMoons(); i++) {
	            System.out.println("\t" + mars.getMoons()[i].getName());
	        }
	    }

}
