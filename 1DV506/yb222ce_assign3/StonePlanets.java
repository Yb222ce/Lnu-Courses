package yb222ce_assign3;

public class StonePlanets {
	public static void main(String[] args) {

		
		Planet[] stonePlan = new Planet[4]; 

        stonePlan[0] = new Planet("Mercury", 0, 0, 0.47, 0.31);
        stonePlan[2] = new Planet("Earth", 0, 1, 1.0, 0.99);
        stonePlan[1] = new Planet("Venus", 0, 0, 0.72, 0.72);
        stonePlan[3] = new Planet("Mars", 0, 2, 1.666, 1.382);
       
        Moon theEarth = new Moon("The Moon", 0);    
        Moon deismos = new Moon("Deismos", 0);
        Moon phobos = new Moon("Phobos", 0);

        stonePlan[2].addMoon(theEarth);     
        stonePlan[3].addMoon(deismos);
        stonePlan[3].addMoon(phobos);


        for (int i = 0; i < stonePlan.length; i++) {    
            System.out.println("Planet " + stonePlan[i].getName() + " has aphelion "
                    + stonePlan[i].getAphelion() + " AU, perihelion " + stonePlan[i].getPeriheli()
                    + " AU, and " + stonePlan[i].getNumOfMoons() + " moon(s).");
            for (int j = 0; j < stonePlan[i].getNumOfMoons(); j++) {
                System.out.println(stonePlan[i].getMoons()[j].getName());
            }
        }

    }
}
