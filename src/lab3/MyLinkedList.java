/**
 * 
 */
package lab3;

/**
 * Implements MyList interface as an linked list.
 * 
 * @author Greg Fletcher
 * @author Sean O'Donnell
 *
 * @param <T> list type
 */
public class MyLinkedList<T> implements MyList<T> {
  private int size;
  private MyNode<T> head;
  private MyNode<T> tail;

  /**
   * Default constructor initializes an empty list.
   */
  public MyLinkedList() {
    this.size = 0;
    this.head = new MyNode<T>(null, null);
    this.tail = new MyNode<T>(null, null);
  }

  /**
   * Adds element at a given index.
   * 
   * @param index index to add at.
   * @param object element to be added.
   * @return boolean if operation was successful.
   */
  @Override
  public boolean add(int index, T object) {
    MyNode<T> previous = (MyNode<T>) head;
    if (index == 0) {
      MyNode<T> newNode = new MyNode<T>(object, head);
      head = newNode;
    } else if (index == size - 1) {
      MyNode<T> oldTail = (MyNode<T>) tail;
      tail = new MyNode<T>(object, null);
      oldTail.setNext(tail);
    }
    for (int i = 0; i < index; i++) {
      previous = (MyNode<T>) previous.getNext();
    }
    MyNode<T> next = (MyNode<T>) previous.getNext();
    MyNode<T> newNode = new MyNode<T>(object, next);
    previous.setNext(newNode);
    this.size++;
    return true;
  }

  /**
   * Adds element at the end of the list.
   * 
   * @param index index to add at.
   * @param object element to be added.
   * @return boolean if operation was successful.
   */
  @Override
  public boolean add(T object) {
    if (head.getValue() == null) {
      head = new MyNode<T>(object, null);
      tail = head;
    } else {
      MyNode<T> oldTail = (MyNode<T>) tail;
      tail = new MyNode<T>(object, null);
      oldTail.setNext(tail);
    }
    this.size++;
    return true;
  }

  public boolean push(T object) {
    if (isEmpty()) {
      head = new MyNode<T>(object, null);
      tail = head;
    } else {
      MyNode<T> oldHead = (MyNode<T>) head;
      head = new MyNode<T>(object, oldHead);
    }
    this.size++;
    return true;
  }

  public T pop() {
    MyNode<T> oldHead = (MyNode<T>) head;
    if (size < 1) {
      head = null;
    } else {
      head = head.getNext();
    }
    this.size--;
    return (T) oldHead.getValue();
  }

  /**
   * Clears list of all elements.
   * 
   * @return boolean if operation was successful.
   */
  @Override
  public boolean clear() {
    this.head = null;
    this.size = 0;
    return true;
  }

  /**
   * Searches list for given element.
   * 
   * @param object to search for in list.
   * @return boolean if operation was successful.
   */
  @Override
  public boolean contains(T object) {
    MyNode<T> next = (MyNode<T>) head;
    for (int i = 0; i < this.size; i++) {
      if (next.getValue().equals(object)) {
        return true;
      }
      next = (MyNode<T>) next.getNext();
    }
    return false;
  }

  /**
   * Retrieves element at given index.
   * 
   * @param index of element to retrieve.
   * @return element
   */
  @Override
  public T get(int index) {
    MyNode<T> next = (MyNode<T>) head;
    for (int i = 0; i < index; i++) {
      next = (MyNode<T>) next.getNext();
    }
    return (T) next.getValue();
  }

  /**
   * Searches list for given element to find index value.
   * 
   * @param object to search for in list.
   * @return int value of the element's index.
   */
  @Override
  public int indexOf(T object) {
    MyNode<T> next = (MyNode<T>) head;
    for (int i = 0; i < this.size; i++) {
      if (next.getValue().equals(object)) {
        return i;
      }
      next = (MyNode<T>) next.getNext();
    }
    return -1;
  }

  /**
   * Check if list is empty.
   * 
   * @return boolean if list does not have content.
   */
  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  /**
   * Removes element at given index.
   * 
   * @param index of element to be removed.
   * @return object that was removed.
   */
  @SuppressWarnings("unchecked")
  @Override
  public T remove(int index) {
    MyNode<T> previous = (MyNode<T>) head;
    for (int i = 0; i < index - 1; i++) {
      previous = (MyNode<T>) previous.getNext();
    }
    MyNode<T> next = (MyNode<T>) previous.getNext();
    previous.setNext(next.getNext());
    this.size--;
    return (T) next;
  }

  /**
   * Removes given object from list.
   * 
   * @param object to be removed.
   * @return object that was removed.
   */
  @SuppressWarnings("unchecked")
  @Override
  public T remove(Object object) {
    MyNode<T> previous = (MyNode<T>) head;
    for (int i = 0; i < this.size; i++) {
      if (previous.getNext().getValue().equals(object)) {
        MyNode<T> next = (MyNode<T>) previous.getNext();
        previous.setNext(next.getNext());
        this.size--;
        return (T) next;
      }
      previous = (MyNode<T>) previous.getNext();
    }
    return null;
  }

