package strategy;

import models.Move;

public interface IMoveStrategy {
  Move makeMove(int currentPosition, int diceRoll, int boardSize);
}
