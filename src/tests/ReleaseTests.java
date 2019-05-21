package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sysutilities.PhotoProcessingSys;

public class ReleaseTests {
    /* If you set to true images will be displayed when you ran the tests */
    public static final boolean GRAPHICAL_MODE_FLAG = false;
    
	@Test
	public void relTest1() {
		/* select colors for gGGb */
		String answer = "";
		
		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction(null, "clear", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "display", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "selectcolors", "gGGb", GRAPHICAL_MODE_FLAG);
		
		assertTrue(TestsSupport.isCorrect("relTest1.txt", answer));
	}
	
	@Test
	public void relTest2() {
		/* select colors for gGGb */
		String answer = "";
		
		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction(null, "clear", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "display", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "selectcolors", "  R B b  r ", GRAPHICAL_MODE_FLAG);
		
		assertTrue(TestsSupport.isCorrect("relTest2.txt", answer));
	}
	
	@Test
	public void relTest3() {
		/* blackandwhite, posterize */
		String answer = "";
		
		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction(null, "clear", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("testudo.jpg", "display", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("testudo.jpg", "blackandwhite", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("testudo.jpg", "posterize", null, GRAPHICAL_MODE_FLAG);
		
		assertTrue(TestsSupport.isCorrect("relTest3.txt", answer));
	}
	
	@Test
	public void relTest4() {
		/* checking getTransactions */
		String answer = "";
		
		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction(null, "clear", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("testudo.jpg", "display", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("testudo.jpg", "blackandwhite", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("testudo.jpg", "posterize", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("testudo.jpg", "displaylast", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.getTransactions();
		
		assertTrue(TestsSupport.isCorrect("relTest4.txt", answer));
	}
}