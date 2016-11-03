/**
 * 
 */
package lab3;

/**
 * @author Greg Fletcher
 * @author Sean O'Donnell
 *
 */
public class driver {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // Update string to input to Postfix calculator
    String post = "2 2 3 * + 2 / 5 +";
    // Update string to input to Infix calculator
    String in = "(2+2)(3+4)4";
    // Uncomment following line to run Postfix calculator
    System.out.println(String.valueOf(Postfix.evaluate(post)));
    // Uncomment following line to run Postfix calculator
    System.out.println(String.valueOf(Infix.evaluate(in)));
    // Enter board size, starting x and starting y to run Knights Tour
    new KnightsTour(5, 3, 3);
  }

}
