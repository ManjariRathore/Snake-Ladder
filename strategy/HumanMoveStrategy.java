package strategy;

import java.util.Scanner;
import models.Move;

public class HumanMoveStrategy implements IMoveStrategy {
  private static final Scanner scanner = new Scanner(System.in);

  @Override
  public Move makeMove(int currentPosition, int diceRoll, int boardSize) {
    System.out.print("Press Enter to roll the dice...");
    scanner.nextLine();

    int newPosition = currentPosition + diceRoll;
    return new Move(diceRoll, currentPosition, newPosition);
  }
}
