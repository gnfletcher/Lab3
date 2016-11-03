/**
 * 
 */
package lab3;

/**
 * Ordered Pair object used as coordinates of a square on a chess board
 * 
 * @author Greg Fletcher
 * @author Sean O'Donnell
 *
 */
public class OrderedPair {

  public int x;
  public int y;

  /**
   * Constructor takes ints x and y that serve as x and y coordinates and creates a new Ordered Pair
   * 
   * @param int x coordinate
   * @param int y coordinate
   * 
   * 
   */
  public OrderedPair(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Retrieves the current x coordinate
   * 
   * @return int x coordinate
   */
  public int getX() {
    return this.x;
  }

  /**
   * Retrieves the current y coordinate
   * 
   * @return int y coordinate
   */
  public int getY() {
    return this.y;
  }


  /**
   * Compares the current Ordered Pair to another Ordered Pair and tests if they are equal
   * 
   * @param Object Ordered Pair to be compared
   * @return boolean whether or not they are equal
   */
  public boolean equals(Object o) {
    if (!(o instanceof OrderedPair)) {
      return false;
    }
    OrderedPair test = (OrderedPair) o;
    return (this.x == test.getX()) && (this.y == test.getY());
  }
}
