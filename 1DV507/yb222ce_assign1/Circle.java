package yb222ce_assign1;

public class Circle extends Shape {
	private double radius;
    double pi = Math.PI;
    public Circle(String name, double radius) {
        // TODO Auto-generated constructor stub
        super(name);
        this.radius=radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius=radius;
    }


    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        return pi * Math.pow(radius,2);
    }

    @Override
    public double getPerimeter() {
        // TODO Auto-generated method stub
        return 2 * pi * radius;
    }
}


