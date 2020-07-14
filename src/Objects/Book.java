package Objects;

public class Book {
private String callNum;
private String title;
private String kind;
private String author;
private String publishingComp;
private int price;
private String status;
public Book() {
	
}
public Book(String calNum, String title, String kind, String auth, String pubComp, int price, String stat) {
	this.callNum=calNum;
	this.title=title;
	this.kind=kind;
	this.author=auth;
	this.publishingComp=pubComp;
	this.price=price;
	this.setStatus(stat);
}
public String getKind() {
	return kind;
}
public void setKind(String kind) {
	this.kind = kind;
}
public String getCallNum() {
	return callNum;
}
public void setCallNum(String callNum) {
	this.callNum = callNum;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublishingComp() {
	return publishingComp;
}
public void setPublishingComp(String publishingComp) {
	this.publishingComp = publishingComp;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
