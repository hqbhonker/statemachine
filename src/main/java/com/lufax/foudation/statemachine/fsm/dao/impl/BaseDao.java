package com.lufax.foudation.statemachine.fsm.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * Created by Administrator on 2015/6/29.
 */
public class BaseDao extends SqlMapClientDaoSupport {
    @Autowired
    public void setSqlMapClinet(SqlMapClient sqlMapClinet){
        super.setSqlMapClient(sqlMapClinet);
    }
}
