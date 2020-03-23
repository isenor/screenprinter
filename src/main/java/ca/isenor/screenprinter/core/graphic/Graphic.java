package ca.isenor.screenprinter.core.graphic;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import ca.isenor.screenprinter.core.graphic.structures.Cell;
import ca.isenor.screenprinter.core.graphic.structures.Degrees;
import ca.isenor.screenprinter.core.graphic.structures.Orientation;
import ca.isenor.screenprinter.core.graphic.structures.Position;

/**
 * More or less a map of coordinates (Position) to characters (Cell).
 * 
 * @author isenor
 */
public class Graphic {
	private static final Cell EMPTY_CELL = new Cell(' ');
	private final Map<Position, Cell> cells;
	private static boolean defaultTransparency = false;
	
	/**
	 * TODO: This is dangerous and stupid. Try to come up with a better way to
	 * handle this.
	 * 
	 * @param transparent
	 */
	public static void setDefaultTransparency(boolean transparent) {
		defaultTransparency = transparent;
	}
	/*
	 * This determines how empty cells are treated when adding/applying graphics.
	 * If false, spaces will be considered as whitespace and cover over whatever is under it.
	 * If true, spaces are effectively ignored and are not copied.
	 */
	private boolean transparent;
	/*
	 * distance from 0 to the farthest down cell
	 */
	private int height = 0;
	/*
	 * distance from 0 to the farthest right cell
	 */
	private int width = 0;

	public Graphic() {
		cells = Maps.newHashMap();
		transparent = defaultTransparency;
	}
	
	public Graphic(boolean transparent) {
		this();
		this.transparent = transparent; 
	}

	public Graphic(String text) {
		this();
		add(text);
	}

	public Graphic(Position position, String text) {
		this();
		add(position, text);
	}

