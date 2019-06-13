import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Scorecardfrm extends JFrame {

	private JPanel contentPane;
	private JTextField sem1sub1;
	private JTextField sem1avg;
	private JTextField sem1sub2;
	private JTextField sem1sub3;
	private JTextField sem1sub4;
	private JTextField sem1sub5;
	private JTextField sem1sub6;
	private JTextField sem1sub7;
	private JTextField sem1sub8;
	private JTextField sem2sub1;
	private JTextField sem2avg;
	private JTextField sem2sub2;
	private JTextField sem2sub3;
	private JTextField sem2sub4;
	private JTextField sem2sub5;
	private JTextField sem2sub6;
	private JTextField sem2sub7;
	private JTextField sem2sub8;
	private JTextField sem3sub1;
	private JTextField sem3avg;
	private JTextField sem3sub2;
	private JTextField sem3sub3;
	private JTextField sem3sub4;
	private JTextField sem3sub5;
	private JTextField sem3sub6;
	private JTextField sem3sub7;
	private JTextField sem3sub8;
	private JTextField sem4sub1;
	private JTextField sem4avg;
	private JTextField sem4sub2;
	private JTextField sem4sub3;
	private JTextField sem4sub4;
	private JTextField sem4sub5;
	private JTextField sem4sub6;
	private JTextField sem4sub7;
	private JTextField sem4sub8;
	private JTextField sem5sub1;
	private JTextField sem5avg;
	private JTextField sem5sub2;
	private JTextField sem5sub3;
	private JTextField sem5sub4;
	private JTextField sem5sub5;
	private JTextField sem5sub6;
	private JTextField sem5sub7;
	private JTextField sem5sub8;
	private JTextField sem6sub1;
	private JTextField sem6avg;
	private JTextField sem6sub2;
	private JTextField sem6sub3;
	private JTextField sem6sub4;
	private JTextField sem6sub5;
	private JTextField sem6sub6;
	private JTextField sem6sub7;
	private JTextField sem6sub8;
	private JTextField roll;
	private JTextField reg;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scorecardfrm frame = new Scorecardfrm();
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
	public Scorecardfrm() {
		setTitle("Student Information System - Score Card");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					String sql1 = "SELECT fname, lname, reg_no, roll_no FROM sis.student where id = ?";
					PreparedStatement ps1 = con.prepareStatement(sql1);
					ps1.setString(1, Glvar.stdn_id);
					ResultSet rs1 = ps1.executeQuery();
					while (rs1.next()) {
						reg.setText(rs1.getString("reg_no"));
						roll.setText(rs1.getString("roll_no"));
						String fullname = rs1.getString("fname") + " " + rs1.getString("lname");
						name.setText(fullname);
					}
					ps1.close();
					
					String sql2 = "SELECT * FROM sis.score where roll_no = ?";
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ps2.setString(1, Glvar.stdn_roll);
					ResultSet rs2 = ps2.executeQuery();
					while (rs2.next()) {
						sem1sub1.setText(rs2.getString("sem1sub1"));
						sem1sub2.setText(rs2.getString("sem1sub2"));
						sem1sub3.setText(rs2.getString("sem1sub3"));
						sem1sub4.setText(rs2.getString("sem1sub4"));
						sem1sub5.setText(rs2.getString("sem1sub5"));
						sem1sub6.setText(rs2.getString("sem1sub6"));
						sem1sub7.setText(rs2.getString("sem1sub7"));
						sem1sub8.setText(rs2.getString("sem1sub8"));
						sem1avg.setText(rs2.getString("sem1avg"));

						sem2sub1.setText(rs2.getString("sem2sub1"));
						sem2sub2.setText(rs2.getString("sem2sub2"));
						sem2sub3.setText(rs2.getString("sem2sub3"));
						sem2sub4.setText(rs2.getString("sem2sub4"));
						sem2sub5.setText(rs2.getString("sem2sub5"));
						sem2sub6.setText(rs2.getString("sem2sub6"));
						sem2sub7.setText(rs2.getString("sem2sub7"));
						sem2sub8.setText(rs2.getString("sem2sub8"));
						sem2avg.setText(rs2.getString("sem2avg"));

						sem3sub1.setText(rs2.getString("sem3sub1"));
						sem3sub2.setText(rs2.getString("sem3sub2"));
						sem3sub3.setText(rs2.getString("sem3sub3"));
						sem3sub4.setText(rs2.getString("sem3sub4"));
						sem3sub5.setText(rs2.getString("sem3sub5"));
						sem3sub6.setText(rs2.getString("sem3sub6"));
						sem3sub7.setText(rs2.getString("sem3sub7"));
						sem3sub8.setText(rs2.getString("sem3sub8"));
						sem3avg.setText(rs2.getString("sem3avg"));

						sem4sub1.setText(rs2.getString("sem4sub1"));
						sem4sub2.setText(rs2.getString("sem4sub2"));
						sem4sub3.setText(rs2.getString("sem4sub3"));
						sem4sub4.setText(rs2.getString("sem4sub4"));
						sem4sub5.setText(rs2.getString("sem4sub5"));
						sem4sub6.setText(rs2.getString("sem4sub6"));
						sem4sub7.setText(rs2.getString("sem4sub7"));
						sem4sub8.setText(rs2.getString("sem4sub8"));
						sem4avg.setText(rs2.getString("sem4avg"));

						sem5sub1.setText(rs2.getString("sem5sub1"));
						sem5sub2.setText(rs2.getString("sem5sub2"));
						sem5sub3.setText(rs2.getString("sem5sub3"));
						sem5sub4.setText(rs2.getString("sem5sub4"));
						sem5sub5.setText(rs2.getString("sem5sub5"));
						sem5sub6.setText(rs2.getString("sem5sub6"));
						sem5sub7.setText(rs2.getString("sem5sub7"));
						sem5sub8.setText(rs2.getString("sem5sub8"));
						sem5avg.setText(rs2.getString("sem5avg"));

						sem6sub1.setText(rs2.getString("sem6sub1"));
						sem6sub2.setText(rs2.getString("sem6sub2"));
						sem6sub3.setText(rs2.getString("sem6sub3"));
						sem6sub4.setText(rs2.getString("sem6sub4"));
						sem6sub5.setText(rs2.getString("sem6sub5"));
						sem6sub6.setText(rs2.getString("sem6sub6"));
						sem6sub7.setText(rs2.getString("sem6sub7"));
						sem6sub8.setText(rs2.getString("sem6sub8"));
						sem6avg.setText(rs2.getString("sem6avg"));
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		con = DbConnector.Connector();
		
		String namedb = null;
		String rolldb = null;
		String regdb = null;
		
		String sem1sub1db = null;
		String sem1sub2db = null;
		String sem1sub3db = null;
		String sem1sub4db = null;
		String sem1sub5db = null;
		String sem1sub6db = null;
		String sem1sub7db = null;
		String sem1sub8db = null;
		String sem1avgdb = null;
		
		String sem2sub1db = null;
		String sem2sub2db = null;
		String sem2sub3db = null;
		String sem2sub4db = null;
		String sem2sub5db = null;
		String sem2sub6db = null;
		String sem2sub7db = null;
		String sem2sub8db = null;
		String sem2avgdb = null;
		
		String sem3sub1db = null;
		String sem3sub2db = null;
		String sem3sub3db = null;
		String sem3sub4db = null;
		String sem3sub5db = null;
		String sem3sub6db = null;
		String sem3sub7db = null;
		String sem3sub8db = null;
		String sem3avgdb = null;
		
		String sem4sub1db = null;
		String sem4sub2db = null;
		String sem4sub3db = null;
		String sem4sub4db = null;
		String sem4sub5db = null;
		String sem4sub6db = null;
		String sem4sub7db = null;
		String sem4sub8db = null;
		String sem4avgdb = null;
		
		String sem5sub1db = null;
		String sem5sub2db = null;
		String sem5sub3db = null;
		String sem5sub4db = null;
		String sem5sub5db = null;
		String sem5sub6db = null;
		String sem5sub7db = null;
		String sem5sub8db = null;
		String sem5avgdb = null;
		
		String sem6sub1db = null;
		String sem6sub2db = null;
		String sem6sub3db = null;
		String sem6sub4db = null;
		String sem6sub5db = null;
		String sem6sub6db = null;
		String sem6sub7db = null;
		String sem6sub8db = null;
		String sem6avgdb = null;
		
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(197, 30, 1128, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(10, 675, 1097, 28);
		contentPane.add(panel);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = btnEdit.getText();
				if (txt.equals("Edit")) {
					boolean bt = true;
					
					btnEdit.setText("Update");
					
					sem1sub1.setEditable(bt);
					sem1avg.setEditable(bt);
					sem1sub2.setEditable(bt);
					sem1sub3.setEditable(bt);
					sem1sub4.setEditable(bt);
					sem1sub5.setEditable(bt);
					sem1sub6.setEditable(bt);
					sem1sub7.setEditable(bt);
					sem1sub8.setEditable(bt);
					sem2sub1.setEditable(bt);
					sem2avg.setEditable(bt);
					sem2sub2.setEditable(bt);
					sem2sub3.setEditable(bt);
					sem2sub4.setEditable(bt);
					sem2sub5.setEditable(bt);
					sem2sub6.setEditable(bt);
					sem2sub7.setEditable(bt);
					sem2sub8.setEditable(bt);
					sem3sub1.setEditable(bt);
					sem3avg.setEditable(bt);
					sem3sub2.setEditable(bt);
					sem3sub3.setEditable(bt);
					sem3sub4.setEditable(bt);
					sem3sub5.setEditable(bt);
					sem3sub6.setEditable(bt);
					sem3sub7.setEditable(bt);
					sem3sub8.setEditable(bt);
					sem4sub1.setEditable(bt);
					sem4avg.setEditable(bt);
					sem4sub2.setEditable(bt);
					sem4sub3.setEditable(bt);
					sem4sub4.setEditable(bt);
					sem4sub5.setEditable(bt);
					sem4sub6.setEditable(bt);
					sem4sub7.setEditable(bt);
					sem4sub8.setEditable(bt);
					sem5sub1.setEditable(bt);
					sem5avg.setEditable(bt);
					sem5sub2.setEditable(bt);
					sem5sub3.setEditable(bt);
					sem5sub4.setEditable(bt);
					sem5sub5.setEditable(bt);
					sem5sub6.setEditable(bt);
					sem5sub7.setEditable(bt);
					sem5sub8.setEditable(bt);
					sem6sub1.setEditable(bt);
					sem6avg.setEditable(bt);
					sem6sub2.setEditable(bt);
					sem6sub3.setEditable(bt);
					sem6sub4.setEditable(bt);
					sem6sub5.setEditable(bt);
					sem6sub6.setEditable(bt);
					sem6sub7.setEditable(bt);
					sem6sub8.setEditable(bt);
					
				}
				else if (txt.equals("Update")) {
					btnEdit.setText("Edit");
					
					try {
						String sql = "UPDATE `sis`.`score` SET `sem1sub1` = ?, `sem1sub2` = ?, `sem1sub3` = ?, `sem1sub4` = ?, `sem1sub5` = ?, `sem1sub6` = ?, `sem1sub7` = ?, `sem1sub8` = ?, `sem1avg` = ?, `sem2sub1` = ?, `sem2sub2` = ?, `sem2sub3` = ?, `sem2sub4` = ?, `sem2sub5` = ?, `sem2sub6` = ?, `sem2sub7` = ?, `sem2sub8` = ?, `sem2avg` = ?, `sem3sub1` = ?, `sem3sub2` = ?, `sem3sub3` = ?, `sem3sub4` = ?, `sem3sub5` = ?, `sem3sub6` = ?, `sem3sub7` = ?, `sem3sub8` = ?, `sem3avg` = ?, `sem4sub1` = ?, `sem4sub2` = ?, `sem4sub3` = ?, `sem4sub4` = ?, `sem4sub5` = ?, `sem4sub6` = ?, `sem4sub7` = ?, `sem4sub8` = ?, `sem4avg` = ?, `sem5sub1` = ?, `sem5sub2` = ?, `sem5sub3` = ?, `sem5sub4` = ?, `sem5sub5` = ?, `sem5sub6` = ?, `sem5sub7` = ?, `sem5sub8` = ?, `sem5avg` = ?, `sem6sub1` = ?, `sem6sub2` = ?, `sem6sub3` = ?, `sem6sub4` = ?, `sem6sub5` = ?, `sem6sub6` = ?, `sem6sub7` = ?, `sem6sub8` = ?, `sem6avg` = ? WHERE (`roll_no` = ?)";
						PreparedStatement ps = con.prepareStatement(sql);
						
						ps.setString(1, sem1sub1.getText());
						ps.setString(2, sem1sub2.getText());
						ps.setString(3, sem1sub3.getText());
						ps.setString(4, sem1sub4.getText());
						ps.setString(5, sem1sub5.getText());
						ps.setString(6, sem1sub6.getText());
						ps.setString(7, sem1sub7.getText());
						ps.setString(8, sem1sub8.getText());
						ps.setString(9, sem1avg.getText());

						ps.setString(10, sem2sub1.getText());
						ps.setString(11, sem2sub2.getText());
						ps.setString(12, sem2sub3.getText());
						ps.setString(13, sem2sub4.getText());
						ps.setString(14, sem2sub5.getText());
						ps.setString(15, sem2sub6.getText());
						ps.setString(16, sem2sub7.getText());
						ps.setString(17, sem2sub8.getText());
						ps.setString(18, sem2avg.getText());

						ps.setString(19, sem3sub1.getText());
						ps.setString(20, sem3sub2.getText());
						ps.setString(21, sem3sub3.getText());
						ps.setString(22, sem3sub4.getText());
						ps.setString(23, sem3sub5.getText());
						ps.setString(24, sem3sub6.getText());
						ps.setString(25, sem3sub7.getText());
						ps.setString(26, sem3sub8.getText());
						ps.setString(27, sem3avg.getText());

						ps.setString(28, sem4sub1.getText());
						ps.setString(29, sem4sub2.getText());
						ps.setString(30, sem4sub3.getText());
						ps.setString(31, sem4sub4.getText());
						ps.setString(32, sem4sub5.getText());
						ps.setString(33, sem4sub6.getText());
						ps.setString(34, sem4sub7.getText());
						ps.setString(35, sem4sub8.getText());
						ps.setString(36, sem4avg.getText());

						ps.setString(37, sem5sub1.getText());
						ps.setString(38, sem5sub2.getText());
						ps.setString(39, sem5sub3.getText());
						ps.setString(40, sem5sub4.getText());
						ps.setString(41, sem5sub5.getText());
						ps.setString(42, sem5sub6.getText());
						ps.setString(43, sem5sub7.getText());
						ps.setString(44, sem5sub8.getText());
						ps.setString(45, sem5avg.getText());

						ps.setString(46, sem6sub1.getText());
						ps.setString(47, sem6sub2.getText());
						ps.setString(48, sem6sub3.getText());
						ps.setString(49, sem6sub4.getText());
						ps.setString(50, sem6sub5.getText());
						ps.setString(51, sem6sub6.getText());
						ps.setString(52, sem6sub7.getText());
						ps.setString(53, sem6sub8.getText());
						ps.setString(54, sem6avg.getText());
						
						ps.setString(55, Glvar.stdn_roll);
						
						int res = ps.executeUpdate();
						if (res > 0)
							JOptionPane.showMessageDialog(null, "Score card updated.");
						else
							JOptionPane.showMessageDialog(null, "Unable to update");
						
						boolean bf = false;
						
						sem1sub1.setEditable(bf);
						sem1avg.setEditable(bf);
						sem1sub2.setEditable(bf);
						sem1sub3.setEditable(bf);
						sem1sub4.setEditable(bf);
						sem1sub5.setEditable(bf);
						sem1sub6.setEditable(bf);
						sem1sub7.setEditable(bf);
						sem1sub8.setEditable(bf);
						sem2sub1.setEditable(bf);
						sem2avg.setEditable(bf);
						sem2sub2.setEditable(bf);
						sem2sub3.setEditable(bf);
						sem2sub4.setEditable(bf);
						sem2sub5.setEditable(bf);
						sem2sub6.setEditable(bf);
						sem2sub7.setEditable(bf);
						sem2sub8.setEditable(bf);
						sem3sub1.setEditable(bf);
						sem3avg.setEditable(bf);
						sem3sub2.setEditable(bf);
						sem3sub3.setEditable(bf);
						sem3sub4.setEditable(bf);
						sem3sub5.setEditable(bf);
						sem3sub6.setEditable(bf);
						sem3sub7.setEditable(bf);
						sem3sub8.setEditable(bf);
						sem4sub1.setEditable(bf);
						sem4avg.setEditable(bf);
						sem4sub2.setEditable(bf);
						sem4sub3.setEditable(bf);
						sem4sub4.setEditable(bf);
						sem4sub5.setEditable(bf);
						sem4sub6.setEditable(bf);
						sem4sub7.setEditable(bf);
						sem4sub8.setEditable(bf);
						sem5sub1.setEditable(bf);
						sem5avg.setEditable(bf);
						sem5sub2.setEditable(bf);
						sem5sub3.setEditable(bf);
						sem5sub4.setEditable(bf);
						sem5sub5.setEditable(bf);
						sem5sub6.setEditable(bf);
						sem5sub7.setEditable(bf);
						sem5sub8.setEditable(bf);
						sem6sub1.setEditable(bf);
						sem6avg.setEditable(bf);
						sem6sub2.setEditable(bf);
						sem6sub3.setEditable(bf);
						sem6sub4.setEditable(bf);
						sem6sub5.setEditable(bf);
						sem6sub6.setEditable(bf);
						sem6sub7.setEditable(bf);
						sem6sub8.setEditable(bf);
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				boolean bf = false;
				
				
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdit.setBounds(10, 0, 85, 28);
		panel.add(btnEdit);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(1002, 0, 85, 28);
		panel.add(button_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(176, 224, 230));
		panel_7.setBounds(10, 136, 1097, 478);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 359, 234);
		panel_7.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Semester 1");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 10, 339, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Subject 1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 46, 90, 26);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblSubject = new JLabel("Subject 2");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject.setBounds(10, 82, 90, 26);
		panel_1.add(lblSubject);
		
		JLabel lblSubject_1 = new JLabel("Subject 3");
		lblSubject_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject_1.setBounds(10, 118, 90, 26);
		panel_1.add(lblSubject_1);
		
		JLabel lblSubject_2 = new JLabel("Subject 4");
		lblSubject_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject_2.setBounds(10, 154, 90, 26);
		panel_1.add(lblSubject_2);
		
		JLabel lblSubject_3 = new JLabel("Subject 5");
		lblSubject_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject_3.setBounds(167, 46, 90, 26);
		panel_1.add(lblSubject_3);
		
		JLabel lblSubject_4 = new JLabel("Subject 6");
		lblSubject_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject_4.setBounds(167, 82, 90, 26);
		panel_1.add(lblSubject_4);
		
		JLabel lblSubject_5 = new JLabel("Subject 7");
		lblSubject_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject_5.setBounds(167, 118, 90, 26);
		panel_1.add(lblSubject_5);
		
		JLabel lblSubject_6 = new JLabel("Subject 8");
		lblSubject_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject_6.setBounds(167, 154, 90, 26);
		panel_1.add(lblSubject_6);
		
		JLabel lblSemesterAverage = new JLabel("Semester average");
		lblSemesterAverage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSemesterAverage.setBounds(10, 193, 147, 26);
		panel_1.add(lblSemesterAverage);
		
		sem1avg = new JTextField();
		sem1avg.setEditable(false);
		sem1avg.setColumns(10);
		sem1avg.setBounds(167, 193, 90, 26);
		panel_1.add(sem1avg);
		
		sem1sub1 = new JTextField();
		sem1sub1.setEditable(false);
		sem1sub1.setColumns(10);
		sem1sub1.setBounds(110, 46, 47, 26);
		panel_1.add(sem1sub1);
		
		sem1sub2 = new JTextField();
		sem1sub2.setEditable(false);
		sem1sub2.setColumns(10);
		sem1sub2.setBounds(110, 82, 47, 26);
		panel_1.add(sem1sub2);
		
		sem1sub3 = new JTextField();
		sem1sub3.setEditable(false);
		sem1sub3.setColumns(10);
		sem1sub3.setBounds(110, 118, 47, 26);
		panel_1.add(sem1sub3);
		
		sem1sub4 = new JTextField();
		sem1sub4.setEditable(false);
		sem1sub4.setColumns(10);
		sem1sub4.setBounds(110, 154, 47, 26);
		panel_1.add(sem1sub4);
		
		sem1sub5 = new JTextField();
		sem1sub5.setEditable(false);
		sem1sub5.setColumns(10);
		sem1sub5.setBounds(267, 46, 47, 26);
		panel_1.add(sem1sub5);
		
		sem1sub6 = new JTextField();
		sem1sub6.setEditable(false);
		sem1sub6.setColumns(10);
		sem1sub6.setBounds(267, 82, 47, 26);
		panel_1.add(sem1sub6);
		
		sem1sub7 = new JTextField();
		sem1sub7.setEditable(false);
		sem1sub7.setColumns(10);
		sem1sub7.setBounds(267, 118, 47, 26);
		panel_1.add(sem1sub7);
		
		sem1sub8 = new JTextField();
		sem1sub8.setEditable(false);
		sem1sub8.setColumns(10);
		sem1sub8.setBounds(267, 154, 47, 26);
		panel_1.add(sem1sub8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(369, 0, 359, 234);
		panel_7.add(panel_2);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(176, 224, 230));
		
		JLabel lblSemester = new JLabel("Semester 2");
		lblSemester.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemester.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSemester.setBounds(10, 10, 339, 26);
		panel_2.add(lblSemester);
		
		JLabel label_1 = new JLabel("Subject 1");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(10, 46, 90, 26);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Subject 2");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(10, 82, 90, 26);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Subject 3");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(10, 118, 90, 26);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Subject 4");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(10, 154, 90, 26);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Subject 5");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(167, 46, 90, 26);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Subject 6");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(167, 82, 90, 26);
		panel_2.add(label_6);
		
		sem2sub1 = new JTextField();
		sem2sub1.setEditable(false);
		sem2sub1.setColumns(10);
		sem2sub1.setBounds(110, 46, 47, 26);
		panel_2.add(sem2sub1);
		
		JLabel label_7 = new JLabel("Subject 7");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(167, 118, 90, 26);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("Semester average");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(10, 193, 147, 26);
		panel_2.add(label_8);
		
		sem2avg = new JTextField();
		sem2avg.setEditable(false);
		sem2avg.setColumns(10);
		sem2avg.setBounds(167, 193, 90, 26);
		panel_2.add(sem2avg);
		
		sem2sub2 = new JTextField();
		sem2sub2.setEditable(false);
		sem2sub2.setColumns(10);
		sem2sub2.setBounds(110, 82, 47, 26);
		panel_2.add(sem2sub2);
		
		sem2sub3 = new JTextField();
		sem2sub3.setEditable(false);
		sem2sub3.setColumns(10);
		sem2sub3.setBounds(110, 118, 47, 26);
		panel_2.add(sem2sub3);
		
		sem2sub4 = new JTextField();
		sem2sub4.setEditable(false);
		sem2sub4.setColumns(10);
		sem2sub4.setBounds(110, 154, 47, 26);
		panel_2.add(sem2sub4);
		
		sem2sub5 = new JTextField();
		sem2sub5.setEditable(false);
		sem2sub5.setColumns(10);
		sem2sub5.setBounds(267, 46, 47, 26);
		panel_2.add(sem2sub5);
		
		sem2sub6 = new JTextField();
		sem2sub6.setEditable(false);
		sem2sub6.setColumns(10);
		sem2sub6.setBounds(267, 82, 47, 26);
		panel_2.add(sem2sub6);
		
		sem2sub7 = new JTextField();
		sem2sub7.setEditable(false);
		sem2sub7.setColumns(10);
		sem2sub7.setBounds(267, 118, 47, 26);
		panel_2.add(sem2sub7);
		
		JLabel label_9 = new JLabel("Subject 8");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_9.setBounds(167, 154, 90, 26);
		panel_2.add(label_9);
		
		sem2sub8 = new JTextField();
		sem2sub8.setEditable(false);
		sem2sub8.setColumns(10);
		sem2sub8.setBounds(267, 154, 47, 26);
		panel_2.add(sem2sub8);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(738, 0, 359, 234);
		panel_7.add(panel_3);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(176, 224, 230));
		
		JLabel lblSemester_1 = new JLabel("Semester 3");
		lblSemester_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemester_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSemester_1.setBounds(10, 10, 339, 26);
		panel_3.add(lblSemester_1);
		
		JLabel label_11 = new JLabel("Subject 1");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_11.setBounds(10, 46, 90, 26);
		panel_3.add(label_11);
		
		JLabel label_12 = new JLabel("Subject 2");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_12.setBounds(10, 82, 90, 26);
		panel_3.add(label_12);
		
		JLabel label_13 = new JLabel("Subject 3");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_13.setBounds(10, 118, 90, 26);
		panel_3.add(label_13);
		
		JLabel label_14 = new JLabel("Subject 4");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_14.setBounds(10, 154, 90, 26);
		panel_3.add(label_14);
		
		JLabel label_15 = new JLabel("Subject 5");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_15.setBounds(167, 46, 90, 26);
		panel_3.add(label_15);
		
		JLabel label_16 = new JLabel("Subject 6");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_16.setBounds(167, 82, 90, 26);
		panel_3.add(label_16);
		
		sem3sub1 = new JTextField();
		sem3sub1.setEditable(false);
		sem3sub1.setColumns(10);
		sem3sub1.setBounds(110, 46, 47, 26);
		panel_3.add(sem3sub1);
		
		JLabel label_17 = new JLabel("Subject 7");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_17.setBounds(167, 118, 90, 26);
		panel_3.add(label_17);
		
		JLabel label_18 = new JLabel("Semester average");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_18.setBounds(10, 193, 147, 26);
		panel_3.add(label_18);
		
		sem3avg = new JTextField();
		sem3avg.setEditable(false);
		sem3avg.setColumns(10);
		sem3avg.setBounds(167, 193, 90, 26);
		panel_3.add(sem3avg);
		
		sem3sub2 = new JTextField();
		sem3sub2.setEditable(false);
		sem3sub2.setColumns(10);
		sem3sub2.setBounds(110, 82, 47, 26);
		panel_3.add(sem3sub2);
		
		sem3sub3 = new JTextField();
		sem3sub3.setEditable(false);
		sem3sub3.setColumns(10);
		sem3sub3.setBounds(110, 118, 47, 26);
		panel_3.add(sem3sub3);
		
		sem3sub4 = new JTextField();
		sem3sub4.setEditable(false);
		sem3sub4.setColumns(10);
		sem3sub4.setBounds(110, 154, 47, 26);
		panel_3.add(sem3sub4);
		
		sem3sub5 = new JTextField();
		sem3sub5.setEditable(false);
		sem3sub5.setColumns(10);
		sem3sub5.setBounds(267, 46, 47, 26);
		panel_3.add(sem3sub5);
		
		sem3sub6 = new JTextField();
		sem3sub6.setEditable(false);
		sem3sub6.setColumns(10);
		sem3sub6.setBounds(267, 82, 47, 26);
		panel_3.add(sem3sub6);
		
		sem3sub7 = new JTextField();
		sem3sub7.setEditable(false);
		sem3sub7.setColumns(10);
		sem3sub7.setBounds(267, 118, 47, 26);
		panel_3.add(sem3sub7);
		
		JLabel label_19 = new JLabel("Subject 8");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_19.setBounds(167, 154, 90, 26);
		panel_3.add(label_19);
		
		sem3sub8 = new JTextField();
		sem3sub8.setEditable(false);
		sem3sub8.setColumns(10);
		sem3sub8.setBounds(267, 154, 47, 26);
		panel_3.add(sem3sub8);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 244, 359, 234);
		panel_7.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(new Color(176, 224, 230));
		
		JLabel lblSemester_2 = new JLabel("Semester 4");
		lblSemester_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemester_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSemester_2.setBounds(10, 10, 339, 26);
		panel_4.add(lblSemester_2);
		
		JLabel label_21 = new JLabel("Subject 1");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_21.setBounds(10, 46, 90, 26);
		panel_4.add(label_21);
		
		JLabel label_22 = new JLabel("Subject 2");
		label_22.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_22.setBounds(10, 82, 90, 26);
		panel_4.add(label_22);
		
		JLabel label_23 = new JLabel("Subject 3");
		label_23.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_23.setBounds(10, 118, 90, 26);
		panel_4.add(label_23);
		
		JLabel label_24 = new JLabel("Subject 4");
		label_24.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_24.setBounds(10, 154, 90, 26);
		panel_4.add(label_24);
		
		JLabel label_25 = new JLabel("Subject 5");
		label_25.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_25.setBounds(167, 46, 90, 26);
		panel_4.add(label_25);
		
		JLabel label_26 = new JLabel("Subject 6");
		label_26.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_26.setBounds(167, 82, 90, 26);
		panel_4.add(label_26);
		
		sem4sub1 = new JTextField();
		sem4sub1.setEditable(false);
		sem4sub1.setColumns(10);
		sem4sub1.setBounds(110, 46, 47, 26);
		panel_4.add(sem4sub1);
		
		JLabel label_27 = new JLabel("Subject 7");
		label_27.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_27.setBounds(167, 118, 90, 26);
		panel_4.add(label_27);
		
		JLabel label_28 = new JLabel("Semester average");
		label_28.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_28.setBounds(10, 193, 147, 26);
		panel_4.add(label_28);
		
		sem4avg = new JTextField();
		sem4avg.setEditable(false);
		sem4avg.setColumns(10);
		sem4avg.setBounds(167, 193, 90, 26);
		panel_4.add(sem4avg);
		
		sem4sub2 = new JTextField();
		sem4sub2.setEditable(false);
		sem4sub2.setColumns(10);
		sem4sub2.setBounds(110, 82, 47, 26);
		panel_4.add(sem4sub2);
		
		sem4sub3 = new JTextField();
		sem4sub3.setEditable(false);
		sem4sub3.setColumns(10);
		sem4sub3.setBounds(110, 118, 47, 26);
		panel_4.add(sem4sub3);
		
		sem4sub4 = new JTextField();
		sem4sub4.setEditable(false);
		sem4sub4.setColumns(10);
		sem4sub4.setBounds(110, 154, 47, 26);
		panel_4.add(sem4sub4);
		
		sem4sub5 = new JTextField();
		sem4sub5.setEditable(false);
		sem4sub5.setColumns(10);
		sem4sub5.setBounds(267, 46, 47, 26);
		panel_4.add(sem4sub5);
		
		sem4sub6 = new JTextField();
		sem4sub6.setEditable(false);
		sem4sub6.setColumns(10);
		sem4sub6.setBounds(267, 82, 47, 26);
		panel_4.add(sem4sub6);
		
		sem4sub7 = new JTextField();
		sem4sub7.setEditable(false);
		sem4sub7.setColumns(10);
		sem4sub7.setBounds(267, 118, 47, 26);
		panel_4.add(sem4sub7);
		
		JLabel label_29 = new JLabel("Subject 8");
		label_29.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_29.setBounds(167, 154, 90, 26);
		panel_4.add(label_29);
		
		sem4sub8 = new JTextField();
		sem4sub8.setEditable(false);
		sem4sub8.setColumns(10);
		sem4sub8.setBounds(267, 154, 47, 26);
		panel_4.add(sem4sub8);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(369, 244, 359, 234);
		panel_7.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBackground(new Color(176, 224, 230));
		
		JLabel lblSemester_3 = new JLabel("Semester 5");
		lblSemester_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemester_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSemester_3.setBounds(10, 10, 339, 26);
		panel_5.add(lblSemester_3);
		
		JLabel label_31 = new JLabel("Subject 1");
		label_31.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_31.setBounds(10, 46, 90, 26);
		panel_5.add(label_31);
		
		JLabel label_32 = new JLabel("Subject 2");
		label_32.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_32.setBounds(10, 82, 90, 26);
		panel_5.add(label_32);
		
		JLabel label_33 = new JLabel("Subject 3");
		label_33.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_33.setBounds(10, 118, 90, 26);
		panel_5.add(label_33);
		
		JLabel label_34 = new JLabel("Subject 4");
		label_34.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_34.setBounds(10, 154, 90, 26);
		panel_5.add(label_34);
		
		JLabel label_35 = new JLabel("Subject 5");
		label_35.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_35.setBounds(167, 46, 90, 26);
		panel_5.add(label_35);
		
		JLabel label_36 = new JLabel("Subject 6");
		label_36.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_36.setBounds(167, 82, 90, 26);
		panel_5.add(label_36);
		
		sem5sub1 = new JTextField();
		sem5sub1.setEditable(false);
		sem5sub1.setColumns(10);
		sem5sub1.setBounds(110, 46, 47, 26);
		panel_5.add(sem5sub1);
		
		JLabel label_37 = new JLabel("Subject 7");
		label_37.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_37.setBounds(167, 118, 90, 26);
		panel_5.add(label_37);
		
		JLabel label_38 = new JLabel("Semester average");
		label_38.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_38.setBounds(10, 193, 147, 26);
		panel_5.add(label_38);
		
		sem5avg = new JTextField();
		sem5avg.setEditable(false);
		sem5avg.setColumns(10);
		sem5avg.setBounds(167, 193, 90, 26);
		panel_5.add(sem5avg);
		
		sem5sub2 = new JTextField();
		sem5sub2.setEditable(false);
		sem5sub2.setColumns(10);
		sem5sub2.setBounds(110, 82, 47, 26);
		panel_5.add(sem5sub2);
		
		sem5sub3 = new JTextField();
		sem5sub3.setEditable(false);
		sem5sub3.setColumns(10);
		sem5sub3.setBounds(110, 118, 47, 26);
		panel_5.add(sem5sub3);
		
		sem5sub4 = new JTextField();
		sem5sub4.setEditable(false);
		sem5sub4.setColumns(10);
		sem5sub4.setBounds(110, 154, 47, 26);
		panel_5.add(sem5sub4);
		
		sem5sub5 = new JTextField();
		sem5sub5.setEditable(false);
		sem5sub5.setColumns(10);
		sem5sub5.setBounds(267, 46, 47, 26);
		panel_5.add(sem5sub5);
		
		sem5sub6 = new JTextField();
		sem5sub6.setEditable(false);
		sem5sub6.setColumns(10);
		sem5sub6.setBounds(267, 82, 47, 26);
		panel_5.add(sem5sub6);
		
		sem5sub7 = new JTextField();
		sem5sub7.setEditable(false);
		sem5sub7.setColumns(10);
		sem5sub7.setBounds(267, 118, 47, 26);
		panel_5.add(sem5sub7);
		
		JLabel label_39 = new JLabel("Subject 8");
		label_39.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_39.setBounds(167, 154, 90, 26);
		panel_5.add(label_39);
		
		sem5sub8 = new JTextField();
		sem5sub8.setEditable(false);
		sem5sub8.setColumns(10);
		sem5sub8.setBounds(267, 154, 47, 26);
		panel_5.add(sem5sub8);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(738, 244, 359, 234);
		panel_7.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBackground(new Color(176, 224, 230));
		
		JLabel lblSemester_4 = new JLabel("Semester 6");
		lblSemester_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemester_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSemester_4.setBounds(10, 10, 339, 26);
		panel_6.add(lblSemester_4);
		
		JLabel label_41 = new JLabel("Subject 1");
		label_41.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_41.setBounds(10, 46, 90, 26);
		panel_6.add(label_41);
		
		JLabel label_42 = new JLabel("Subject 2");
		label_42.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_42.setBounds(10, 82, 90, 26);
		panel_6.add(label_42);
		
		JLabel label_43 = new JLabel("Subject 3");
		label_43.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_43.setBounds(10, 118, 90, 26);
		panel_6.add(label_43);
		
		JLabel label_44 = new JLabel("Subject 4");
		label_44.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_44.setBounds(10, 154, 90, 26);
		panel_6.add(label_44);
		
		JLabel label_45 = new JLabel("Subject 5");
		label_45.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_45.setBounds(167, 46, 90, 26);
		panel_6.add(label_45);
		
		JLabel label_46 = new JLabel("Subject 6");
		label_46.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_46.setBounds(167, 82, 90, 26);
		panel_6.add(label_46);
		
		sem6sub1 = new JTextField();
		sem6sub1.setEditable(false);
		sem6sub1.setColumns(10);
		sem6sub1.setBounds(110, 46, 47, 26);
		panel_6.add(sem6sub1);
		
		JLabel label_47 = new JLabel("Subject 7");
		label_47.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_47.setBounds(167, 118, 90, 26);
		panel_6.add(label_47);
		
		JLabel label_48 = new JLabel("Semester average");
		label_48.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_48.setBounds(10, 193, 147, 26);
		panel_6.add(label_48);
		
		sem6avg = new JTextField();
		sem6avg.setEditable(false);
		sem6avg.setColumns(10);
		sem6avg.setBounds(167, 193, 90, 26);
		panel_6.add(sem6avg);
		
		sem6sub2 = new JTextField();
		sem6sub2.setEditable(false);
		sem6sub2.setColumns(10);
		sem6sub2.setBounds(110, 82, 47, 26);
		panel_6.add(sem6sub2);
		
		sem6sub3 = new JTextField();
		sem6sub3.setEditable(false);
		sem6sub3.setColumns(10);
		sem6sub3.setBounds(110, 118, 47, 26);
		panel_6.add(sem6sub3);
		
		sem6sub4 = new JTextField();
		sem6sub4.setEditable(false);
		sem6sub4.setColumns(10);
		sem6sub4.setBounds(110, 154, 47, 26);
		panel_6.add(sem6sub4);
		
		sem6sub5 = new JTextField();
		sem6sub5.setEditable(false);
		sem6sub5.setColumns(10);
		sem6sub5.setBounds(267, 46, 47, 26);
		panel_6.add(sem6sub5);
		
		sem6sub6 = new JTextField();
		sem6sub6.setEditable(false);
		sem6sub6.setColumns(10);
		sem6sub6.setBounds(267, 82, 47, 26);
		panel_6.add(sem6sub6);
		
		sem6sub7 = new JTextField();
		sem6sub7.setEditable(false);
		sem6sub7.setColumns(10);
		sem6sub7.setBounds(267, 118, 47, 26);
		panel_6.add(sem6sub7);
		
		JLabel label_49 = new JLabel("Subject 8");
		label_49.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_49.setBounds(167, 154, 90, 26);
		panel_6.add(label_49);
		
		sem6sub8 = new JTextField();
		sem6sub8.setEditable(false);
		sem6sub8.setColumns(10);
		sem6sub8.setBounds(267, 154, 47, 26);
		panel_6.add(sem6sub8);
		
		JLabel lblNewLabel = new JLabel("Score Card");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 1094, 28);
		contentPane.add(lblNewLabel);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(176, 224, 230));
		panel_8.setBounds(10, 48, 1094, 78);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 10, 59, 26);
		panel_8.add(lblName);
		
		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRollNo.setBounds(10, 46, 70, 26);
		panel_8.add(lblRollNo);
		
		JLabel lblRegistrationNo = new JLabel("Registration No");
		lblRegistrationNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistrationNo.setBounds(291, 46, 121, 26);
		panel_8.add(lblRegistrationNo);
		
		roll = new JTextField();
		roll.setEditable(false);
		roll.setColumns(10);
		roll.setBounds(79, 46, 162, 26);
		panel_8.add(roll);
		
		reg = new JTextField();
		reg.setEditable(false);
		reg.setColumns(10);
		reg.setBounds(422, 42, 162, 26);
		panel_8.add(reg);
		
		name = new JTextField();
		name.setEditable(false);
		name.setColumns(10);
		name.setBounds(79, 10, 209, 26);
		panel_8.add(name);
	}
}
