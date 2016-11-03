/**
 * 
 */
package lab3;

/**
 * Calculator that takes a user inputted Postfix equation and determines the final answer, if there
 * is one.
 * 
 * @author Greg Fletcher
 * @Author Sean O'Donnell
 *
 */
public class Postfix {

  /**
   * a blank constructor that simply creates a new instance of Postfix
   * 
   */
  public Postfix() {

  }

  /**
   * Parses through the input given by the user in Postfix form and evaluates the expresiion to find
   * an answer
   * 
   * @param String equation inputted
   * @return int final answer
   */
  public static int evaluate(String eq) {
    MyLinkedList<String> stack = new MyLinkedList<String>();
    String[] newEq = eq.split("\\s");
    String operand = "[0-9]";
    int opCounter = 0;
    for (int i = 0; i < newEq.length; i++) {
      if (newEq[i].matches(operand)) {
        stack.push(newEq[i]);
        opCounter++;
      } else if (newEq[i].equals("+")) {
        int second = Integer.valueOf(stack.pop());
        int first = Integer.valueOf(stack.pop());
        stack.push(String.valueOf(first + second));
        opCounter--;
      } else if (newEq[i].equals("*")) {
        int second = Integer.valueOf(stack.pop());
        int first = Integer.valueOf(stack.pop());
        stack.push(String.valueOf(first * second));
        opCounter--;
      } else if (newEq[i].equals("/")) {
        int second = Integer.valueOf(stack.pop());
        int first = Integer.valueOf(stack.pop());
        stack.push(String.valueOf(first / second));
        opCounter--;
      } else if (newEq[i].equals("-")) {
        int second = Integer.valueOf(stack.pop());
        int first = Integer.valueOf(stack.pop());
        stack.push(String.valueOf(first - second));
        opCounter--;
      } else {
        System.out.println("Invalid input. Improper postfix format.");
        System.exit(0);
      }
    }
    if (opCounter > 1) {
      System.out.println("Invalid input. Missing operation.");
      System.exit(0);
    } else if (opCounter < 1) {
      System.out.println("Invalid input. Missing operand.");
      System.exit(0);
    }
    return Integer.valueOf(stack.pop());
  }
}
