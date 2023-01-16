package ladder.libs;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GameElement {

	private String name;

	public GameElement(String name) {
		this.name = name;
	} // constructor
	
	@Override
	public String toString() {

		return String.format("%s", this.name);
	} // toString
	
} // end interface
