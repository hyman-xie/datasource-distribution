package com.hyman.framework.datasource;

public class DynamicDataSourceHolder {

	public static final ThreadLocal<String> originalHolder = new ThreadLocal<String>();

	public static final ThreadLocal<String> currentHolder = new ThreadLocal<String>();

	public static void putDataSource(String name) {
		currentHolder.set(name);
	}

	public static void putOriginalDataSource(String name) {
		originalHolder.set(name);
	}

	public static String getDataSouce() {
		return currentHolder.get();
	}

	public static String getOriginalDataSource(){
		return originalHolder.get();
	}

}
