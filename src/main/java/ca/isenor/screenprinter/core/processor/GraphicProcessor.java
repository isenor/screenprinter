package ca.isenor.screenprinter.core.processor;

import ca.isenor.screenprinter.core.graphic.Graphic;
import ca.isenor.screenprinter.core.graphic.structures.Position;

/**
 * Processes Graphic objects into text to be printed. 
 * 
 * @author isenor
 *
 */
public class GraphicProcessor implements Processor<Graphic, String> {
	
	private static final String NEW_LINE = "\n";
	private Position offset;
	
	public GraphicProcessor() {
		this(new Position(0,0));
	}
	
	public GraphicProcessor(Position offset) {
		this.offset = offset;
	}
	
	public String process(Graphic graphic) {
		StringBuilder builder = new StringBuilder();
		for (int j = 0; j <= graphic.getMaxY() + offset.getY(); j++) {
			for (int i = 0; i <= graphic.getMaxX() + offset.getX(); i++) {
				builder.append(graphic.getCell(i - offset.getX(), j - offset.getY()));
			}
			builder.append(NEW_LINE);
		}
		return builder.toString();
	}
}
