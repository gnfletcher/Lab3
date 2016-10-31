/**
 * 
 */
package lab3;

/**
 * @author FletcherG
 *
 */
public class driver {

  /**
   * @param args
   */
  public static void main(String[] args) {
    String post = "2 2 3 * + 2 / 5 +";
    String in = "(2+2)(3+4)4";
    System.out.println(String.valueOf(Postfix.evaluate(post)));
    System.out.println(String.valueOf(Infix.evaluate(in)));
    new KnightsTour(8, 0, 0);
  }

}
