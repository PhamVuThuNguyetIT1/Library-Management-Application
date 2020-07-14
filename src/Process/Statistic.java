package Process;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class Statistic extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistic frame = new Statistic();
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
	public Statistic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "STATISTIC", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label = new JLabel("New label");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("New label");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("New label");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("New label");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblListOfOverdue = new JLabel("LIST OF OVERDUE SLIPS");
		lblListOfOverdue.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfOverdue.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Backward");
		btnNewButton.setForeground(Color.BLUE);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblListOfOverdue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
							.addComponent(label_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
							.addComponent(label_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
							.addComponent(label_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
							.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
							.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
							.addComponent(scrollPane, Alignment.LEADING)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addComponent(lblListOfOverdue)
					.addGap(38)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(btnNewButton)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null}
		            },
		            new String [] {
		                "Title 1", "Title 2", "Title 3", "Title 4"
		            }
		        ));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
        try{
            String sql1 = "SELECT COUNT(MASACH) as tongsach FROM SACH";
            String sql2 = "SELECT COUNT(MAKH) as tongkhach FROM KHACH_HANG";
            String sql3 = "SELECT COUNT(MAPHIEU) as tongphieu FROM PHIEU_MUON";
            String sql4 = "SELECT COUNT(DISTINCT MA_KHACH) as khachmuon FROM PHIEU_MUON";
            String sql5 = "SELECT COUNT(MAPHIEU) as phieumuon FROM PHIEU_MUON where (HAN_TRA < (select GETDATE()) and NGAY_TRA IS NULL)";
            ResultSet rs1 = Table.ShowTextField(sql1);
            ResultSet rs2 = Table.ShowTextField(sql2);
            ResultSet rs3 = Table.ShowTextField(sql3);
            ResultSet rs4 = Table.ShowTextField(sql4);
            ResultSet rs5 = Table.ShowTextField(sql5);
            if(rs1.next()) lblNewLabel.setText(" Total number of books: "+Integer.toString(rs1.getInt("tongsach")));
            if(rs2.next()) label.setText(" Total number of customers: " + Integer.toString(rs2.getInt("tongkhach")));
            if(rs3.next()) label_1.setText(" Total number of slips: "+Integer.toString(rs3.getInt("tongphieu")));
            if(rs4.next()) label_2.setText(" Total number of customers borrowing books: "+Integer.toString(rs4.getInt("khachmuon")));
            if(rs5.next()) label_3.setText(" Total number of overdue slips : "+Integer.toString(rs5.getInt("phieumuon")));            
        }catch(Exception e) { 
        }
        Table.LoadData("select * from PHIEU_MUON where (HAN_TRA<(select GETDATE()) and NGAY_TRA IS NULL)", table);
	}
}
