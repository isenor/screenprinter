package ca.isenor.screenprinter.graphics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.isenor.screenprinter.core.graphic.Graphic;
import ca.isenor.screenprinter.core.graphic.structures.Degrees;
import ca.isenor.screenprinter.core.graphic.structures.Position;

public class RotationTest {

	@Test
	public void testRotationLeavesCenterInPlace() {
		Graphic graphic = new Graphic("xyz");
		Graphic rotatedGraphic = graphic.rotate(new Position(0,0), Degrees.DEGREE_90);
		
		assertEquals(graphic.getCell(0,0).getDisplay(), rotatedGraphic.getCell(0,0).getDisplay());
	}
	
	@Test
	public void testRotationMovesAround() {
		Graphic graphic = new Graphic("xyz");
		Graphic rotatedGraphic = graphic.rotate(new Position(0,0), Degrees.DEGREE_90);
		
		assertEquals(graphic.getCell(1,0).getDisplay(), rotatedGraphic.getCell(0,1).getDisplay());
		assertEquals(graphic.getCell(2,0).getDisplay(), rotatedGraphic.getCell(0,2).getDisplay());
	}
	
	@Test
	public void testRotationWithOffsetCenter() {
		Graphic graphic = new Graphic("xyz");
		Graphic rotatedGraphic = graphic.rotate(new Position(0,1), Degrees.DEGREE_90);
		
		assertEquals(graphic.getCell(0,0).getDisplay(), rotatedGraphic.getCell(1,1).getDisplay());
		assertEquals(graphic.getCell(1,0).getDisplay(), rotatedGraphic.getCell(1,2).getDisplay());
		assertEquals(graphic.getCell(2,0).getDisplay(), rotatedGraphic.getCell(1,3).getDisplay());
	}
	
	@Test
	public void testRotation180() {
		Graphic graphic = new Graphic("xyz\nabc");
		Graphic rotatedGraphic = graphic.rotate(new Position(0,2), Degrees.DEGREE_180);
		assertEquals(graphic.getCell(0,0).getDisplay(), rotatedGraphic.getCell(0,4).getDisplay());
		assertEquals(graphic.getCell(1,0).getDisplay(), rotatedGraphic.getCell(-1,4).getDisplay());
		assertEquals(graphic.getCell(2,0).getDisplay(), rotatedGraphic.getCell(-2,4).getDisplay());
	}
	
	@Test
	public void testRotation270() {
		Graphic graphic = new Graphic("xyz\nabc");
		Graphic rotatedGraphic = graphic.rotate(new Position(2,1), Degrees.DEGREE_270);
		assertEquals(graphic.getCell(0,0).getDisplay(), rotatedGraphic.getCell(1,3).getDisplay());
		assertEquals(graphic.getCell(1,0).getDisplay(), rotatedGraphic.getCell(1,2).getDisplay());
		assertEquals(graphic.getCell(2,0).getDisplay(), rotatedGraphic.getCell(1,1).getDisplay());
	}
	

}
