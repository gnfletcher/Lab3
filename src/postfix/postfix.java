/**
 * 
 */
package postfix;

/**
 * @author FletcherG
 *
 */
public class postfix {
  
    public postfix(String eq){
      parseEq(eq);
    }
    
    private int parseEq(String eq){
      MyLinkedList<String> stack = new MyLinkedList<String>();
      int total = 0;
      String[] newEq = eq.split("\\s");
      String operand = "[0-9]";
      int opCounter = 0;
      for(int i=0; i<newEq.length; i++){
        if(newEq[i].matches(operand)){
          stack.push(newEq[i]);
          opCounter++;
        } else if (newEq[i].equals("+") || newEq[i].equals("*") || newEq[i].equals("/") || newEq[i].equals("-")){
          int second = Integer.valueOf(stack.pop());
          int first = Integer.valueOf(stack.pop());
          char operator = newEq[i].charAt(i);
          total = Integer.valueOf(first)
          opCounter--;
        } else {
          System.out.println("Invalid input");
          System.exit(0);
        }
      }
      if(opCounter != 1){
        System.out.println("Invalid input");
        System.exit(0);
      } 
      return total;
    }
}
