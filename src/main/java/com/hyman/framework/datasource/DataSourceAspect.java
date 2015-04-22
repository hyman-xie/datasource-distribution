package com.hyman.framework.datasource;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyman.framework.datasource.annotation.DataSource;

public class DataSourceAspect {

	private static final Logger log = LoggerFactory.getLogger(DataSourceAspect.class);

	@Autowired
	private DataSourceKeyDeterminer dataSourceKeyDeterminer;

	public void before(JoinPoint point) {
		boolean putDataSource=false;
		try {
			MethodSignature methodSignature = ((MethodSignature) point.getSignature());
			Method method = methodSignature.getMethod();
			Object[] parameterValues = point.getArgs();
			Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
			Annotation[][] parameterAnnotations = point.getTarget().getClass().getMethod(method.getName(), parameterTypes).getParameterAnnotations();
			for (int i = 0; i < parameterAnnotations.length; i++) {
				Annotation[] pas = parameterAnnotations[i];
				for (int j = 0; j < pas.length; j++) {
					Annotation annotation = pas[j];
					if (annotation instanceof DataSource) {
						DataSource data = (DataSource) annotation;
						if(data.value()==null || data.value().trim().length()==0){
							return;
						}
						log.info("=================find annotation datasource with name:"+data.value()+" value:"+parameterValues[i]);
						String datasourceKey = dataSourceKeyDeterminer.determine(data.value(), (Long) parameterValues[i]);
						DynamicDataSourceHolder.putDataSource(datasourceKey);
						putDataSource=true;
						return;
					}
				}
			}
		} catch (Exception e) {
			log.error("error in datasource aspect",e);
		} finally{
			if(!putDataSource){
				DynamicDataSourceHolder.putDataSource(dataSourceKeyDeterminer.getDefaultDataSourceKey());
			}
			if(DynamicDataSourceHolder.getOriginalDataSource()==null){
				DynamicDataSourceHolder.putOriginalDataSource(DynamicDataSourceHolder.getDataSouce());
			}
		}
	}

	public void after(JoinPoint point){
		if(DynamicDataSourceHolder.getOriginalDataSource()!=null){
			DynamicDataSourceHolder.putDataSource(DynamicDataSourceHolder.getOriginalDataSource());
		}
	}
}
