package yb222ce_assign3;


public class Moon {
	private String name;
    private int diameter;

    public Moon(){
    }
    public Moon(String name,int diameter){
        setName(name);
        setDiameter(diameter);
    }

    public String getName() {
        return name;
    }
    public void setName(String theName){
        name = theName;
    }
    public int getDiameter(){
        return diameter;
    }
    public void setDiameter(int theDiameter){
        diameter = theDiameter;
    }

}
