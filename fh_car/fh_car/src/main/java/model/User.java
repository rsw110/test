package model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
private int id;
private String uname;
private int carid;
private String carType;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date buyDate;
private double price;
private int isAllIn;
private String imgUrl;

public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public int getCarid() {
	return carid;
}
public void setCarid(int carid) {
	this.carid = carid;
}
public String getCarType() {
	return carType;
}
public void setCarType(String carType) {
	this.carType = carType;
}
public Date getBuyDate() {
	return buyDate;
}
public void setBuyDate(Date buyDate) {
	this.buyDate = buyDate;
}
public int getIsAllIn() {
	return isAllIn;
}
public void setIsAllIn(int isAllIn) {
	this.isAllIn = isAllIn;
}
public String getImgUrl() {
	return imgUrl;
}
public void setImgUrl(String imgUrl) {
	this.imgUrl = imgUrl;
}

}
