package yb222ce_assign1;

public class Car extends Vehicle {
	
	public Car(int p){
		
		size = 8;
		
		if(p<=4 && p>0){
			
			vecType = vehicleType.Car;
			
			passengers.setPassengers(p);
			
		}else throw new IndexOutOfBoundsException();
	}


}
