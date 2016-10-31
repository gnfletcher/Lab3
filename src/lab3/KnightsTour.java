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
    public ArrayList<OrderedPair> board;
    public ArrayList<OrderedPair> usedMoves;
    public int boardSize;
    public int path;

    public KnightsTour(int boardSize, int x, int y) {
        this.boardSize = boardSize;
        createBoard();
        usedMoves = new ArrayList<OrderedPair>();
        path = 0;
        OrderedPair first = new OrderedPair(x, y);
        if (move(first)) {
            printMoves();
        } else {
            System.out.println("No Solution Found!");
        }
    }

    public boolean move(OrderedPair current) {
        
board.remove(current);
        usedMoves.add(current);
        if (board.isEmpty()) {
            return true;
        }
        if (board.contains(new OrderedPair(current.getX() + 1, current.getY() + 2)) && move(new OrderedPair(current.getX() + 1, current.getY() + 2))) {
            return true;
        } else if (board.contains(new OrderedPair(current.getX() + 2, current.getY() + 1)) && move(new OrderedPair(current.getX() + 2, current.getY() + 1))) { 
            return true;
        }else if (board.contains(new OrderedPair(current.getX() + 1, current.getY() - 2)) && move(new OrderedPair(current.getX() + 1, current.getY() - 2))) {
            return true;
        }else if (board.contains(new OrderedPair(current.getX() + 2, current.getY() - 1)) && move(new OrderedPair(current.getX() + 2, current.getY() - 1))) {
            return true;
        } else if (board.contains(new OrderedPair(current.getX() - 1, current.getY() + 2)) && move(new OrderedPair(current.getX() - 1, current.getY() + 2))) {
            return true;
        }else if (board.contains(new OrderedPair(current.getX() - 2, current.getY() + 1)) && move(new OrderedPair(current.getX() - 2, current.getY() + 1))) {
            return true;
        }else if (board.contains(new OrderedPair(current.getX() - 1, current.getY() - 2)) && move(new OrderedPair(current.getX() - 1, current.getY() - 2))) {
            return true;
        }else if (board.contains(new OrderedPair(current.getX() - 2, current.getY() - 1)) && move(new OrderedPair(current.getX() - 2, current.getY() - 1))) {

            return true;
        }
        board.add(current);
        usedMoves.remove(current);
        return false;
    }

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