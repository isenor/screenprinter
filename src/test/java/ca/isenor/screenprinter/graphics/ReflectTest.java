package ca.isenor.screenprinter.graphics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.isenor.screenprinter.core.graphic.Graphic;
import ca.isenor.screenprinter.core.graphic.structures.Orientation;
import ca.isenor.screenprinter.core.graphic.structures.Position;

public class ReflectTest {

	@Test
	public void testVertical() {
		Graphic graphic = new Graphic("xyz\nabc");
		assertEquals("zyx\ncba", graphic.reflect(2,Orientation.VERTICAL).toString());
	}
	
	@Test
	public void testVertical2() {
		Graphic graphic = new Graphic("xyz\nabc");
		assertEquals('x', graphic.getCell(0, 0).getDisplay());
		assertEquals('y', graphic.getCell(1, 0).getDisplay());
		assertEquals('z', graphic.getCell(2, 0).getDisplay());
		Graphic updatedGraphic = graphic.reflect(4,Orientation.VERTICAL);
		assertEquals('x', updatedGraphic.getCell(8, 0).getDisplay());
		assertEquals('y', updatedGraphic.getCell(7, 0).getDisplay());
		assertEquals('z', updatedGraphic.getCell(6, 0).getDisplay());
	}
	
	@Test
	public void testHorizontal() {
		Graphic graphic = new Graphic("xyz\n   \nabc");
		assertEquals("abc\n   \nxyz", graphic.reflect(2,Orientation.HORIZONTAL).toString());
	}
	
	@Test
	public void testBoth() {
		Graphic graphic = new Graphic("xyz\nlmn\nabc");
		assertEquals("cba\nnml\nzyx", graphic.reflect(2,Orientation.HORIZONTAL).reflect(2, Orientation.VERTICAL).toString());
	}
	
	@Test
	public void testOffsets() {
		Graphic graphic = new Graphic(new Position(0,5), "xyz");
		assertEquals('x', graphic.reflect(3,Orientation.HORIZONTAL).getCell(new Position(0,1)).getDisplay());
	}

}
