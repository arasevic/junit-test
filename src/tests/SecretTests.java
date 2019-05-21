package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import sysutilities.Address;

public class SecretTests {
    /* If you set to true images will be displayed when you ran the tests */
    public static final boolean GRAPHICAL_MODE_FLAG = false;
    
	@Test
	public void secTest1() {
		/* Copy constructor */
		String answer = "";
	
		Address address1 = new Address("8134 Java St.", "Silver Spring", "VA", "21567");
		Address address2 = new Address(address1);
		answer += address2 + "\n";
		
		assertTrue(TestsSupport.isCorrect("secTest1.txt", answer));
	}
	
	@Test
	public void secTest2() {
		/* One Parameter constructor */
		String answer = "";
	
		Address address1 = new Address("8134 Java St.");
		answer += address1 + "\n";
		
		assertTrue(TestsSupport.isCorrect("secTest2.txt", answer));
	}
	
	@Test
	public void secTest3() {
		/* Checking null parameters for Address */		
		try {
			Address address1 = new Address(null, null, null, null);
			assertTrue(false);
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void secTest4() {
		/* Checking invalid zip code */		
		try {
			Address address1 = new Address("C++ Script", "Bethesda", "MD", "20A742");
			assertTrue(false);
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}		
	}
	
	@Test
	public void secTest5() {
		/* Checking trimming in Address */		
		try {
			Address address1 = new Address("  C++ Script  ", "   Bethesda", " MD", "  20742");
			Address address2 = new Address("C++ Script", "Bethesda", " MD", "20742");
			assertTrue(address1.equals(address2));
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}		
	}
}