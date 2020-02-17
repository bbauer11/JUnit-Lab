import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {

	GradeBook book1;
	GradeBook book2;
	GradeBook book3;
	GradeBook book0;
	
	@BeforeEach
	void setUp() throws Exception {
		book1 = new GradeBook(5);
		book1.addScore(10);
		book1.addScore(5.2);
		book1.addScore(4.9);
		book1.addScore(0);
		book1.addScore(8.5);
		
		book2 = new GradeBook(5);
		book2.addScore(1.1);
		book2.addScore(2.2);
		book2.addScore(3.3);
		
		book3 = new GradeBook(5);
		book3.addScore(1);
		book3.addScore(2.2);
		book3.addScore(3.1);
		book3.addScore(4);
		book3.addScore(5);
		book3.addScore(0);
		
		book0 = new GradeBook(0);
	}

	@AfterEach
	void tearDown() throws Exception {
		book1 = null;
		book2 = null;
		book3 = null;
		book0 = null;
	}

	
	@Test
	void addScoreTest() {
		assertEquals("10.0 5.2 4.9 0.0 8.5", book1.toString());
		assertEquals(book2.toString(), "1.1 2.2 3.3");
		assertEquals(book3.toString(), "1.0 2.2 3.1 4.0 5.0");
		assertEquals(book0.toString(), "");
		
		assertEquals(5, book1.getScoreSize());
		assertEquals(3, book2.getScoreSize());
		assertEquals(5, book3.getScoreSize());
		assertEquals(0, book0.getScoreSize());
	}

	
	@Test
	void sumTest() {
		assertEquals(28.6, book1.sum(), .0001);
		assertEquals(6.6, book2.sum(), .0001);
		assertEquals(15.3, book3.sum());
		assertEquals(0, book0.sum());
	}
	
	@Test
	void minimumTest() {
		assertEquals(0, book1.minimum());
		assertEquals(1.1, book2.minimum());
		assertEquals(1.0, book3.minimum());
		assertEquals(0, book0.minimum());
	}
	
	@Test
	void finalScoreTest() {
		assertEquals(28.6, book1.finalScore());
		assertEquals(5.5, book2.finalScore());
		assertEquals(14.3, book3.finalScore());
		assertEquals(0, book0.finalScore());
		
		GradeBook oneEntry = new GradeBook(12);
		oneEntry.addScore(5.5);
		assertEquals(5.5, oneEntry.finalScore());
	}
	
	
}