  /**
   * Sets value of element to given value at given index.
   * 
   * @param index index of element to set value.
   * @param element value to set.
   * @return boolean if operation was successful.
   */
  @Override
  public boolean set(int index, T object) {
    MyNode<T> next = (MyNode<T>) head;
    for (int i = 0; i < index; i++) {
      next = (MyNode<T>) next.getNext();
    }
    next.setValue(object);
    return true;
  }

  /**
   * Returns number of elements in list.
   * 
   * @return int value of list size.
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Creates a list from a section of elements for a list from a given index to a given index.
   * 
   * @param fromIndex starting index for new list
   * @param toIndex ending index for new list
   * @return list of the specified subset.
   */
  @SuppressWarnings("unchecked")
  @Override
  public T[] subList(int fromIndex, int toIndex) {
    T[] newArray = (T[]) new Object[toIndex - fromIndex + 1];
    MyNode<T> next = (MyNode<T>) head;
    for (int i = 0; i < fromIndex; i++) {
      next = (MyNode<T>) next.getNext();
    }
    for (int i = 0; i < fromIndex - toIndex; i++) {
      next = (MyNode<T>) next.getNext();
      newArray[i] = (T) next;
    }
    return newArray;
  }

  /**
   * Converts content of list to an array.
   * 
   * @return array of list elements
   */
  @SuppressWarnings("unchecked")
  @Override
  public T[] toArray() {
    T[] newArray = (T[]) new Object[size];
    MyNode<T> next = (MyNode<T>) head;
    for (int i = 0; i < size; i++) {
      newArray[i] = (T) next;
      next = (MyNode<T>) next.getNext();
    }
    return newArray;
  }

  /**
   * Takes two elements at given indexes and exchanges their value.
   * 
   * @param position1 index of first element
   * @param position2 index of second element
   * @return boolean if operation was successful.
   */
  @Override
  public boolean swap(int position1, int position2) {
    int firstIndex = position1;
    int secondIndex = position2;
    T temp;
    if (position1 > position2) {
      firstIndex = position2;
      secondIndex = position1;
    }
    if (position1 != position2) {
      if (secondIndex == size - 1) {
        MyNode<T> firstNode = (MyNode<T>) head.getNext();
        for (int i = 0; i < firstIndex; i++) {
          firstNode = (MyNode<T>) firstNode.getNext();
        }
        temp = firstNode.getValue();
        firstNode.setValue(tail.getValue());
        tail.setValue(temp);
        return true;
      } else {
        MyNode<T> firstNode = (MyNode<T>) head.getNext();
        for (int i = 0; i < firstIndex; i++) {
          firstNode = (MyNode<T>) firstNode.getNext();
        }
        MyNode<T> secondNode = (MyNode<T>) firstNode;
        for (int i = firstIndex; i < secondIndex; i++) {
          secondNode = (MyNode<T>) secondNode.getNext();
        }
        temp = firstNode.getValue();
        firstNode.setValue(secondNode.getValue());
        secondNode.setValue(temp);
        return true;
      }
    }
    return true;
  }

  /**
   * Moves elements in list by given number of elements. Indexes can move in a positive or negative
   * direction.
   * 
   * @param positions number of indexes to move elements of list.
   * @return boolean if operation was successful.
   */
  @Override
  public boolean shift(int positions) {
    tail.setNext(head);
    MyNode<T> next = (MyNode<T>) head;
    if (positions > 0) {
      for (int i = 0; i < positions; i++) {
        next = (MyNode<T>) next.getNext();
      }
      head = (MyNode<T>) next.getNext();
      next.setNext(null);
      tail = next;
    } else if (positions < 0) {
      for (int i = 0; i < size + positions - 1; i++) {
        next = (MyNode<T>) next.getNext();
      }
      head = (MyNode<T>) next.getNext();
      next.setNext(null);
      tail = next;
    }
    return true;
  }

  /**
   * Retrieves head of list.
   * 
   * @return node object of head.
   */
  public MyNode<T> getHead() {
    return head;
  }


  /**
   * Retrieves tail of list.
   * 
   * @return node object of tail.
   */
  public MyNode<T> getTail() {
    return tail;
  }

  /**
   * Sets head marker to given object.
   * 
   * @param head node object
   */
  public void setHead(MyNode<T> head) {
    this.head = head;
  }

  /**
   * Sets tail marker to given object.
   * 
   * @param tail node object
   */
  public void setTail(MyNode<T> tail) {
    this.tail = tail;
  }

  /**
   * Gets size of array.
   * 
   * @return int of array size
   */
  public int getSize() {
    return size;
  }
}
