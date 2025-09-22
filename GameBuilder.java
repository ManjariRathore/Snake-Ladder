import java.util.List;
import java.util.Objects;

import models.Player;
import algo.IWinningAlgo;
import algo.ClassicWinningAlgo;
import strategy.IRollingStrategy;
import strategy.ClassicRollingStrategy;

public class GameBuilder {

  public static final int DEFAULT_SIZE = 100;

  public int size;
  public List<Player> players;
  public IWinningAlgo winningAlgo;
  public IRollingStrategy rollingStrategy;

  public GameBuilder setSize(int size) {
    this.size = size;
    return this;
  }

  public GameBuilder setPlayers(List<Player> players) {
    this.players = players;
    return this;
  }

  public GameBuilder setWinningAlgo(IWinningAlgo winningAlgo) {
    this.winningAlgo = winningAlgo;
    return this;
  }

  public GameBuilder setRollingStrategy(IRollingStrategy rollingStrategy) {
    this.rollingStrategy = rollingStrategy;
    return this;
  }

  public Game build() {
    Objects.requireNonNull(players, "Players are required to start the game");
    if (players.isEmpty())
      throw new IllegalArgumentException("At least one player required");

    this.rollingStrategy = (this.rollingStrategy != null) ? this.rollingStrategy
        : new ClassicRollingStrategy();
    this.winningAlgo = (this.winningAlgo != null) ? this.winningAlgo
        : new ClassicWinningAlgo();
    this.size = (this.size > 0) ? this.size : DEFAULT_SIZE;
    return new Game(this);
  }

}