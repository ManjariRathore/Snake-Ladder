package models;

public class Move {
  private final int diceRoll;
  private final int fromPosition;
  private final int toPosition;

  public Move(int diceRoll, int fromPosition, int toPosition) {
    this.diceRoll = diceRoll;
    this.fromPosition = fromPosition;
    this.toPosition = toPosition;
  }

  public int getDiceRoll() {
    return diceRoll;
  }

  public int getFromPosition() {
    return fromPosition;
  }

  public int getToPosition() {
    return toPosition;
  }
}
