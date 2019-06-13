import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Chusrfrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chusrfrm frame = new Chusrfrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con = null;
	
	/**
	 * Create the frame.
	 */
	public Chusrfrm() {
		setTitle("Change User");
		con = DbConnector.Connector();
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(81, 43, 282, 171);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 111, 28);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(10, 66, 111, 28);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(131, 14, 141, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String pwd = new String(passwordField.getPassword());
				String sql = "select login_id, password from faculty where login_id = ?";
				String loginid = null;
				String password = null;
				
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, id);
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						loginid = rs.getString("login_id");
						password = rs.getString("password");
					}
					ps.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (id.equals(loginid) && pwd.equals(password)) {
					Glvar.logedinuser = loginid;
					Glvar.logedinusr_pwd = password;
					if (Glvar.openfrm.equals("Mainfrm")) {
						Mainfrm mainfrmobj = new Mainfrm();
						mainfrmobj.setVisible(true);
					}
					else if (Glvar.openfrm.equals("Admainfrm")) {
						Admainfrm admainfrmobj = new Admainfrm();
						admainfrmobj.setVisible(true);
					}
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Id or Password");
				}
			}
		});
		passwordField.setBounds(131, 67, 141, 27);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String pwd = new String(passwordField.getPassword());
				String sql = "select login_id, password from faculty where login_id = ?";
				String loginid = null;
				String password = null;
				
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, id);
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						loginid = rs.getString("login_id");
						password = rs.getString("password");
					}
					ps.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (id.equals(loginid) && pwd.equals(password)) {
					Glvar.logedinuser = loginid;
					Glvar.logedinusr_pwd = password;
					if (Glvar.openfrm.equals("Mainfrm")) {
						Mainfrm mainfrmobj = new Mainfrm();
						mainfrmobj.setVisible(true);
					}
					else if (Glvar.openfrm.equals("Admainfrm")) {
						Admainfrm admainfrmobj = new Admainfrm();
						admainfrmobj.setVisible(true);
					}
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Id or Password");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(10, 133, 111, 28);
		panel.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Glvar.openfrm.equals("Mainfrm")) {
					Mainfrm mainfrmobj = new Mainfrm();
					mainfrmobj.setVisible(true);
				}
				else if (Glvar.openfrm.equals("Admainfrm")) {
					Admainfrm admainfrmobj = new Admainfrm();
					admainfrmobj.setVisible(true);
				}
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancel.setBounds(161, 133, 111, 28);
		panel.add(btnCancel);
	}
}
