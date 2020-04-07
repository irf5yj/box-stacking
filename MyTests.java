package boxstacking;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyTests {

	@Test public void simpleCase() {
		Algorithm boxStacking = new Algorithm();
			
		Box[] input = {new Box(4,6,7), new Box(1,2,3), new Box(4,5,6), new Box(10,12,32)};
		assertEquals("Example provided should have 60 height", 60,boxStacking.solve(input));	
	}
	
	@Test public void edgeCase() {
		Algorithm boxStacking = new Algorithm();
		
		Box[] t1 = {new Box(3,3,3)};
		Box[] t2 = {};
		Box[] t3 = {new Box(3,3,0)};
		
		assertEquals("Square box should not be stacked on top of itself", 3, boxStacking.solve(t1));
		assertEquals("Empty set should have 0 height", 0, boxStacking.solve(t2));
		assertEquals("Flat box should still be rotated", 3, boxStacking.solve(t3));

	}

}