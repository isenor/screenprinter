package ca.isenor.screenprinter.graphics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.isenor.screenprinter.core.graphic.structures.Position;

public class PositionAdditionTest {

	@Test
	public void test() {
		
		Position addition = new Position(4,3).add(new Position(2,6));
		
		assertEquals(new Position(6,9), addition);
	}
	
	@Test
	public void testZero() {
		
		Position addition = new Position(0,0).add(new Position(2,6));
		
		assertEquals(new Position(2,6), addition);
	}
	
	@Test
	public void testZeroSum() {
		
		Position addition = new Position(-2,-6).add(new Position(2,6));
		
		assertEquals(new Position(0,0), addition);
	}

}
