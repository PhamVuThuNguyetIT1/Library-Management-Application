package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Objects.Book;
import Objects.Connect;

public class BookData {
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

public static void Insert(Book B) {
	try {
		ps=Connect.getConnect().prepareStatement("insert into SACH(MASACH, TENSACH, THELOAI, TACGIA, NXB, GIABIA, TINHTRANG) values (?,?,?,?,?,?,?)");
		ps.setString(1, B.getCallNum());
		ps.setString(2, B.getTitle());
		ps.setString(3, B.getKind());
		ps.setString(4, B.getAuthor());
		ps.setString(5, B.getPublishingComp());
		ps.setInt(6, B.getPrice());
		ps.setString(7, B.getStatus());
		ps.execute();
		JOptionPane.showMessageDialog(null, "Add Book Successfully!","Notification",1);
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Add Book Failed!","Notification",1);
	}	
}

public static void Update(Book B) {
	try {
		ps=Connect.getConnect().prepareStatement("update SACH set TENSACH=?, THELOAI=?, TACGIA=?, NXB=?, GIABIA=?, TINHTRANG=? where MASACH=?");
		ps.setString(1, B.getTitle());
		ps.setString(2, B.getKind());
		ps.setString(3, B.getAuthor());
		ps.setString(4, B.getPublishingComp());
		ps.setInt(5, B.getPrice());
		ps.setString(6, B.getStatus());
		ps.setString(7, B.getCallNum());
		ps.execute();
		JOptionPane.showMessageDialog(null, "Update Book Successfully!","Notification",1);
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Update Book Failed!","Notification",1);
	}
}

public static void Delete(String MASACH) {
	try {
		ps=Connect.getConnect().prepareStatement("delete from SACH where MASACH=?");
		ps.setString(1, MASACH);
		ps.execute();
		JOptionPane.showMessageDialog(null, "Delete Book Successfully!","Notification",1);
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Delete Book Failed!","Notification",1);
	}
}
}
