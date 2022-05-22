package yb222ce_assign1;

public class Bus extends Vehicle {
	public Bus(int p){
		size = 8;
		vecType = vehicleType.Bus;
		if(p<=20 && p>0){
			passengers.setPassengers(p);
		}else throw new IndexOutOfBoundsException();
	}

}
