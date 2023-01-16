package ladder.libs;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Location {
	
	private int row;
	private int column;
	
	public Location(int row, int column) {
		
		this.row = row;
		this.column = column;
	} // constructor
	
	@Override
	public String toString() {
		
		return String.format("{%d, %d}", this.row, this.column);
	} // toString

} // end class
