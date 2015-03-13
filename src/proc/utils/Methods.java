package proc.utils;

import java.math.BigDecimal;

public class Methods {

	//REF http://stackoverflow.com/questions/8911356/whats-the-best-practice-to-round-a-float-to-2-decimals answered Jan 18 '12 at 14:21
	public static double 
	round(double d, int decimalPlace) {
		
        BigDecimal bd = new BigDecimal(Double.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
        
    }
	
}
