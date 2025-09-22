package models;

public class Cell {
  
  private Jump jump;
  private final int number;
  private ECellContains cellContains;

  public Cell(int number) {
    this.number = number;
    this.cellContains = ECellContains.EMPTY;
  }

  public void setJump(int destination, ECellContains type) {
    this.jump = new Jump(number, destination, type);
  }

  public int getNumber() {
    return number;
  }

  public Jump getJump() {
    return this.jump;
  }

  public ECellContains getCellContains() {
    return cellContains;
  }
}
