package org.mycompany.model;

public class StatementRequest {

private String productCode;
private String accountId;
private String paperTypeCode;
private String fromDate;
private String toDate;

public String getProductCode() {
	return productCode;
}
public void setProductCode(String productCode) {
	this.productCode = productCode;
}
public String getAccountId() {
	return accountId;
}
public void setAccountId(String accountId) {
	this.accountId = accountId;
}
public String getPaperTypeCode() {
	return paperTypeCode;
}
public void setPaperTypeCode(String paperTypeCode) {
	this.paperTypeCode = paperTypeCode;
}
public String getFromDate() {
	return fromDate;
}
public void setFromDate(String fromDate) {
	this.fromDate = fromDate;
}
public String getToDate() {
	return toDate;
}
public void setToDate(String toDate) {
	this.toDate = toDate;
}

}
