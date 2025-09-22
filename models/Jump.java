package models;

public class Jump {
  private final int start;
  private final int end;
  private final ECellContains type;
  public Jump(int start, int end, ECellContains type) {
    this.start = start;
    this.end = end;
    this.type = type;
  }
  
  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }

  public ECellContains getType(){
    return this.type;
  }
}
