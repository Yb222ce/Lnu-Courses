package yb222ce_assign3;

public class MoonMain {
	public static void main(String[] args) {
        Moon ganymede = new Moon("Ganymede", 5262);

        System.out.println("Largest moon in the solar system is " + ganymede.getName() + " which is " +
                ganymede.getDiameter() + " km in diameter.");
    }

}
