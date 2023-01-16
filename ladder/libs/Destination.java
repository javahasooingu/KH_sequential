package ladder.libs;

import lombok.Getter;


@Getter
public class Destination
	extends GameElement{
	
	private static final String EMOJI = "🎁";
	
	public Destination(String name) {
		super(name);
	} // constructor
	
	@Override
	public String toString() {
		
		return String.format("%s", Destination.EMOJI);
	} // toString
	
} // end class
