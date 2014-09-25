import java.util.*;
import java.util.regex.Pattern;

/* 
 * Translates an infix expression with parentheses
 * to a postfix expression.
 * @author Koffman & Wolfgang
 */

public class InfixToPostfixParens {

    public static class SyntaxErrorException // Nested Class
            extends Exception {

        SyntaxErrorException(String message) {
            super(message);
        }
    }
    private Stack<Character> operatorStack; // Data Fields
    
    private static final String OPERATORS = "-+*/()";
    
    private static final Pattern pattern =
            Pattern.compile("\\d+\\.\\d*|\\d+|"
            + "\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*"
            + "|[" + OPERATORS + "]");
    /** The precedence of the operators, matches order of OPERATORS. */
    
    private static final int[] PRECEDENCE = {1, 1, 2, 2, -1, -1};
    
    private StringBuilder postfix;
    
    public String convert(String infix) throws SyntaxErrorException {
        operatorStack = new Stack<Character>();
        postfix = new StringBuilder();
        Scanner scan = new Scanner(infix);
        try {
            // Process each token in the infix string.
            String nextToken;
            while ((nextToken = scan.findInLine(pattern)) != null) {
                char firstChar = nextToken.charAt(0);
                // Is it an operand?
                if (Character.isJavaIdentifierStart(firstChar)
                        || Character.isDigit(firstChar)) {
                    postfix.append(nextToken);
                    postfix.append(' ');
                } // Is it an operator?
                else if (isOperator(firstChar)) {
                    processOperator(firstChar);
                } else {
                    throw new SyntaxErrorException("Unexpected Character Encountered: "
                            + firstChar);
                }
            } // End while.
            // Pop any remaining operators
            // and append them to postfix.
            while (!operatorStack.empty()) {
                char op = operatorStack.pop();
                // Any '(' on the stack is not matched.
                if (op == ')') {
                    throw new SyntaxErrorException(
                            "Unmatched opening parenthesis");
                }
                postfix.append(op);
                postfix.append(' ');
            }
            // assert: Stack is empty, return result.
            return postfix.toString();
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }

    public void processOperator(char op) {
        if (operatorStack.empty() || op == '(') {
            operatorStack.push(op);
        } else {
            // Peek the operator stack and
            // let topOp be the top operator.
            char topOp = operatorStack.peek();
            if (precedence(op) > precedence(topOp)) {
                operatorStack.push(op);
            } else {
                // Pop all stacked operators with equal
                // or higher precedence than op.
                while (!operatorStack.empty()
                        && precedence(op) <= precedence(topOp)) {
                    operatorStack.pop();
                    if (topOp == '(') {
                        // Matching '(' popped - exit loop.
                        break;
                    }
                    postfix.append(topOp);
                    postfix.append(' ');
                    if (!operatorStack.empty()) {
                        // Reset topOp.
                        topOp = operatorStack.peek();
                    }
                }

                // assert: Operator stack is empty or
                //         current operator precedence >
                //         top of stack operator precedence.
                if (op != ')') {
                    operatorStack.push(op);
                }
            }
        }
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    private int precedence(char op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }
}
