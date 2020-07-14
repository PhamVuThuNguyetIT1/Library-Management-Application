package Objects;

public class Admin {
private String adminID;
private String adminPass;
public Admin() {
	
}
public Admin(String ID, String pass) {
	this.adminID=ID;
	this.adminPass=pass;
}
public String getAdminID() {
	return adminID;
}
public void setAdminID(String adminID) {
	this.adminID = adminID;
}
public String getAdminPass() {
	return adminPass;
}
public void setAdminPass(String adminPass) {
	this.adminPass = adminPass;
}

}
