package ca.isenor.screenprinter.core.printer;

import java.util.Collection;

import ca.isenor.screenprinter.core.graphic.Graphic;

/**
 * Parses "things" into a list of graphics
 * 
 * @author isenor
 *
 * @param <T> this should be a list or similar
 */

public abstract class Parser<T> {

	public abstract Collection<Graphic> parse(T things);
}
