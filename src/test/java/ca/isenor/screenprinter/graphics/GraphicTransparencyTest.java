package ca.isenor.screenprinter.graphics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ca.isenor.screenprinter.core.graphic.Graphic;

public class GraphicTransparencyTest {

	private Graphic right;
	private Graphic middle;
	private Graphic left;
	
	@Before
	public void setUp() {
		left = new Graphic(  "xxx");
		middle = new Graphic("   xxx");
		right = new Graphic( "      xxx");
	}

	@Test
	public void testTransparencyOffByDefault() {
		// The whitespace at the beginning of the line in right is covered by the
		// subsequent graphics
		assertEquals("xxxxxxxxx", right.apply(middle).apply(left).toString());
	}
	
	@Test
	public void testTransparencyOffByDefaultOtherDirection() {
		// the whitespace in the applied graphics covers over the previous graphics
		assertEquals(right.toString(), left.apply(middle).apply(right).toString());
	}
	

	@Test
	public void testTransparencyOn() {
		left.setTransparent(true);
		middle.setTransparent(true);
		right.setTransparent(true);
		// the whitespace in the applied graphics covers over the previous graphics
		assertEquals("xxxxxxxxx", left.apply(middle).apply(right).toString());
	}
	
	@Test
	public void testTransparencyOnAndOff() {
		left.setTransparent(true);
		middle.setTransparent(false);
		right.setTransparent(true);
		// the whitespace in the applied graphics covers over the previous graphics
		assertEquals("   xxxxxx", left.apply(middle).apply(right).toString());
	}
	
	@Test
	public void testTransparentQualityTransfer1() {
		left.setTransparent(true);
		middle.setTransparent(false);
		
		assertFalse(left.apply(middle).isTransparent());
	}
	
	@Test
	public void testTransparentQualityTransfer2() {
		left.setTransparent(true);
		middle.setTransparent(true);
		
		assertTrue(left.apply(middle).isTransparent());
	}
	
	@Test
	public void testTransparentQualityTransfer3() {
		left.setTransparent(false);
		middle.setTransparent(false);
		
		assertFalse(left.apply(middle).isTransparent());
	}
	
	@Test
	public void testTransparentQualityTransfer4() {
		left.setTransparent(false);
		middle.setTransparent(true);
		
		assertFalse(left.apply(middle).isTransparent());
	}
}
