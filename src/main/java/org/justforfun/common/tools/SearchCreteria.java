package org.justforfun.common.tools;

/**
 * @author root
 * search creteria
 */
public class SearchCreteria {

	
	public final SearchCreteria and(SearchCreteria creteria){
		
		
		return null;
	}
	
	public final SearchCreteria or(SearchCreteria creteria){
		
		return null;
	}
	
	private String columnName;
	private SearhCreteriaType creteriaType;
	private String value;
	private String queryString;
	
	@Override
	public String toString(){
		if(this.queryString.isEmpty()){
		}
		return this.queryString;
	}
	
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public SearhCreteriaType getCreteriaType() {
		return creteriaType;
	}
	public void setCreteriaType(SearhCreteriaType creteriaType) {
		this.creteriaType = creteriaType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}