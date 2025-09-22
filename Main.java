
import java.util.Arrays;
import java.util.List;

import models.Player;
import strategy.BotMoveStrategy;
import strategy.HumanMoveStrategy;

public class Main {

  public static void main(String[] args) {

    List<Player> players = Arrays.asList(
        new Player("Koro", 'K', new HumanMoveStrategy()),
        new Player("Shivansh", 'S', new BotMoveStrategy()));

    Game game = new GameBuilder()
        .setSize(100)
        .setPlayers(players)
        .build();

    // display the board
    game.getBoard().displayBoard();

    // start the game
    game.startGame();

    System.out.println("Thanks for playing");
  }
}