package org.mycompany.services;

import org.mycompany.model.StatementRequest;
import org.mycompany.model.StatementResponse;

public class StatementServices {
	
	public static StatementResponse getGUID(StatementRequest req) {
		
		StatementResponse response =new StatementResponse();
		
//		String productCode = req.getProductCode();
//		String accountId = req.getAccountId();
//		String paperTypeCode=req.getPaperTypeCode();
//		String fromDate=req.getFromDate();
//		String toDate=req.getToDate();
		response.setGUID("SUCCESS");
		return response;
		
		
	}

}
