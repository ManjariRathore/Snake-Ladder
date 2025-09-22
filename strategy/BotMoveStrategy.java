package strategy;

import models.Move;

public class BotMoveStrategy implements IMoveStrategy {
  @Override
  public Move makeMove(int currentPosition, int diceRoll, int boardSize) {
    int newPosition = currentPosition + diceRoll;
    return new Move(diceRoll, currentPosition, newPosition);
  }
}
