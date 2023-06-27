
//Created by Shivam Pithva 
//Inter as Java Developer Intern at LetGrowMore
// Task 3 : Create a Scientific Calculator

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends JFrame {

    // Defining the private elements which use into project
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton[] operatorButtons;
    private JButton clearButton;
    private JButton equalsButton;
    private JButton decimalButton;
    private JButton backButton;
    private JButton signButton;
    private JPanel buttonPanel;
    Image icon;

    private double num1 = 0;
    private double num2 = 0;
    private char operator;
    private boolean isPositive = true;

    public ScientificCalculator() {

        // setting window (JFrame)
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(350, 600);
        setFocusable(false);
        setLocationRelativeTo(null);

        // JTextField which shows all the calculations
        displayField = new JTextField();
        displayField.setPreferredSize(new Dimension(400, 100));
        displayField.setFont(new Font("Arial", Font.BOLD, 25));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setBackground(Color.WHITE);
        displayField.setEditable(false);

        // main panel which contains all the button for calc
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        functionButtons = new JButton[4]; /* 1 button (squar-root) */
        functionButtons[3] = new JButton("√");
        functionButtons[3].setFont(new Font("Arial", Font.BOLD, 18));
        functionButtons[3].setBackground(new Color(42, 56, 63));
        functionButtons[3].setForeground(Color.white);
        functionButtons[3].setOpaque(true);
        functionButtons[3].setFocusable(false);
        buttonPanel.add(functionButtons[3]);
        functionButtons[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String currentText = displayField.getText();
                double value = Double.parseDouble(currentText);

                displayField.setText(String.valueOf(Math.sqrt(value)));
            }
        });

        operatorButtons = new JButton[5]; /* 2 button (power) */
        operatorButtons[4] = new JButton("^");
        for (int i = 4; i < 5; i++) {
            operatorButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            operatorButtons[i].setBackground(new Color(42, 56, 63));
            operatorButtons[i].setForeground(Color.white);
            operatorButtons[i].setOpaque(true);
            operatorButtons[i].setFocusable(false);
            buttonPanel.add(operatorButtons[i]);
            final int index = i;
            operatorButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String currentText = displayField.getText();
                    num1 = Double.parseDouble(currentText);
                    operator = index == 0 ? '+' : index == 1 ? '-' : index == 2 ? '*' : index == 3 ? '/' : '^';
                    displayField.setText("");
                }
            });
        }

        clearButton = new JButton("C"); /* 3 button (clear) */
        clearButton.setFont(new Font("Arial", Font.BOLD, 18));
        clearButton.setBackground(new Color(239, 111, 0));
        clearButton.setForeground(Color.white);
        clearButton.setOpaque(true);
        clearButton.setFocusable(false);
        buttonPanel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayField.setText("");
            }
        });

        backButton = new JButton("←"); /* 4 button (back) */
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setBackground(new Color(239, 111, 0));
        backButton.setForeground(Color.white);
        backButton.setOpaque(true);
        backButton.setFocusable(false);
        buttonPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String currentText = displayField.getText();
                if (currentText.length() > 0) {
                    displayField.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });

        functionButtons[0] = new JButton("sin"); /* 5 button (sin) */
        functionButtons[1] = new JButton("cos"); /* 6 button (cos) */
        functionButtons[2] = new JButton("tan"); /* 7 button (tan) */

        for (int i = 0; i < 3; i++) {
            functionButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            functionButtons[i].setBackground(new Color(42, 56, 63));
            functionButtons[i].setForeground(Color.white);
            functionButtons[i].setOpaque(true);
            functionButtons[i].setFocusable(false);
            buttonPanel.add(functionButtons[i]);
            final int index = i;
            functionButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String currentText = displayField.getText();
                    double value = Double.parseDouble(currentText);
                    if (index == 0) { // sin
                        displayField.setText(String.valueOf(Math.sin(Math.toRadians(value))));
                    } else if (index == 1) { // cos
                        displayField.setText(String.valueOf(Math.cos(Math.toRadians(value))));
                    } else if (index == 2) { // tan
                        displayField.setText(String.valueOf(Math.tan(Math.toRadians(value))));
                    }
                }
            });
        }

        operatorButtons[3] = new JButton("/"); /* 8 button (/) */
        for (int i = 3; i < 4; i++) {
            operatorButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            operatorButtons[i].setBackground(new Color(89, 114, 126));
            operatorButtons[i].setForeground(Color.white);
            operatorButtons[i].setOpaque(true);
            operatorButtons[i].setFocusable(false);
            buttonPanel.add(operatorButtons[i]);
            final int index = i;
            operatorButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String currentText = displayField.getText();
                    num1 = Double.parseDouble(currentText);
                    operator = index == 0 ? '+' : index == 1 ? '-' : index == 2 ? '*' : index == 3 ? '/' : '^';
                    displayField.setText("");
                }
            });
        }

        numberButtons = new JButton[10]; /* 9,10,11 button (7,8,9) */
        for (int i = 7; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            numberButtons[i].setBackground(new Color(89, 114, 126));
            numberButtons[i].setForeground(Color.white);
            numberButtons[i].setOpaque(true);
            numberButtons[i].setFocusable(false);
            buttonPanel.add(numberButtons[i]);
            final int index = i;
            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String currentText = displayField.getText();
                    displayField.setText(currentText + index);
                }
            });
        }

        operatorButtons[2] = new JButton("*"); /* 12 button (*) */
        for (int i = 2; i < 3; i++) {
            operatorButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            operatorButtons[i].setBackground(new Color(89, 114, 126));
            operatorButtons[i].setForeground(Color.white);
            operatorButtons[i].setOpaque(true);
            operatorButtons[i].setFocusable(false);
            buttonPanel.add(operatorButtons[i]);
            final int index = i;
            operatorButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String currentText = displayField.getText();
                    num1 = Double.parseDouble(currentText);
                    operator = index == 0 ? '+' : index == 1 ? '-' : index == 2 ? '*' : index == 3 ? '/' : '^';
                    displayField.setText("");
                }
            });
        }

        for (int i = 4; i < 7; i++) { /* 13,14,15 button (4,5,6) */
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            numberButtons[i].setBackground(new Color(89, 114, 126));
            numberButtons[i].setForeground(Color.white);
            numberButtons[i].setOpaque(true);
            numberButtons[i].setFocusable(false);
            buttonPanel.add(numberButtons[i]);
            final int index = i;
            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String currentText = displayField.getText();
                    displayField.setText(currentText + index);
                }
            });
        }

        operatorButtons[1] = new JButton("-"); /* 16 button (-) */
        for (int i = 1; i < 2; i++) {
            operatorButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            operatorButtons[i].setBackground(new Color(89, 114, 126));
            operatorButtons[i].setForeground(Color.white);
            operatorButtons[i].setOpaque(true);
            operatorButtons[i].setFocusable(false);
            buttonPanel.add(operatorButtons[i]);
            final int index = i;
            operatorButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String currentText = displayField.getText();
                    num1 = Double.parseDouble(currentText);
                    operator = index == 0 ? '+' : index == 1 ? '-' : index == 2 ? '*' : index == 3 ? '/' : '^';
                    displayField.setText("");
                }
            });
        }

        for (int i = 1; i < 4; i++) { /* 17,18,19 button (1,2,3) */
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            numberButtons[i].setBackground(new Color(89, 114, 126));
            numberButtons[i].setForeground(Color.white);
            numberButtons[i].setOpaque(true);
            numberButtons[i].setFocusable(false);
            buttonPanel.add(numberButtons[i]);
            final int index = i;
            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String currentText = displayField.getText();
                    displayField.setText(currentText + index);
                }
            });
        }

        operatorButtons[0] = new JButton("+"); /* 20 button (+) */
        for (int i = 0; i < 1; i++) {
            operatorButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            operatorButtons[i].setBackground(new Color(89, 114, 126));
            operatorButtons[i].setForeground(Color.white);
            operatorButtons[i].setOpaque(true);
            operatorButtons[i].setFocusable(false);
            buttonPanel.add(operatorButtons[i]);
            final int index = i;
            operatorButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String currentText = displayField.getText();
                    num1 = Double.parseDouble(currentText);
                    operator = index == 0 ? '+' : index == 1 ? '-' : index == 2 ? '*' : index == 3 ? '/' : '^';
                    displayField.setText("");
                }
            });
        }

        signButton = new JButton("±"); /* 21 button (+/-) */
        signButton.setFont(new Font("Arial", Font.BOLD, 18));
        signButton.setBackground(new Color(89, 114, 126));
        signButton.setForeground(Color.white);
        signButton.setOpaque(true);
        signButton.setFocusable(false);
        buttonPanel.add(signButton);
        signButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String currentText = displayField.getText();
                double value = Double.parseDouble(currentText);
                value = isPositive ? -value : Math.abs(value);
                displayField.setText(String.valueOf(value));
                isPositive = !isPositive;
            }
        });

        for (int i = 0; i < 1; i++) { /* 22 button (0) */
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            numberButtons[i].setBackground(new Color(89, 114, 126));
            numberButtons[i].setForeground(Color.white);
            numberButtons[i].setOpaque(true);
            numberButtons[i].setFocusable(false);
            buttonPanel.add(numberButtons[i]);
            final int index = i;
            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String currentText = displayField.getText();
                    displayField.setText(currentText + index);
                }
            });
        }

        decimalButton = new JButton("."); /* 23 button (.) */
        decimalButton.setFont(new Font("Arial", Font.BOLD, 18));
        decimalButton.setBackground(new Color(89, 114, 126));
        decimalButton.setForeground(Color.white);
        decimalButton.setOpaque(true);
        decimalButton.setFocusable(false);
        buttonPanel.add(decimalButton);
        decimalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String currentText = displayField.getText();
                if (!currentText.contains(".")) {
                    displayField.setText(currentText + ".");
                }
            }
        });

        equalsButton = new JButton("="); /* 24 button (=) */
        equalsButton.setFont(new Font("Arial", Font.BOLD, 18));
        equalsButton.setBackground(new Color(77, 97, 106));
        equalsButton.setForeground(Color.white);
        equalsButton.setOpaque(true);
        equalsButton.setFocusable(false);
        buttonPanel.add(equalsButton);
        equalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String currentText = displayField.getText();
                num2 = Double.parseDouble(currentText);
                double result = 0;

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    case '^':
                        result = Math.pow(num1, num2);
                        break;
                }

                displayField.setText(String.valueOf(result));
            }
        });

        setLayout(new BorderLayout());
        add(displayField, BorderLayout.NORTH); /*displays the textfield into jframe */
        add(buttonPanel, BorderLayout.CENTER); /*displays the buttonpanel into frame */
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ScientificCalculator calculator = new ScientificCalculator();
                calculator.setVisible(true);

            }
        });
    }
}
