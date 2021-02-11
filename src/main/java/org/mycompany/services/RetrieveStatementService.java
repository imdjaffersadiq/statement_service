package org.mycompany.services;

import org.apache.camel.Exchange;
import org.mycompany.model.AccountDetails;
import org.mycompany.model.FaultType;
import org.mycompany.model.RetrieveOnlineStatementRequest;
import org.mycompany.model.RetrieveOnlineStatementRequest;
import org.mycompany.model.RetrieveOnlineStatementResponse;
import org.mycompany.model.TransactionDetails;

public class RetrieveStatementService {
	
	
	
	public RetrieveOnlineStatementResponse getStatementService(Exchange exchange) {
		String loggerContext = exchange.getIn().getHeader("loggerContext", String.class);
		String accountNumber =exchange.getIn().getHeader("accountNumber",String.class);
		
		RetrieveOnlineStatementResponse response = new RetrieveOnlineStatementResponse();
		
		if (accountNumber == null || accountNumber.equals("")) {
			return setFault();
		}
		
		response = getStatementResponse();
		return response;
		
		
	}
   
	private RetrieveOnlineStatementResponse getStatementResponse() {
		RetrieveOnlineStatementResponse response = new RetrieveOnlineStatementResponse();
		AccountDetails account = new AccountDetails();
		
		account.setAccountNumber("123456");
		account.setAccountTypeDescription("Savings Bank");
		account.setName1("John");
		account.setName2("Cena");
		account.setAddress1("ABC Street");
		account.setAddress2("XYZ Palace");
		account.setAddress3("Chennai");
		account.setAddress4("Tamil Nadu");
		
		TransactionDetails transaction = new TransactionDetails();
		
		transaction.setBalance("2000");
		transaction.setCredit("100");
		transaction.setDateTime("22-11-2020");
		transaction.setDebit("400");
		transaction.setDescription("Debitted");
		transaction.setType("Net Banking");
		
		response.setAccount(account);
		response.setTransaction(transaction);
		return response;
		
		
	}
	
	private RetrieveOnlineStatementResponse setTransaction() {
		
		RetrieveOnlineStatementResponse response= new RetrieveOnlineStatementResponse();
		TransactionDetails transaction = new TransactionDetails();
		
		transaction.setBalance("2000");
		transaction.setCredit("100");
		transaction.setDateTime("22-11-2020");
		transaction.setDebit("400");
		transaction.setDescription("Debitted");
		transaction.setType("Net Banking");
		
		return response;
		
		
	}
	
	
//	public RetrieveOnlineStatementResponse getFault(Exchange exchange) {
//		
//		String loggerContext=exchange.getIn().getHeader("loggerContext", String.class);
//		
//		System.out.println("logger-context"+loggerContext);
//		
//		String accountNumber = (String) exchange.getIn().getHeader("accountNumber");
//		
//	//	RetrieveOnlineStatementResponse response = new RetrieveOnlineStatementResponse();
//		 if (accountNumber == "" | accountNumber == null) { 
//			 return setFault(); 
//			 }
//		 
//		
//		// return response;
//
//		RetrieveOnlineStatementRequest req = exchange.getIn().getBody(RetrieveOnlineStatementRequest.class);
//		String AccountNumber = req.getAccountNumber();
//		
//		
//		
//		RetrieveOnlineStatementResponse response = new RetrieveOnlineStatementResponse();
//		response.setAccountNumber("123456");
//		response.setName1("John");
//		response.setName2("Cena");		
//		response.setAddress1("Chennai");
//		response.setAddress2("india");
//		response.setBalance("23455");
//		//response.setFault("NO");
//		return response;
//
//	}
	
//	private RetrieveOnlineStatementResponse getBalance() {
//		RetrieveOnlineStatementResponse response = new RetrieveOnlineStatementResponse();
//		response.setAccountNumber("123456");
//		response.setName1("John");
//		response.setName2("Cena");		
//		response.setAddress1("Chennai");
//		response.setAddress2("india");
//		response.setBalance("23455");
//		//response.setFault("NO");
//		return response;
//		//return null;
//		
//		
//	}
	
	private RetrieveOnlineStatementResponse setFault() {
		RetrieveOnlineStatementResponse response = new RetrieveOnlineStatementResponse();
		FaultType fault = new FaultType();
		fault.setType("Client Error");
		fault.setSystem("Source");
		fault.setRetryAfter("10 sec");
		fault.setNumber(1);
		fault.setNativeError("No account id is found.");
		fault.setDescription("No account id is found in the header.");
		
		response.setFault(fault);
		
		return response;

		//return response;
		
		
	}
}
