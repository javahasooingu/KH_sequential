package ladder.libs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;


@Getter
public class Game {

	//	private List<List<GameElement>> gameList;

	private List<GameElement> userList;
	private Ladder ladder;
	private List<GameElement> destinationList;

	private Map<GameElement, GameElement> resultMap;

	private final int ROW_AMOUNT;
	private final int COLUMN_AMOUNT;

	{
		//		this.gameList = new ArrayList<>();
		this.resultMap = new HashMap<>();
	}


	public Game(List<GameElement> userList, Ladder ladder, List<GameElement> destinationList) {
		this.userList = userList;
		this.ladder = ladder;
		this.destinationList = destinationList;

		this.ROW_AMOUNT = this.ladder.getROW_AMOUNT() + 2;
		this.COLUMN_AMOUNT = userList.size();
	}

	public void printGameTable() {
		this.printGameTable(new User());
	} // printTable

	public void printGameTable(User user) {
		//		List<List<GameElement>> printGameTable = this.gameList;

		this.printUserList();
		this.printLadder(user);
		this.printdestinationList();

		this.printSeparator();
	} // printTable

	public void printUserList() {

		this.userList.forEach((gameElement) -> {this.print(gameElement);} );
		System.out.println();

	} // printUserList

	public void printLadder(User user) {

		List<List<GameElement>> ladderList = this.ladder.getLadderList();

		for(int rowCount = 0; rowCount < ladderList.size(); rowCount++ ) {

			for(int columnCount = 0; columnCount < this.COLUMN_AMOUNT; columnCount++) {

				GameElement currentElement = ladderList.get(rowCount).get(columnCount);

				if(!user.getName().equals(User.NON_EXISTENT)) {

					Location currentUserLocation = user.getLocation();

					if(currentUserLocation.getRow() == rowCount
							&& currentUserLocation.getColumn() == columnCount) {

						currentElement = user;
					} // if

				} // if

				this.print(currentElement);
			} // inner for

			System.out.println();
		} // outer for

	}
	public void printdestinationList() {

		this.destinationList.forEach((gameElement) -> { this.print(gameElement); });
		System.out.println();

	} // printdestinationList

	public void print(GameElement gameElement) {

		GameElement printElement = gameElement;

		if (printElement instanceof MovingValue mv) {

			this.print(mv);

		} else if(printElement instanceof User u) {

			this.print(u);

		} else {

			System.out.printf("%7s%-8s ","",printElement);

		} // if-else if-else

	} // print

	public void print(MovingValue movingValue) {

		switch (movingValue.getDirection()) {
		case -1	-> {System.out.printf("%7s%s%7s",((movingValue.getRowNum() + 1) + "<-"),MovingValue.EMOJI,"");} // 1
		case 1	-> {System.out.printf("%7s%s%-7s","",MovingValue.EMOJI,("->" + (movingValue.getRowNum() + 1)));} // -1
		default	-> {System.out.printf("%7s%s%7s","",MovingValue.EMOJI,"");} // 0
		} // switch

	} // print

	public void print(User user) {

		if(user.isPlayingGame) {

			Location currentUserLocation = user.getLocation();
			int userRowNum = currentUserLocation.getRow();
			int userColumnNum = currentUserLocation.getColumn();

			if(ladder.getLadderList().get(userRowNum).get(userColumnNum) instanceof MovingValue mv) {

				if(user.isUsedLadder) {
					mv = new MovingValue();
				} // if

				switch (mv.getDirection()) {
				case -1	-> {System.out.printf("%7s%s%7s",((mv.getRowNum() + 1) + "<-"),User.EMOJI,"");} // 1
				case 1	-> {System.out.printf("%7s%s%-7s","",User.EMOJI,("->" + (mv.getRowNum() + 1)));} // -1
				default	-> {System.out.printf("%7s%s%7s","",User.EMOJI,"");} // 0
				} // switch

				return;
			} // if
		} // if

		this.print(new GameElement(user.getName()));

	} // print

	public void printResult(User user) {

		System.out.printf("%s가 %s에 도착했습니다.%n%n",user,resultMap.get(user).getName());
		System.out.printf("결과 : %s = %s%n",user,resultMap.get(user).getName());
		this.printSeparator();

	} // printResult

	public void printResultTable() {

		System.out.println("Result Table");
		this.printSeparator();

		userList.forEach((user) -> {
			System.out.printf("%-8s || %-8s%n",user,resultMap.get(user).getName());
		});

		this.printSeparator();

	} // printResult

	public void printStartMessage(User user) {

		System.out.printf("%s가 이동을 시작합니다.%n",user);
		this.printSeparator();

	} // printStartMessage

	public void printSeparator() {
		for(int i = 0; i < COLUMN_AMOUNT * 16; i++) {
			System.out.print("=");
		} // for 
		System.out.println();
	} // printSeparator

	// printTable() 통합해야함. 해결 -> print(obj)추가 및 로직 변경... 더 복잡한듯?
	// user가 움직이는 로직 구현해야함 -> ... 사다리가 교차되면 무한반복...
	// 사다리 정렬로직 다시 짜야함. -> 로직을 다시 짜니 무한반복 안빠짐...
	// 게임로직분리

} // end class
