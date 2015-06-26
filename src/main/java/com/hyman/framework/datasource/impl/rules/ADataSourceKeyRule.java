package com.hyman.framework.datasource.impl.rules;

import com.hyman.framework.datasource.DataSourceKeyRule;

public abstract class ADataSourceKeyRule implements DataSourceKeyRule {
	
	private String field;
	private boolean readonly=false;
	private String dataSourceKey;
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public boolean isReadonly() {
		return readonly;
	}
	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}
	public String getDataSourceKey() {
		return dataSourceKey;
	}
	public void setDataSourceKey(String dataSourceKey) {
		this.dataSourceKey = dataSourceKey;
	}
	
}
