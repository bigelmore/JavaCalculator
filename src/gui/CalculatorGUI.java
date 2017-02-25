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
    private JLabel lblResult;

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
	tfEquation.setBounds(10, 36, 209, 20);
	contentPane.add(tfEquation);
	tfEquation.setColumns(10);
	
	JButton btnCalculate = new JButton("Calculate!");
	btnCalculate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    Calculator cal = new Calculator();
		    try{
			cal.setEquation(tfEquation.getText());
			lblResult.setText("The result is: "+cal.operate());
		    }catch(UnsupportedOrderException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
		    }catch(UnsupportedOperatorsException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
		    }
		}
	});
	btnCalculate.setBounds(229, 36, 115, 23);
	contentPane.add(btnCalculate);
	
	lblResult = new JLabel("");
	lblResult.setBounds(10, 67, 209, 14);
	contentPane.add(lblResult);
    }
}
