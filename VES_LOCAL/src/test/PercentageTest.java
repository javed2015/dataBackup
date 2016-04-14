package test;

import java.text.DecimalFormat;

public class PercentageTest {
	static double test = 169;
	static double falses = 168;
	
	
	/**
	 * @param args
	 */
	public static void main(String []args){
		double	percentage =  ((falses/test)*100);
		DecimalFormat df = new DecimalFormat("#.00");
	//	  String angleFormated = df.format(percentage);
	System.out.println(df.format(percentage));
	}
 
}
