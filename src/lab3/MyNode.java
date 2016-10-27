/**
 * 
 */
package lab3;

/**
 * Node object used as element of a linked list or circular linked list.
 * 
 * @author Greg Fletcher
 * @author Sean O'Donnell
 *
 */
public class MyNode<T> {
  private MyNode<T> next;
  private T value;

  /**
   * Constructor takes an object and instantiates a node with no next value.
   * @param value object value of node.
   */
  public MyNode(T value) {
    this.value = value;
    this.next = null;
  }

  /**
   * Constructor takes an object and node, instantiates a node with a next value of a node.
   * @param value object value of node.
   * @param next node object of next node.
   */
  public MyNode(T value, MyNode<T> next) {
    this.value = value;
    this.next = next;
  }

  /**
   * Retrieves next node in the list.
   * @return node next in list
   */
  public MyNode<T> getNext() {
    return next;
  }

  /**
   * Sets next node in the list.
   * @param next node to be set as next.
   */
  public void setNext(MyNode<T> next) {
    this.next = next;
  }

  /**
   * Retrieves object value of node.
   * @return object of node value.
   */
  public T getValue() {
    return value;
  }

  /**
   * Sets node value.
   * @param value object to set as node value.
   */
  public void setValue(T value) {
    this.value = value;
  }


}
