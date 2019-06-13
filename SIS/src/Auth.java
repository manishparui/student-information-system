import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Auth extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auth frame = new Auth();
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
	public Auth() {
		setTitle("Student Information System - Authentication");
		con = DbConnector.Connector();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(935, 520, 383, 227);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(10, 39, 349, 141);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Id :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 60, 26);
		panel.add(lblNewLabel);
		
		JLabel lblUser = new JLabel(Glvar.logedinuser);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUser.setBounds(80, 10, 109, 26);
		panel.add(lblUser);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your password");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPleaseEnterYour.setBounds(10, 46, 179, 26);
		panel.add(lblPleaseEnterYour);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(199, 46, 140, 25);
		panel.add(passwordField);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd = new String(passwordField.getPassword());
				
				if (pwd.equals(Glvar.logedinusr_pwd)) {
					if (Glvar.openfrm.equals("Admainfrm")) {
						try {
							String sql = "DELETE FROM `sis`.`faculty` WHERE (`login_id` = ?)";
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setString(1, Glvar.uid_db);
							int res = ps.executeUpdate();
							if (res > 0) {
								JOptionPane.showMessageDialog(null, "Profile Deleted. Please refresh database.");
								Glvar.stdn_id = null;
								Glvar.stdn_roll = null;
							}
							else
								JOptionPane.showMessageDialog(null, "Unable to delete.");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Glvar.uid_db = null;
						dispose();
					}
					else if (Glvar.openfrm.equals("Mainfrm")) {
						try {
							String sql0 = "DELETE FROM `sis`.`score` WHERE (`roll_no` = ?)";
							PreparedStatement ps0 = con.prepareStatement(sql0);
							ps0.setString(1, Glvar.stdn_roll);
							int res0 = ps0.executeUpdate();
							if (res0 > 0)
								JOptionPane.showMessageDialog(null, "Score card deleted.");
							else
								JOptionPane.showMessageDialog(null, "Unable to delete score card.");
							
							String sql = "DELETE FROM `sis`.`student` WHERE (`id` = ?)";
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setString(1, Glvar.stdn_id);
							int res = ps.executeUpdate();
							if (res > 0)
								JOptionPane.showMessageDialog(null, "Profile deleted. Please refresh database.");
							else
								JOptionPane.showMessageDialog(null, "Unable to delete.");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Wrong password");
				
				
				
			} //end of actionPerformed
		});
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirm.setBounds(10, 110, 109, 21);
		panel.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(230, 110, 109, 21);
		panel.add(btnCancel);
		
		JLabel lblPleaseConfirmYour = new JLabel("Please confirm your password");
		lblPleaseConfirmYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseConfirmYour.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPleaseConfirmYour.setBounds(10, 10, 349, 26);
		contentPane.add(lblPleaseConfirmYour);
	}
}
