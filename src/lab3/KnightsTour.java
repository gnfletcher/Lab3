/**
 * 
 */
package lab3;

import java.util.ArrayList;

/**
 * Knights Tour determines if a Knight's Tour is possible with the given parameters. If a Tour is
 * possible, the sequence the program took is outputted If not, a simple print statement is issued
 * detailing such.
 * 
 * @author Greg Fletcher
 * @author Sean O'Donnell
 *
 */
public class KnightsTour {
  public ArrayList<OrderedPair> board;
  public ArrayList<OrderedPair> usedMoves;
  public int boardSize;

  /**
   * Constructor that attempts a new Knight's Tour
   * 
   * @param int size of the board
   * @param int starting x coordinate
   * @param int starting y coordinate
   *
   */
  public KnightsTour(int boardSize, int x, int y) {
    this.boardSize = boardSize;
    this.usedMoves = new ArrayList<OrderedPair>();
    createBoard();
    solve(new OrderedPair(x, y));
  }

  /**
   * Executes first move and test if solution is found or not.
   * 
   * @param OrderedPair Starting position on board
   *
   */
  public void solve(OrderedPair first) {
    if (move(first)) {
      printMoves();
    } else {
      System.out.println("No Solution Found!");
    }
  }

  /**
   * Tests whether or not the knight can move to any possible next location that a knight could move
   * to. If it can, true is returned and the process is repeated. If not, false is returned and the
   * method returns back up.
   * 
   * @param OrderedPair original position
   * @return boolean whether or not knight could move
   */
  public boolean move(OrderedPair current) {
    board.remove(current);
    usedMoves.add(current);

    if (board.isEmpty()) {
      return true;
    }

    if (board.contains(new OrderedPair(current.getX() + 1, current.getY() + 2))
        && move(new OrderedPair(current.getX() + 1, current.getY() + 2))) {
      return true;
    }

    if (board.contains(new OrderedPair(current.getX() + 2, current.getY() + 1))
        && move(new OrderedPair(current.getX() + 2, current.getY() + 1))) {
      return true;
    }

    if (board.contains(new OrderedPair(current.getX() + 1, current.getY() - 2))
        && move(new OrderedPair(current.getX() + 1, current.getY() - 2))) {
      return true;
    }

    if (board.contains(new OrderedPair(current.getX() + 2, current.getY() - 1))
        && move(new OrderedPair(current.getX() + 2, current.getY() - 1))) {
      return true;
    }

    if (board.contains(new OrderedPair(current.getX() - 1, current.getY() + 2))
        && move(new OrderedPair(current.getX() - 1, current.getY() + 2))) {
      return true;
    }

    if (board.contains(new OrderedPair(current.getX() - 2, current.getY() + 1))
        && move(new OrderedPair(current.getX() - 2, current.getY() + 1))) {
      return true;
    }

    if (board.contains(new OrderedPair(current.getX() - 1, current.getY() - 2))
        && move(new OrderedPair(current.getX() - 1, current.getY() - 2))) {
      return true;
    }

    if (board.contains(new OrderedPair(current.getX() - 2, current.getY() - 1))
        && move(new OrderedPair(current.getX() - 2, current.getY() - 1))) {
      return true;
    }

    board.add(current);
    usedMoves.remove(current);
    return false;
  }


  /**
   * Creates a new board with all coordinates using the given size
   * 
   */
  public void createBoard() {
    if (boardSize <= 0) {
      System.out.print("Invalid board size.");
    } else {
      board = new ArrayList<OrderedPair>();
      for (int i = 0; i < boardSize; i++) {
        for (int j = 0; j < boardSize; j++) {
          board.add(new OrderedPair(i, j));
        }
      }
    }
  }


  /**
   * Prints the used moves after a solution is found solution is printed in chess board form.
   * 
   * 
   */
  public void printMoves() {
    int exp = 1;
    int size = boardSize * boardSize;
    while (size / 10 > 0) {
      size /= 10;
      exp++;
    }
    System.out.println("Solution Found!");
    int[][] board = new int[usedMoves.size()][usedMoves.size()];
    int counter = 1;
    for (OrderedPair move : usedMoves) {
      if (board[move.getX()][move.getY()] == 0) {
        board[move.getX()][move.getY()] = counter;
        counter++;
      }
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
