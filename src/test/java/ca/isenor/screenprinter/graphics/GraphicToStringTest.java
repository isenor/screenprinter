package ca.isenor.screenprinter.graphics;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.isenor.screenprinter.core.graphic.Graphic;
import ca.isenor.screenprinter.core.graphic.structures.Position;

public class GraphicToStringTest {

	@Test
	public void testToString() {
		String expected = "howdy";
		Graphic graphic = new Graphic(new Position(4,5), expected);
		assertEquals(expected, graphic.toString());
	}
	
	@Test
	public void testToStringTwoLines() {
		String expected = "hello\ndello";
		Graphic graphic = new Graphic(new Position(4,5), expected);
		assertEquals(expected, graphic.toString());
	}
	
	/*
	 * The string that you get out via 'toString()' is not guaranteed to match what was given to Graphic
	 */
	@Test
	public void testToStringSpaces() {
		String expected = " hello\ndello";
		Graphic graphic = new Graphic(new Position(4,5), expected);
		assertEquals(expected + " ", graphic.toString());
	}
	
	@Test
	public void testAfterAdding() {
		String expected = "hello\ndello";
		Graphic graphic = new Graphic(new Position(1,3), expected);
		graphic.add(new Position(1,1), expected);
		assertEquals(expected + "\n" + expected, graphic.toString());
	}
	
	@Test
	public void testTopLeft() {
		String expected = "hello\ndello";
		Graphic graphic = new Graphic(new Position(4,3), expected);
		assertEquals(new Position(4,3), graphic.getTopLeftPosition());
		graphic.add(new Position(1,4), expected);
		assertEquals(new Position(1,3), graphic.getTopLeftPosition());
	}

}
