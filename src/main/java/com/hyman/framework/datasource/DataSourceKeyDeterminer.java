package com.hyman.framework.datasource;

public interface DataSourceKeyDeterminer {
	
	public String determine(String field, Long value, boolean readonly);
	
	public String determine(String field, Integer value, boolean readonly);
	
	public String getDefaultDataSourceKey();
	
}