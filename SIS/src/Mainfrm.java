import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class Mainfrm extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField ln;
	private JTextField dob;
	private JTextField fn;
	private JTextField sex;
	private JTextField university;
	private JTextField section;
	private JTextField roll;
	private JTextField department;
	private JTextField reg;
	private JTextField college;
	private JTextField contact;
	private JTextField email;
	private JTable table;
	private JTextArea address;
	
	private JButton btnNew;
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnScoreCard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainfrm frame = new Mainfrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con = null;
	private JTextField SearchKey;
	/**
	 * Create the frame.
	 */
	public Mainfrm() {
		con = DbConnector.Connector();
		
		Glvar.openfrm = "Mainfrm";
		
		setResizable(false);
		setTitle("Student Information System - Student Mode");
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
				btnDelete.setEnabled(false);
				btnEdit.setEnabled(false);
				btnScoreCard.setEnabled(false);
				
				String sql = "select * from student where id = ?";
				String searchkey = SearchKey.getText();
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, searchkey);
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
		
		SearchKey = new JTextField();
		SearchKey.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchKey.setText(null);
			}
		});
		SearchKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete.setEnabled(false);
				btnEdit.setEnabled(false);
				btnScoreCard.setEnabled(false);
				
				String sql = "select * from student where id = ?";
				String searchkey = SearchKey.getText();
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, searchkey);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		SearchKey.setText("Enter Id here");
		SearchKey.setFont(new Font("Tahoma", Font.PLAIN, 12));
		SearchKey.setColumns(10);
		SearchKey.setBounds(281, 0, 150, 24);
		panel_2.add(SearchKey);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(176, 224, 230));
		panel_8.setBounds(10, 44, 536, 531);
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 516, 511);
		panel_8.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDelete.setEnabled(true);
				btnEdit.setEnabled(true);
				btnScoreCard.setEnabled(true);
				
				try {
					int row = table.getSelectedRow();
					Glvar.stdn_id = (table.getModel().getValueAt(row, 0)).toString();
					
					String sql = "SELECT * FROM sis.student where id = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, Glvar.stdn_id);
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						id.setText(rs.getString("id"));
						fn.setText(rs.getString("fname"));
						ln.setText(rs.getString("lname"));
						sex.setText(rs.getString("sex"));
						dob.setText(rs.getString("dob"));
						contact.setText(rs.getString("contact_no"));
						address.setText(rs.getString("address"));
						email.setText(rs.getString("email"));
						university.setText(rs.getString("university"));
						college.setText(rs.getString("college"));
						department.setText(rs.getString("department"));
						section.setText(rs.getString("section"));
						reg.setText(rs.getString("reg_no"));
						roll.setText(rs.getString("roll_no"));
						
						Glvar.stdn_roll = rs.getString("roll_no");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setBackground(SystemColor.info);
		
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
				String txt = btnEdit.getText();
				String t = null;
				
				String iddb = id.getText();
				String fndb = fn.getText();
				String lndb = ln.getText();
				String sexdb = sex.getText();
				String dobdb = dob.getText();
				String contactdb = contact.getText();
				String addressdb = address.getText();
				String emaildb = email.getText();
				String universitydb = university.getText();
				String collegedb = college.getText();
				String departmentdb = department.getText();
				String sectiondb = section.getText();
				String regdb = reg.getText();
				String rolldb = roll.getText();
				
				if (txt.equals("Edit")) {
					btnEdit.setText("Update");
					
					id.setEditable(bt);
					fn.setEditable(bt);
					ln.setEditable(bt);
					sex.setEditable(bt);
					dob.setEditable(bt);
					contact.setEditable(bt);
					address.setEditable(bt);
					email.setEditable(bt);
					university.setEditable(bt);
					college.setEditable(bt);
					department.setEditable(bt);
					section.setEditable(bt);
					reg.setEditable(bt);
					roll.setEditable(bt);
				}
				
				else if (txt.equals("Update")) {
					//sql update
					try {
						String sql = "UPDATE `sis`.`student` SET `id` = ?, `fname` = ?, `lname` = ?, `sex` = ?, `dob` = ?, `contact_no` = ?, `email` = ?, `address` = ?, `university` = ?, `college` = ?, `department` = ?, `section` = ?, `reg_no` = ?, `roll_no` = ? WHERE (`id` = ?)";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, iddb);
						ps.setString(2, fndb);
						ps.setString(3, lndb);
						ps.setString(4, sexdb);
						ps.setString(5, dobdb);
						ps.setString(6, contactdb);
						ps.setString(7, emaildb);
						ps.setString(8, addressdb);
						ps.setString(9, universitydb);
						ps.setString(10, collegedb);
						ps.setString(11, departmentdb);
						ps.setString(12, sectiondb);
						ps.setString(13, regdb);
						ps.setString(14, rolldb);
						ps.setString(15, Glvar.stdn_id);
						
						int res = ps.executeUpdate();
						if (res > 0)
							JOptionPane.showMessageDialog(null, "Profile Updated. Please refresh database.");
						else
							JOptionPane.showMessageDialog(null, "Unable to update");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					btnEdit.setText("Edit");
					
					id.setEditable(bf);
					id.setText(t);
					
					fn.setEditable(bf);
					fn.setText(t);
					
					ln.setEditable(bf);
					ln.setText(t);
					
					sex.setEditable(bf);
					sex.setText(t);
					
					dob.setEditable(bf);
					dob.setText(t);
					
					contact.setEditable(bf);
					contact.setText(t);
					
					address.setEditable(bf);
					address.setText(t);
					
					email.setEditable(bf);
					email.setText(t);
					
					university.setEditable(bf);
					university.setText(t);
					
					college.setEditable(bf);
					college.setText(t);
					
					department.setEditable(bf);
					department.setText(t);
					
					section.setEditable(bf);
					section.setText(t);
					
					reg.setEditable(bf);
					reg.setText(t);
					
					roll.setEditable(bf);
					roll.setText(t);
					
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
				id.setText(t);
				fn.setEditable(bf);
				fn.setText(t);
				ln.setEditable(bf);
				ln.setText(t);
				sex.setEditable(bf);
				sex.setText(t);
				dob.setEditable(bf);
				dob.setText(t);
				contact.setEditable(bf);
				contact.setText(t);
				address.setEditable(bf);
				address.setText(t);
				email.setEditable(bf);
				email.setText(t);
				university.setEditable(bf);
				university.setText(t);
				college.setEditable(bf);
				college.setText(t);
				department.setEditable(bf);
				department.setText(t);
				section.setEditable(bf);
				section.setText(t);
				reg.setEditable(bf);
				reg.setText(t);
				roll.setEditable(bf);
				roll.setText(t);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(441, 0, 85, 24);
		panel_3.add(btnDelete);
		
		btnNew = new JButton("New");
		btnNew.setBounds(10, 0, 85, 24);
		panel_3.add(btnNew);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bt = true;
				boolean bf = false;
				String t = null;
				String txt = btnNew.getText();
				
				String iddb = id.getText();
				String fndb = fn.getText();
				String lndb = ln.getText();
				String sexdb = sex.getText();
				String dobdb = dob.getText();
				String contactdb = contact.getText();
				String addressdb = address.getText();
				String emaildb = email.getText();
				String universitydb = university.getText();
				String collegedb = college.getText();
				String departmentdb = department.getText();
				String sectiondb = section.getText();
				String regdb = reg.getText();
				String rolldb = roll.getText();
				
				if (txt.equals("New")) {
					btnNew.setText("Create");
					
					id.setEditable(bt);
					id.setText(t);
					
					fn.setEditable(bt);
					fn.setText(t);
					
					ln.setEditable(bt);
					ln.setText(t);
					
					sex.setEditable(bt);
					sex.setText(t);
					
					dob.setEditable(bt);
					dob.setText(t);
					
					contact.setEditable(bt);
					contact.setText(t);
					
					address.setEditable(bt);
					address.setText(t);
					
					email.setEditable(bt);
					email.setText(t);
					
					university.setEditable(bt);
					university.setText(t);
					
					college.setEditable(bt);
					college.setText(t);
					
					department.setEditable(bt);
					department.setText(t);
					
					section.setEditable(bt);
					section.setText(t);
					
					reg.setEditable(bt);
					reg.setText(t);
					
					roll.setEditable(bt);
					roll.setText(t);
				}
				
				else if(txt.equals("Create")) {
					//sql insert
					try {
						String sql = "INSERT INTO `sis`.`student` (`id`, `fname`, `lname`, `sex`, `dob`, `contact_no`, `email`, `address`, `university`, `college`, `department`, `section`, `reg_no`, `roll_no`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, iddb);
						ps.setString(2, fndb);
						ps.setString(3, lndb);
						ps.setString(4, sexdb);
						ps.setString(5, dobdb);
						ps.setString(6, contactdb);
						ps.setString(7, emaildb);
						ps.setString(8, addressdb);
						ps.setString(9, universitydb);
						ps.setString(10, collegedb);
						ps.setString(11, departmentdb);
						ps.setString(12, sectiondb);
						ps.setString(13, regdb);
						ps.setString(14, rolldb);
						
						int res = ps.executeUpdate();
						if (res > 0)
							JOptionPane.showMessageDialog(null, "Profile created. Please refresh database.");
						else
							JOptionPane.showMessageDialog(null, "Profile not created");
						
						String sql1 = "INSERT INTO `sis`.`score` (`roll_no`) VALUES (?);";
						PreparedStatement ps1 = con.prepareStatement(sql1);
						ps1.setString(1, rolldb);
						int res1 = ps1.executeUpdate();
						if (res1 > 0)
							JOptionPane.showMessageDialog(null, "Blank score card generated.");
						else
							JOptionPane.showMessageDialog(null, "Unable to generate score card");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					btnNew.setText("New");
					id.setEditable(bf);
					id.setText(t);
					
					fn.setEditable(bf);
					fn.setText(t);
					
					ln.setEditable(bf);
					ln.setText(t);
					
					sex.setEditable(bf);
					sex.setText(t);
					
					dob.setEditable(bf);
					dob.setText(t);
					
					contact.setEditable(bf);
					contact.setText(t);
					
					address.setEditable(bf);
					address.setText(t);
					
					email.setEditable(bf);
					email.setText(t);
					
					university.setEditable(bf);
					university.setText(t);
					
					college.setEditable(bf);
					college.setText(t);
					
					department.setEditable(bf);
					department.setText(t);
					
					section.setEditable(bf);
					section.setText(t);
					
					reg.setEditable(bf);
					reg.setText(t);
					
					roll.setEditable(bf);
					roll.setText(t);
				} //end of else if
			}
		});
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(176, 224, 230));
		panel_7.setBounds(10, 58, 536, 429);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(176, 224, 230));
		panel_4.setBounds(0, 48, 536, 98);
		panel_7.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Id **");
		lblNewLabel.setBounds(10, 10, 100, 20);
		panel_4.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblFirstName = new JLabel("First Name *");
		lblFirstName.setBounds(10, 40, 100, 20);
		panel_4.add(lblFirstName);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		id = new JTextField();
		id.setEditable(false);
		id.setFont(new Font("Tahoma", Font.PLAIN, 12));
		id.setBounds(120, 10, 100, 20);
		panel_4.add(id);
		id.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex *");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSex.setBounds(10, 70, 100, 20);
		panel_4.add(lblSex);
		
		ln = new JTextField();
		ln.setEditable(false);
		ln.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ln.setColumns(10);
		ln.setBounds(426, 41, 100, 20);
		panel_4.add(ln);
		
		dob = new JTextField();
		dob.setEditable(false);
		dob.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dob.setColumns(10);
		dob.setBounds(426, 70, 100, 20);
		panel_4.add(dob);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(316, 40, 100, 20);
		panel_4.add(lblLastName);
		
		JLabel lblBirthDate = new JLabel("Birth Date *");
		lblBirthDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBirthDate.setBounds(316, 70, 100, 20);
		panel_4.add(lblBirthDate);
		
		fn = new JTextField();
		fn.setEditable(false);
		fn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fn.setColumns(10);
		fn.setBounds(120, 40, 100, 20);
		panel_4.add(fn);
		
		sex = new JTextField();
		sex.setEditable(false);
		sex.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sex.setColumns(10);
		sex.setBounds(120, 70, 100, 20);
		panel_4.add(sex);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(176, 224, 230));
		panel_5.setBounds(0, 331, 536, 98);
		panel_7.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblUniversity = new JLabel("University *");
		lblUniversity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUniversity.setBounds(10, 10, 100, 20);
		panel_5.add(lblUniversity);
		
		JLabel lblDepartment = new JLabel("Department *");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDepartment.setBounds(10, 40, 100, 20);
		panel_5.add(lblDepartment);
		
		university = new JTextField();
		university.setEditable(false);
		university.setFont(new Font("Tahoma", Font.PLAIN, 12));
		university.setColumns(10);
		university.setBounds(120, 10, 100, 20);
		panel_5.add(university);
		
		JLabel lblRegNo = new JLabel("Reg. No. **");
		lblRegNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegNo.setBounds(10, 70, 100, 20);
		panel_5.add(lblRegNo);
		
		section = new JTextField();
		section.setEditable(false);
		section.setFont(new Font("Tahoma", Font.PLAIN, 12));
		section.setColumns(10);
		section.setBounds(426, 40, 100, 20);
		panel_5.add(section);
		
		roll = new JTextField();
		roll.setEditable(false);
		roll.setFont(new Font("Tahoma", Font.PLAIN, 12));
		roll.setColumns(10);
		roll.setBounds(426, 70, 100, 20);
		panel_5.add(roll);
		
		JLabel lblSection = new JLabel("Section *");
		lblSection.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSection.setBounds(316, 40, 100, 20);
		panel_5.add(lblSection);
		
		JLabel lblRollNo = new JLabel("Roll No. **");
		lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRollNo.setBounds(316, 70, 100, 20);
		panel_5.add(lblRollNo);
		
		department = new JTextField();
		department.setEditable(false);
		department.setFont(new Font("Tahoma", Font.PLAIN, 12));
		department.setColumns(10);
		department.setBounds(120, 40, 100, 20);
		panel_5.add(department);
		
		reg = new JTextField();
		reg.setEditable(false);
		reg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		reg.setColumns(10);
		reg.setBounds(120, 70, 100, 20);
		panel_5.add(reg);
		
		JLabel lblCollege = new JLabel("College *");
		lblCollege.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCollege.setBounds(316, 10, 100, 20);
		panel_5.add(lblCollege);
		
		college = new JTextField();
		college.setEditable(false);
		college.setFont(new Font("Tahoma", Font.PLAIN, 12));
		college.setColumns(10);
		college.setBounds(426, 10, 100, 20);
		panel_5.add(college);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(176, 224, 230));
		panel_6.setBounds(0, 204, 536, 69);
		panel_7.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContactNo.setBounds(10, 10, 100, 20);
		panel_6.add(lblContactNo);
		
		JLabel lblEmail = new JLabel("Email Id");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(10, 40, 100, 20);
		panel_6.add(lblEmail);
		
		contact = new JTextField();
		contact.setEditable(false);
		contact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contact.setColumns(10);
		contact.setBounds(120, 10, 100, 20);
		panel_6.add(contact);
		
		email = new JTextField();
		email.setEditable(false);
		email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		email.setColumns(10);
		email.setBounds(120, 40, 100, 20);
		panel_6.add(email);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(316, 10, 100, 20);
		panel_6.add(lblAddress);
		
		address = new JTextArea();
		address.setFont(new Font("Monospaced", Font.PLAIN, 12));
		address.setWrapStyleWord(true);
		address.setEditable(false);
		address.setLineWrap(true);
		address.setBounds(426, 10, 100, 50);
		panel_6.add(address);
		
		JLabel label = new JLabel("General Information");
		label.setBounds(0, 0, 536, 38);
		panel_7.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblContactDetails = new JLabel("Contact Details");
		lblContactDetails.setBounds(0, 156, 536, 38);
		panel_7.add(lblContactDetails);
		lblContactDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblAcademicInformation = new JLabel("Academic Information");
		lblAcademicInformation.setBounds(0, 283, 536, 38);
		panel_7.add(lblAcademicInformation);
		lblAcademicInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcademicInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("* marked fields are mandatory.  ** marked fields are mandatory & should be unique.");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(10, 497, 536, 13);
		panel_1.add(lblNewLabel_1);
		
		btnScoreCard = new JButton("Score Card");
		btnScoreCard.setEnabled(false);
		btnScoreCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scorecardfrm scorecardfrmobj = new Scorecardfrm();
				scorecardfrmobj.setVisible(true);
			}
		});
		btnScoreCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnScoreCard.setBounds(425, 10, 121, 24);
		panel_1.add(btnScoreCard);
		
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
		lblUserName.setForeground(Color.BLACK);
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
		
		JButton btnSwitchToAdministrator = new JButton("Switch to administrator mode");
		btnSwitchToAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admainfrm admainfrmobj = new Admainfrm();
				admainfrmobj.setVisible(true);
			}
		});
		btnSwitchToAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSwitchToAdministrator.setBounds(10, 0, 227, 21);
		logedin_panel.add(btnSwitchToAdministrator);
		
		JLabel lblStudentMode = new JLabel("Student Mode");
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
		
		JPanel mnu_btn_panel = new JPanel();
		mnu_btn_panel.setBackground(new Color(176, 224, 230));
		mnu_btn_panel.setBounds(10, 54, 1144, 34);
		contentPane.add(mnu_btn_panel);
		mnu_btn_panel.setLayout(null);
		
		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStudentDetails.setBounds(489, 0, 166, 34);
		mnu_btn_panel.add(lblStudentDetails);
		
		JButton loaddb = new JButton("Load Database");
		loaddb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loaddb.setText("Refresh Database");
				SearchKey.setText("Enter Id here");
				boolean bf = false;
				String t = null;
				Glvar.stdn_roll = null;
				
				btnDelete.setEnabled(false);
				btnEdit.setEnabled(false);
				btnScoreCard.setEnabled(false);
				
				id.setEditable(bf);
				id.setText(t);
				
				fn.setEditable(bf);
				fn.setText(t);
				
				ln.setEditable(bf);
				ln.setText(t);
				
				sex.setEditable(bf);
				sex.setText(t);
				
				dob.setEditable(bf);
				dob.setText(t);
				
				contact.setEditable(bf);
				contact.setText(t);
				
				address.setEditable(bf);
				address.setText(t);
				
				email.setEditable(bf);
				email.setText(t);
				
				university.setEditable(bf);
				university.setText(t);
				
				college.setEditable(bf);
				college.setText(t);
				
				department.setEditable(bf);
				department.setText(t);
				
				section.setEditable(bf);
				section.setText(t);
				
				reg.setEditable(bf);
				reg.setText(t);

				roll.setEditable(bf);
				roll.setText(t);
				
				try {
					String sql = "SELECT * FROM sis.student;";
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		loaddb.setFont(new Font("Tahoma", Font.BOLD, 18));
		loaddb.setBounds(10, 0, 227, 34);
		mnu_btn_panel.add(loaddb);
		
	}
}
