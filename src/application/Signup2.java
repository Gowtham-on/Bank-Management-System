package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup2 extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
	JTextField t1, t2;
	JComboBox c1, c2, c3, c4, c5;
	JRadioButton r1, r2, r3, r4;
	JButton b1;
	int appNo = 0;
	Connection con;
	PreparedStatement st;

	ButtonGroup g1, g2;

	public Signup2(int ran) {
		appNo = ran;
		l1 = new JLabel("Page 2: Additional Details");
		l1.setFont(new Font("RaleWay", Font.BOLD, 22));

		l2 = new JLabel("Religion");
		l2.setFont(new Font("RaleWay", Font.BOLD, 14));

		l3 = new JLabel("Category");
		l3.setFont(new Font("RaleWay", Font.BOLD, 14));

		l4 = new JLabel("Income");
		l4.setFont(new Font("RaleWay", Font.BOLD, 14));

		l5 = new JLabel("Edu. Qualification");
		l5.setFont(new Font("RaleWay", Font.BOLD, 14));

		l6 = new JLabel("Occupation");
		l6.setFont(new Font("RaleWay", Font.BOLD, 14));

		l7 = new JLabel("Pan num");
		l7.setFont(new Font("RaleWay", Font.BOLD, 14));

		l8 = new JLabel("Aadhar");
		l8.setFont(new Font("RaleWay", Font.BOLD, 14));

		l9 = new JLabel("Senior Citizen");
		l9.setFont(new Font("RaleWay", Font.BOLD, 14));

		l10 = new JLabel("Existing Account");
		l10.setFont(new Font("RaleWay", Font.BOLD, 14));

		t1 = new JTextField();
		t1.setFont(new Font("RaleWay", Font.BOLD, 14));

		t2 = new JTextField();
		t2.setFont(new Font("RaleWay", Font.BOLD, 14));

		g1 = new ButtonGroup();
		r1 = new JRadioButton("yes");
		r1.setFont(new Font("RaleWay", Font.BOLD, 14));
		r1.setBackground(Color.WHITE);

		r2 = new JRadioButton("no");
		r2.setFont(new Font("RaleWay", Font.BOLD, 14));
		r2.setBackground(Color.WHITE);
		g1.add(r1);
		g1.add(r2);

		g2 = new ButtonGroup();

		r3 = new JRadioButton("yes");
		r3.setFont(new Font("RaleWay", Font.BOLD, 14));
		r3.setBackground(Color.WHITE);

		r4 = new JRadioButton("no");
		r4.setFont(new Font("RaleWay", Font.BOLD, 14));
		r4.setBackground(Color.WHITE);
		g2.add(r3);
		g2.add(r4);

		b1 = new JButton("Next");
		b1.setFont(new Font("RaleWay", Font.BOLD, 14));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);

		String[] c1Arr = { "Hindu", "Muslim", "Christian", "Sikh", "Other" };
		String[] c2Arr = { "General", "OBC", "SC", "ST", "Other" };
		String[] c3Arr = { "null", "<1,50,000", "<2,50,000", "<5,00,000", ">5,00,000" };
		String[] c4Arr = { "Graduate", "Non-Graduate", "Post-Graduate", "Doctrate", "Others" };
		String[] c5Arr = { "Salaried", "Self Employed", "Businness", "Student", "Retired", "Others" };

		c1 = new JComboBox<>(c1Arr);
		c1.setBackground(Color.WHITE);
		c1.setSelectedIndex(-1);

		c2 = new JComboBox<>(c2Arr);
		c2.setBackground(Color.WHITE);
		c2.setSelectedIndex(-1);

		c3 = new JComboBox<>(c3Arr);
		c3.setBackground(Color.WHITE);
		c3.setSelectedIndex(-1);

		c4 = new JComboBox<>(c4Arr);
		c4.setBackground(Color.WHITE);
		c4.setSelectedIndex(-1);

		c5 = new JComboBox<>(c5Arr);
		c5.setBackground(Color.WHITE);
		c5.setSelectedIndex(-1);

		setLayout(null);

		l1.setBounds(220, 40, 350, 50);
		add(l1);

		l2.setBounds(150, 130, 300, 50);
		add(l2);

		l3.setBounds(150, 160, 300, 50);
		add(l3);

		l4.setBounds(150, 190, 300, 50);
		add(l4);

		l5.setBounds(150, 220, 300, 50);
		add(l5);

		l6.setBounds(150, 250, 300, 50);
		add(l6);

		l7.setBounds(150, 280, 300, 50);
		add(l7);

		l8.setBounds(150, 310, 300, 50);
		add(l8);

		l9.setBounds(150, 340, 300, 50);
		add(l9);

		l10.setBounds(150, 370, 300, 50);
		add(l10);

		c1.setBounds(300, 145, 250, 22);
		add(c1);

		c2.setBounds(300, 175, 250, 22);
		add(c2);

		c3.setBounds(300, 207, 250, 22);
		add(c3);

		c4.setBounds(300, 237, 250, 22);
		add(c4);

		c5.setBounds(300, 265, 250, 22);
		add(c5);

		t1.setBounds(300, 295, 250, 22);
		add(t1);

		t2.setBounds(300, 325, 250, 22);
		add(t2);

		r1.setBounds(300, 355, 100, 18);
		add(r1);

		r2.setBounds(420, 355, 100, 18);
		add(r2);

		r3.setBounds(300, 385, 100, 18);
		add(r3);

		r4.setBounds(420, 385, 100, 18);
		add(r4);

		b1.setBounds(500, 450, 100, 30);
		add(b1);

		this.setVisible(true);
		this.setSize(700, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String sc = "";
		if (r1.isSelected()) {
			sc = "Yes";
		} else if (r2.isSelected()) {
			sc = "No";
		}
		String ea = "";
		if (r3.isSelected()) {
			ea = "Yes";
		} else if (r4.isSelected()) {
			ea = "No";
		}
		if (e.getSource() == b1) {

			if (t1.getText().equals("") || t2.getText().equals("") || c1.getSelectedItem().equals(null)
					|| c2.getSelectedItem().equals(null) || c3.getSelectedItem().equals(null)
					|| c4.getSelectedItem().equals(null) || c5.getSelectedItem().equals(null)) {
				JOptionPane.showMessageDialog(null, "Enter all fields");

			} else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms", "root", "Gowtham@123");

					st = con.prepareStatement("insert into pageTwo values(?,?,?,?,?,?,?,?,?,?)");
					st.setInt(1, appNo);
					st.setString(2, (String) c1.getSelectedItem());
					st.setString(3, (String) c2.getSelectedItem());
					st.setString(4, (String) c3.getSelectedItem());
					st.setString(5, (String) c4.getSelectedItem());
					st.setString(6, (String) c5.getSelectedItem());
					st.setString(7, t1.getText());
					st.setString(8, t2.getText());
					st.setString(9, sc);
					st.setString(10, ea);

					int i = st.executeUpdate();
					System.out.println(i + "records changed");

					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				this.setVisible(false);
				new Signup3(appNo);
			}

		}
	}
}
