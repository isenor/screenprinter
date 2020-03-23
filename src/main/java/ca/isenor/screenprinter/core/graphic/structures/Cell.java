package ca.isenor.screenprinter.core.graphic.structures;

public class Cell {
	private final char display;
	
	public Cell(char display) {
		this.display = display;
	}
	
	public char getDisplay() {
		return display;
	}
	
	public static Cell extractCell(String string, int position) {
		return new Cell(string.charAt(position));
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + display;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (display != other.display)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return Character.toString(display);
	}
}
