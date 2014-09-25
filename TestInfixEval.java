/*
 * @author Tabetha Boushey
 * @version 2/26/2013
 */

import java.util.Scanner;
import javax.swing.JFrame;

public class TestInfixEval extends JFrame
{
    public static CalcPanel myCalculator;
    
    public static double evaluatePostfix(String expression) {
        MyStack evalStack = new MyStack();
        String[] split = expression.split(" ");
        for (int i = 0; i < split.length; i++) {
            //System.out.println("split[" + i + "] = " + split[i]);
            if (split[i].equals("+")) {
                double secondOperand = evalStack.pop().getData();
                double firstOperand = evalStack.pop().getData();
                double result = firstOperand + secondOperand;
                evalStack.push(new StackNode(result));
            } else if (split[i].equals("-")) {
                double secondOperand = evalStack.pop().getData();
                double firstOperand = evalStack.pop().getData();
                double result = firstOperand - secondOperand;
                evalStack.push(new StackNode(result));
            } else if (split[i].equals("*")) {
                double secondOperand = evalStack.pop().getData();
                double firstOperand = evalStack.pop().getData();
                double result = firstOperand * secondOperand;
                evalStack.push(new StackNode(result));
            } else if (split[i].equals("/")) {
                double secondOperand = evalStack.pop().getData();
                double firstOperand = evalStack.pop().getData();
                double result = firstOperand / secondOperand;
                evalStack.push(new StackNode(result));
            } else {
                // split[i] is a number (assumption)
                evalStack.push(new StackNode(Double.parseDouble(split[i])));
            }
        }
        double expressionValue = evalStack.pop().getData();
        return expressionValue;
    }

    public static void main(String[] args) {
        CalcFrame.getInstance();
        myCalculator = new CalcPanel();
        Scanner myScanner = new Scanner(System.in);
        String expression = myScanner.nextLine();
        //System.out.println("expression: " + expression);
        // convert to post-fix:
        InfixToPostfixParens converter = new InfixToPostfixParens();
        try {
            String postfix = converter.convert(expression);
            System.out.println("equals: " + evaluatePostfix(postfix));
        } catch (Exception ex) {
            System.out.println(ex);
        };
    }
}
