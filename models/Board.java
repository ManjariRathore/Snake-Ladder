package models;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Board {
  private final int size;
  private final List<Cell> board;

  public Board(int size, List<Jump> jumps) {
    this.size = size;
    this.board = createBoard(size, jumps);
  }

  private List<Cell> createBoard(int size, List<Jump> jumps) {
    List<Cell> temp = new ArrayList<>();
    for (int i = 1; i <= size; i++) {
      temp.add(new Cell(i));
    }
    for (Jump j : jumps) {
      temp.get(j.getStart() - 1).setJump(j.getEnd(), j.getType());
    }
    return Collections.unmodifiableList(temp);
  }

  public int getSize() {
    return size;
  }

  public Cell getCell(int index) {
    if (index < 1 || index > size) {
      throw new IndexOutOfBoundsException("Cell index must be between 1 and " + size);
    }
    return board.get(index - 1);
  }

  public List<Cell> getAllCells() {
    return board;
  }

  public boolean isValidMove(int fromPosition, int diceRoll) {
    return fromPosition + diceRoll <= size;
  }

  public int movePlayer(int currentPosition, int diceRoll) {
    int newPosition = currentPosition + diceRoll;
    if (newPosition > size) {
      return currentPosition; // Invalid move, stay at current position
    }

    // Apply jump if present
    Cell cell = getCell(newPosition);
    Jump jump = cell.getJump();
    if (jump != null) {
      System.out.println(getJumpMessage(jump));
      return jump.getEnd();
    }

    return newPosition;
  }

  private String getJumpMessage(Jump jump) {
    switch (jump.getType()) {
      case SNAKE:
        return "🐍 Snake bite! Moving from " + jump.getStart() + " to " + jump.getEnd();
      case LADDER:
        return "🪜 Ladder climb! Moving from " + jump.getStart() + " to " + jump.getEnd();
      default:
        return "";
    }
  }

  public void displayBoard() {
    System.out.println("\n📋 Board Layout:");
    System.out.println("🐍 = Snake, 🪜 = Ladder, • = Empty");

    int columns = 10;
    int rows = (size + columns - 1) / columns;

    for (int row = rows - 1; row >= 0; row--) {
      System.out.print("| ");

      if (row % 2 == (rows - 1) % 2) {
        // Left to right
        for (int col = 0; col < columns; col++) {
          int cellNum = row * columns + col + 1;
          if (cellNum <= size) {
            printCell(cellNum);
            System.out.print("  ");
          }
        }
      } else {
        // Right to left (snake pattern)
        for (int col = columns - 1; col >= 0; col--) {
          int cellNum = row * columns + col + 1;
          if (cellNum <= size) {
            printCell(cellNum);
            System.out.print("  ");
          }
        }
      }
      System.out.println("|");
    }
    System.out.println();
  }

  private void printCell(int cellNum) {
    Cell cell = getCell(cellNum);
    Jump jump = cell.getJump();

    if (jump != null) {
      if (jump.getType() == ECellContains.SNAKE) {
        System.out.print(cellNum + "🐍");
        return;
      } else if (jump.getType() == ECellContains.LADDER) {
        System.out.print(cellNum + "🪜");
        return;
      }
    }
    System.out.print(cellNum + "•"); 
  }
}
