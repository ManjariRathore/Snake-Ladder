package algo;

import models.Player;

public class ClassicWinningAlgo implements IWinningAlgo {
  private final int boardSize;

  public ClassicWinningAlgo(int boardSize) {
    this.boardSize = boardSize;
  }

  public ClassicWinningAlgo() {
    this.boardSize = 100;
  }

  @Override
  public boolean checkWinCondition(Player player) {
    return player.getCurrentCellIndex() == boardSize;
  }
}
