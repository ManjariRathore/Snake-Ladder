package factory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.List;
import java.util.Set;

import models.ECellContains;
import models.Jump;

public class RandomJumpGenerator {
    private final int boardSize;
    private final Random random;

    public RandomJumpGenerator(int boardSize) {
        this.boardSize = boardSize;
        this.random = new Random();
    }

    public List<Jump> generateJumps(int snakeCount, int ladderCount) {
        List<Jump> jumps = new ArrayList<>();
        Set<Integer> usedPositions = new HashSet<>();

        // Generate snakes
        for (int i = 0; i < snakeCount; i++) {
            int head, tail;
            do {
                head = random.nextInt(boardSize - 1) + 2;
                tail = random.nextInt(head - 1) + 1;
            } while (usedPositions.contains(head) || usedPositions.contains(tail) || head == tail);
            usedPositions.add(head);
            usedPositions.add(tail);
            jumps.add(new Jump(head, tail, ECellContains.SNAKE));
        }
        // Generate ladders
        for (int i = 0; i < ladderCount; i++) {
            int start, end;
            do {
                start = random.nextInt(boardSize - 2) + 1;
                end = random.nextInt(boardSize - start - 1) + start + 1;
            } while (usedPositions.contains(start) || usedPositions.contains(end) || start == end);
            usedPositions.add(start);
            usedPositions.add(end);
            jumps.add(new Jump(start, end, ECellContains.LADDER));
        }

        return jumps;
    }
}
