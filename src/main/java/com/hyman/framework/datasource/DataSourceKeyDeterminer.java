package com.hyman.framework.datasource;

public interface DataSourceKeyDeterminer {

	public String determine(String field, Long value);

	public String getDefaultDataSourceKey();

}
