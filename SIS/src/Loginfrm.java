import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Loginfrm {

	private JFrame frmStudentInformationSystem;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginfrm window = new Loginfrm();
					window.frmStudentInformationSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con = null;
	
	/**
	 * Create the application.
	 */
	public Loginfrm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		con = DbConnector.Connector();
		
		frmStudentInformationSystem = new JFrame();
		frmStudentInformationSystem.setResizable(false);
		frmStudentInformationSystem.setBackground(SystemColor.menu);
		frmStudentInformationSystem.getContentPane().setBackground(new Color(176, 224, 230));
		frmStudentInformationSystem.setTitle("Student Information System - Login");
		frmStudentInformationSystem.setBounds(100, 100, 688, 421);
		frmStudentInformationSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentInformationSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(10, 53, 304, 290);
		frmStudentInformationSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLoginId = new JLabel("Login Id");
		lblLoginId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLoginId.setBounds(10, 51, 111, 28);
		panel.add(lblLoginId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(10, 100, 111, 28);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(131, 51, 141, 27);
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
					frmStudentInformationSystem.dispose();
					Mainfrm mainfrmobj = new Mainfrm();
					mainfrmobj.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Id or Password");
				}
			}
		});
		passwordField.setBounds(131, 100, 141, 27);
		panel.add(passwordField);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.addActionListener(new ActionListener() {
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
					frmStudentInformationSystem.dispose();
					Mainfrm mainfrmobj = new Mainfrm();
					mainfrmobj.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Id or Password");
				}
					
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBounds(99, 185, 105, 28);
		panel.add(btnLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(366, 53, 304, 290);
		frmStudentInformationSystem.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Createusrfrm createusrfrmobj = new Createusrfrm();
				createusrfrmobj.setVisible(true);
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSignUp.setBounds(104, 136, 105, 28);
		panel_1.add(btnSignUp);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(335, 53, 10, 124);
		frmStudentInformationSystem.getContentPane().add(panel_2);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOr.setBounds(324, 187, 35, 22);
		frmStudentInformationSystem.getContentPane().add(lblOr);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(335, 219, 10, 124);
		frmStudentInformationSystem.getContentPane().add(panel_3);
	}

	public void Visible(boolean b) {
		Loginfrm window = new Loginfrm();
		window.frmStudentInformationSystem.setVisible(true);
	}
}
