package org.mycompany.services;

import org.apache.camel.Exchange;
import org.mycompany.model.FaultType;
import org.mycompany.model.RetrieveOnlineStatementRequest;
import org.mycompany.model.RetrieveOnlineStatementRequest;
import org.mycompany.model.RetrieveOnlineStatementResponse;

public class RetrieveStatementService {

	
	public RetrieveOnlineStatementResponse getFault(Exchange exchange) {
		
		String loggerContext=exchange.getIn().getHeader("loggerContext", String.class);
		
		System.out.println("logger-context"+loggerContext);
		
		String accountNumber = (String) exchange.getIn().getHeader("accountNumber");
		
	//	RetrieveOnlineStatementResponse response = new RetrieveOnlineStatementResponse();
		 if (accountNumber == "" | accountNumber == null) { 
			 return setFault(); 
			 }
		 
		
		// return response;

		RetrieveOnlineStatementRequest req = exchange.getIn().getBody(RetrieveOnlineStatementRequest.class);
		String AccountNumber = req.getAccountNumber();
		
		
		
		RetrieveOnlineStatementResponse response = new RetrieveOnlineStatementResponse();
		response.setAccountNumber("123456");
		response.setName1("John");
		response.setName2("Cena");		
		response.setAddress1("Chennai");
		response.setAddress2("india");
		response.setBalance("23455");
		//response.setFault("NO");
		return response;

	}
	
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
