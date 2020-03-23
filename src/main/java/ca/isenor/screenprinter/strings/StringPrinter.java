package ca.isenor.screenprinter.strings;

import java.io.PrintStream;
import java.util.Collection;

import ca.isenor.screenprinter.core.graphic.Graphic;
import ca.isenor.screenprinter.core.printer.Printer;
import ca.isenor.screenprinter.core.processor.GraphicProcessor;

/**
 * Prints strings as ascii art
 * 
 * @author isenor
 *
 */
public class StringPrinter extends Printer<String> {
	
	private static final int LINE_HEIGHT = 14;
	private static final int SPACING = 3;
	
	public StringPrinter(StringParser parser, GraphicProcessor processor, PrintStream stream) {
		super(parser, processor, stream);
		Graphic.setDefaultTransparency(true);
	}
	
	protected void populateScreen(Collection<Graphic> line) {
		for (Graphic letter : line) {
			bufferLetter(letter);
		}
	}

	private int bufferLetter(Graphic letter) {
		if (Characters.get('\n').equals(letter)) {
			cursor = 0;
			lineNumber++;
		}
		else {
			screen.add(letter.offset(cursor, lineNumber * LINE_HEIGHT));
			cursor += letter.getMaxX() + SPACING;
		}
		return cursor;
	}
}
