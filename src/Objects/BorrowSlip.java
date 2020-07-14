package Objects;

import java.sql.Date;

public class BorrowSlip {
private String slipNum;
private String cusID;
private String calNum;
private Date borDate;
private Date retTerm;
private Date retDate;
private int deposit;
public BorrowSlip() {
	
}
public BorrowSlip(String slipNum, String cusID, String calNum, Date borDate, Date retTerm, Date retDate, int dep) {
	this.slipNum=slipNum;
	this.cusID=cusID;
	this.calNum=calNum;
	this.borDate=borDate;
	this.retTerm=retTerm;
	this.retDate=retDate;
	this.deposit=dep;
}
public String getSlipNum() {
	return slipNum;
}
public void setSlipNum(String slipNum) {
	this.slipNum = slipNum;
}
public String getCusID() {
	return cusID;
}
public void setCusID(String cusID) {
	this.cusID = cusID;
}
public String getCalNum() {
	return calNum;
}
public void setCalNum(String calNum) {
	this.calNum = calNum;
}
public Date getBorDate() {
	return borDate;
}
public void setBorDate(Date borDate) {
	this.borDate = borDate;
}
public Date getRetTerm() {
	return retTerm;
}
public void setRetTerm(Date retTerm) {
	this.retTerm = retTerm;
}
public Date getRetDate() {
	return retDate;
}
public void setRetDate(Date retDate) {
	this.retDate = retDate;
}
public int getDeposit() {
	return deposit;
}
public void setDeposit(int deposit) {
	this.deposit = deposit;
}

}
