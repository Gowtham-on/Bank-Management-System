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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup1 extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, date, month, year;
	JTextField t1, t2, t3, t4, t5, t6, t7;
	JRadioButton r1, r2, r3, r4;
	JComboBox c1, c2, c3;
	JButton b1;

	Connection con;
	PreparedStatement st;

	Random ran = new Random();
	int rn = ran.nextInt() % 10000;
	String id = String.format("%04d", ran.nextInt(10000));

	public Signup1() {

		l1 = new JLabel("APPLICATION FORM NO. " + id);
		l1.setFont(new Font("RaleWay", Font.BOLD, 22));

		l2 = new JLabel("Page 1 Personal Details");
		l2.setFont(new Font("RaleWay", Font.BOLD, 12));

		l3 = new JLabel("Name");
		l3.setFont(new Font("RaleWay", Font.BOLD, 14));

		l4 = new JLabel("Father's Name");
		l4.setFont(new Font("RaleWay", Font.BOLD, 14));

		l5 = new JLabel("DoB");
		l5.setFont(new Font("RaleWay", Font.BOLD, 14));

		date = new JLabel("Date");
		date.setFont(new Font("RaleWay", Font.BOLD, 14));

		month = new JLabel("Month");
		month.setFont(new Font("RaleWay", Font.BOLD, 14));

		year = new JLabel("Year");
		year.setFont(new Font("RaleWay", Font.BOLD, 14));

		l6 = new JLabel("Gender");
		l6.setFont(new Font("RaleWay", Font.BOLD, 14));

		l7 = new JLabel("Email");
		l7.setFont(new Font("RaleWay", Font.BOLD, 14));

		l8 = new JLabel("Marital status");
		l8.setFont(new Font("RaleWay", Font.BOLD, 14));

		l9 = new JLabel("Address");
		l9.setFont(new Font("RaleWay", Font.BOLD, 14));

		l10 = new JLabel("City");
		l10.setFont(new Font("RaleWay", Font.BOLD, 14));

		l11 = new JLabel("Pin code");
		l11.setFont(new Font("RaleWay", Font.BOLD, 14));

		l12 = new JLabel("State");
		l12.setFont(new Font("RaleWay", Font.BOLD, 14));

		t1 = new JTextField();
		t1.setFont(new Font("RaleWay", Font.BOLD, 14));

		t2 = new JTextField();
		t2.setFont(new Font("RaleWay", Font.BOLD, 14));

		t3 = new JTextField();
		t3.setFont(new Font("RaleWay", Font.BOLD, 14));

		t4 = new JTextField();
		t4.setFont(new Font("RaleWay", Font.BOLD, 14));

		t5 = new JTextField();
		t5.setFont(new Font("RaleWay", Font.BOLD, 14));

		t6 = new JTextField();
		t6.setFont(new Font("RaleWay", Font.BOLD, 14));

		t7 = new JTextField();
		t7.setFont(new Font("RaleWay", Font.BOLD, 14));

		b1 = new JButton("Next");
		b1.setFont(new Font("RaleWay", Font.BOLD, 14));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);

		ButtonGroup G1 = new ButtonGroup();
		r1 = new JRadioButton("Male");
		r1.setFont(new Font("RaleWay", Font.BOLD, 14));
		r1.setBackground(Color.WHITE);
		r1.addActionListener(this);

		r2 = new JRadioButton("Female");
		r2.setFont(new Font("RaleWay", Font.BOLD, 14));
		r2.setBackground(Color.WHITE);
		r2.addActionListener(this);

		G1.add(r1);
		G1.add(r2);

		ButtonGroup G2 = new ButtonGroup();

		r3 = new JRadioButton("Married");
		r3.setFont(new Font("RaleWay", Font.BOLD, 14));
		r3.setBackground(Color.WHITE);
		r3.addActionListener(this);

		r4 = new JRadioButton("Unmarried");
		r4.setFont(new Font("RaleWay", Font.BOLD, 14));
		r4.setBackground(Color.WHITE);
		r4.addActionListener(this);

		G2.add(r3);
		G2.add(r4);

		String[] dateArr = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

		String[] monthArr = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		String[] yearArr = { "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001",
				"2002", "2003", "2004", "2005" };

		c1 = new JComboBox<>(dateArr);
		c1.setBackground(Color.WHITE);
		c2 = new JComboBox<>(monthArr);
		c2.setBackground(Color.WHITE);
		c3 = new JComboBox<>(yearArr);
		c3.setBackground(Color.WHITE);

		c1.setSelectedIndex(-1);
		c2.setSelectedIndex(-1);
		c3.setSelectedIndex(-1);

		setLayout(null);

		l1.setBounds(200, 40, 350, 50);
		add(l1);

		l2.setBounds(290, 80, 300, 50);
		add(l2);

		l3.setBounds(150, 130, 300, 50);
		add(l3);

		l4.setBounds(150, 160, 300, 50);
		add(l4);

		l5.setBounds(150, 190, 300, 50);
		add(l5);

		date.setBounds(300, 190, 300, 50);
		add(date);

		c1.setBounds(340, 207, 45, 20);
		add(c1);

		month.setBounds(400, 190, 300, 50);
		add(month);

		c2.setBounds(450, 207, 50, 20);
		add(c2);

		year.setBounds(510, 190, 300, 50);
		add(year);

		c3.setBounds(550, 207, 55, 20);
		add(c3);

		l6.setBounds(150, 220, 300, 50);
		add(l6);

		l7.setBounds(150, 250, 300, 50);
		add(l7);

		l8.setBounds(150, 280, 300, 50);
		add(l8);

		l9.setBounds(150, 310, 300, 50);
		add(l9);

		l10.setBounds(150, 340, 300, 50);
		add(l10);

		l11.setBounds(150, 370, 300, 50);
		add(l11);

		l12.setBounds(150, 400, 300, 50);
		add(l12);

		t1.setBounds(300, 145, 250, 22);
		add(t1);

		t2.setBounds(300, 175, 250, 22);
		add(t2);

		t3.setBounds(300, 265, 250, 22);
		add(t3);

		t4.setBounds(300, 325, 250, 22);
		add(t4);

		t5.setBounds(300, 355, 250, 22);
		add(t5);

		t6.setBounds(300, 385, 250, 22);
		add(t6);

		t7.setBounds(300, 415, 250, 22);
		add(t7);

		b1.setBounds(500, 480, 100, 30);
		add(b1);

		r1.setBounds(300, 237, 100, 18);
		add(r1);

		r2.setBounds(400, 237, 100, 18);
		add(r2);

		r3.setBounds(300, 295, 100, 18);
		add(r3);

		r4.setBounds(400, 295, 100, 18);
		add(r4);

		setTitle("Bank Management System");
		setVisible(true);
		setSize(700, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
	}

	String text1, text2, text3, text4, text5, text6, text7;

	@Override
	public void actionPerformed(ActionEvent e) {

		String final_date = c1.getSelectedItem() + "/" + c2.getSelectedItem() + "/" + c3.getSelectedItem();

		String gender = "";
		if (r1.isSelected()) {
			gender = "M";
		} else if (r2.isSelected()) {
			gender = "F";
		}
		String ms = "";
		if (r3.isSelected()) {
			ms = "Married";
		} else if (r4.isSelected()) {
			ms = "Unmarried";
		}

		if (e.getSource() == b1) {
			if (t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("")
					|| t5.getText().equals("") || t6.getText().equals("") || t7.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Enter all fields");

			} else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms", "root", "Gowtham@123");

					st = con.prepareStatement("insert into pageOne values(?,?,?,?,?,?,?,?,?,?,?)");
					st.setInt(1, Math.abs(rn));
					st.setString(2, t1.getText());
					st.setString(3, t2.getText());
					st.setString(4, final_date);
					st.setString(5, gender);
					st.setString(6, t3.getText());
					st.setString(7, ms);
					st.setString(8, t4.getText());
					st.setString(9, t5.getText());
					st.setString(10, t6.getText());
					st.setString(11, t7.getText());

					int i = st.executeUpdate();
					System.out.println(i + "records changed");

					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				this.setVisible(false);
				new Signup2(Math.abs(rn));
			}

		}

	}
}
