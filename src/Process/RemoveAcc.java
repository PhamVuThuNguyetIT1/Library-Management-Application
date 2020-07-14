package Process;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

import Data.AdminData;
import Objects.Connect;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class RemoveAcc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveAcc frame = new RemoveAcc();
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
	public RemoveAcc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "REMOVE ACCOUNT", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		JButton btnNewButton = new JButton("REMOVE ACCOUNT");
		btnNewButton.addActionListener(new ActionListener() {
			private PreparedStatement ps;
			private ResultSet rs;
			String s;
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					ps = Connect.getConnect().prepareStatement("select PASSWORD from ADMIN where MA_ADMIN=?");
					ps.setString(1, textField.getText());
					rs=ps.executeQuery();
					while (rs.next()) {
						s=rs.getString("PASSWORD");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(passwordField.getText().equals(s)) {
					AdminData.Delete(textField.getText());
					JOptionPane.showMessageDialog(null, "Please login or register to enter the service!", "Notification", 1);
					Login lg = new Login();
					lg.setVisible(true);
					lg.setTitle("LIBRARY MANAGEMENT");
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong username or password!", "Notification", 1);
				}
			}
		});
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\PinClipart.com_chromosome-clipart_3345797.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("BACKWARD");
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				m.setTitle("LIBRARY MANAGEMENT");
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\0987b190ab1a5fda4479337de2ca79a7.png"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
