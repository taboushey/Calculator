/*
 * @author Tabetha Boushey
 * @version 2/26/2013
 */

public class MyStack
{
    // instance variables - replace the example below with your own
    private StackNode top;

    public MyStack()
    {
        // initialise instance variables
        top = null;
    }

    public void push(StackNode node) {
        if (node != null) {
            StackNode oldTop = top;
            top = node;
            top.setPrevious(oldTop);
        }
    }
    
    public StackNode peek() {
        return top;
    }
    
    public StackNode pop() {
        StackNode curTop = top;
        if (top != null)
            top = top.getPrevious();
       return curTop;
    }
}
