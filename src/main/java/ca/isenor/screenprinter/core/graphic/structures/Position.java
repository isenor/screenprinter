package ca.isenor.screenprinter.core.graphic.structures;

/**
 * Holds x- and y-coordinates
 * 
 * @author isenor
 *
 */
public class Position {

	private final int x;
	private final int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public Position add(Position other) {
		return new Position(x + other.x, y + other.y);
	}
	
	public Position subtract(Position other) {
		return new Position(x - other.x, y - other.y);
	}
}
