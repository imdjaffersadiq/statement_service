package org.mycompany.model;

public class RetrieveOnlineStatementResponse {
	
	protected AccountDetails account;
	protected TransactionDetails transaction;
	protected FaultType fault;
	public AccountDetails getAccount() {
		return account;
	}
	public void setAccount(AccountDetails account) {
		this.account = account;
	}
	public TransactionDetails getTransaction() {
		return transaction;
	}
	public void setTransaction(TransactionDetails transaction) {
		this.transaction = transaction;
	}
	public FaultType getFault() {
		return fault;
	}
	public void setFault(FaultType fault) {
		this.fault = fault;
	}

//	private String accountNumber;
//	private String name1;
//	private String name2;
//	private String address1;
//	private String address2;
//	private String balance;
//	private FaultType fault;
//	public String getAccountNumber() {
//		return accountNumber;
//	}
//	public void setAccountNumber(String accountNumber) {
//		this.accountNumber = accountNumber;
//	}
//	public String getName1() {
//		return name1;
//	}
//	public void setName1(String name1) {
//		this.name1 = name1;
//	}
//	public String getName2() {
//		return name2;
//	}
//	public void setName2(String name2) {
//		this.name2 = name2;
//	}
//	public String getAddress1() {
//		return address1;
//	}
//	public void setAddress1(String address1) {
//		this.address1 = address1;
//	}
//	public String getAddress2() {
//		return address2;
//	}
//	public void setAddress2(String address2) {
//		this.address2 = address2;
//	}
//	public String getBalance() {
//		return balance;
//	}
//	public void setBalance(String balance) {
//		this.balance = balance;
//	}
//	public FaultType getFault() {
//		return fault;
//	}
//	public void setFault(FaultType fault) {
//		this.fault = fault;
//	}
	
	
}
