package ladder.libs;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User 
	extends GameElement{

	Location location;
	
	boolean isUsedLadder;
	boolean isPlayingGame;
	boolean isArrived;

	static final String NON_EXISTENT = "NonExistent";
	static final String EMOJI = "🙋‍♂️";

	{
		this.isUsedLadder = false;
		this.isArrived = false;
		this.isPlayingGame = false;
	}

	public User() {
		
		this(User.NON_EXISTENT, 0);
	} // default constructor

	public User(String name, int turn) {
		super(name);

		this.location = new Location(0, turn);
	} // constructor

	public void startGame() {

		this.setPlayingGame(true);
	} // start

	public void move(int rowNum, int columnNum) {

		setLocation(new Location(rowNum, columnNum));
	} // move

	public void endGame() {

		if(this.isArrived) {
			
			this.setPlayingGame(false);
		} // if
		
	} // start

	@Override
	public String toString() {

		return String.format("%s", this.getName());
	} // toString

} // end class
