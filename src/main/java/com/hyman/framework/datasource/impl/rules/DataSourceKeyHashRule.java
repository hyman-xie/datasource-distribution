package com.hyman.framework.datasource.impl.rules;

import com.hyman.framework.datasource.DataSourceKeyRule;

public class DataSourceKeyHashRule implements DataSourceKeyRule {

	private String field;
	private Long from;
	private Long to;
	private String dataSourceKey;

	public DataSourceKeyHashRule() {
		super();
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Long getFrom() {
		return from;
	}
	public void setFrom(Long from) {
		this.from = from;
	}
	public Long getTo() {
		return to;
	}
	public void setTo(Long to) {
		this.to = to;
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
		if(from==null && to!=null && value.longValue()<to.longValue()){
			return true;
		}
		if(from!=null && to==null && value.longValue()>=from.longValue()){
			return true;
		}
		if(from!=null && to!=null && value.longValue()>=from.longValue() && value.longValue()<to.longValue()){
			return true;
		}
		return false;
	}
}
