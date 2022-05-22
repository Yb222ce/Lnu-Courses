package yb222ce_assign4.BinaryHeap;



public class BinaryIntHeap  {
	private int[] data;
	private int size;
	
	public BinaryIntHeap(){ //Constructs an empty heap
		
		data=new int[8];
		size=0;
	
	}
	public void insert(int n){ // Add n to heap
		
		size++;
		data[size]=n;
		//System.out.println(toString());
		percolationUp(n,size);
		if(size+1==data.length)
		{
			resize();
		}
	}
	
	private void percolationUp(int n, int pos){
		
		if(pos/2!=0 && data[pos/2]<n)
		{
			int tmp=data[pos/2];
			data[pos/2]=n;
			data[pos]=tmp;
			percolationUp(n,pos/2);
		}
		
		
	}
	
	private void  resize() {
		int[] tmp = new int[2*data.length];
		System.arraycopy(data,0,tmp,0,data.length); 
		data=tmp;
	}
	
	
	public int pullHighest(){ // Return and remove element with highest priority
	
		int highest=data[1];
		
		data[1]=data[size];
		int[] tmp = new int[data.length];
		System.arraycopy(data,0,tmp,0,size); 
		data=tmp;
		size--;
		percolationDown(data[1],1);
		
		return highest;
	}
	
	private void percolationDown(int n, int pos){
		
		if(2*pos<size)
		{
			if(data[2*pos]>n)
			{
				int tmp=data[pos];
				data[pos]=data[2*pos];
				data[2*pos]=tmp;
				percolationDown(n,2*pos);
			}
		}
		else if(2*pos+1<size)
		{
			if(data[2*pos+1]>n)
			{
				int tmp=data[pos];
				data[pos]=data[2*pos+1];
				data[2*pos+1]=tmp;
				percolationDown(n,2*pos+1);
			}
		}
		
		
		
	}
	
	
	
	
	
	public int size(){ // Current heap size
		
		return size;
	}
	public boolean isEmpty(){ // True if heap is empty
		
		return size==0;
	}
	
	public String toString(){
		
		StringBuilder str=new StringBuilder();
		str.append("[");
		str.append("empty,");
		for(int i=1;i<=size;i++)
		{
			str.append(data[i]);
			str.append(",");
		}
		str.append("]");
		return str.toString();
	}

}
