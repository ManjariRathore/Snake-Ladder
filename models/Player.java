package models;

import strategy.IMoveStrategy;

public class Player {
  String name;
  char symbol;
  int currentCellIndex;
  IMoveStrategy moveStrategy;

  public Player(String name, char symbol, IMoveStrategy moveStrategy) {
    this.name = name;
    this.symbol = symbol;
    this.currentCellIndex = 0;
    this.moveStrategy = moveStrategy;
  }

  public String getName() {
    return name;
  }

  public char getSymbol() {
    return symbol;
  }

  public int getCurrentCellIndex() {
    return currentCellIndex;
  }

  public void setCurrentCellIndex(int cellIndex) {
    this.currentCellIndex = cellIndex;
  }

  public IMoveStrategy getMoveStrategy() {
    return moveStrategy;
  }
}
