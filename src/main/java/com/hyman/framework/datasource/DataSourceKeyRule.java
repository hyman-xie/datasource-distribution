package com.hyman.framework.datasource;

public interface DataSourceKeyRule {
	
	public String getDataSourceKey();
	
	public boolean applyRule(String field, Long value);
	
	public boolean applyRule(String field, Long value, boolean readonly);
	
	public boolean isReadonly();
}
