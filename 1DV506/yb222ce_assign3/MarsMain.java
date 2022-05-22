package yb222ce_assign3;

public class MarsMain {
	public static void main(String[] args){
        Planet mars = new Planet();
        mars.setName("Mars");
        mars.setNumFromSun(4);
        mars.setNumOfMoons(2);
        mars.setAphelion(1.666);
        mars.setPeriheli(1.382);

        System.out.println(mars.getName() + ": \n" + "\t"
                        + "Position:   " + mars.getNumFromSun()
                        + "\n" + "\t"+ "Moons:      " + mars.getNumOfMoons()
                        + "\n" + "\t" + "Aphelion:   " + mars.getAphelion()
                        + "\n" + "\t" + "Perihelion: " + mars.getPeriheli());
    }
}
