import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

class myFrame extends JFrame implements ActionListener {
	private JPanel displayPanel;
	private JPanel buttonPanel;
	private JTextField display;
	private JButton[] button;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMultiply;
	private JButton btnDivide;
	private JButton btnEqual;
	private JButton btnCE;
	private JLabel prev;
	private JLabel operator;
	private JLabel flag;

	public myFrame() {
		this.setTitle("계산기");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		displayPanel = new JPanel();
		buttonPanel = new JPanel();

		displayPanel.setLayout(new FlowLayout());
		buttonPanel.setLayout(new GridLayout(0, 4, 6, 6));

		display = new JTextField(10);
		displayPanel.add(display);

		button = new JButton[16];

		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton(Integer.toString(i));
			button[i].addActionListener(this);
		}
		btnPlus = new JButton("+");
		btnMinus = new JButton("-");
		btnMultiply = new JButton("*");
		btnDivide = new JButton("/");
		btnEqual = new JButton("=");
		btnCE = new JButton("CE");
		btnPlus.addActionListener(this);
		btnMinus.addActionListener(this);
		btnMultiply.addActionListener(this);
		btnDivide.addActionListener(this);
		btnEqual.addActionListener(this);
		btnCE.addActionListener(this);

		buttonPanel.add(button[7]);
		buttonPanel.add(button[8]);
		buttonPanel.add(button[9]);
		buttonPanel.add(btnPlus);
		buttonPanel.add(button[4]);
		buttonPanel.add(button[5]);
		buttonPanel.add(button[6]);
		buttonPanel.add(btnMinus);
		buttonPanel.add(button[1]);
		buttonPanel.add(button[2]);
		buttonPanel.add(button[3]);
		buttonPanel.add(btnMultiply);
		buttonPanel.add(button[0]);
		buttonPanel.add(btnEqual);
		buttonPanel.add(btnCE);
		buttonPanel.add(btnDivide);

		prev = new JLabel("");
		operator = new JLabel("");
		flag = new JLabel("");

		this.add(displayPanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < button.length; i++) {
			if (e.getSource() == button[i]) {
				if (display.getText().equals("0")) {
					display.setText("" + i);
				} else {
					if (operator.getText().equals("")) {
						display.setText(display.getText() + i);
					} else {
						if (flag.getText().equals("")) {
							display.setText("" + i);
						} else {
							display.setText(display.getText() + i);
						}
					}
				}
			}
		}
		if (e.getSource() == btnEqual) { 
			double num1, num2, result;
			num1 =  Double.parseDouble(prev.getText());
			num2 =  Double.parseDouble(display.getText());
			if (operator.getText().equals("+")) {
				result = num1 + num2;
				display.setText("" + result);
			}
			if (operator.getText().equals("-")) {
				result = num1 - num2;
				display.setText("" + result);
			}
			if (operator.getText().equals("*")) {
				result = num1 * num2;
				display.setText("" + result);
			}
			if (operator.getText().equals("/")) {
				result = num1 / num2;
				display.setText("" + result);
			}
		}
		if (e.getSource() == btnPlus) {
			prev.setText(display.getText());
			operator.setText("+");
		}
		if (e.getSource() == btnMinus) {
			prev.setText(display.getText());
			operator.setText("-");
		}
		if (e.getSource() == btnMultiply) {
			prev.setText(display.getText());
			operator.setText("*");
		}
		if (e.getSource() == btnDivide) {
			prev.setText(display.getText());
			operator.setText("/");
		}
		if (e.getSource() == btnCE) {
			display.setText("0");
			prev.setText("");
			operator.setText("");
		}
	}
}

public class Calculator {
	public static void main(String[] args) {
		myFrame frame = new myFrame();
	}
}