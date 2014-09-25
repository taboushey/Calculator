import javax.swing.*;
import java.awt.*;

/*
 * @author Tabetha Boushey
 * @version 2/26/2013
 */

public class TopCalcPanel extends JPanel {
     public static TopCalcPanel inst;
    public static int calculationValue = 0;
    public static JTextField calculation;
    
    public TopCalcPanel () { // This is the text field at the top of the calculator.
        setLayout (new GridLayout(1,1)); 
        calculation = new JTextField();
        Font bigFont = new Font("Serif", Font.PLAIN, 20); // Makes the size of the text box.
        calculation.setFont(bigFont);
        calculation.setEditable(false); // Doesn't allow the user to type things in, they mush push buttons.
        this.add(calculation);
        this.setVisible(true); // Lets the user see what is in the text box.
}
    public static TopCalcPanel getInstance() {
        if (inst == null) {
            inst = new TopCalcPanel();
        }
        return inst;
    }
}
