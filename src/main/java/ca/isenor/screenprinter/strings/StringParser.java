package ca.isenor.screenprinter.strings;           

import java.util.List;

import com.google.common.collect.Lists;

import ca.isenor.screenprinter.core.graphic.Graphic;
import ca.isenor.screenprinter.core.printer.Parser;

/**
 * Parses Strings into a list of Graphics to be printed
 * 
 * @author isenor
 *
 */
public class StringParser extends Parser<String> {
	
	@Override
	public List<Graphic> parse(String text) {
		List<Graphic> line = Lists.newArrayList();
		for (char character : text.toCharArray()) {
			if (Characters.has(character)) {
				line.add(Characters.get(character));
			}
			else {
				throw new IllegalArgumentException("The character '" + character + "' is unsupported.");
			}
		}
		return line;
	}
}
