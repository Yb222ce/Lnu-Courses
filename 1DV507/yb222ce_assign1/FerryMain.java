package yb222ce_assign1;

public class FerryMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FerryBoat ferry = new FerryBoat();
		Car car = new Car(4);
		Bus bus = new Bus(10);
		Bicycle bicycle = new Bicycle();
		Lorry lorry = new Lorry(2);
		Passenger passenger = new Passenger();
		
		
		ferry.embark(car);
		ferry.embark(bus);
		ferry.embark(passenger);
		ferry.embark(bicycle);
		ferry.embark(lorry);
		System.out.println(ferry.toString());
		ferry.disembark();
		System.out.println(ferry.toString());

}}
