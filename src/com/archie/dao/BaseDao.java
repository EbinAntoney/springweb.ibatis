package com.archie.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * BaseDao,Dao需继承此Dao
 * 
 * @author archie2010 since 2011-3-3 下午02:52:36
 */
public class BaseDao extends SqlMapClientDaoSupport {

	@Resource(name = "sqlMapClient")
	private SqlMapClient sqlMapClient;

	@PostConstruct
	public void initSqlMapClient() {
		super.setSqlMapClient(sqlMapClient);
	}
}
