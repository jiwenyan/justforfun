package org.justforfun.common.exceptions;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8888681182565496190L;
	
	private BusinessFlows businessflow;
	public BusinessFlows getBusinessFlow(){
		return this.businessflow;
	}
	
	public BusinessException(BusinessFlows businessFlow,String errorMsg){
		super(errorMsg);
		this.businessflow=businessFlow;
	}

}
