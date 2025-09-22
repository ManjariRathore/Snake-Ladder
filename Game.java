import java.util.List;

import algo.IWinningAlgo;
import factory.RandomJumpGenerator;
import models.Board;
import models.EGameState;
import models.Player;
import strategy.IRollingStrategy;

public class Game {

  private final Board board;
  private EGameState gameState;
  private final List<Player> players;
  private final IWinningAlgo winningAlgo;
  private final IRollingStrategy rollingStrategy;
  private int currentPlayerIndex;

  public Game(GameBuilder builder) {
    this.players = builder.players;
    this.winningAlgo = builder.winningAlgo;
    this.rollingStrategy = builder.rollingStrategy;
    this.gameState = EGameState.IN_PROGRESS;
    this.board = new Board(builder.size, new RandomJumpGenerator(builder.size).generateJumps(6, 6));
    this.currentPlayerIndex = 0;
  }

  public void startGame() {
    System.out.println("🎮 Welcome to Snake & Ladder!");
    System.out.println("Players: " + players.size());
    for (Player player : players) {
      System.out.println("  - " + player.getName() + " (" + player.getSymbol() + ")");
    }
    System.out.println("Board size: " + board.getSize());

    while (gameState == EGameState.IN_PROGRESS) {
      processTurn();

      if (winningAlgo.checkWinCondition(getCurrentPlayer())) {
        gameState = EGameState.FINISHED;
        System.out.println("\n🎉 " + getCurrentPlayer().getName() + " wins the game! 🎉");
        break;
      }

      nextTurn();
    }
  }

  private void processTurn() {
    Player currentPlayer = getCurrentPlayer();
    System.out
        .println("👤 " + currentPlayer.getName() + "'s turn (Position: " + currentPlayer.getCurrentCellIndex() + ")");

    int diceRoll = rollingStrategy.rollDice();
    System.out.println("🎲 Rolled: " + diceRoll);

    currentPlayer.getMoveStrategy().makeMove(
        currentPlayer.getCurrentCellIndex(),
        diceRoll,
        board.getSize());

    int newPosition = board.movePlayer(currentPlayer.getCurrentCellIndex(), diceRoll);
    currentPlayer.setCurrentCellIndex(newPosition);

    System.out.println("📍 " + currentPlayer.getName() + " moved to position: " + newPosition);
    System.out.println();
  }

  private void nextTurn() {
    currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
  }

  public Board getBoard() {
    return board;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public EGameState getGameState() {
    return gameState;
  }

  public Player getCurrentPlayer() {
    return players.get(currentPlayerIndex);
  }
}
