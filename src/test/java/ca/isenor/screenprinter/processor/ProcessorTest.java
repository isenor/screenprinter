package ca.isenor.screenprinter.processor;

import org.junit.Ignore;
import org.junit.Test;

import ca.isenor.screenprinter.core.graphic.Graphic;
import ca.isenor.screenprinter.core.graphic.structures.Position;
import ca.isenor.screenprinter.core.processor.GraphicProcessor;

@Ignore
public class ProcessorTest {

	@Test
	public void test() {
		GraphicProcessor processor = new GraphicProcessor();
		
		Graphic graphic = new Graphic();
		graphic.add(new Position(0,0), "hello\nhello\nhello");
		System.out.println(processor.process(graphic));
	}
	
	@Test
	public void testOffset() {
		GraphicProcessor processor = new GraphicProcessor(new Position(3,0));
		
		Graphic square = new Graphic("XXXX\nX--X\nX--X\nXXXX");
		Graphic whole = new Graphic();
		whole.add(square);
		int i = 6;
		whole.add(square.offset(new Position(i,i)));
		whole.add(square.offset(new Position(0,i*2)));
		whole.add(square.offset(new Position(i*2,0)));
		whole.add(square.offset(new Position(i*2,i*2)));
		System.out.println(processor.process(whole));
	}
	
	

}
