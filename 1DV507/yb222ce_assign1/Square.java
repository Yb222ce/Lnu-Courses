package yb222ce_assign1;

public class Square extends Shape{
	private int side;
	  public Square(String name, int side){
	        super(name);
	        this.side=side;
	    }
	    @Override
	    public double getArea() {
	        return side*side;
	    }

	    @Override
	    public double getPerimeter() {
	        return side +side +side+ side;
	    }

	    @Override
	    public String toString() {
	        return super.toString();
	    }
	}



