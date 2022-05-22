package yb222ce_assign1;

public class Lorry extends Vehicle {
	public Lorry(int p){
		size = 8;
		vecType = vehicleType.Lorry;
		if(p<=2 && p>0){
			
		}else throw new IndexOutOfBoundsException();
	}

}
