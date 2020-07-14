package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Objects.Connect;
import Objects.BorrowSlip;

public class BorrowSlipData {
	public static PreparedStatement ps;
	public static ResultSet rs;

	public static ResultSet showTextfield(String sql) {
		try {
			ps=Connect.getConnect().prepareStatement(sql);
			return ps.executeQuery();		
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void Insert(BorrowSlip p) {
        String sql = "insert into PHIEU_MUON(MAPHIEU, MA_KHACH, MA_SACH, NGAY_MUON, HAN_TRA, NGAY_TRA, TIENCOC) values(?,?,?,?,?,?,?)";
        try {
            ps = Connect.getConnect().prepareStatement(sql);
            ps.setString(1, p.getSlipNum());
            ps.setString(2, p.getCusID());
            ps.setString(3, p.getCalNum());
            ps.setDate(4, p.getBorDate());
            ps.setDate(5, p.getRetTerm());
            ps.setDate(6, p.getRetDate());
            ps.setInt(7, p.getDeposit());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Add Slip Successfully!" , "Notification", 1);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Add Slip Failed!" , "Notification", 1);
        }
    }
	
	  public static void Update(BorrowSlip p) {
	        try {
	            ps = Connect.getConnect().prepareStatement("update PHIEU_MUON set MA_KHACH=?, MA_SACH=?, NGAY_MUON=?, HAN_TRA=?, NGAY_TRA=?, TIENCOC=? where MAPHIEU=?");
	            ps.setString(1, p.getCusID());
	            ps.setString(2, p.getCalNum());
	            ps.setDate(3, p.getBorDate());
	            ps.setDate(4, p.getRetTerm());
	            ps.setDate(5, p.getRetDate());
	            ps.setInt(6, p.getDeposit());
	            ps.setString(7, p.getSlipNum());
	            ps.execute();
	            JOptionPane.showMessageDialog(null, "Update Slip Successfully!" , "Notification", 1);
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Update Slip Failed!" , "Notification", 1);
	        }
	    }
	    
	    public static void Delete(String mp) {
	        try {
	            ps = Connect.getConnect().prepareStatement("delete from PHIEU_MUON where MAPHIEU=?");
	            ps.setString(1, mp);
	            ps.execute();
	            JOptionPane.showMessageDialog(null, "Delete Slip Successfully!","Notification",1);
	        } catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, "Delete Slip Failed!","Notification",1);
	        }
	    }
}
