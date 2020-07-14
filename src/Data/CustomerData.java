package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Objects.Connect;
import Objects.Customer;

public class CustomerData {
	public static PreparedStatement ps;
    public static ResultSet rs;
    
    public static ResultSet showTextfield(String sql) {
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    
    public static void Insert(Customer kh) {
        String sql = "insert into KHACH_HANG(MAKH, TENKH, GTINH, NGSINH, DCHI, DIENTHOAI) values(?,?,?,?,?,?)";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, kh.getCustomerID());
            ps.setString(2, kh.getName());
            ps.setString(3, kh.getSex());
            ps.setDate(4, kh.getBirthday());
            ps.setString(5, kh.getAddress());
            ps.setString(6, kh.getPhoneNum());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Add Customer Successfully!" , "Notification", 1);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Add Customer Failed!" , "Notification", 1);
        }
    }
    
    public static void Update(Customer kh) {
        try {
            ps = Connect.getConnect().prepareStatement("update KHACH_HANG set TENKH = ?, GTINH = ?, NGSINH = ?, DCHI = ?, DIENTHOAI = ? where MAKH = ?");
            ps.setString(6, kh.getCustomerID());
            ps.setString(1, kh.getName());
            ps.setString(2, kh.getSex());
            ps.setDate(3, kh.getBirthday());
            ps.setString(4, kh.getAddress());
            ps.setString(5, kh.getPhoneNum());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Update Customer Successfully!" , "Notification", 1);
        } catch (Exception e) {
        	 JOptionPane.showMessageDialog(null, "Update Customer Failed!" , "Notification", 1);
        }
    }
    
    public static void Delete(String maKH) {
        try {
            ps = Connect.getConnect().prepareStatement("delete from KHACH_HANG WHERE MAKH = ?");
            ps.setString(1, maKH);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Delete Customer Successfully!" , "Notification", 1);
        } catch(Exception e) {
        	 JOptionPane.showMessageDialog(null, "Delete Customer Failed!" , "Notification", 1);
        }
    }
}
