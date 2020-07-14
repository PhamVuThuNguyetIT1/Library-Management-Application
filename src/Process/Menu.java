package Process;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "MENU", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		setContentPane(contentPane);
		
		JButton btnUpdate = new JButton("UPDATE BOOK");
		btnUpdate.setForeground(Color.RED);
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\PinClipart.com_read-a-book-clip_4935744.png"));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateBook udb= new UpdateBook();
				udb.setTitle("BOOKS MANAGEMENT");
				udb.setVisible(true);
				dispose();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnSearch = new JButton("UPDATE SLIP");
		btnSearch.setForeground(new Color(50, 205, 50));
		btnSearch.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\PinClipart.com_clipart-sites_5480.png"));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateSlip uds= new UpdateSlip();
				uds.setVisible(true);
				uds.setTitle("SLIPS MANAGEMENT");
				dispose();
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnStatistic = new JButton("STATISTIC");
		btnStatistic.setForeground(new Color(153, 0, 0));
		btnStatistic.setIconTextGap(6);
		btnStatistic.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\PinClipart.com_graph-clipart_111498.png"));
		btnStatistic.setBackground(Color.WHITE);
		btnStatistic.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statistic st = new Statistic();
				st.setVisible(true);
				st.setTitle("STATISTIC");
				dispose();
			}
		});
		btnStatistic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnUpdateCustomer = new JButton("UPDATE CUSTOMER");
		btnUpdateCustomer.setForeground(Color.MAGENTA);
		btnUpdateCustomer.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\PinClipart.com_supermarket-building-clipart_831272.png"));
		btnUpdateCustomer.setBackground(Color.WHITE);
		btnUpdateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCustomer udc= new UpdateCustomer();
				udc.setVisible(true);
				udc.setTitle("CUSTOMER MANAGEMENT");
				dispose();
			}
		});
		btnUpdateCustomer.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUpdateCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\kisspng-computer-icons-download-login-icon-design-exit-5ac22872b9f219.2043624015226737787616.png"));
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("CHANGE PASSWORD");
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\PinClipart.com_password-clipart_3892916.png"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePass cp = new ChangePass();
				cp.setVisible(true);
				cp.setTitle("CHANGE PASSWORD");
				dispose();
			}
		});
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnDeleteAccount = new JButton("REMOVE ACCOUNT");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveAcc rm = new RemoveAcc();
				rm.setVisible(true);
				rm.setTitle("REMOVE ACCOUNT");
				dispose();
			}
		});
		btnDeleteAccount.setIcon(new ImageIcon("C:\\Users\\nk\\Pictures\\PinClipart.com_chromosome-clipart_3345797.png"));
		btnDeleteAccount.setIconTextGap(6);
		btnDeleteAccount.setForeground(Color.BLACK);
		btnDeleteAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteAccount.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDeleteAccount.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(316)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(btnUpdateCustomer, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 165, Short.MAX_VALUE)
								.addComponent(btnUpdate, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
							.addGap(49)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnSearch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnStatistic, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnDeleteAccount, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnSearch))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdateCustomer)
						.addComponent(btnStatistic))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnDeleteAccount, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
