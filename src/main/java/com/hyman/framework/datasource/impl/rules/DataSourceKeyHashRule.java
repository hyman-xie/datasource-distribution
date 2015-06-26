package com.hyman.framework.datasource.impl.rules;

import com.hyman.framework.datasource.DataSourceKeyRule;

public class DataSourceKeyHashRule extends ADataSourceKeyRule implements DataSourceKeyRule {
	
	private Long from;
	private Long to;
	
	public DataSourceKeyHashRule() {
		super();
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
	public boolean applyRule(String field, Long value) {
		return applyRule(field, value, false);
	}
	@Override
	public boolean applyRule(String field, Long value, boolean readonly) {
		if(field==null || value==null){
			return false;
		}
		if(field.compareTo(getField())!=0){
			return false;
		}
		if(!isReadonly() && readonly){
			return false;
		}
		if(isReadonly() && !readonly){
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
