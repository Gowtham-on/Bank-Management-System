package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup3 extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
	JRadioButton r1, r2, r3, r4;
	JCheckBox cb1, cb2, cb3, cb4, cb5, cb6;
	JButton b1, b2;
	JTextField t1;
	int appNo = 0;
	Connection con;
	PreparedStatement st;
	Random ran = new Random();
	long first14 = (long) ((ran.nextDouble() * 100000000000000L) + 8600000000000000L);
	int last4 = (int) (first14 % 10000);
	String CNo = String.valueOf(first14);

	public Signup3(int ran) {
		appNo = ran;
		l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("RaleWay", Font.BOLD, 22));

		l2 = new JLabel("Account Type:");
		l2.setFont(new Font("RaleWay", Font.BOLD, 16));

		ButtonGroup g1 = new ButtonGroup();
		r1 = new JRadioButton("Savings Account");
		r1.setFont(new Font("RaleWay", Font.BOLD, 12));
		r1.setBackground(Color.WHITE);

		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("RaleWay", Font.BOLD, 12));
		r2.setBackground(Color.WHITE);

		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("RaleWay", Font.BOLD, 12));
		r3.setBackground(Color.WHITE);

		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("RaleWay", Font.BOLD, 12));
		r4.setBackground(Color.WHITE);
		g1.add(r1);
		g1.add(r2);
		g1.add(r3);
		g1.add(r4);

		l3 = new JLabel("Card Number:");
		l3.setFont(new Font("RaleWay", Font.BOLD, 16));

		l4 = new JLabel("(Your 16-digit Card Number)");
		l4.setFont(new Font("RaleWay", Font.BOLD, 10));

		l5 = new JLabel("XXXX-XXXX-XXXX-" + last4);
		l5.setFont(new Font("RaleWay", Font.BOLD, 16));

		l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
		l6.setFont(new Font("RaleWay", Font.BOLD, 10));

		l7 = new JLabel("PIN:");
		l7.setFont(new Font("RaleWay", Font.BOLD, 16));

		l8 = new JLabel("(4-digit password)");
		l8.setFont(new Font("RaleWay", Font.BOLD, 10));

		t1 = new JTextField();
		t1.setFont(new Font("RaleWay", Font.BOLD, 16));

		l10 = new JLabel("Services Required:");
		l10.setFont(new Font("RaleWay", Font.BOLD, 16));

		cb1 = new JCheckBox("ATM Card");
		cb1.setFont(new Font("RaleWay", Font.BOLD, 14));
		cb1.setBackground(Color.WHITE);

		cb2 = new JCheckBox("Internet Banking");
		cb2.setFont(new Font("RaleWay", Font.BOLD, 14));
		cb2.setBackground(Color.WHITE);

		cb3 = new JCheckBox("Mobile Banking");
		cb3.setFont(new Font("RaleWay", Font.BOLD, 14));
		cb3.setBackground(Color.WHITE);

		cb4 = new JCheckBox("Email Alerts");
		cb4.setFont(new Font("RaleWay", Font.BOLD, 14));
		cb4.setBackground(Color.WHITE);

		cb5 = new JCheckBox("Cheque Book");
		cb5.setFont(new Font("RaleWay", Font.BOLD, 14));
		cb5.setBackground(Color.WHITE);

		cb6 = new JCheckBox("E-Statement");
		cb6.setFont(new Font("RaleWay", Font.BOLD, 14));
		cb6.setBackground(Color.WHITE);

		b1 = new JButton("Submit");
		b1.setFont(new Font("RaleWay", Font.BOLD, 14));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);

		b2 = new JButton("Cancel");
		b2.setFont(new Font("RaleWay", Font.BOLD, 14));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);

		setLayout(null);

		l1.setBounds(250, 30, 350, 50);
		add(l1);

		l2.setBounds(150, 100, 350, 50);
		add(l2);

		r1.setBounds(150, 140, 200, 35);
		add(r1);

		r2.setBounds(350, 140, 200, 35);
		add(r2);

		r3.setBounds(150, 170, 200, 35);
		add(r3);

		r4.setBounds(350, 170, 200, 35);
		add(r4);

		l3.setBounds(150, 220, 350, 50);
		add(l3);

		l4.setBounds(150, 240, 350, 50);
		add(l4);

		l5.setBounds(330, 220, 350, 50);
		add(l5);

		l6.setBounds(330, 240, 350, 50);
		add(l6);

		l7.setBounds(150, 290, 350, 50);
		add(l7);

		l8.setBounds(150, 310, 350, 50);
		add(l8);

		t1.setBounds(330, 290, 250, 22);
		add(t1);

		l10.setBounds(150, 350, 350, 50);
		add(l10);

		cb1.setBounds(150, 390, 150, 35);
		add(cb1);

		cb2.setBounds(350, 390, 150, 35);
		add(cb2);

		cb3.setBounds(150, 420, 150, 35);
		add(cb3);

		cb4.setBounds(350, 420, 150, 35);
		add(cb4);

		cb5.setBounds(150, 450, 150, 35);
		add(cb5);

		cb6.setBounds(350, 450, 150, 35);
		add(cb6);

		b1.setBounds(230, 525, 90, 30);
		add(b1);

		b2.setBounds(350, 525, 90, 30);
		add(b2);

		this.setVisible(true);
		this.setSize(700, 650);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b2)
			this.setVisible(false);

		String accType = "";
		if (r1.isSelected()) {
			accType = "Savings Account";
		} else if (r2.isSelected()) {
			accType = "Fixed Deposit Account";
		} else if (r3.isSelected()) {
			accType = "Current Account";
		} else if (r4.isSelected()) {
			accType = "Recurring Deposit Account";
		}
//		ATM Card  Internet Banking       
		String services = "";
		if (cb1.isSelected()) {
			services += "ATM Card";
		}
		if (cb2.isSelected()) {
			services += ", Internet Banking";
		}
		if (cb3.isSelected()) {
			services += ", Mobile Banking";
		}
		if (cb4.isSelected()) {
			services += ", Email Alerts";
		}
		if (cb5.isSelected()) {
			services += ", Cheque Book";
		}
		if (cb6.isSelected()) {
			services += ", E-Statement";
		}

		if (e.getSource() == b1) {
			if (t1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Enter PIN number");

			} else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms", "root", "Gowtham@123");

					st = con.prepareStatement("insert into pageThree values(?,?,?,?,?)");
					st.setInt(1, appNo);
					st.setString(2, accType);
					st.setString(3, CNo);
					st.setString(4, t1.getText());
					st.setString(5, services);

					int i = st.executeUpdate();
					System.out.println(i + "records changed");

					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Your card number: " + CNo + "\n" + "Your PIN: " + t1.getText());
				this.setVisible(false);
			}

		}
	}
}
