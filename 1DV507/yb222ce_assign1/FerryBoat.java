package yb222ce_assign1;

import java.util.ArrayList;
import java.util.Iterator;

public class FerryBoat implements Ferry{
	
	private int passengerAmount=0; 
	private int sizeLeft = 200; 
	private int money = 0;
	private ArrayList<Vehicle> currentVehicles= new ArrayList<>();

	public int countPassengers() {
		// TODO Auto-generated method stub
		return passengerAmount;
	}

	public int countVehicleSpace() {
		// TODO Auto-generated method stub
		return 200 - sizeLeft;
	}

	public int countMoney() {
		// TODO Auto-generated method stub
		return money;
	}

	public Iterator<Vehicle> iterator() {
		return iterator();
	}

	public void embark(Vehicle v) {
		if(hasSpaceFor(v) && hasRoomFor(v.getPassenger()) && !v.getState()){ 
			sizeLeft = sizeLeft - v.size;
			passengerAmount+=v.getPassenger().getPassAmount();
			v.stationVehicle();
			currentVehicles.add(v);
			switch(v.getType()){
				case Bicycle:
					money+=40;
					break;
				case Car:
					money += 100 +(15*( v.getPassenger().getPassAmount()));
					break;
				case Bus:
					money +=200 +(10*( v.getPassenger().getPassAmount()));
					break;
				case Lorry:
					money +=300 +(15*( v.getPassenger().getPassAmount()));
					break;
			}
		}else throw new IndexOutOfBoundsException();
	}

	public void embark(Passenger p) {
		if(hasRoomFor(p)){
			passengerAmount +=p.getPassAmount();
			money += 20*p.getPassAmount();
		}else throw new IndexOutOfBoundsException();
		
	}

	public void disembark() { 
		sizeLeft = 200;
		passengerAmount = 0;
		int temp = currentVehicles.size();
		while(currentVehicles.size() >0){
			currentVehicles.get(0).stationVehicle();
			currentVehicles.remove(0);
			
		}
		
	}

	public boolean hasSpaceFor(Vehicle v) { 
		if(v.getSize() <= sizeLeft)
			return true;
		
		return false;
	}

	public boolean hasRoomFor(Passenger p) { 
		// TODO Auto-generated method stub
		if(p.getPassAmount() + passengerAmount <=200)
			return true;
		
		return false;
	}
	
	public String toString(){
		
		return "Total vehicles on ferry : " + currentVehicles.size()+"."+ "\n"
			+  "Total passengers on ferry : " + passengerAmount + " \n" +
			   "Total money earned : " + countMoney() + " \n"+
			   "Can fit " + (200-passengerAmount) + " passengers " + "\n" +
			   "Can fit " + sizeLeft + " more vehicles" + "\n";
	}

}


