/**
 * 
 */
package lab3;

import java.util.ArrayList;

/**
 * @author FletcherG
 *
 */
public class KnightsTour {

  public KnightsTour(int boardSize, int x, int y) {
    ArrayList<OrderedPair> board = createBoard(boardSize);
    ArrayList<OrderedPair> usedMoves = new ArrayList<OrderedPair>();
    OrderedPair first = new OrderedPair(x, y);
    board.remove(first);
    usedMoves.add(first);
    move(first, board, usedMoves, boardSize);
  }

  public void move(OrderedPair current, ArrayList<OrderedPair> board,
      ArrayList<OrderedPair> usedMoves, int boardSize) {
    ArrayList<OrderedPair> legalMoves = getLegalMoves(current, board);
    if (board.isEmpty()) {
      System.out.println("Solution found!:");
      printMoves(usedMoves, boardSize);
    } else if (!legalMoves.isEmpty()) {
      for (OrderedPair newMove : legalMoves) {
        board.remove(newMove);
        usedMoves.add(newMove);
        move(newMove, board, usedMoves, boardSize);
      }
    } else {
      System.out.println("No Solution.");
    }
  }


  public ArrayList<OrderedPair> createBoard(int boardSize) {
    ArrayList<OrderedPair> board = new ArrayList<OrderedPair>();
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        board.add(new OrderedPair(i, j));
      }
    }
    return board;
  }

  public ArrayList<OrderedPair> getLegalMoves(OrderedPair current,
      ArrayList<OrderedPair> newBoard) {
    ArrayList<OrderedPair> legalMoves = new ArrayList<OrderedPair>();
    ArrayList<OrderedPair> board = newBoard;
    OrderedPair testPair = new OrderedPair(current.getX() + 1, current.getY() + 2);
    if (board.contains(testPair)) {
      legalMoves.add(testPair);
    }
    testPair = new OrderedPair(current.getX() + 2, current.getY() + 1);
    if (board.contains(testPair)) {
      legalMoves.add(testPair);
    }
    testPair = new OrderedPair(current.getX() + 1, current.getY() - 2);
    if (board.contains(testPair)) {
      legalMoves.add(testPair);
    }
    testPair = new OrderedPair(current.getX() + 2, current.getY() - 1);
    if (board.contains(testPair)) {
      legalMoves.add(testPair);
    }
    testPair = new OrderedPair(current.getX() - 1, current.getY() + 2);
    if (board.contains(testPair)) {
      legalMoves.add(testPair);
    }
    testPair = new OrderedPair(current.getX() - 2, current.getY() + 1);
    if (board.contains(testPair)) {
      legalMoves.add(testPair);
    }
    testPair = new OrderedPair(current.getX() - 1, current.getY() - 2);
    if (board.contains(testPair)) {
      legalMoves.add(testPair);
    }
    testPair = new OrderedPair(current.getX() - 2, current.getY() - 1);
    if (board.contains(testPair)) {
      legalMoves.add(testPair);
    }
    return legalMoves;
  }

  public void printMoves(ArrayList<OrderedPair> usedMoves, int boardSize) {
    int exp = 1;
    int size = boardSize * boardSize;
    while (size / 10 > 0) {
      size /= 10;
      exp++;
    }
    ArrayList<OrderedPair> newUsedMoves = usedMoves;
    int[][] board = new int[newUsedMoves.size()][newUsedMoves.size()];
    int counter = 1;
    for (OrderedPair move : usedMoves) {
      board[move.getX()][move.getY()] = counter;
      counter++;
    }
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        System.out.printf("%" + exp + "d", board[j][i]);
        System.out.print(" | ");
      }
      System.out.println("");
    }
  }
}
