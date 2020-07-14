package Process;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.CustomerData;
import Objects.Customer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class UpdateCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JRadioButton rdbtnByName;
	private JRadioButton rdbtnByCustomerId;
	private JRadioButton rdbtnBySex;
	private JRadioButton rdbtnByAddress;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JLabel lblPhone;
	private Container lblAddress;
	private JLabel lblBirthday;
	private Container lblSex;
	private JLabel lblName;
	private JLabel lblCusid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomer frame = new UpdateCustomer();
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
	public UpdateCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
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
		            String sql1 = "select * from KHACH_HANG ";
		            Table.LoadData(sql1, table);
		        }
				else if(rdbtnByCustomerId.isSelected()) {
		        	String sql1 = "select * from KHACH_HANG where MAKH like '"+textField.getText()+"%'";
		            Table.LoadData(sql1, table);
		        }		
				else if(rdbtnByName.isSelected()) {
					String sql1 = "select * from KHACH_HANG where TENKH like '"+textField.getText()+"%'";
		            Table.LoadData(sql1, table);
				}
		        else if(rdbtnBySex.isSelected()) {
		            String sql1 = "select * from KHACH_HANG where GTINH like '"+textField.getText()+"%'";
		            Table.LoadData(sql1, table);
		        }
		        else if(rdbtnByAddress.isSelected()) {
					String sql1 = "select * from KHACH_HANG where DCHI like '"+textField.getText()+"%'";
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
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()||textField_4.getText().isEmpty()||textField_5.getText().isEmpty()||textField_6.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Invalid customer infomation!", "Notification", 1);
				}
				else if(textField_1.getText().length()!=4) {
					JOptionPane.showMessageDialog(null, "Invalid customer ID!", "Notification", 2);
				}
		        else {
				Customer C = new Customer(textField_1.getText(),textField_2.getText(),textField_3.getText(),Date.valueOf(textField_4.getText()),textField_5.getText(), textField_6.getText());
				CustomerData.Insert(C);
				button.doClick();
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
				textField_1.setEditable(true);
				button_3.setEnabled(false);
				button_4.setEnabled(false);
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		button_3 = new JButton("UPDATE");
		button_3.setForeground(new Color(255, 0, 255));
		button_3.setBackground(Color.WHITE);
		button_3.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\iconfinder_new-24_103173.png"));
		button_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()||textField_4.getText().isEmpty()||textField_5.getText().isEmpty()||textField_6.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Invalid customer infomation!", "Notification", 1);
				}else {
				Customer C = new Customer(textField_1.getText(),textField_2.getText(),textField_3.getText(),Date.valueOf(textField_4.getText()),textField_5.getText(), textField_6.getText());
				CustomerData.Update(C);
				button.doClick();
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
			public void actionPerformed(ActionEvent e) {
				CustomerData.Delete(textField_1.getText());
				button.doClick();
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblCusid = new JLabel("CUS.ID");
		lblCusid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(15);
		
		lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(15);
		
		lblSex = new JLabel("SEX");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(15);
		
		lblBirthday = new JLabel("BIRTHDAY");
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(15);
		
		lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(15);
		
		lblPhone = new JLabel("PHONE");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(15);
		
		JScrollPane scrollPane = new JScrollPane();
		
		button_5 = new JButton("Backward");
		button_5.setForeground(new Color(0, 0, 205));
		button_5.setBackground(Color.WHITE);
		button_5.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\0987b190ab1a5fda4479337de2ca79a7.png"));
		button_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				m.setTitle("LIBRARY MANAGEMENT");
				dispose();
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		rdbtnByCustomerId = new JRadioButton("By Cus.ID");
		rdbtnByCustomerId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
				rdbtnByName.setSelected(false);
				rdbtnBySex.setSelected(false);
				rdbtnByAddress.setSelected(false);
			}
		});
		rdbtnByCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnByCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnByCustomerId.setBorderPainted(true);
		rdbtnByCustomerId.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		rdbtnByName = new JRadioButton("By Name");
		rdbtnByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
				rdbtnByCustomerId.setSelected(false);
				rdbtnBySex.setSelected(false);
				rdbtnByAddress.setSelected(false);
			}
		});
		rdbtnByName.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnByName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnByName.setBorderPainted(true);
		rdbtnByName.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		rdbtnBySex = new JRadioButton("By Sex");
		rdbtnBySex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
				rdbtnByCustomerId.setSelected(false);
				rdbtnByName.setSelected(false);
				rdbtnByAddress.setSelected(false);
			}
		});
		rdbtnBySex.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBySex.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnBySex.setBorderPainted(true);
		rdbtnBySex.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		rdbtnByAddress = new JRadioButton("By Address");
		rdbtnByAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
				rdbtnByCustomerId.setSelected(false);
				rdbtnByName.setSelected(false);
				rdbtnBySex.setSelected(false);
			}
		});
		rdbtnByAddress.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnByAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnByAddress.setBorderPainted(true);
		rdbtnByAddress.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(70, Short.MAX_VALUE)
					.addComponent(rdbtnByCustomerId, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(rdbtnByName, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(rdbtnBySex, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(rdbtnByAddress, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblSex, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(54)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addGap(106)
								.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addGap(49)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(54)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addGap(106)
								.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblCusid, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addGap(106)
								.addComponent(lblBirthday, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
						.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane))
					.addContainerGap(18, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(159, Short.MAX_VALUE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(148))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnByCustomerId, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnByName, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(rdbtnByAddress, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnBySex, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCusid, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblBirthday, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblSex, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
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
				textField_1.setEditable(false);
			        try{
			            int row = table.getSelectedRow();
			            String IDrow = (table.getModel().getValueAt(row, 0)).toString();
			            String sql1 = "select * from KHACH_HANG where MAKH='"+IDrow+"'";
			            ResultSet rs = Table.ShowTextField(sql1);
			            if(rs.next()) {
			               textField_1.setText(rs.getString("MAKH"));
			               textField_2.setText(rs.getString("TENKH"));
			               textField_3.setText(rs.getString("GTINH"));
			               textField_4.setText(rs.getString("NGSINH"));
			               textField_5.setText(rs.getString("DCHI"));
			               textField_6.setText(rs.getString("DIENTHOAI"));
			            }
			        }catch(Exception ex) {
			            
			        }
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
