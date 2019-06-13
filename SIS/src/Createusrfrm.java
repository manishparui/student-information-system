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
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class Createusrfrm extends JFrame {

	private JPanel contentPane;
	private JTextField login_id;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Createusrfrm frame = new Createusrfrm();
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
	public Createusrfrm() {
		setTitle("Create New User");
		con = DbConnector.Connector();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 352);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(67, 72, 303, 177);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(10, 80, 136, 25);
		panel.add(lblPassword);
		
		JLabel lblLoginId = new JLabel("Login Id");
		lblLoginId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLoginId.setBounds(10, 45, 136, 25);
		panel.add(lblLoginId);
		
		login_id = new JTextField();
		login_id.setColumns(10);
		login_id.setBounds(156, 45, 136, 25);
		panel.add(login_id);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 80, 136, 25);
		panel.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginid = login_id.getText();
				String pwd = new String(passwordField.getPassword());
				String sql = "UPDATE `sis`.`faculty` SET `password` = ? WHERE (`login_id` = ?)";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, pwd);
					ps.setString(2, loginid);
					
					int res = ps.executeUpdate();
					if (res > 0) {
						JOptionPane.showMessageDialog(null, "Password created, please loging with your login id & password.");
						//Loginfrm loginfrmobj = new Loginfrm();
						//loginfrmobj.Visible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Unable to create password, please contact your admin.");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(96, 136, 113, 31);
		panel.add(btnNewButton_1);
		
		JLabel lblCreateNewUser = new JLabel("Create new user");
		lblCreateNewUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewUser.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCreateNewUser.setBounds(10, 37, 416, 25);
		contentPane.add(lblCreateNewUser);
		
		JLabel lblContactYourAdmin = new JLabel("Note: contact your admin for Login Id");
		lblContactYourAdmin.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblContactYourAdmin.setBounds(10, 292, 260, 13);
		contentPane.add(lblContactYourAdmin);
	}
}
