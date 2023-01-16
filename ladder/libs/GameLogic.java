package ladder.libs;

import java.util.Scanner;


public class GameLogic {
	
	

	static Scanner sc = new Scanner(System.in);

	public static void startLadderGame(Game ladderGame) {

		Game currentGame = ladderGame;

		boolean isEnd = false;

		//		for(int gameCount = 0; gameCount < 1; gameCount++) { // test
		for(int gameCount = 0; gameCount < currentGame.getCOLUMN_AMOUNT(); gameCount++) {

			if(currentGame.getUserList().get(gameCount) instanceof User user ) {

				while(!isEnd) {

					System.out.printf("%s의 이동을 시작할까요?%n",user);
					System.out.print("(시작 : Y / 결과출력 : N) >>>");

					String control = sc.nextLine();

					System.out.println();

					if(control.equalsIgnoreCase("Y")) {
						break;
					} else if(control.equalsIgnoreCase("N")) {
						isEnd = true;
						continue;
					} else {
						System.out.println("입력값이 이상합니다.");
						continue;
					} // if-else if-else

				} // while

				GameLogic.start(user, currentGame);

			} // if

		} // for

		currentGame.printResultTable();

	} // startGame

	public static void start(User user, Game ladderGame) {

		User playingUser = user;
		Game currentGame = ladderGame;

		playingUser.startGame();
		currentGame.printStartMessage(playingUser);
		GameLogic.moveUser(playingUser, currentGame);

	} // start

	public static void moveUser(User user, Game ladderGame) {

		User playingUser = user;
		Game currentGame = ladderGame;

		Location currenUserLocation = playingUser.getLocation();;

		while(!playingUser.isArrived) {

			currenUserLocation = playingUser.getLocation();

			GameElement currentMovingValue;

			if (currenUserLocation.getRow() == currentGame.getLadder().getROW_AMOUNT()) {
				user.setArrived(true);
				continue;
			} // if : 도착조건

			currentGame.printGameTable(playingUser);

			if(user.isUsedLadder) {

				user.move((currenUserLocation.getRow() + 1), currenUserLocation.getColumn());
				user.setUsedLadder(false);

			}else {

				currentMovingValue = currentGame.getLadder().ladderList.get(currenUserLocation.getRow()).get(currenUserLocation.getColumn());

				if(currentMovingValue instanceof MovingValue MV) {

					if(MV.getDirection() == 0) {

						user.move((currenUserLocation.getRow() + 1), currenUserLocation.getColumn());
						user.setUsedLadder(false);

					} else {

						user.move((MV.getRowNum()), currenUserLocation.getColumn() + MV.getDirection());
						user.setUsedLadder(true);

					} // if-else
				}
			} // if-else

		} // while

		playingUser.endGame();

		Destination destination = (Destination) currentGame.getDestinationList().get(currenUserLocation.getColumn());

		currentGame.getResultMap().put(playingUser, destination);

		currentGame.printResult(playingUser);

	} // moveUser

} // end class