	public Graphic(Graphic graphic) {
		this(graphic.transparent);
		for (Entry<Position, Cell> entry : graphic.cells.entrySet()) {
			cells.put(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * This method returns the cell at the given Position or the empty cell if no
	 * cell exists there.
	 * 
	 * @param position
	 * @return
	 */
	public Cell getCell(Position position) {
		if (!cells.containsKey(position))
			return EMPTY_CELL;
		return cells.get(position);
	}

	public Cell getCell(int x, int y) {
		return getCell(new Position(x, y));
	}

	public boolean hasCell(Position position) {
		return cells.containsKey(position);
	}

	private void setCell(Position position, Cell cell) {
		cells.put(position, cell);
		// updateDimensions(position);

	}

	/**
	 * TODO: The idea here was to save operations when calling the getHeight/Width
	 * methods by keeping height and width variables up to date after initial
	 * calculation. Currently unused, but could be used in order to increase
	 * effeciency.
	 * 
	 * @param position
	 */
	private void updateDimensions(Position position) {
		if (position.getY() > height)
			height = position.getY();
		if (position.getX() > width)
			width = position.getX();
	}

	/**
	 * Add 'text' to this graphic starting at 0,0.
	 * 
	 * @param text the text string to add
	 */
	public void add(String text) {
		add(new Position(0, 0), text);
	}

	/**
	 * Add 'Text' starting at the given position
	 * 
	 * @param position The positon where the text starts at
	 * @param text the text string to add
	 */
	public void add(Position position, String text) {
		int size = text.length();
		int x = position.getX();
		int y = position.getY();
		for (int cursor = 0; cursor < size; cursor++) {
			if (text.charAt(cursor) == '\n') {
				y++;
				x = position.getX();
			} else {
				cells.put(new Position(x++, y), Cell.extractCell(text, cursor));
			}
		}
	}

	/**
	 * Adds the given graphic to this graphic
	 * 
	 * @param graphic
	 */
	public void add(Graphic graphic) {
		// this copy must be made so that adding copies of the same graphic works
		Graphic copy = new Graphic(graphic);
		
		this.transparent = this.transparent && copy.transparent;
		for (Entry<Position, Cell> entry : copy.cells.entrySet()) {
			if (!copy.transparent || !EMPTY_CELL.equals(entry.getValue())) {
				cells.put(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * Get the largest y-coordinate in the graphic.
	 * 
	 * @return the largest y-coordinate in the graphic
	 */
	public int getMaxY() {
		int height = 0;
		for (Position position : cells.keySet()) {
			if (position.getY() > height)
				height = position.getY();
		}
		return height;
	}

	/**
	 * Get the largest x-coordinate in the graphic
	 * 
	 * @return the largest x-coodinate in the graphic
	 */
	public int getMaxX() {
		int width = 0;
		for (Position position : cells.keySet()) {
			if (position.getX() > width)
				width = position.getX();
		}
		return width;
	}

	/**
	 * This method returns a copy of the current Graphic offset by the given
	 * Position.<br>
	 * All the cells of the graphic will have their positions updated according to
	 * the given Position.<br>
	 * The x coordinate offsets the graphic to the right if positive and to the left
	 * if negative. <br>
	 * The y coordinate offsets the graphic downwards if positive and upwards if
	 * negative.
	 * 
	 * @param offset The amount by which to offset the graphic
	 * @return The offset graphic
	 */
	public Graphic offset(Position offset) {
		Graphic graphic = new Graphic(this.transparent);
		for (Entry<Position, Cell> entry : cells.entrySet()) {
			graphic.setCell(entry.getKey().add(offset), entry.getValue());
		}
		return graphic;
	}

	/**
	 * This method returns a copy of the current Graphic offset by the given
	 * coordinates. <br>
	 * All the cells of the graphic will have their positions updated according to
	 * the given coordinates.<br>
	 * The x coordinate offsets the graphic to the right if positive and to the left
	 * if negative. <br>
	 * The y coordinate offsets the graphic downwards if positive and upwards if
	 * negative.
	 * 
	 * @param x The horizontal amount by which to offset the graphic
	 * @param y The vertical amount by which to offset the graphic
	 * @return The offset graphic
	 */
	public Graphic offset(int x, int y) {
		return offset(new Position(x, y));
	}

	/**
	 * There is no guarantee that the string initially provided to the graphic will
	 * be identical to the string that is recovered from this toString() method.
	 * This is due to lines being extended with whitespace to match the length of
	 * the greatest line.
	 * 
	 * This method differs from the output from a processor in that it implicitly
	 * removes any offset (i.e. the String, if printed, will be at 0,0)
	 * 
	 */
	@Override
	public String toString() {
		Position topLeft = getTopLeftPosition();
		StringBuilder builder = new StringBuilder();
		for (int j = topLeft.getY(); j <= getMaxY(); j++) {
			for (int i = topLeft.getX(); i <= getMaxX(); i++) {
				builder.append(getCell(new Position(i, j)));
			}
			if (j < getMaxY())
				builder.append("\n");
		}
		return builder.toString();
	}

	/**
	 * This method returns the unique top-left most corner cell position in the
	 * graphic, even if there is no cell defined for that position.
	 * 
	 * @return the top-left most position in the graphic
	 */
	public Position getTopLeftPosition() {
		Position topLeft = null;
		for (Position position : cells.keySet()) {
			if (topLeft == null) {
				topLeft = position;
			} else if (topLeft.getX() > position.getX() && topLeft.getY() > position.getY()) {
				topLeft = position;
			} else if (topLeft.getX() > position.getX()) {
				topLeft = new Position(position.getX(), topLeft.getY());
			} else if (topLeft.getY() > position.getY()) {
				topLeft = new Position(topLeft.getX(), position.getY());
			}
		}
		return topLeft;
	}
	
	/**
	 * Reflects the graphic across a line
	 * 
	 * @param line
	 * @return
	 */
	public Graphic reflect(int axis, Orientation orientation) {
		Graphic graphic = new Graphic(this.transparent);
		for (Entry<Position, Cell> entry : cells.entrySet()) {
			switch (orientation) {
			case HORIZONTAL:
				graphic.setCell(new Position(entry.getKey().getX(), 2 * axis - entry.getKey().getY()) , entry.getValue());
				break;
			case VERTICAL:
				graphic.setCell(new Position(2 * axis - entry.getKey().getX(), entry.getKey().getY()) , entry.getValue());
				break;
			}
		}
		return graphic;
	}
	
	/**
	 * Applies the given graphic on top of 'this' graphic. If any cells exist in
	 * both, the cell in the given graphic will override the cell in 'this' graphic.
	 * 
	 * @param graphic
	 * @return a new graphic object that contains the cells of both graphics
	 */
	public Graphic apply(Graphic graphic) {
		Graphic result = new Graphic(this);
		// The resulting graphic will only be transparent if BOTH of the graphics being
		// joined are transparent
		result.transparent = this.transparent && graphic.transparent;
		for (Entry<Position, Cell> entry : graphic.cells.entrySet()) {
			if (!graphic.transparent || !EMPTY_CELL.equals(entry.getValue())) {
				result.cells.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}
	
	/**
	 * Rotates the graphic around the center a number of degrees
	 * 
	 * @param rotation
	 * @return the rotated graphic
	 */
	public Graphic rotate(Position center, Degrees degrees) {
		Graphic graphic = new Graphic(this.transparent);
		for (Entry<Position, Cell> entry : cells.entrySet()) {
			// Strategy is to translate each entry based on a (0,0) center, perform the
			// rotation, and then translate back to the original center.
			Position offsetEntry = entry.getKey().subtract(center);
			switch (degrees) {
			case DEGREE_90:
				graphic.setCell(new Position(
						center.getX() - offsetEntry.getY(),
						center.getY() + offsetEntry.getX()), entry.getValue());
				break;
			case DEGREE_180:
				graphic.setCell(new Position(
						center.getX() - offsetEntry.getX(),
						center.getY() - offsetEntry.getY()), entry.getValue());
				break;
			case DEGREE_270:
				graphic.setCell(new Position(
						center.getX() + offsetEntry.getY(),
						center.getY() - offsetEntry.getX()), entry.getValue());
				break;
			}
		}
		return graphic;
	}
	
	public void setTransparent(boolean transparent) {
		this.transparent = transparent;
	}
	
	public boolean isTransparent() {
		return transparent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cells == null) ? 0 : cells.hashCode());
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
		Graphic other = (Graphic) obj;
		if (cells == null) {
			if (other.cells != null)
				return false;
		} else if (!cells.equals(other.cells))
			return false;
		return true;
	}
}
