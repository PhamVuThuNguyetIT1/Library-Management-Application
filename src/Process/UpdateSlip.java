package Process;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.BorrowSlipData;
import Objects.BorrowSlip;
import Objects.Connect;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class UpdateSlip extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTable table;
	private JRadioButton rdbtnBySlipNumber;
	private JRadioButton rdbtnByCusid;
	private JRadioButton rdbtnByCallNumber;
	private JRadioButton rdbtnByReturnTerm;
	private JButton button_3;
	private JButton button_4;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JLabel lblSlipNum;
	private JLabel lblCusId;
	private JLabel lblCallNum;
	private JLabel lblBorDate;
	private JLabel lblRetTerm;
	private JLabel lblRetDate;
	private JLabel lblDeposit;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSlip frame = new UpdateSlip();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateSlip() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		button = new JButton("SEARCH");
		button.setForeground(new Color(148, 0, 211));
		button.setBackground(Color.WHITE);
		button.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\icons8-search-64.png"));
		button.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length() == 0) {
		            String sql1 = "select * from PHIEU_MUON ";
		            Table.LoadData(sql1, table);
		        }
				else if(rdbtnBySlipNumber.isSelected()) {
		        	String sql1 = "select * from PHIEU_MUON where MAPHIEU like '"+textField.getText()+"%'";
		            Table.LoadData(sql1, table);
		        }		
				else if(rdbtnByCusid.isSelected()) {
					String sql1 = "select * from PHIEU_MUON where MA_KHACH like '"+textField.getText()+"%'";
		            Table.LoadData(sql1, table);
				}
		        else if(rdbtnByCallNumber.isSelected()) {
		            String sql1 = "select * from PHIEU_MUON where MA_SACH like '"+textField.getText()+"%'";
		            Table.LoadData(sql1, table);
		        }
		        else if(rdbtnByReturnTerm.isSelected()) {
					String sql1 = "select * from PHIEU_MUON where HAN_TRA like '"+textField.getText()+"%'";
		            Table.LoadData(sql1, table);		
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setEnabled(false);
		
		button_1 = new JButton("ADD");
		button_1.setForeground(Color.RED);
		button_1.setBackground(Color.WHITE);
		button_1.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\fce7f123bdf61abdbca195a572631467.png"));
		button_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_1.addActionListener(new ActionListener() {
			private ResultSet rs, rs1;
			private PreparedStatement ps, ps1, ps2;
			private String s,s1;
			public void actionPerformed(ActionEvent e) {
				
				try {
					ps = Connect.getConnect().prepareStatement("select TINHTRANG from SACH where MASACH=?");
					ps.setString(1, textField_3.getText());
					rs = ps.executeQuery();
					while (rs.next()) {
						s = rs.getString("TINHTRANG");
					}
					ps1 = Connect.getConnect().prepareStatement("select MA_KHACH from PHIEU_MUON where MA_KHACH =? and NGAY_TRA is null");
					ps1.setString(1, textField_2.getText());
					rs1= ps1.executeQuery();
					while(rs1.next()) {
						s1=rs1.getString("MA_KHACH");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(textField_1.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()||textField_4.getText().isEmpty()||textField_5.getText().isEmpty()||textField_7.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Invalid slip's infomation!", "Notification", 1);
				}
				else if(textField_1.getText().length()!=4) {
					JOptionPane.showMessageDialog(null, "Invalid slip number!", "Notification", 2);
				} else {
					try {
						if(textField_2.getText().equals(s1)) {
							JOptionPane.showMessageDialog(null, "This customer have not return book yet!", "Notification", 2);
						}
						else {
							if(s.equals("HET")) {
							JOptionPane.showMessageDialog(null, "This book is unavailable!", "Notification", 2);
							}
							else {
								if(textField_6.getText().isEmpty()) {
									BorrowSlip s = new BorrowSlip(textField_1.getText(), textField_2.getText(), textField_3.getText(), Date.valueOf(textField_4.getText()), Date.valueOf(textField_5.getText()), null, Integer.parseInt(textField_7.getText()));	
									BorrowSlipData.Insert(s);
									ps2 = Connect.getConnect().prepareStatement("update SACH set TINHTRANG=? where MASACH=?");
									ps2.setString(1, "HET");
									ps2.setString(2, textField_3.getText());
									ps2.executeUpdate();
									button.doClick();
								}
								else {
									BorrowSlip S= new BorrowSlip(textField_1.getText(), textField_2.getText(), textField_3.getText(), Date.valueOf(textField_4.getText()), Date.valueOf(textField_5.getText()), Date.valueOf(textField_6.getText()), Integer.parseInt(textField_7.getText()));
									BorrowSlipData.Insert(S);
									ps2 = Connect.getConnect().prepareStatement("update SACH set TINHTRANG=? where MASACH=?");
									ps2.setString(1, "CON");
									ps2.setString(2, textField_3.getText());
									ps2.executeUpdate();
									button.doClick();
								}
							}
						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		button_2 = new JButton("RETYPE");
		button_2.setForeground(Color.BLUE);
		button_2.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\990a494ead869807f280f2872303a53a.png"));
		button_2.setBackground(Color.WHITE);
		button_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_1.setEnabled(true);
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_1.setEditable(true);
				button_3.setEnabled(false);
				button_4.setEnabled(false);
				btnNewButton.setEnabled(false);
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		button_3 = new JButton("UPDATE");
		button_3.setForeground(new Color(255, 0, 255));
		button_3.setBackground(Color.WHITE);
		button_3.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\iconfinder_new-24_103173.png"));
		button_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_3.addActionListener(new ActionListener() {
			private ResultSet rs, rs0, rs1, rs2;
			private PreparedStatement ps, ps0, ps1, ps2, ps01, ps02;
			private String s, s0, s1, s2;
			public void actionPerformed(ActionEvent e) {
				try {
					ps0 =Connect.getConnect().prepareStatement("select MA_SACH from PHIEU_MUON where MAPHIEU=?");
					ps0.setString(1, textField_1.getText());
					rs0=ps0.executeQuery();
					while (rs0.next()) {
						s0=rs0.getString("MA_SACH");
					}
					ps1 =Connect.getConnect().prepareStatement("update SACH set TINHTRANG=? where MASACH=?");
					ps1.setString(1, "CON");
					ps1.setString(2, s0);
					ps1.executeUpdate();
					ps01 = Connect.getConnect().prepareStatement("select MA_KHACH from PHIEU_MUON where MA_KHACH =? and NGAY_TRA is null");
					ps01.setString(1, textField_2.getText());
					rs1= ps01.executeQuery();
					while(rs1.next()) {
						s1=rs1.getString("MA_KHACH");
					}
					ps02 = Connect.getConnect().prepareStatement("select MA_KHACH from PHIEU_MUON where MAPHIEU=?");
					ps02.setString(1, textField_1.getText());
					rs2 = ps02.executeQuery();
					while(rs2.next()) {
						s2=rs2.getString("MA_KHACH");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				try {
					ps = Connect.getConnect().prepareStatement("select TINHTRANG from SACH where MASACH=?");
					ps.setString(1, textField_3.getText());
					rs = ps.executeQuery();
					while (rs.next()) {
						s = rs.getString("TINHTRANG");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(textField_1.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()||textField_4.getText().isEmpty()||textField_5.getText().isEmpty()||textField_7.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Invalid slip's infomation!", "Notification", 1);
				}
				else {
					try {
						if(textField_2.getText().equals(s2)) {
							if(textField_6.getText().isEmpty()) {
								BorrowSlip s = new BorrowSlip(textField_1.getText(),textField_2.getText(),textField_3.getText(),Date.valueOf(textField_4.getText()),Date.valueOf(textField_5.getText()),null, Integer.parseInt(textField_7.getText()));
								BorrowSlipData.Update(s);
								ps2 = Connect.getConnect().prepareStatement("update SACH set TINHTRANG=? where MASACH=?");
								ps2.setString(1, "HET");
								ps2.setString(2, textField_3.getText());
								ps2.executeUpdate();
								button.doClick();
							}
							else {
								BorrowSlip s = new BorrowSlip(textField_1.getText(),textField_2.getText(),textField_3.getText(),Date.valueOf(textField_4.getText()),Date.valueOf(textField_5.getText()),Date.valueOf(textField_6.getText()),Integer.parseInt(textField_7.getText()));
								BorrowSlipData.Update(s);
								ps2 = Connect.getConnect().prepareStatement("update SACH set TINHTRANG=? where MASACH=?");
								ps2.setString(1, "CON");
								ps2.setString(2, textField_3.getText());
								ps2.executeUpdate();
								button.doClick();
							}
						}
						else {
							if(textField_2.getText().equals(s1)) {
								JOptionPane.showMessageDialog(null, "This customer have not return book yet!", "Notification", 2);
							}
							else {
								if(s.equals("HET")) {
								JOptionPane.showMessageDialog(null, "This book is unavailable!", "Notification", 2);
								}
								else {
									if(textField_6.getText().isEmpty()) {
										BorrowSlip s = new BorrowSlip(textField_1.getText(),textField_2.getText(),textField_3.getText(),Date.valueOf(textField_4.getText()),Date.valueOf(textField_5.getText()),null, Integer.parseInt(textField_7.getText()));
										BorrowSlipData.Update(s);
										ps2 = Connect.getConnect().prepareStatement("update SACH set TINHTRANG=? where MASACH=?");
										ps2.setString(1, "HET");
										ps2.setString(2, textField_3.getText());
										ps2.executeUpdate();
										button.doClick();
									}
									else {
										BorrowSlip s = new BorrowSlip(textField_1.getText(),textField_2.getText(),textField_3.getText(),Date.valueOf(textField_4.getText()),Date.valueOf(textField_5.getText()),Date.valueOf(textField_6.getText()),Integer.parseInt(textField_7.getText()));
										BorrowSlipData.Update(s);
										ps2 = Connect.getConnect().prepareStatement("update SACH set TINHTRANG=? where MASACH=?");
										ps2.setString(1, "CON");
										ps2.setString(2, textField_3.getText());
										ps2.executeUpdate();
										button.doClick();
									}
								}
							}
						}
			}catch (Exception e1) {
				// TODO: handle exception
			}
				}
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		button_4 = new JButton("DELETE");
		button_4.setForeground(new Color(128, 0, 0));
		button_4.setBackground(Color.WHITE);
		button_4.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\a2091c1f5008e2fe59c242eeb6075e91.png"));
		button_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_4.addActionListener(new ActionListener() {
			private PreparedStatement ps;
			public void actionPerformed(ActionEvent e) {
				try {
					ps = Connect.getConnect().prepareStatement("update SACH set TINHTRANG=? where MASACH=?");
					ps.setString(1, "CON");
					ps.setString(2, textField_3.getText());
					ps.executeUpdate();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				BorrowSlipData.Delete(textField_1.getText());
				button.doClick();
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnNewButton = new JButton("RETURN BOOK");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\ClipartKey_907647.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			private PreparedStatement ps,ps2;
			public void actionPerformed(ActionEvent e) {
				try {
					ps = Connect.getConnect().prepareStatement("update PHIEU_MUON set NGAY_TRA = (select GETDATE()) where MAPHIEU=?");
					ps.setString(1, textField_1.getText());
					ps.execute();
					ps2 = Connect.getConnect().prepareStatement("update SACH set TINHTRANG = ? where MASACH = ?");
					ps2.setString(1, "CON");
					ps2.setString(2, textField_3.getText());
					ps2.execute();
					button.doClick();
					JOptionPane.showMessageDialog(null, "Return book successfully!", "Notification", 1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Return book failed!", "Notification", 1);
				}
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblSlipNum = new JLabel("SLIP NUM");
		lblSlipNum.setForeground(Color.WHITE);
		lblSlipNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblCusId = new JLabel("CUS. ID");
		lblCusId.setForeground(Color.WHITE);
		lblCusId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblCallNum = new JLabel("CALL NUM");
		lblCallNum.setForeground(Color.WHITE);
		lblCallNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(15);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(15);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(15);
		
		lblBorDate = new JLabel("BOR. DATE");
		lblBorDate.setForeground(Color.WHITE);
		lblBorDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblRetTerm = new JLabel("RET. TERM");
		lblRetTerm.setForeground(Color.WHITE);
		lblRetTerm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblRetDate = new JLabel("RET. DATE");
		lblRetDate.setForeground(Color.WHITE);
		lblRetDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(15);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(15);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(15);
		
		lblDeposit = new JLabel("DEPOSIT");
		lblDeposit.setForeground(Color.WHITE);
		lblDeposit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_7.setColumns(15);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnNewButton_1 = new JButton("Backward");
		btnNewButton_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\0987b190ab1a5fda4479337de2ca79a7.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				m.setTitle("LIBRARY MANAGEMENT");
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		rdbtnBySlipNumber = new JRadioButton("By Slip Number");
		rdbtnBySlipNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
				rdbtnByCusid.setSelected(false);
				rdbtnByCallNumber.setSelected(false);
				rdbtnByReturnTerm.setSelected(false);
			}
		});
		rdbtnBySlipNumber.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBySlipNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnBySlipNumber.setBorderPainted(true);
		rdbtnBySlipNumber.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		rdbtnByCusid = new JRadioButton("By Cus.ID");
		rdbtnByCusid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
				rdbtnBySlipNumber.setSelected(false);
				rdbtnByCallNumber.setSelected(false);
				rdbtnByReturnTerm.setSelected(false);
			}
		});
		rdbtnByCusid.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnByCusid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnByCusid.setBorderPainted(true);
		rdbtnByCusid.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		rdbtnByCallNumber = new JRadioButton("By Call Number");
		rdbtnByCallNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
				rdbtnBySlipNumber.setSelected(false);
				rdbtnByCusid.setSelected(false);
				rdbtnByReturnTerm.setSelected(false);
			}
		});
		rdbtnByCallNumber.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnByCallNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnByCallNumber.setBorderPainted(true);
		rdbtnByCallNumber.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		rdbtnByReturnTerm = new JRadioButton("By Ret. Term");
		rdbtnByReturnTerm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
				rdbtnBySlipNumber.setSelected(false);
				rdbtnByCusid.setSelected(false);
				rdbtnByCallNumber.setSelected(false);
			}
		});
		rdbtnByReturnTerm.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnByReturnTerm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnByReturnTerm.setBorderPainted(true);
		rdbtnByReturnTerm.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(91, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
					.addGap(90))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblSlipNum, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblCusId, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
											.addGap(36)
											.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDeposit, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCallNum, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(80)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblBorDate, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblRetDate, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
											.addGap(41))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblRetTerm, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_5, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_6, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 739, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addContainerGap(27, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(69, Short.MAX_VALUE)
					.addComponent(rdbtnBySlipNumber, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(rdbtnByCusid, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(rdbtnByCallNumber, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(rdbtnByReturnTerm, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(63))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(136, Short.MAX_VALUE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(84))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnBySlipNumber, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnByCusid, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnByCallNumber, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnByReturnTerm, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_4)
						.addComponent(button_1)
						.addComponent(button_2)
						.addComponent(button_3)
						.addComponent(btnNewButton))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblSlipNum))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblBorDate)))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCusId))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblRetTerm)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRetDate)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblCallNum))
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDeposit, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(23))
		);
		
		table = new JTable();
		table.setDragEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Title 1", "Title 2", "Title 3", "Title 4"
			}
		));
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				button_1.setEnabled(false);
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				btnNewButton.setEnabled(true);
				textField_1.setEditable(false);
			        try{
			            int row = table.getSelectedRow();
			            String IDrow = (table.getModel().getValueAt(row, 0)).toString();
			            String sql1 = "SELECT * FROM PHIEU_MUON where MAPHIEU='"+IDrow+"'";
			            ResultSet rs = Table.ShowTextField(sql1);
			            if(rs.next()) {
			               textField_1.setText(rs.getString("MAPHIEU"));
			               textField_2.setText(rs.getString("MA_KHACH"));
			               textField_3.setText(rs.getString("MA_SACH"));
			               textField_4.setText(rs.getString("NGAY_MUON"));
			               textField_5.setText(rs.getString("HAN_TRA"));
			               textField_6.setText(rs.getString("NGAY_TRA"));
			               textField_7.setText(rs.getString("TIENCOC"));
			            }
			        }catch(Exception ex) {
			            
			        }
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
