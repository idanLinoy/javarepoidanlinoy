package com.myproj.javacourse;
import static java.lang.Math.*;

public class MathEx3 {
	
	public static double circleArea(int r) {
		return (Math.PI)*r*r;
	}
	
	public static double calcOpposite(int angle, int hypotenuse) {
		double radians = ((angle*Math.PI)/180);
		
		return Math.round(Math.sin(radians)*hypotenuse);
	}

	public static String getResults() {
		String resultStr = new String();
		int radius = 50,
			angle = 30, hypotenuse = 50,
			base = 20, exp = 13;
		
		String line1 = new String ("Calculation 1: Area of circle with radius " + radius + " is " + MathEx3.circleArea(radius) + " square-cm");
		String line2 = new String ("Calculation 2: Length of opposite where angle B is  " + angle + " and Hypotenuse length is " + hypotenuse + " is " + MathEx3.calcOpposite(angle,hypotenuse) + " cm");
		String line3 = new String ("Calculation 3: Power of base " + base + " with exp of " + exp + " is " + pow(base,exp));
		
		resultStr = line1 + "<br>" + line2 + "<br>" + line3;
		return resultStr;
	}
}