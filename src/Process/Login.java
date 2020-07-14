package Process;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import Data.AdminData;
import Objects.Admin;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;


public class Login extends JFrame {

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
					Login log = new Login();
					log.setTitle("LIBRARY MANAGEMENT");
					log.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "LOGIN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.setBackground(Color.YELLOW);
		setContentPane(contentPane);
		
		JLabel lblAccount = new JLabel("Username");
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.GREEN);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\kisspng-computer-icons-login-icon-design-5b2c21206296c8.1035883515296187204038.png"));
		btnLogin.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String acc=textField.getText();
				@SuppressWarnings("deprecation")
				String pass=passwordField.getText();
				if(acc.isEmpty()||pass.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Invalid account or password!", "Notification", 1);
				}else {
					Admin ad= AdminData.Login(acc, pass);
				try {
					if(ad!=null) {
						Menu m = new Menu();
						m.setVisible(true);
						m.setTitle("LIBRARY MANAGEMENT");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Account not found!", "Notification",1);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\kisspng-computer-icons-download-login-icon-design-exit-5ac22872b9f219.2043624015226737787616.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("REGISTER");
		btnNewButton_1.setForeground(Color.MAGENTA);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\FAVPNG_share-icon-clip-art_H7aTKSqZ.png"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register rg = new Register();
				rg.setVisible(true);
				rg.setTitle("REGISTER FORM");
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword)
								.addComponent(lblAccount))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, 222, 222, 222)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccount)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton)
						.addComponent(btnLogin))
					.addGap(46))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
