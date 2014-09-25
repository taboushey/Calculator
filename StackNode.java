/*
 * @author Tabetha Boushey
 * @version 2/26/2013 
 */
public class StackNode
{
    // instance variables - replace the example below with your own
    private StackNode previous;
    private double data;

    public StackNode(double c)
    {
        // initialise instance variables
        data = c;
    }

    public void setPrevious(StackNode node) {
        previous = node;
    }
    
    public StackNode getPrevious() {
        return previous;
    }
    
    public double getData() {
        return data;
    }
}
