package com.archie.util;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * ibatis������,���SqlMapClient����
 * @author archie2010
 *
 */
public class SqlMapUtil {

	private SqlMapUtil(){}
	private static SqlMapClient sqlMapClient=null;
	
	public static SqlMapClient getSqlMapClient(){
		//ibatis�����ļ���·��
		String resource="sqlMap/sql-map-config.xml";
		try {
			//��ȡ�����ļ�
			Reader reader=Resources.getResourceAsReader(resource);
			//����SqlMapClient����
			sqlMapClient=SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlMapClient;
	}
}
