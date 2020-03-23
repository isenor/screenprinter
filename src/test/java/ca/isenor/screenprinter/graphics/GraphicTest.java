package ca.isenor.screenprinter.graphics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Ignore;
import org.junit.Test;

import ca.isenor.screenprinter.core.graphic.Graphic;
import ca.isenor.screenprinter.core.graphic.structures.Cell;
import ca.isenor.screenprinter.core.graphic.structures.Position;

public class GraphicTest {

	@Ignore
	@Test
	public void test() {
		Graphic graphic = new Graphic();
		graphic.add(new Position(1,0), "  hello\nmy name is\nTOM RIDDLE!");
		displayGraphic(graphic);
	}
	
	@Ignore
	@Test
	public void test2() {
		Graphic graphic = new Graphic();
		graphic.add(new Position(10,5), "  hello\nmy name is\nTOM RIDDLE!");
		displayGraphic(graphic);
	}
	
	@Ignore
	@Test
	public void test3() {
		Graphic graphic = new Graphic();
		graphic.add(new Position(10,5), "    hello\nmy name is\nTOM RIDDLE!");
		graphic.add(new Position(10,5), "not");
		graphic.add(new Position(10,7), "JON");
		graphic.add(new Position(14,7), "PU");
		displayGraphic(graphic);
	}
	
	@Ignore
	@Test
	public void testOffset() {
		Graphic graphic = new Graphic();
		graphic.add(new Position(0,0), "hello\n hello\nhello");
		graphic = graphic.offset(new Position(1,1));
		//graphic.offset(new Position(1,-2));
		displayGraphic(graphic);
	}

	
	
	private void displayGraphic(Graphic graphic) {
		for (int j = 0; j <= graphic.getMaxY(); j++) {
			for (int i = 0; i <= graphic.getMaxX(); i++) {
				System.out.print(graphic.getCell(i, j));
			}
			System.out.println();
		}
	}
	
	@Test
	public void testNoArgsConstructor() {
		Graphic graphic = new Graphic();
		assertEquals(0,graphic.getMaxY());
		assertEquals(0,graphic.getMaxX());
		assertEquals(new Cell(' '), graphic.getCell(0, 0));
	}

	@Ignore
	@Test
	public void testTextConstructor() {
		Graphic graphic = new Graphic("howdy");
		
	}
	
	@Test
	public void testNoExtraSpaceAtEnd() {
		Graphic graphic = new Graphic("hello");
		assertFalse(graphic.hasCell(new Position(6, 1)));
	}
}
