package application;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class DisplayOptions extends JFrame {
	
	JLabel l1,l2,l3,l4;
	JButton b1,b2,b3;
	JSeparator s1, s2,s3;
	String name;
	Connection con;
	PreparedStatement st,st1;
	
	public DisplayOptions(String s) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bms", "root",
					"Gowtham@123");

			st = con.prepareStatement("select Application_No from pageThree where Card_Number = ?;");
			st.setString(1,s);
			
			ResultSet rs = st.executeQuery();
			rs.next();
			int num = rs.getInt("Application_No");

			st1 = con.prepareStatement("select Name_ from pageOne where Application_No = ?;");
			st1.setInt(1, num);
			
			ResultSet rs1 = st1.executeQuery();
			rs1.next();
			name= rs1.getString("Name_");


			con.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		
		s1 = new JSeparator();
		s1.setBounds(0, 85, 684, 2);
		getContentPane().add(s1);
		
		l1 = new JLabel(name);
		l1.setFont(new Font("RaleWay", Font.BOLD, 22));
		
		
		setLayout(null);
		
		l1.setBounds(20, 15, 150, 20);
		add(l1);
		
		setVisible(true);
		setSize(600, 450);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
	}

}
