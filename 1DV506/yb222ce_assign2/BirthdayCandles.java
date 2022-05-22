package yb222ce_assign2;

public class BirthdayCandles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int candle = 0, box = 0 , boxCounter = 0; 
       

        for (int i  = 1; i <=100; i++) {
            while (candle < i) { 
                box++;
                boxCounter++;
                candle = candle + 24;
            }

            if (box > 0) { 
                System.out.println("Before " + i + " birthday, " + " buy " + box + " box(es)");
            }

            candle = candle - i; 
            box = 0; 
        }

        
        System.out.println("Total boxes: " + boxCounter + " Candles left: " + candle);
	}

}
