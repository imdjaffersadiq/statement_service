package org.mycompany.services;

import org.apache.camel.Exchange;
import org.mycompany.model.RetrieveOnlineStatementRequest;
//import org.mycompany.model.RetrieveOnlineStatementRequest;
import org.mycompany.model.RetrieveOnlineStatementResponse;

public class RetrieveStatementService {

	
	public RetrieveOnlineStatementResponse getFault(Exchange exchange) {
		
		String loggerContext=exchange.getIn().getHeader("loggerContext", String.class);
		
		System.out.println("logger-context"+loggerContext);
		
		RetrieveOnlineStatementRequest req = exchange.getIn().getBody(RetrieveOnlineStatementRequest.class);
		String AccountNumber = req.getAccountNumber();
		
		RetrieveOnlineStatementResponse response = new RetrieveOnlineStatementResponse();
		response.setAccountNumber("123456");
		response.setName1("John");
		response.setName2("Cena");		
		response.setAddress1("Chennai");
		response.setAddress2("india");
		response.setBalance("23455");
		response.setFault("NO");
		return response;

	}
}
