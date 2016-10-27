/**
 * 
 */
package lab3;

/**
 * @author FletcherG
 *
 */
public class Infix {

  public Infix() {

  }

  public static String infixToPostfix(String eq) {
    MyLinkedList<String> stack = new MyLinkedList<String>();
    int parenBalance = 0;
    eq = eq.replaceAll("[)](?=\\d)", ")*");
    eq = eq.replaceAll("(?<=\\d)[(]", "*(");
    eq = eq.replaceAll("\\)\\(", ")*(");
    System.out.println(eq);
    String[] newEq = eq.split("(?<=[-+*/()])|(?=[-+*/()])");
    String[] postfixEq = new String[newEq.length * 2];
    String operand = "[0-9]";
    int j = 0;
    for (int i = 0; i < newEq.length; i++) {
      if (newEq[i].matches(operand)) {
        postfixEq[j] = newEq[i];
        j++;
        postfixEq[j] = " ";
        j++;
      } else if (newEq[i].equals("(")) {
        stack.push(newEq[i]);
        parenBalance++;
      } else if (newEq[i].equals(")")) {
        if (parenBalance == 0) {
          System.out.print("Illegal paren use. Closed paren without paired open paren.");
          System.exit(0);
        }
        while (!stack.getHead().getValue().equals("(")) {
          postfixEq[j] = stack.pop();
          j++;
          postfixEq[j] = " ";
          j++;
        }
        stack.pop();
        if (!stack.isEmpty()) {
          if (stack.getHead().getValue().equals("*") || stack.getHead().getValue().equals("/")
              || stack.getHead().getValue().equals("+") || stack.getHead().getValue().equals("-")) {
            postfixEq[j] = stack.pop();
            j++;
            postfixEq[j] = " ";
            j++;
          }
        }
        parenBalance--;
      } else if ((newEq[i].equals("+") || newEq[i].equals("-") || newEq[i].equals("*")
          || newEq[i].equals("/"))) {
        if (newEq[i + 1].equals("(")) {
          stack.push(newEq[i]);
        } else if (newEq[i].equals("*") || newEq[i].equals("/")) {
          postfixEq[j] = newEq[i+1];
          j++;
          postfixEq[j] = " ";
          j++;
          postfixEq[j] = newEq[i];
          j++;
          postfixEq[j] = " ";
          j++;
          i++;
        } else {
          stack.push(newEq[i]);
        }
      } else {
        System.out.println("Invalid input");
        System.exit(0);
      }
    }
    if (parenBalance != 0) {
      System.out.println(
          "Invalid input. Mismatched parens. Confirm all open parens are matched with a closed paren.");
      System.exit(0);
    }
    while (!stack.isEmpty()) {
      postfixEq[j] = stack.pop();
      j++;
      postfixEq[j] = " ";
      j++;
    }
    StringBuilder eqString = new StringBuilder();
    for (String s : postfixEq) {
      if (s == null) {
      } else {
        eqString.append(s);
      }
    }
    System.out.println(eqString.toString());
    return eqString.toString();
  }

  public static int evaluate(String eq) {
    return Postfix.evaluate(infixToPostfix(eq));
  }
}