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

	public void move(OrderedPair current, ArrayList<OrderedPair> newBoard, ArrayList<OrderedPair> newUsedMoves,
			int boardSize) {
		ArrayList<OrderedPair> legalMoves = getLegalMoves(current, newBoard);
		if (!newBoard.isEmpty() && legalMoves.isEmpty()) {
			System.out.println("No Solution Found!");
		} else if (newBoard.isEmpty() && legalMoves.isEmpty()) {
			printMoves(newUsedMoves, boardSize);
		}
		while (!legalMoves.isEmpty()) {
			OrderedPair move = legalMoves.iterator().next();
			newBoard.remove(move);
			newUsedMoves.add(move);
			legalMoves.remove(move);
			move(move, newBoard, newUsedMoves, boardSize);
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

	public ArrayList<OrderedPair> removeFromBoard(OrderedPair move, ArrayList<OrderedPair> newBoard) {
		ArrayList<OrderedPair> board = new ArrayList<OrderedPair>();
		board.remove(move);
		return board;
	}

	public ArrayList<OrderedPair> addToMoves(OrderedPair move, ArrayList<OrderedPair> newBoard) {
		ArrayList<OrderedPair> board = new ArrayList<OrderedPair>();
		board.add(move);
		return board;
	}

	public ArrayList<OrderedPair> getLegalMoves(OrderedPair current, ArrayList<OrderedPair> newBoard) {
		ArrayList<OrderedPair> legalMoves = new ArrayList<OrderedPair>();
		ArrayList<OrderedPair> board = newBoard;
		OrderedPair testPair = new OrderedPair(current.getX() + 1, current.getY() + 2);
		if (board.contains(testPair)) {
			System.out.print("(" + testPair.getX() + "," + testPair.getY() + ")");
			legalMoves.add(testPair);
		}
		testPair = new OrderedPair(current.getX() + 2, current.getY() + 1);
		if (board.contains(testPair)) {
			System.out.print("(" + testPair.getX() + "," + testPair.getY() + ")");
			legalMoves.add(testPair);
		}
		testPair = new OrderedPair(current.getX() + 1, current.getY() - 2);
		if (board.contains(testPair)) {
			System.out.print("(" + testPair.getX() + "," + testPair.getY() + ")");
			legalMoves.add(testPair);
		}
		testPair = new OrderedPair(current.getX() + 2, current.getY() - 1);
		if (board.contains(testPair)) {
			System.out.print("(" + testPair.getX() + "," + testPair.getY() + ")");
			legalMoves.add(testPair);
		}
		testPair = new OrderedPair(current.getX() - 1, current.getY() + 2);
		if (board.contains(testPair)) {
			System.out.print("(" + testPair.getX() + "," + testPair.getY() + ")");
			legalMoves.add(testPair);
		}
		testPair = new OrderedPair(current.getX() - 2, current.getY() + 1);
		if (board.contains(testPair)) {
			System.out.print("(" + testPair.getX() + "," + testPair.getY() + ")");
			legalMoves.add(testPair);
		}
		testPair = new OrderedPair(current.getX() - 1, current.getY() - 2);
		if (board.contains(testPair)) {
			System.out.print("(" + testPair.getX() + "," + testPair.getY() + ")");
			legalMoves.add(testPair);
		}
		testPair = new OrderedPair(current.getX() - 2, current.getY() - 1);
		if (board.contains(testPair)) {
			System.out.print("(" + testPair.getX() + "," + testPair.getY() + ")");
			legalMoves.add(testPair);
		}
		System.out.println("");
		return legalMoves;
	}

	public void printMoves(ArrayList<OrderedPair> usedMoves, int boardSize) {
		int exp = 1;
		int size = boardSize * boardSize;
		while (size / 10 > 0) {
			size /= 10;
			exp++;
		}
		System.out.println("Solution Found!");
		ArrayList<OrderedPair> newUsedMoves = usedMoves;
		int[][] board = new int[newUsedMoves.size()][newUsedMoves.size()];
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