import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/*
 * @author Tabetha Boushey
 * @version 2/26/2013
 */

public class CalcFrame extends JFrame{
    private static CalcFrame instance;
 
    CalcFrame() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w + 70) / 5;
        int y = (dim.height - h) / 6;
        this.setLocation(x, y);
        Container c = getContentPane();
        c.add(TopCalcPanel.getInstance(), BorderLayout.NORTH);
        c.add(CalcPanel.getInstance(), BorderLayout.SOUTH);
        setSize(275, 295);
        setResizable(true);
        setVisible(true);
    }
    
    public static CalcFrame getInstance() {
        if (instance == null) {
            instance = new CalcFrame();
        }
        return instance;
    }
}
