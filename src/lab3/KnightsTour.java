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
    move(new OrderedPair(x, y), board, usedMoves);
  }

  public void move(OrderedPair current, ArrayList<OrderedPair> newBoard,
      ArrayList<OrderedPair> newUsedMoves) {
    ArrayList<OrderedPair> board = newBoard;
    ArrayList<OrderedPair> usedMoves = newUsedMoves;
    ArrayList<OrderedPair> legalMoves = getLegalMoves(current, board);
    if (board.isEmpty()) {
      System.out.println("Solution found!:");
      printMoves(usedMoves);
    } else if (!legalMoves.isEmpty()) {
      System.out.println("Moves:");
      for (OrderedPair newMove : legalMoves) {
        System.out.println("(" + newMove.getX() + "," + newMove.getY() + ")" + "  ");
      }
      if (!legalMoves.isEmpty()) {
        for (OrderedPair newMove : legalMoves) {
          System.out.println(board.remove(newMove));
          for (OrderedPair boardSpace : board) {
            System.out.println("(" + boardSpace.getX() + "," + boardSpace.getY() + ")" + "  ");
          }
          usedMoves.add(newMove);
          move(newMove, board, usedMoves);
        }
      }
    }
  }

  public ArrayList<OrderedPair> createBoard(int boardSize) {
    ArrayList<OrderedPair> board = new ArrayList<OrderedPair>();
    for (int i = 0; i <= boardSize; i++) {
      for (int j = 0; j <= boardSize; j++) {
        board.add(new OrderedPair(i, j));
      }
    }
    return board;
  }

  public ArrayList<OrderedPair> getLegalMoves(OrderedPair current, ArrayList<OrderedPair> newBoard) {
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

  public void printMoves(ArrayList<OrderedPair> usedMoves) {
    for (OrderedPair move : usedMoves) {
      System.out.println("(" + move.getX() + "," + move.getY() + ")" + "  ");
    }
  }
}
