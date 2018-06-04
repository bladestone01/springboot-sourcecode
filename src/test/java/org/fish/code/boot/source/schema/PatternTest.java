package org.fish.code.boot.source.schema;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PatternTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void isPositiveInteger() {
		System.out.println("\n*** Positive Intger *****");
		String pattern = "^\\+?[1-9]\\d*"; //? -- {0,1}
		
		System.out.println("90:" + "90".matches(pattern));
		System.out.println("9:" + "9".matches(pattern));
		System.out.println("90.1:" + "90.1".matches(pattern));
		System.out.println("-9:" + "-9".matches(pattern));
		System.out.println("00:" + "00".matches(pattern));
	}

	@Test
	public void isNegativeInteger() {
		System.out.println("\n*** Negative Intger *****");
        String pattern = "^-[1-9]\\d*";
		
		System.out.println("90:" + "90".matches(pattern));
		System.out.println("90.1:" + "90.1".matches(pattern));
		System.out.println("-9:" + "-9".matches(pattern));
		System.out.println("00:" + "00".matches(pattern));
		System.out.println("-0.1:" + "00".matches(pattern));
	}
	
	@Test
	public void isWholeNumber() {
		System.out.println("\n ***  is Pure Number ****");
		String numberPattern = "[+-]?0";
		
		System.out.println("+0:" + "+0".matches(numberPattern));
		System.out.println("-0:" + "-0".matches(numberPattern));
		System.out.println("0:" + "0".matches(numberPattern));
		
	   //combine three pattern 0, isNegative, isPositive
	}
	
	@Test
	public void isNegativeDecimal() {
		System.out.println("\n ***  is Negative Number ****");
		String decimalPattern = "^-[0]\\.[1-9]*|^-[1-9]\\d*\\.\\d*";
		
		System.out.println("-12.1:" + "-12.1".matches(decimalPattern));;
		System.out.println("-122:" + "-122".matches(decimalPattern));;
		System.out.println("122:" + "122".matches(decimalPattern));;
		System.out.println("0.2:" + "0.2".matches(decimalPattern));;
	}
	
	@Test
	public void isPositveDecimal() {
		System.out.println("\n ***  is Positive Number ****");
		String positvePattern = "\\+{0,1}[0]\\.[1-9]*|\\+{0,1}[1-9]\\d*\\.\\d*";
		
		System.out.println("-12.1:" + "-12.1".matches(positvePattern));;
		System.out.println("-122:" + "-122".matches(positvePattern));;
		System.out.println("122:" + "122".matches(positvePattern));;
		System.out.println("0.2:" + "0.2".matches(positvePattern));;
	}
	
	@Test
	public void isDecimal() {
		//combine negative decimal/positive decimal
		String pattern = "[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+";
	}
}
