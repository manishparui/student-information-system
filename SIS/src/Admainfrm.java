import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Driver;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class Admainfrm extends JFrame {

	private JPanel contentPane;
	private JTextField searchkey;
	private JTextField id;
	private JTextField fname;
	private JTextField lname;
	private JTextField dob;
	private JTextField contactno;
	private JTextField email;
	private JTextField department;
	private JPasswordField pwd;
	private JTextField sex;
	private JTextArea address;
	private JButton btnEdit;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admainfrm frame = new Admainfrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con = null;	
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	
	public Admainfrm() {
		con = DbConnector.Connector();
		Glvar.openfrm = "Admainfrm";
		
		setResizable(false);
		setBackground(new Color(176, 224, 230));
		setTitle("Student Information System - Administrator Mode");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(173, 30, 1178, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel info_vw_panel = new JPanel();
		info_vw_panel.setBackground(new Color(176, 224, 230));
		info_vw_panel.setBounds(10, 98, 1144, 605);
		contentPane.add(info_vw_panel);
		info_vw_panel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 10, 556, 585);
		info_vw_panel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.info);
		panel_2.setBounds(10, 10, 536, 24);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				
				try {
					String srchkey = searchkey.getText();
					String sql = "SELECT login_id, fname, lname, sex, dob, contact_no, email, address, department FROM sis.faculty where login_id = ?;";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, srchkey);
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBounds(441, 0, 85, 24);
		panel_2.add(btnSearch);
		
		searchkey = new JTextField();
		searchkey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String srchkey = searchkey.getText();
					String sql = "SELECT login_id, fname, lname, sex, dob, contact_no, email, address, department FROM sis.faculty where login_id = ?;";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, srchkey);
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		searchkey.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchkey.setText(null);
			}
		});
		searchkey.setFont(new Font("Tahoma", Font.PLAIN, 12));
		searchkey.setText("Enter Login Id here");
		searchkey.setBounds(281, 0, 150, 24);
		panel_2.add(searchkey);
		searchkey.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(176, 224, 230));
		panel_6.setBounds(10, 44, 536, 531);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 516, 511);
		panel_6.add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.info);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Glvar.logedinuser.equals("admin")) {
					btnEdit.setEnabled(true);
					btnDelete.setEnabled(true);
				}
				else {
					btnEdit.setEnabled(false);
					btnDelete.setEnabled(false);
				}
				
				
				try {
					int row = table.getSelectedRow();
					Glvar.uid_db = (table.getModel().getValueAt(row, 0)).toString();
					
					String sql = "SELECT * FROM sis.faculty where login_id = ? ";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, Glvar.uid_db);
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						String iddb = rs.getString("login_id");
						String pwddb = rs.getString("password");
						String fnamedb = rs.getString("fname");
						String lnamedb = rs.getString("lname");
						String dobdb = rs.getString("dob");
						String contactdb = rs.getString("contact_no");
						String emaildb = rs.getString("email");
						String addressdb = rs.getString("address");
						String departmentdb = rs.getString("department");
						String sexdb = rs.getString("sex");
						
						id.setText(iddb);
						pwd.setText(pwddb);
						fname.setText(fnamedb);
						lname.setText(lnamedb);
						dob.setText(dobdb);
						contactno.setText(contactdb);
						email.setText(emaildb);
						address.setText(addressdb);
						department.setText(departmentdb);
						sex.setText(sexdb);
						
					}
					
					ps.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(576, 10, 556, 585);
		info_vw_panel.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(176, 224, 230));
		panel_3.setLayout(null);
		panel_3.setBounds(10, 551, 536, 24);
		panel_1.add(panel_3);
		
		btnEdit = new JButton("Edit");
		btnEdit.setEnabled(false);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bt = true;
				boolean bf = false;
				String t = null;
				
				//String idu = id.getText();
				//String pwdu = new String(pwd.getPassword());
				String fnameu = fname.getText();
				String lnameu = lname.getText();
				String dobu = dob.getText();
				String contactu = contactno.getText();
				String emailu = email.getText();
				String addressu = address.getText();
				String departmentu = department.getText();
				String sexu = sex.getText();
				
				String txt = btnEdit.getText();
				
				if(txt.equals("Edit")) {
					fname.setEditable(bt);
					lname.setEditable(bt);
					dob.setEditable(bt);
					contactno.setEditable(bt);
					email.setEditable(bt);
					address.setEditable(bt);
					department.setEditable(bt);
					sex.setEditable(bt);
					
					btnEdit.setText("Update");
				}
				else if(txt.equals("Update")) {
					try {
						String sql = "UPDATE `sis`.`faculty` SET `fname` = ?, `lname` = ?, `sex` = ?, `dob` = ?, `contact_no` = ?, `email` = ?, `address` = ?, `department` = ? WHERE (`login_id` = ?)";
						PreparedStatement ps = con.prepareStatement(sql);
						
						ps.setString(1, fnameu);
						ps.setString(2, lnameu);
						ps.setString(3, sexu);
						ps.setString(4, dobu);
						ps.setString(5, contactu);
						ps.setString(6, emailu);
						ps.setString(7, addressu);
						ps.setString(8, departmentu);
						ps.setString(9, Glvar.uid_db);
						
						int res = ps.executeUpdate();
						if (res > 0)
							JOptionPane.showMessageDialog(null, "Profile Updated. Please refresh database.");
						else
							JOptionPane.showMessageDialog(null, "Profile not Updated");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					btnEdit.setText("Edit");
					
					id.setEditable(bf);
					pwd.setEditable(bf);
					fname.setEditable(bf);
					lname.setEditable(bf);
					dob.setEditable(bf);
					contactno.setEditable(bf);
					email.setEditable(bf);
					address.setEditable(bf);
					department.setEditable(bf);
					sex.setEditable(bf);
					
					id.setText(t);
					pwd.setText(t);
					fname.setText(t);
					lname.setText(t);
					dob.setText(t);
					contactno.setText(t);
					email.setText(t);
					address.setText(t);
					department.setText(t);
					sex.setText(t);
					
					Glvar.uid_db = null;
				}  //end of else if 
				
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBounds(226, 0, 85, 24);
		panel_3.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Auth authobj = new Auth();
				authobj.setVisible(true);
				
				boolean bf = false;
				String t = null;
				
				id.setEditable(bf);
				pwd.setEditable(bf);
				fname.setEditable(bf);
				lname.setEditable(bf);
				dob.setEditable(bf);
				contactno.setEditable(bf);
				email.setEditable(bf);
				address.setEditable(bf);
				department.setEditable(bf);
				sex.setEditable(bf);
				
				id.setText(t);
				pwd.setText(t);
				fname.setText(t);
				lname.setText(t);
				dob.setText(t);
				contactno.setText(t);
				email.setText(t);
				address.setText(t);
				department.setText(t);
				sex.setText(t);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(441, 0, 85, 24);
		panel_3.add(btnDelete);
		
		JButton btnNewButton_1 = new JButton("New");
		if (Glvar.logedinuser.equals("admin")) {
			btnNewButton_1.setEnabled(true);
		}
		else
			btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(10, 0, 85, 24);
		panel_3.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = null;
				String idn = id.getText();
				String pwdn = new String(pwd.getPassword());
				String fnamen = fname.getText();
				String lnamen = lname.getText();
				String dobn = dob.getText();
				String contactn = contactno.getText();
				String emailn = email.getText();
				String addressn = address.getText();
				String departmentn = department.getText();
				String sexn = sex.getText();
				String txt = btnNewButton_1.getText();
				
				if (txt.equals("New")) {
					btnNewButton_1.setText("Create");
					
					id.setEditable(true);
					id.setText(t);
					
					pwd.setEditable(true);
					pwd.setText(t);
					
					fname.setEditable(true);
					fname.setText(t);
					
					lname.setEditable(true);
					lname.setText(t);
					
					dob.setEditable(true);
					dob.setText(t);
					
					contactno.setEditable(true);
					contactno.setText(t);
					
					email.setEditable(true);
					email.setText(t);
					
					address.setEditable(true);
					address.setText(t);
					
					department.setEditable(true);
					department.setText(t);
					
					sex.setEditable(true);
					sex.setText(t);
				}
				else if (txt.equals("Create")) {
					//sql insert
					try {
						String sql = "INSERT INTO `sis`.`faculty` (`login_id`, `password`, `fname`, `lname`, `sex`, `dob`, `contact_no`, `email`, `address`, `department`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
						PreparedStatement ps =con.prepareStatement(sql);
						ps.setString(1, idn);
						ps.setString(2, pwdn);
						ps.setString(3, fnamen);
						ps.setString(4, lnamen);
						ps.setString(5, sexn);
						ps.setString(6, dobn);
						ps.setString(7, contactn);
						ps.setString(8, emailn);
						ps.setString(9, addressn);
						ps.setString(10, departmentn);
						
						int res = ps.executeUpdate();
						
						if (res > 0)
							JOptionPane.showMessageDialog(null, "Profile created. Please refresh database.");
						else
							JOptionPane.showMessageDialog(null, "Profile not created");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					btnNewButton_1.setText("New");
					boolean bf = false;
					id.setEditable(bf);
					pwd.setEditable(bf);
					fname.setEditable(bf);
					lname.setEditable(bf);
					dob.setEditable(bf);
					contactno.setEditable(bf);
					email.setEditable(bf);
					address.setEditable(bf);
					department.setEditable(bf);
					sex.setEditable(bf);
					
					id.setText(t);
					pwd.setText(t);
					fname.setText(t);
					lname.setText(t);
					dob.setText(t);
					contactno.setText(t);
					email.setText(t);
					address.setText(t);
					department.setText(t);
					sex.setText(t);
					
					Glvar.uid_db = null;
				}
				
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("Create New User Profile");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(10, 0, 536, 30);
		panel_1.add(label_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(176, 224, 230));
		panel_4.setBounds(102, 40, 393, 432);
		panel_1.add(panel_4);
		
		JLabel label_2 = new JLabel("Login Id");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(10, 22, 151, 24);
		panel_4.add(label_2);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(10, 90, 151, 24);
		panel_4.add(label_3);
		
		JLabel label_4 = new JLabel("First Name");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(10, 124, 151, 24);
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel("Last Name");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(10, 158, 151, 24);
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("Sex");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(10, 192, 151, 24);
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("Birth Date");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(10, 226, 151, 24);
		panel_4.add(label_7);
		
		JLabel label_8 = new JLabel("Contact Number");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(10, 260, 151, 24);
		panel_4.add(label_8);
		
		JLabel label_9 = new JLabel("Email Id");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_9.setBounds(10, 294, 151, 24);
		panel_4.add(label_9);
		
		JLabel label_10 = new JLabel("Address");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_10.setBounds(10, 328, 151, 24);
		panel_4.add(label_10);
		
		JLabel label_11 = new JLabel("Department");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_11.setBounds(10, 395, 151, 24);
		panel_4.add(label_11);
		
		id = new JTextField();
		id.setEditable(false);
		id.setColumns(10);
		id.setBounds(171, 22, 151, 24);
		panel_4.add(id);
		
		fname = new JTextField();
		fname.setEditable(false);
		fname.setColumns(10);
		fname.setBounds(171, 124, 150, 24);
		panel_4.add(fname);
		
		lname = new JTextField();
		lname.setEditable(false);
		lname.setColumns(10);
		lname.setBounds(170, 158, 151, 24);
		panel_4.add(lname);
		
		dob = new JTextField();
		dob.setEditable(false);
		dob.setColumns(10);
		dob.setBounds(171, 226, 151, 24);
		panel_4.add(dob);
		
		contactno = new JTextField();
		contactno.setEditable(false);
		contactno.setColumns(10);
		contactno.setBounds(171, 260, 151, 24);
		panel_4.add(contactno);
		
		email = new JTextField();
		email.setEditable(false);
		email.setColumns(10);
		email.setBounds(170, 294, 151, 24);
		panel_4.add(email);
		
		department = new JTextField();
		department.setEditable(false);
		department.setColumns(10);
		department.setBounds(170, 395, 151, 24);
		panel_4.add(department);
		
		pwd = new JPasswordField();
		pwd.setEditable(false);
		pwd.setBounds(171, 90, 150, 24);
		panel_4.add(pwd);
		
		sex = new JTextField();
		sex.setEditable(false);
		sex.setColumns(10);
		sex.setBounds(170, 192, 151, 24);
		panel_4.add(sex);
		
		JLabel lblIdShouldBe = new JLabel("Id should be unique & not more than 10 character long.");
		lblIdShouldBe.setForeground(Color.GRAY);
		lblIdShouldBe.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblIdShouldBe.setBounds(20, 56, 363, 24);
		panel_4.add(lblIdShouldBe);
		
		address = new JTextArea();
		address.setWrapStyleWord(true);
		address.setFont(new Font("Tahoma", Font.PLAIN, 10));
		address.setEditable(false);
		address.setLineWrap(true);
		address.setBounds(170, 328, 151, 58);
		panel_4.add(address);
		
		JLabel label = new JLabel("only admin can do this");
		if (Glvar.logedinuser.equals("admin")) {
			label.setForeground(new Color(176, 224, 230));
		}
		label.setBounds(199, 517, 160, 22);
		panel_1.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel logedin_panel = new JPanel();
		logedin_panel.setBackground(new Color(176, 224, 230));
		logedin_panel.setBounds(10, 10, 1144, 22);
		contentPane.add(logedin_panel);
		logedin_panel.setLayout(null);
		
		JLabel lblLogInAs_1 = new JLabel("Log in as:");
		lblLogInAs_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogInAs_1.setBounds(686, 0, 68, 22);
		logedin_panel.add(lblLogInAs_1);
		
		JLabel lblUserName = new JLabel(Glvar.logedinuser);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(764, 0, 106, 22);
		logedin_panel.add(lblUserName);
		
		JButton btnChangeUser = new JButton("Change User");
		btnChangeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Chusrfrm chusrfrmobj = new Chusrfrm();
				chusrfrmobj.setVisible(true);
			}
		});
		btnChangeUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnChangeUser.setBounds(1012, 0, 122, 21);
		logedin_panel.add(btnChangeUser);
		
		JButton btnSwitchToAdministrator = new JButton("Switch to student mode");
		btnSwitchToAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Mainfrm mainfrmobj = new Mainfrm();
				mainfrmobj.setVisible(true);
			}
		});
		btnSwitchToAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSwitchToAdministrator.setBounds(10, 0, 227, 21);
		logedin_panel.add(btnSwitchToAdministrator);
		
		JLabel lblStudentMode = new JLabel("Administrator Mode");
		lblStudentMode.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentMode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblStudentMode.setBounds(247, 0, 153, 22);
		logedin_panel.add(lblStudentMode);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginfrm loginfrmobj = new Loginfrm();
				loginfrmobj.Visible(true);
				dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogOut.setBounds(880, 0, 122, 21);
		logedin_panel.add(btnLogOut);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(176, 224, 230));
		panel_5.setBounds(10, 54, 1144, 34);
		contentPane.add(panel_5);
		
		JLabel lblUserDetails = new JLabel("User Details");
		lblUserDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserDetails.setBounds(489, 0, 166, 34);
		panel_5.add(lblUserDetails);
		
		JButton btnLoadDatabase = new JButton("Load Database");
		btnLoadDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadDatabase.setText("Refresh Database");
				boolean bf = false;
				String t = null;
				
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				
				id.setEditable(bf);
				pwd.setEditable(bf);
				fname.setEditable(bf);
				lname.setEditable(bf);
				dob.setEditable(bf);
				contactno.setEditable(bf);
				email.setEditable(bf);
				address.setEditable(bf);
				department.setEditable(bf);
				sex.setEditable(bf);
				
				id.setText(t);
				pwd.setText(t);
				fname.setText(t);
				lname.setText(t);
				dob.setText(t);
				contactno.setText(t);
				email.setText(t);
				address.setText(t);
				department.setText(t);
				sex.setText(t);
				
				try {
					String sql = "SELECT login_id, fname, lname, sex, dob, contact_no, email, address, department FROM sis.faculty;";
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				searchkey.setText("Enter Login Id here");
				Glvar.uid_db = null;
			}
		});
		btnLoadDatabase.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLoadDatabase.setBounds(10, 0, 227, 34);
		panel_5.add(btnLoadDatabase);
		
	}
}
