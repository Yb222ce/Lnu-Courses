package yb222ce_assign1;

public abstract class Vehicle {
	protected int size;
	protected Passenger passengers = new Passenger();
	protected boolean isStationed = false;
	protected vehicleType vecType;
	public int sizeOfVehicle;
	
	public enum vehicleType{
		Car,
		Bus,
		Bicycle,
		Lorry;
	}

	public void stationVehicle(){
		if(!isStationed)
			isStationed = true;
		else 
			isStationed = false;
		
	}
	public Object getVecType(){
		return vecType;
	}
	
	protected void setSize(int n){
		passengers.setPassengers(n);
	}
	
	public boolean getState(){
		return isStationed;
	}
	public Passenger getPassenger(){
		return passengers;
	}
	public int passAmount(){
		return getPassenger().getPassAmount();
	}
	
	public int getSize(){
		return size;
	}
	public vehicleType getType(){
		return vecType;
	}
	public int totalCost() {
		// TODO Auto-generated method stub
		return 0;
	}
	


}

