package Objects;

import java.sql.Date;

public class Customer {
private String customerID;
private String name;
private String sex;
private Date birthday;
private String address;
private String phoneNum;
public Customer() {
	
}
public Customer(String ID, String name, String sex, Date birth, String add, String phone) {
	this.customerID=ID;
	this.name=name;
	this.sex=sex;
	this.birthday=birth;
	this.address=add;
	this.phoneNum=phone;
}
public String getCustomerID() {
	return customerID;
}
public void setCustomerID(String customerID) {
	this.customerID = customerID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhoneNum() {
	return phoneNum;
}
public void setPhoneNum(String phoneNum) {
	this.phoneNum = phoneNum;
}

}
