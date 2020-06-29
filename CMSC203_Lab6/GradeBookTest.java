package Lab6;

import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	private GradeBook scores1;
	private GradeBook scores2;
	@BeforeEach
	void setUp() throws Exception {
		scores1 = new GradeBook(5);
		scores2 = new GradeBook(5);
		
		scores1.addScore(100.0);
		scores1.addScore(78.3);
		scores1.addScore(92.0);
		scores1.addScore(88.6);
		
		scores2.addScore(43.5);
		scores2.addScore(87.4);
		scores2.addScore(35.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		scores1 = null;
		scores2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(scores1.toString().equals("100.0 78.3 92.0 88.6 0.0 "));
		assertTrue(scores2.toString().equals("43.5 87.4 35.0 0.0 0.0 "));
		
		assertEquals(4, scores1.getScoreSize());
		assertEquals(3, scores2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(358.9, scores1.sum(), 0.0001);
		assertEquals(165.9, scores2.sum(), 0.0001);
	}

	@Test
	void testMinimum() {
		assertEquals(78.3, scores1.minimum(), 0.001);
		assertEquals(35.0, scores2.minimum(), 0.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(280.6, scores1.finalScore(), 0.001);
		assertEquals(130.9, scores2.finalScore(), 0.001);
	}
}
