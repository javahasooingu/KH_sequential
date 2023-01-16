package ladder.libs;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MovingValue 
	extends GameElement{

	private Integer direction; // {-1, 0, 1} = {좌,직진,우}
	private Integer rowNum; // 이동하는 행
	boolean isConneted;
	
	public static final String EMOJI = "🪜";
	
	{
		this.isConneted = false; // 연결설정
	}
	
	public MovingValue() {
		super(MovingValue.EMOJI);
		
		this.direction = 0;
		this.rowNum = 0;
	} // constructor
	
	public MovingValue(int rowAmount) {
		
		this(rowAmount, "NonF/L");
	} // constructor
	
	public MovingValue(int rowAmount, String line) {
		super(MovingValue.EMOJI);

		// 방향설정
		if(line.equals("First")) {
			this.direction = (int)(Math.random()*2);
		}else if (line.equals("Last")) {
			this.direction = (int)(Math.random()*2)-1;
		}else {
			this.direction = (int)(Math.random()*3)-1;
		} // if-else if-else

		// 행설정
		if(this.direction != 0) {
			this.rowNum = (int)(Math.random()*rowAmount);
		} else {
			this.rowNum = 0;
		} // if-else
		
	} // constructor
	
	@Override
	public String toString() {
		return String.format("{%d,%d}", this.direction, this.rowNum);
	} // toString

} // end class
