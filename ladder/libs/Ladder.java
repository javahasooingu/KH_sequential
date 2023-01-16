package ladder.libs;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;


@Getter
public class Ladder {

	public List<List<GameElement>> ladderList;

	private final int ROW_AMOUNT;
	private final int COLUMN_AMOUNT;

	{
		this.ladderList = new ArrayList<>();
	}

	public Ladder(int lineAmount, int userAmount){

		this.ROW_AMOUNT = lineAmount;
		this.COLUMN_AMOUNT = userAmount;

		for(int rowCount = 0; rowCount < this.ROW_AMOUNT; rowCount++ ) {

			this.ladderList.add(new ArrayList<GameElement>());

			for(int columnCount = 0; columnCount < this.COLUMN_AMOUNT; columnCount++) {

				if(columnCount == 0) {

					this.ladderList.get(rowCount).add(new MovingValue(this.ROW_AMOUNT,"First"));

				} else if(columnCount == (this.COLUMN_AMOUNT - 1)) {

					this.ladderList.get(rowCount).add(new MovingValue(this.ROW_AMOUNT,"Last"));

				} else {

					this.ladderList.get(rowCount).add(new MovingValue(this.ROW_AMOUNT));

				} // if-else if-else

			} // inner for

		} // outer for
	} // constructor

	public void sortLadder() {
		
		for(int rowCount = 0; rowCount < this.ROW_AMOUNT; rowCount++ ) {

			for(int columnCount = 0; columnCount < this.COLUMN_AMOUNT; columnCount++) {

				MovingValue currentMovingValue = (MovingValue) this.ladderList.get(rowCount).get(columnCount);
				int direction = currentMovingValue.getDirection();
				int rowNum = currentMovingValue.getRowNum();

				if(!currentMovingValue.isConneted) {

					if(direction != 0) {
						MovingValue destination = (MovingValue) this.ladderList.get(rowNum).get(columnCount + direction);

						if(destination.isConneted()) {

							currentMovingValue.setDirection(0);
							currentMovingValue.setRowNum(0);

						} else {

							currentMovingValue.setConneted(true);
							destination.setDirection(direction * (-1));
							destination.setRowNum(rowCount);
							destination.setConneted(true);


						} // if-else

					} // if

				} // if

			} // inner for
			
		} // outer for

	} // sortLadder

	public void printLadder() {

		for(int rowCount = 0; rowCount < this.ROW_AMOUNT; rowCount++ ) {

			for(int columnCount = 0; columnCount < this.COLUMN_AMOUNT; columnCount++) {
				MovingValue currentMovingValue = (MovingValue) this.ladderList.get(rowCount).get(columnCount);

				System.out.print(currentMovingValue + "\t");

			} // inner for

			System.out.println();
		} // outer for

	} // printLadder

} // end class
