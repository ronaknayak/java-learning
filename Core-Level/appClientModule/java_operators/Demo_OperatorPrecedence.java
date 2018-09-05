package java_operators;

/** -> In java, we have only operator precedence but not operand precedence.
 * 
 *  -> Before applying any operator, all operator will be evaluated from LEFT to RIGHT.
 * */

public class Demo_OperatorPrecedence {
	
	public static void main(String[] args) {
		System.out.println(m(1)+m(2)*m(3)/m(4)+m(5)*m(6));
	}
	
	public static int m(int i){
		System.out.println("operands evaluation order: "+i);
		return i;
	}
}
