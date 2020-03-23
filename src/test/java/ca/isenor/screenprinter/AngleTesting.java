package ca.isenor.screenprinter;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class AngleTesting {

	private static final double DEGREE_90 = Math.PI/2;
	private static final double DEGREE_180 = Math.PI;
	private static final double DEGREE_270 = 3*Math.PI/2;

	@Test
	public void test() {
		System.out.println(Math.round(Math.cos(DEGREE_90)));
		System.out.println(Math.round(Math.sin(DEGREE_90)));
		
		System.out.println(Math.round(Math.cos(DEGREE_180)));
		System.out.println(Math.round(Math.sin(DEGREE_180)));
		
		System.out.println(Math.round(Math.cos(DEGREE_270)));
		System.out.println(Math.round(Math.sin(DEGREE_270)));
	}

}
