package ca.isenor.screenprinter.core.printer;

import java.io.PrintStream;
import java.util.Collection;

import ca.isenor.screenprinter.core.graphic.Graphic;
import ca.isenor.screenprinter.core.processor.Processor;

/**
 * Base class for printing out Graphics from other objects.
 * To use this framework, you must:<br>
 * Have an object type you want to print out.<br>
 * Subclass Parser<T> with T probably being a collection of your object<br>
 * Subclass this Printer<T> class, implementing the populateScreen(...) method.<br>
 * <br>
 * Once you have all that, call your printer like:<br>
 * printer.buffer(myObjects);<br>
 * printer.print();<br>
 * <br>
 * And that's all there is to it!
 * 
 * @author isenor
 *
 * @param <T> the *collection* of objects to be buffered 
 */
public abstract class Printer<T> {

	private final Parser<T> parser;
	private final Processor<Graphic, String> processor;
	private final PrintStream stream;
	
	/**
	 * The full graphic that the processor will process; a composition of all the parsed printables
	 */
	protected Graphic screen;
	protected int cursor;
	protected int lineNumber;
	
	public Printer(Parser<T> parser, Processor<Graphic, String> processor, PrintStream stream) {
		this.parser = parser;
		this.processor = processor;
		this.stream = stream;
		refresh();
	}
	
	/**
	 * Turns "things" into graphics to be printed. <br>
	 * This call can be chained with multiple printer calls:<br>
	 * ex.<br>
	 * {@code printer.bufferln(models).bufferln(models).print();}
	 * 
	 * @param things the things to be buffered
	 * @return this instance
	 */
	public Printer<T> bufferln(T things) {
		buffer(things);
		return bufferln();
	}
	
	public Printer<T> buffer(T things) {
		populateScreen(parser.parse(things));
		return this;
	}
	
	public Printer<T> bufferln() {
		newLine();
		carriageReturn();
		return this;
	}

	protected void newLine() {
		lineNumber++;
	}

	protected void carriageReturn() {
		cursor = 0;
	}
	
	/**
	 * Subclasses implement this method in order to dictate how to populate the
	 * screen based on the parsed graphics. This method is called by the buffer methods.
	 * <br>
	 * 
	 * @param graphics
	 */
	protected abstract void populateScreen(Collection<Graphic> graphics);
	
	
	/**
	 * Process and print out the contents of the screen. Resets the screen
	 * afterwards.
	 */
	public final void print() {
		stream.println(processor.process(screen));
		refresh();
	}
	
	/**
	 * Reset the screen
	 */
	public void refresh() {
		screen = new Graphic();
		carriageReturn();
		lineNumber = 0;
	}
			
}
