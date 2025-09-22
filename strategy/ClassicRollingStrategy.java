package strategy;

public class ClassicRollingStrategy implements IRollingStrategy {
  @Override
  public int rollDice() {
    return (int) (Math.random() * 6) + 1;
  }
  
}
