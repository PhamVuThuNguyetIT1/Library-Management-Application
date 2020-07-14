package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Objects.Admin;
import Objects.Connect;

public class AdminData {
public static PreparedStatement ps;

public static Admin Login(String id, String pass) {
	Admin ad=null;
	try {
		ps=Connect.getConnect().prepareStatement("select * from ADMIN where MA_ADMIN=? and PASSWORD=?");
		ps.setString(1,id);
		ps.setString(2,pass);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ad=new Admin();
		}		
	} catch (Exception e) {
		return ad=null;
	}
	return ad;
}

public static ResultSet showTextfield(String sql) {
	try {
		ps=Connect.getConnect().prepareStatement(sql);
		return ps.executeQuery();
	} catch (Exception e) {
		return null;
	}
}

public static void Update(Admin ad) {
	try {
		ps=Connect.getConnect().prepareStatement("update ADMIN set PASSWORD=? where MA_ADMIN=?");
		ps.setString(1, ad.getAdminPass());
		ps.setString(2, ad.getAdminID());
		ps.execute();
		JOptionPane.showMessageDialog(null, "Change password successfully!","Notification",1);
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Change password failed!","Notification",1);
	}
}

public static void Delete(String adID) {
	try {
		ps=Connect.getConnect().prepareStatement("delete from ADMIN where MA_ADMIN=?");
		ps.setString(1, adID);
		ps.execute();
		JOptionPane.showMessageDialog(null, "Remove account successfully!","Notification",1);
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Remove account failed!","Notification",1);
	}
}

}
