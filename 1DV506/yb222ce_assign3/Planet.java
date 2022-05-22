package yb222ce_assign3;

import java.util.ArrayList;

public class Planet {
	
	 private String name;
	    private int numOfMoons;
	    private int numFromSun;
	    private double Aphelion;
	    private double Periheli;
	    private ArrayList<Moon> moons; 

	    public Planet() {
	        moons = new ArrayList<Moon>();     
	    }

	    public Planet(String name, int numFromSun, int numOfMoons, double Aphelion, double Periheli) {
	        setName(name);
	        setNumFromSun(numFromSun);
	        setNumOfMoons(numOfMoons);
	        setAphelion(Aphelion);
	        setPeriheli(Periheli);
	        moons = new ArrayList<Moon>();         
	    }

	    public String getName() {
	        if (name == null) {
	            return "Unknown planet";
	        } else {
	            return name;
	        }
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public double getPeriheli() {
	        if (Periheli < 0 || Periheli > 30) {
	            return 0;
	        } else {
	            return Periheli;
	        }
	    }

	    public void setPeriheli(double Periheli) {
	        this.Periheli = Periheli;
	    }

	    public double getAphelion() {
	        if (Aphelion < 0 || Aphelion > 50) {
	            return 0;
	        } else {
	            return Aphelion;
	        }
	    }

	    public void setAphelion(double Aphelion) {
	        this.Aphelion = Aphelion;
	    }


	    public int getNumOfMoons() {
	        if (numOfMoons < 0 || numOfMoons > 100) {
	            return 0;
	        } else {
	            return numOfMoons;
	        }
	    }

	    public void setNumOfMoons(int numOfMoons) {
	        this.numOfMoons = numOfMoons;
	    }

	    public int getNumFromSun() {
	        if (numFromSun < 1 || numFromSun > 9) {
	            return 0;
	        } else {
	            return numFromSun;
	        }
	    }

	    public void setNumFromSun(int numFromSun) {
	        this.numFromSun = numFromSun;
	    }

	    public void addMoon(Moon m) {           // lägger till månarna.
	        moons.add(m);
	        numOfMoons = moons.size();
	    }

	    public Moon[] getMoons() {              // hämtar månarna
	         Moon [] m = new Moon [numOfMoons];
	        for (int i = 0; i < numOfMoons ; i++) {
	            m[i] = moons.get(i);
	        } return m;
	    }

}
