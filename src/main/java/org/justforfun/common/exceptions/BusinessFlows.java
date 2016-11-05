package org.justforfun.common.exceptions;

public enum BusinessFlows {
	AUTHENTICATION("authentiation"),
	REGISTRATION("registration");
	
	private String flowCode;
	
	BusinessFlows(String flowCode){
		this.flowCode=flowCode;
	}

	public String getFlowCode() {
		return flowCode;
	}
	
}
