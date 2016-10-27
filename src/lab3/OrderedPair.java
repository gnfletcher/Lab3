/**
 * 
 */
package lab3;

/**
 * @author FletcherG
 *
 */
public class OrderedPair {
  
  public int x;
  public int y;
  
  public OrderedPair(int x, int y){
    this.x = x;
    this.y = y;
  }
  
  public int getX(){
    return this.x;
  }
  
  public int getY(){
    return this.y;
  }
  
  public int[] getPair(){
    int[] pair = new int[2];
    pair[0] = x;
    pair[1] = y;
    return pair;
  }
  
  public boolean equals(Object o){
    if (!(o instanceof OrderedPair)) {
      return false;
    }
    OrderedPair test = (OrderedPair) o;
    return (this.x == test.getX()) && (this.y == test.getY());
  }
}
