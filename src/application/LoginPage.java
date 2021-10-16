package application;

import java.awt.Color;
import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame implements ActionListener {
	JLabel l1, l2, l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1, b2, b3;
	
	Connection con;
	PreparedStatement st;

	public LoginPage() {

		l1 = new JLabel("BANK MANAGEMENT SYSTEM");
		l1.setFont(new Font("RaleWay", Font.BOLD, 22));

		l2 = new JLabel("Card Number");
		l2.setFont(new Font("RaleWay", Font.BOLD, 18));

		l3 = new JLabel("PIN");
		l3.setFont(new Font("RaleWay", Font.BOLD, 18));

		t1 = new JTextField();
		t1.setFont(new Font("RaleWay", Font.BOLD, 14));

		t2 = new JPasswordField();
		t2.setFont(new Font("RaleWay", Font.BOLD, 14));

		b1 = new JButton("Login");
		b1.setFont(new Font("RaleWay", Font.BOLD, 14));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);

		b2 = new JButton("Clear");
		b2.setFont(new Font("RaleWay", Font.BOLD, 14));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);

		b3 = new JButton("Signup");
		b3.setFont(new Font("RaleWay", Font.BOLD, 14));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);

		setLayout(null);

		l1.setBounds(200, 40, 400, 50);
		add(l1);

		l2.setBounds(180, 160, 300, 50);
		add(l2);

		l3.setBounds(180, 220, 300, 50);
		add(l3);

		t1.setBounds(330, 173, 220, 25);
		add(t1);

		t2.setBounds(330, 233, 220, 25);
		add(t2);

		b1.setBounds(220, 290, 120, 30);
		add(b1);

		b2.setBounds(360, 290, 120, 30);
		add(b2);

		b3.setBounds(290, 340, 120, 30);
		add(b3);

		this.setVisible(true);
		this.setSize(700, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cn = t1.getText();
		String pin = t2.getText();
//		System.out.println(pin);
		
		if (e.getSource() == b1) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/bms", "root",
						"Gowtham@123");

				st = con.prepareStatement("select pin from pageThree where Card_Number = ?;");
				st.setString(1, cn);
				
				ResultSet rs = st.executeQuery();
				rs.next();
				String res = rs.getString("pin");
				
				if(res.equals(pin)) {
					this.setVisible(false);
					new DisplayOptions(t1.getText());
				} else{
					JOptionPane.showMessageDialog(null, "Card number and Password are incorrect");
				}
				
				con.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == b2) {
			t1.setText("");
			t2.setText("");
		}
		if (e.getSource() == b3) {
			this.setVisible(false);
			new Signup1();
		}
	}
}
