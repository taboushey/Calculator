import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Tabetha Boushey
 * @version 2/26/2013
 */

public class CalcPanel extends JPanel {

    public static CalcPanel inst;
    public InfixToPostfixParens converter = new InfixToPostfixParens();
    public TestInfixEval evaluate = new TestInfixEval();
    public JButton deleteButton, clearButton, divideButton, multiplyButton, subtractButton, 
            addButton, equalsButton, decimalButton, leftParentheseButton, rightParentheseButton, 
            zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, 
            sevenButton, eightButton, nineButton;

    public CalcPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        sevenButton = new JButton("7"); // Button 7.
        sevenButton.addActionListener(new ActionListener() { //Creates the button for 7.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "7"); // Adds 7 to the text box.
                TopCalcPanel.calculationValue = TopCalcPanel.calculationValue + 7; // Adds 7 to the value of the text.
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 0;
        c.gridy = 0;
        add(sevenButton, c);
        
        eightButton = new JButton("8"); // Button 8.
        eightButton.addActionListener(new ActionListener() { // Creates the button for 8.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "8"); // Adds 8 to the text box.
                TopCalcPanel.calculationValue = TopCalcPanel.calculationValue + 8; // Adds 8 to the value of the text.
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 1;
        c.gridy = 0;
        add(eightButton, c);
        
        nineButton = new JButton("9"); // Button 9.
        nineButton.addActionListener(new ActionListener() { // Creates the button for 9.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "9"); // Adds 9 to the text box.
                TopCalcPanel.calculationValue = TopCalcPanel.calculationValue + 9; // Adds 9 to the value of the text.
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 2;
        c.gridy = 0;
        add(nineButton, c);
        
        deleteButton = new JButton("Delete"); // Delete button.
        deleteButton.addActionListener(new ActionListener() { // Creates the Delete button.
            public void actionPerformed(ActionEvent e) {
                if (TopCalcPanel.calculation.getText() != null || !(TopCalcPanel.calculation.getText().equals(""))) {
                    if (TopCalcPanel.calculation.getText().length() > 0) {
                        char[] text = TopCalcPanel.calculation.getText().toCharArray();
                        TopCalcPanel.calculation.setText(String.valueOf(text, 0, text.length - 1)); // Deletes the last number entered in the text box.
                    }
                }
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; // Puts the button in the desired location.
        c.gridx = 3;
        c.gridy = 0;
        add(deleteButton, c);
        
        clearButton = new JButton("Clear"); // Clear button.
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 4;
        c.gridy = 0;
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearButton.addActionListener(new ClearPressed()); // Clears the text box of the numbers put in.
            }
        });
        clearButton.addActionListener(new ClearPressed());
        add(clearButton, c);

        fourButton = new JButton("4"); // Button 4.
        fourButton.addActionListener(new ActionListener() { // Creates the button for 4.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "4"); // Adds 4 to the text box.
                TopCalcPanel.calculationValue = TopCalcPanel.calculationValue + 4; // Adds 4 to the value of the text.
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 0;
        c.gridy = 1;
        add(fourButton, c);
        
        fiveButton = new JButton("5"); // Button 5.
        fiveButton.addActionListener(new ActionListener() { // Creates the button for 5.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "5"); // Adds 5 to the text box.
                TopCalcPanel.calculationValue = TopCalcPanel.calculationValue + 5; // Adds 5 to the value of the text.
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 1;
        c.gridy = 1;
        add(fiveButton, c);
        
        sixButton = new JButton("6"); // Button 6.
        sixButton.addActionListener(new ActionListener() { // Creates the button for 6.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "6"); // Adds 6 to the text box.
                TopCalcPanel.calculationValue = TopCalcPanel.calculationValue + 6; // Adds 6 to the value of the text.
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 2;
        c.gridy = 1;
        add(sixButton, c);
        
        divideButton = new JButton("/"); // Divide button.
        divideButton.addActionListener(new ActionListener() { // Creates the divide button.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "/"); // Adds / to the text box.
                try {
                    converter.convert(TopCalcPanel.calculation.getText()); // Divides the set of values before and after.
                } catch (InfixToPostfixParens.SyntaxErrorException ex) {
                    Logger.getLogger(CalcPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 3;
        c.gridy = 1;
        add(divideButton, c);
        
        multiplyButton = new JButton("*"); // Multiply button.
        multiplyButton.addActionListener(new ActionListener() { // Creates the multiply button.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "*"); // Adds * to the text box.
                try {
                    converter.convert(TopCalcPanel.calculation.getText()); // Multiplies the set of values before and after.
                } catch (InfixToPostfixParens.SyntaxErrorException ex) {
                    Logger.getLogger(CalcPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 4;
        c.gridy = 1;
        add(multiplyButton, c);

        oneButton = new JButton("1"); // Button 1.
        oneButton.addActionListener(new ActionListener() { // Creates the button for 1.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "1"); // Adds 1 to the text box.
                TopCalcPanel.calculationValue = TopCalcPanel.calculationValue + 1; // Adds 1 to the value of the text.
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 0;
        c.gridy = 2;
        add(oneButton, c);
        
        twoButton = new JButton("2"); // Button 2.
        twoButton.addActionListener(new ActionListener() { // Creates the button for 2.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "2"); // Adds 2 to the text box.
                TopCalcPanel.calculationValue = TopCalcPanel.calculationValue + 2; // Adds 2 to the value of the text.
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 1;
        c.gridy = 2;
        add(twoButton, c);
        
        threeButton = new JButton("3"); // Button 3.
        threeButton.addActionListener(new ActionListener() { // Creates the button for 3.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "3"); // Adds 3 to the text box.
                TopCalcPanel.calculationValue = TopCalcPanel.calculationValue + 3; // Adds 3 to the value of the text.
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 2;
        c.gridy = 2;
        add(threeButton, c);
        
        addButton = new JButton("+"); // Plus button.
        addButton.addActionListener(new ActionListener() { // Creates the plus button.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "+"); // Adds + to the text box.
                try {
                    converter.convert(TopCalcPanel.calculation.getText()); // Adds the values before and after.
                } catch (InfixToPostfixParens.SyntaxErrorException ex) {
                    Logger.getLogger(CalcPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 3;
        c.gridy = 2;
        add(addButton, c);
        
        // If you want to do negative numbers you must first enter a 0.
        subtractButton = new JButton("-"); // Subtract button.
        subtractButton.addActionListener(new ActionListener() { // Creates the subtract button.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "-"); // Adds - to the text box.
                try {
                    converter.convert(TopCalcPanel.calculation.getText()); // Adds the values before and after.
                } catch (InfixToPostfixParens.SyntaxErrorException ex) {
                    Logger.getLogger(CalcPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 4;
        c.gridy = 2;
        add(subtractButton, c);

        zeroButton = new JButton("0"); // Button 0.
        zeroButton.addActionListener(new ActionListener() { // Creates the button for 0.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "0"); // Adds 0 to the text box.
                TopCalcPanel.calculationValue = TopCalcPanel.calculationValue + 0; // Adds 0 to the value of the text.
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 3;
        add(zeroButton, c);

        decimalButton = new JButton("."); // Decimal button.
        decimalButton.addActionListener(new ActionListener() { // Creates the decimal button.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "."); // Adds . to the text box.
                try {
                    converter.convert(TopCalcPanel.calculation.getText()); // Adds a decimal to the end of the text box.
                } catch (InfixToPostfixParens.SyntaxErrorException ex) {
                    Logger.getLogger(CalcPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 3;
        add(decimalButton, c);

        equalsButton = new JButton("="); // Equals button.
        equalsButton.addActionListener(new ActionListener() { // Creates the equal button.
            public void actionPerformed(ActionEvent e) {
                try {
                    String temp = converter.convert(TopCalcPanel.calculation.getText()); // Gets the stuff in the text box.
                    TopCalcPanel.calculation.setText(evaluate.evaluatePostfix(temp) + ""); // evalutes the stuff in the text box.
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Error: Bad input."); //catches stuff and such.
                } //bob
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 3;
        add(equalsButton, c);

        leftParentheseButton = new JButton("("); // Left Parenthese Button.
        leftParentheseButton.addActionListener(new ActionListener() { // Creates the left parenthese button.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + "("); // Adds ( to the text box.
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 3;
        c.gridwidth = 1;
        c.gridy = 3;
        add(leftParentheseButton, c);

        rightParentheseButton = new JButton(")"); // Right Parenthese Button.
        rightParentheseButton.addActionListener(new ActionListener() { // Creates the right parenthese button.
            public void actionPerformed(ActionEvent e) {
                TopCalcPanel.calculation.setText(TopCalcPanel.calculation.getText() + ")"); // Adds ) to the text box.
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 4;
        c.gridwidth = 1;
        c.gridy = 3;
        add(rightParentheseButton, c);
    }

    public static CalcPanel getInstance() {
        if (inst == null) {
            inst = new CalcPanel();
        }
        return inst;
    }

    private class ClearPressed
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TopCalcPanel.calculation.setText("");
        }
    }
}
