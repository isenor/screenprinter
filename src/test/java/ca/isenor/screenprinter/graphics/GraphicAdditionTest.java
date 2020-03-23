package ca.isenor.screenprinter.graphics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.isenor.screenprinter.core.graphic.Graphic;

public class GraphicAdditionTest {

	@Test
	public void testOverriddingGraphics() {
		Graphic graphic = new Graphic("hello");
		graphic.add(graphic.offset(4,0));
		assertEquals("hellhello", graphic.toString());
	}
	
	@Test
	public void testOverriddingGraphicsWithoutTransparency() {
		Graphic graphic = new Graphic("  hello");
		graphic.add(graphic.offset(4,0));
		assertEquals("  he  hello", graphic.toString());
	}
	
	@Test
	public void testOverriddingGraphicsWithTransparency() {
		Graphic graphic = new Graphic("  hello");
		graphic.setTransparent(true);
		graphic.add(graphic.offset(4,0));
		assertEquals("  hellhello", graphic.toString());
	}


}
