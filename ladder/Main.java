package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ladder.libs.Destination;
import ladder.libs.Game;
import ladder.libs.GameElement;
import ladder.libs.GameLogic;
import ladder.libs.Ladder;
import ladder.libs.User;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class Main {
	public static void main(String[] args) {

		Game game;

		List<GameElement> userList = new ArrayList<>();
		Ladder ladder;
		List<GameElement> destinationList = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("User의 수를 입력하세요.");
		System.out.print(">>>>>");
		int userAmount = Integer.parseInt(sc.nextLine());

		log.info("User의 이름을 입력할 차례입니다.(영어 8글자 이내)");
		for(int userCount = 0; userCount < userAmount; userCount++) {
			System.out.println((userCount+1)+"번째 User의 이름을 입력하세요.");
			System.out.print(">>>>>");
			String userName = sc.nextLine();
			
			userList.add(new User(userName, userCount));
		} // for

		log.info("User명단입니다.");
		System.out.println(userList);

		System.out.println("사다리의 길이를 입력하세요.");
		System.out.print(">>>>>");
		int lineAmount = Integer.parseInt(sc.nextLine());

		ladder = new Ladder(lineAmount, userAmount);
		ladder.sortLadder();

		log.info("사다리를 생성했습니다.");
		ladder.printLadder();

		log.info("Destination을 입력할 차례입니다.(영어 8글자 이내)");
		for(int destinationCount = 0; destinationCount < userAmount; destinationCount++) {
			System.out.println((destinationCount+1)+"번째 Destination을 입력하세요.");
			System.out.print(">>>>>");
			String destinationName = sc.nextLine();

			destinationList.add(new Destination(destinationName));
		} // for

		log.info("Destination 목록입니다.");
		destinationList.forEach((destination)->{
			System.out.printf("%s ",destination.getName());
		});
		
		System.out.println();

		game = new Game(userList, ladder, destinationList);

		log.info("사다리게임을 생성했습니다.");
		game.printGameTable();
		
		log.info("사다리게임을 시작합니다.");
		GameLogic.startLadderGame(game);

	} // main


} // end class
