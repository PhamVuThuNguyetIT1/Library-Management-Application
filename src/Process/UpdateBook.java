package Process;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Data.BookData;
import Objects.Book;

import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class UpdateBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnAdd;
	private JButton btnRetype;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JTextField textField_1;
	private JLabel lblTitle;
	private JTextField textField_2;
	private JLabel lblKind;
	private JTextField textField_3;
	private JLabel lblAuthor;
	private JTextField textField_4;
	private JLabel lblPubcomp;
	private JTextField textField_5;
	private JLabel lblPrice;
	private JTextField textField_6;
	private JScrollPane scrollPane;
	private JTable table;
	private JRadioButton rdbtnByTitle;
	private JRadioButton rdbtnByAuthor;
	private JRadioButton radioButton;
	private JLabel lblNewLabel;
	private JTextField textField_7;
	private JRadioButton rdbtnNewRadioButton;
	private JButton btnSearch;
	private JLabel lblCallNum;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBook frame = new UpdateBook();
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
	public UpdateBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800 , 600);
		contentPane = new JPanel();
		contentPane.setFocusTraversalKeysEnabled(false);
		contentPane.setDoubleBuffered(false);
		contentPane.setAutoscrolls(true);
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new LineBorder(new Color(130, 135, 144), 0)));
		setContentPane(contentPane);
		
		rdbtnNewRadioButton = new JRadioButton("By Call Number");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
				rdbtnByAuthor.setSelected(false);
	        	rdbtnByTitle.setSelected(false);
	        	radioButton.setSelected(false);
			}
		});
		rdbtnNewRadioButton.setBorderPainted(true);
		rdbtnNewRadioButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		rdbtnByTitle = new JRadioButton("By Title");
		rdbtnByTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
				rdbtnNewRadioButton.setSelected(false);
				rdbtnByAuthor.setSelected(false);
				radioButton.setSelected(false);
			}
		});
		rdbtnByTitle.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnByTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnByTitle.setBorderPainted(true);
		rdbtnByTitle.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		rdbtnByAuthor = new JRadioButton("By Author");
		rdbtnByAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
				rdbtnNewRadioButton.setSelected(false);
	        	rdbtnByTitle.setSelected(false);
	        	radioButton.setSelected(false);
			}
		});
		rdbtnByAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnByAuthor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnByAuthor.setBorderPainted(true);
		rdbtnByAuthor.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		radioButton = new JRadioButton("By Kind");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
				rdbtnNewRadioButton.setSelected(false);
	        	rdbtnByTitle.setSelected(false);
				rdbtnByAuthor.setSelected(false);
			}
		});
		radioButton.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton.setBorderPainted(true);
		radioButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		btnSearch = new JButton("SEARCH");
		btnSearch.setForeground(new Color(148, 0, 211));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\icons8-search-64.png"));
		btnSearch.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length() == 0) {
		            String sql1 = "select * from SACH ";
		            Table.LoadData(sql1, table);
		        }else if(rdbtnNewRadioButton.isSelected()) {
		        	String sql1 = "select * from SACH where MASACH like '"+textField.getText()+"%'";
		            Table.LoadData(sql1, table);
		        }		
				else if(rdbtnByTitle.isSelected()) {
					String sql1 = "select * from SACH where TENSACH like '"+textField.getText()+"%'";
		            Table.LoadData(sql1, table);
				}
		        else if(rdbtnByAuthor.isSelected()) {
		            String sql1 = "select * from SACH where TACGIA like '"+textField.getText()+"%'";
		            Table.LoadData(sql1, table);
		        }
		        else if(radioButton.isSelected()) {
					String sql1 = "select * from SACH where THELOAI like '"+textField.getText()+"%'";
		            Table.LoadData(sql1, table);		
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setEnabled(false);
		
		btnAdd = new JButton("ADD");
		btnAdd.setForeground(Color.RED);
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\fce7f123bdf61abdbca195a572631467.png"));
		btnAdd.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()||textField_4.getText().isEmpty()||textField_5.getText().isEmpty()||textField_6.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Invalid book's infomation!", "Notification", 1);
				}
				else if(textField_1.getText().length()!=4) {
					JOptionPane.showMessageDialog(null, "Invalid call number!", "Notification", 2);
				}
		        else {
				Book B = new Book(textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText(),textField_5.getText(), Integer.parseInt(textField_6.getText()), textField_7.getText());
				BookData.Insert(B);
				btnSearch.doClick();
		        }
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnRetype = new JButton("RETYPE");
		btnRetype.setForeground(Color.BLUE);
		btnRetype.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\990a494ead869807f280f2872303a53a.png"));
		btnRetype.setBackground(Color.WHITE);
		btnRetype.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRetype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd.setEnabled(true);
				btnUpdate.setEnabled(false);
				btnDelete.setEnabled(false);
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_1.setEditable(true);
			}
		});
		btnRetype.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(255, 0, 255));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\iconfinder_new-24_103173.png"));
		btnUpdate.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()||textField_4.getText().isEmpty()||textField_5.getText().isEmpty()||textField_6.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Invalid book's infomation!", "Notification", 1);
				}else {
				Book B = new Book(textField_1.getText(), textField_2.getText(), textField_3.getText(),textField_4.getText(), textField_5.getText(), Integer.parseInt(textField_6.getText()), textField_7.getText());
				BookData.Update(B);
				btnSearch.doClick();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnDelete = new JButton("DELETE");
		btnDelete.setForeground(new Color(128, 0, 0));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\a2091c1f5008e2fe59c242eeb6075e91.png"));
		btnDelete.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookData.Delete(textField_1.getText());
				btnSearch.doClick();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblCallNum = new JLabel("CALL NUM");
		lblCallNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(15);
		
		lblTitle = new JLabel("TITLE");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(15);
		
		lblKind = new JLabel("KIND");
		lblKind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(15);
		
		lblAuthor = new JLabel("AUTHOR");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(15);
		
		lblPubcomp = new JLabel("PUB.COMP");
		lblPubcomp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(15);
		
		lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(15);
		
		scrollPane = new JScrollPane();
		
		btnNewButton = new JButton("Backward");
		btnNewButton.setForeground(new Color(0, 0, 205));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\0987b190ab1a5fda4479337de2ca79a7.png"));
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				m.setTitle("LIBRARY MANAGEMENT");
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel = new JLabel("STATUS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_7.setColumns(15);
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(0)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(rdbtnNewRadioButton))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(89)
											.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(43)
											.addComponent(rdbtnByTitle, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
											.addGap(43)
											.addComponent(rdbtnByAuthor, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
											.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
											.addGap(37))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(21)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(scrollPane, Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCallNum, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblKind, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
													.addGap(114)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(lblPubcomp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
														.addComponent(lblPrice, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblAuthor, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
												.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))))))
							.addPreferredGap(ComponentPlacement.RELATED, 3, Short.MAX_VALUE)))
					.addContainerGap(18, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(133, Short.MAX_VALUE)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btnRetype, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(119))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnByTitle, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnByAuthor, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnRetype)
						.addComponent(btnUpdate)
						.addComponent(btnDelete))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCallNum)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitle)
						.addComponent(lblPubcomp, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKind, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addContainerGap())
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
				btnAdd.setEnabled(false);
				btnRetype.setEnabled(true);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				textField_1.setEditable(false);
			        try{
			            int row = table.getSelectedRow();
			            String IDrow = (table.getModel().getValueAt(row, 0)).toString();
			            String sql1 = "SELECT * FROM SACH where MASACH='"+IDrow+"'";
			            ResultSet rs = Table.ShowTextField(sql1);
			            if(rs.next()) {
			               textField_1.setText(rs.getString("MASACH"));
			               textField_2.setText(rs.getString("TENSACH"));
			               textField_3.setText(rs.getString("THELOAI"));
			               textField_4.setText(rs.getString("TACGIA"));
			               textField_5.setText(rs.getString("NXB"));
			               textField_6.setText(rs.getString("GIABIA"));
			            }
			        }catch(Exception ex) {
			            
			        }
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
