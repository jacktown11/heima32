package day17;

import java.math.BigDecimal;

public class BigDecimalQues {
	public final static String[] data = {"-0.75","-0.5","-0.25","0.25","0.5","0.75"};
	public static String mathStr = "";
	
	public static void main(String[] args) {
		int[] modes = {BigDecimal.ROUND_CEILING, BigDecimal.ROUND_FLOOR,
				BigDecimal.ROUND_DOWN, BigDecimal.ROUND_UP,
				BigDecimal.ROUND_HALF_DOWN, BigDecimal.ROUND_HALF_EVEN,
				BigDecimal.ROUND_HALF_UP};

		for(int i = 0; i < data.length; i++) {			
			String res = ""+Math.round(Double.parseDouble(data[i]));
			mathStr += String.format("%2s |", res);
		}
		System.out.println(mathStr);
		
		for (int i = 0; i < modes.length; i++) {
			isSameToRound(modes[i]);
		}
	}

	public static void isSameToRound(int roundMode) {
		final BigDecimal ONE = new BigDecimal(1);
		String resStr = "";
		
		for(int i = 0; i < data.length; i++) {			
			BigDecimal bg = new BigDecimal(data[i]);
			String tmp = bg.divide(ONE, 0, roundMode).toString();	
			resStr += String.format("%2s |", tmp);
		}
		System.out.print(resStr);
		System.out.println(mathStr.equals(resStr));
	}
}
