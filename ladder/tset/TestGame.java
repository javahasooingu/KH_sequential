package ladder.tset;

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
public class TestGame {
	public static void main(String[] args) {

		Game game;

		List<GameElement> userList = new ArrayList<>();
		Ladder ladder;
		List<GameElement> destinationList = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("User의 수를 입력하세요.");
		System.out.println(">>>>> 5");
		int userAmount = 5;

		log.info("User의 이름을 입력할 차례입니다.(8글자 이내)");
		userList.add(new User("User1", 0));
		userList.add(new User("User2", 1));
		userList.add(new User("User3", 2));
		userList.add(new User("User4", 3));
		userList.add(new User("User5", 4));
		
		log.info("User명단입니다.");
		System.out.println(userList);

		System.out.println("사다리의 길이를 입력하세요.");
		System.out.println(">>>>> 10");
		int lineAmount = 10;

		ladder = new Ladder(lineAmount, userAmount);
		ladder.sortLadder();

		log.info("사다리를 생성했습니다.");
		ladder.printLadder();

		log.info("Destination을 입력할 차례입니다.");
		destinationList.add(new Destination("dest1"));
		destinationList.add(new Destination("dest2"));
		destinationList.add(new Destination("dest3"));
		destinationList.add(new Destination("dest4"));
		destinationList.add(new Destination("dest5"));
		
		log.info("Destination 목록입니다.");
		System.out.println(destinationList);
		
		game = new Game(userList, ladder, destinationList);

		log.info("사다리게임을 생성했습니다.");
		game.printGameTable();
		
		log.info("사다리게임을 시작합니다.");
		GameLogic.startLadderGame(game);
		
	} // main

}
