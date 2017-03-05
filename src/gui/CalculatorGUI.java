package gui;

import calculator.Calculator;
import calculator.UnsupportedOrderException;
import calculator.UnsupportedOperatorsException;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*This class uses the Calculator class.
 * It presents a GUI for the user to put in the 
 * equation and get the result.
 */
public class CalculatorGUI extends JFrame {

    private JPanel contentPane;
    private JTextField tfEquation;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnComma;
    private JButton btn3;
    private JButton btn6;
    private JButton btn9;
    private JButton btnC;
    private JButton btnBs;
    private JButton btn8;
    private JButton btn5;
    private JButton btn2;
    private JButton btn0;
    private JButton btn1;
    private JButton btn4;
    private JButton btn7;
    private JButton btnFactorial;
    private JButton btnLogarithm;
    private JButton btnSIN;
    private JButton btnCOS;
    private JButton btnTAN;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    CalculatorGUI frame = new CalculatorGUI();
		    frame.setVisible(true);
		    } catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public CalculatorGUI() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 516, 402);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblText = new JLabel("Calculator");
	lblText.setBounds(10, 11, 412, 14);
	contentPane.add(lblText);
	
	tfEquation = new JTextField();
	tfEquation.setBounds(10, 36, 412, 20);
	contentPane.add(tfEquation);
	tfEquation.setColumns(10);
	
	JButton btnCalculate = new JButton("=");
	btnCalculate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    Calculator cal = new Calculator();
		    try{
			cal.setEquation(tfEquation.getText());
			tfEquation.setText(String.valueOf(cal.operate()));
		    }catch(UnsupportedOrderException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
		    }catch(UnsupportedOperatorsException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
		    }
		}
	});
	btnCalculate.setBounds(372, 267, 50, 50);
	contentPane.add(btnCalculate);
	
	btnPlus = new JButton("+");
	btnPlus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"+");
		}
	});
	btnPlus.setBounds(372, 217, 50, 50);
	contentPane.add(btnPlus);
	
	btnMinus = new JButton("-");
	btnMinus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"-");
		}
	});
	btnMinus.setBounds(372, 167, 50, 50);
	contentPane.add(btnMinus);
	
	JButton btnTimes = new JButton("X");
	btnTimes.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"*");
		}
	});
	btnTimes.setBounds(372, 117, 50, 50);
	contentPane.add(btnTimes);
	
	JButton btnDivide = new JButton("/");
	btnDivide.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"/");
		}
	});
	btnDivide.setBounds(372, 67, 50, 50);
	contentPane.add(btnDivide);
	
	btnComma = new JButton(",");
	btnComma.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+",");
		}

	});
	btnComma.setBounds(322, 267, 50, 50);
	contentPane.add(btnComma);
	
	btn3 = new JButton("3");
	btn3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"3");
		}
	});
	btn3.setBounds(322, 217, 50, 50);
	contentPane.add(btn3);
	
	btn6 = new JButton("6");
	btn6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"6");
		}
	});
	btn6.setBounds(322, 167, 50, 50);
	contentPane.add(btn6);
	
	btn9 = new JButton("9");
	btn9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"9");
		}
	});
	btn9.setBounds(322, 117, 50, 50);
	contentPane.add(btn9);
	
	btnC = new JButton("C");
	btnC.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText("");
		}
	});
	btnC.setBounds(272, 67, 50, 50);
	contentPane.add(btnC);
	
	btnBs = new JButton("BS");
	btnBs.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(new StringBuilder(tfEquation.getText()).substring(0, tfEquation.getText().length()-1).toString());
		}
	});
	btnBs.setBounds(322, 67, 50, 50);
	contentPane.add(btnBs);
	
	btn8 = new JButton("8");
	btn8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"8");
		}
	});
	btn8.setBounds(272, 117, 50, 50);
	contentPane.add(btn8);
	
	btn5 = new JButton("5");
	btn5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"5");
		}
	});
	btn5.setBounds(272, 167, 50, 50);
	contentPane.add(btn5);
	
	btn2 = new JButton("2");
	btn2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"2");
		}
	});
	btn2.setBounds(272, 217, 50, 50);
	contentPane.add(btn2);
	
	btn0 = new JButton("0");
	btn0.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"0");
		}
	});
	btn0.setBounds(272, 267, 50, 50);
	contentPane.add(btn0);
	
	btn1 = new JButton("1");
	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"1");
		}
	});
	btn1.setBounds(222, 217, 50, 50);
	contentPane.add(btn1);
	
	btn4 = new JButton("4");
	btn4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"4");
		}
	});
	btn4.setBounds(222, 167, 50, 50);
	contentPane.add(btn4);
	
	btn7 = new JButton("7");
	btn7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"7");
		}
	});
	btn7.setBounds(222, 117, 50, 50);
	contentPane.add(btn7);
	
	JButton btnParenthesisClose = new JButton(")");
	btnParenthesisClose.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+")");

		}
	});
	btnParenthesisClose.setBounds(222, 267, 50, 50);
	contentPane.add(btnParenthesisClose);
	
	JButton btnParenthesisOpen = new JButton("(");
	btnParenthesisOpen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"(");

		}
	});
	btnParenthesisOpen.setBounds(162, 267, 60, 50);
	contentPane.add(btnParenthesisOpen);
	
	btnFactorial = new JButton("!");
	btnFactorial.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"!");

		}
	});
	btnFactorial.setBounds(222, 67, 50, 50);
	contentPane.add(btnFactorial);
	
	btnLogarithm = new JButton("log");
	btnLogarithm.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"log(");

		}
	});
	btnLogarithm.setBounds(162, 67, 60, 50);
	contentPane.add(btnLogarithm);
	
	btnSIN = new JButton("sin");
	btnSIN.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"sin(");

		}
	});
	btnSIN.setBounds(162, 117, 60, 50);
	contentPane.add(btnSIN);
	
	btnCOS = new JButton("cos");
	btnCOS.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"cos(");
		}
	});
	btnCOS.setBounds(162, 167, 60, 50);
	contentPane.add(btnCOS);
	
	btnTAN = new JButton("tan");
	btnTAN.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfEquation.setText(tfEquation.getText()+"tan(");
		}
	});
	btnTAN.setBounds(162, 217, 60, 50);
	contentPane.add(btnTAN);
    }
}
