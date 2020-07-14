package Process;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import Data.AdminData;
import Objects.Admin;
import Objects.Connect;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ChangePass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePass frame = new ChangePass();
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
	public ChangePass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "CHANGE PASSWORD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Username");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("CHANGE PASSWORD");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\PinClipart.com_password-clipart_3892916.png"));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps = null;
				String s = null;
				try {
					ps = Connect.getConnect().prepareStatement("select PASSWORD from ADMIN where MA_ADMIN=?");
					ps.setString(1, textField.getText());
					ResultSet rs =ps.executeQuery();
					while(rs.next()) {
						s= rs.getString("PASSWORD");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(passwordField.getText().equals(s)) {
				if(passwordField_1.getText().equals(passwordField_2.getText())){
						Admin ad = new Admin(textField.getText(), passwordField_1.getText());
						AdminData.Update(ad);
					}
					else {
					JOptionPane.showMessageDialog(null, "Please enter the same new value!", "Notification", 1);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong username or password!", "Notification", 1);
				}
			}
		});
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("Backward");
		btnNewButton_1.setForeground(Color.BLUE);
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
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewPassword, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
								.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(lblNewPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
