package com.hyman.framework.datasource.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hyman.framework.datasource.DataSourceKeyDeterminer;
import com.hyman.framework.datasource.DataSourceKeyRule;

public class DefaultDataSourceKeyDeterminer implements DataSourceKeyDeterminer {

	private Logger log=LoggerFactory.getLogger(DefaultDataSourceKeyDeterminer.class);

	private String defaultDataSourceKey;
	private List<DataSourceKeyRule> rules=new ArrayList<DataSourceKeyRule>();

	public String determine(String field, Long value) {
		for(DataSourceKeyRule dataSourceKeyRule : rules){
			if(dataSourceKeyRule.applyRule(field, value)){
				log.info("============determine to use datasource: field-"+field+"/value-"+value+"/datasource-"+dataSourceKeyRule.getDataSourceKey());
				return dataSourceKeyRule.getDataSourceKey();
			}
		}
		return getDefaultDataSourceKey();
	}

	public String getDefaultDataSourceKey() {
		return defaultDataSourceKey;
	}

	public void setDefaultDataSourceKey(String defaultDataSourceKey) {
		this.defaultDataSourceKey = defaultDataSourceKey;
	}

	public List<DataSourceKeyRule> getRules() {
		return rules;
	}

	public void setRules(List<DataSourceKeyRule> rules) {
		this.rules = rules;
	}

}
