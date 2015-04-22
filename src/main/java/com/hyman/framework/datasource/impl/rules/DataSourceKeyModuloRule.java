package com.hyman.framework.datasource.impl.rules;

import com.hyman.framework.datasource.DataSourceKeyRule;

public class DataSourceKeyModuloRule implements DataSourceKeyRule {

	private String field;
	private Long moduloNumber;
	private Long remainder;
	private String dataSourceKey;

	public DataSourceKeyModuloRule() {
		super();
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Long getModuloNumber() {
		return moduloNumber;
	}
	public void setModuloNumber(Long moduloNumber) {
		this.moduloNumber = moduloNumber;
	}
	public Long getRemainder() {
		return remainder;
	}
	public void setRemainder(Long remainder) {
		this.remainder = remainder;
	}

	public String getDataSourceKey() {
		return dataSourceKey;
	}
	public void setDataSourceKey(String dataSourceKey) {
		this.dataSourceKey = dataSourceKey;
	}
	public boolean applyRule(String field, Long value) {
		if(field==null || value==null){
			return false;
		}
		if(field.compareTo(this.field)!=0){
			return false;
		}
		if(value.longValue()%moduloNumber.longValue()==remainder.longValue()){
			return true;
		}
		return false;
	}
}
