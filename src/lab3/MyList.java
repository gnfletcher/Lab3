/**
 * 
 */
package lab3;

/**
 * Interface for list data structures.
 * 
 * @author Greg Fletcher
 * @author Sean O'Donnell
 *
 */
public interface MyList<T> {

  /**
   * Adds element at a given index.
   * 
   * @param index index to add at.
   * @param object element to be added.
   * @return boolean if operation was successful.
   */
  public boolean add(int index, T object);

  /**
   * Adds element at the end of the list.
   * 
   * @param index index to add at.
   * @param object element to be added.
   * @return boolean if operation was successful.
   */
  public boolean add(T object);

  /**
   * Clears list of all elements.
   * 
   * @return boolean if operation was successful.
   */
  public boolean clear();

  /**
   * Searches list for given element.
   * 
   * @param object to search for in list.
   * @return boolean if operation was successful.
   */
  public boolean contains(T object);

  /**
   * Retrieves element at given index.
   * 
   * @param index of element to retrieve.
   * @return element
   */
  public T get(int index);

  /**
   * Searches list for given element to find index value.
   * 
   * @param object to search for in list.
   * @return int value of the element's index.
   */
  public int indexOf(T object);

  /**
   * Check if list is empty.
   * 
   * @return boolean if list does not have content.
   */
  public boolean isEmpty();

  /**
   * Removes element at given index.
   * 
   * @param index of element to be removed.
   * @return object that was removed.
   */
  public T remove(int index);

  /**
   * Removes given object from list.
   * 
   * @param object to be removed.
   * @return object that was removed.
   */
  public T remove(T object);

  /**
   * Sets value of element to given value at given index.
   * 
   * @param index index of element to set value.
   * @param element value to set.
   * @return boolean if operation was successful.
   */
  public boolean set(int index, T element);

  /**
   * Returns number of elements in list.
   * 
   * @return int value of list size.
   */
  public int size();

  /**
   * Creates a list from a section of elements for a list from a given index to a given index.
   * 
   * @param fromIndex starting index for new list
   * @param toIndex ending index for new list
   * @return list of the specified subset.
   */
  public T[] subList(int fromIndex, int toIndex);

  /**
   * Converts content of list to an array.
   * 
   * @return array of list elements
   */
  public T[] toArray();

  /**
   * Takes two elements at given indexes and exchanges their value.
   * 
   * @param position1 index of first element
   * @param position2 index of second element
   * @return boolean if operation was successful.
   */
  public boolean swap(int position1, int position2);

  /**
   * Moves elements in list by given number of elements. Indexes can move in a positive or negative
   * direction.
   * 
   * @param positions number of indexes to move elements of list.
   * @return boolean if operation was successful.
   */
  public boolean shift(int positions);

}
