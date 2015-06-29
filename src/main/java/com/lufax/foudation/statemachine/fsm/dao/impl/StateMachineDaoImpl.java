/**
 * Description: StateMachineDao
 * Author: 
 * Update: (2015-06-25 17:15)
 */
package com.lufax.foudation.statemachine.fsm.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.lufax.foudation.statemachine.fsm.dao.StateMachineDao;
import com.lufax.foudation.statemachine.fsm.model.StateMachineModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuchenlv565 on 6/25/15.
 */
@Repository
public class StateMachineDaoImpl extends BaseDao implements StateMachineDao

{
    public StateMachineModel findStateMachineByBizTpeAndBizRefNo(String bizType, String bizRefNo) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("bizType", bizType);
        map.put("bizRefNo", bizRefNo);
        return (StateMachineModel) getSqlMapClientTemplate().queryForObject("StateMachineModel.select", map);
    }

    public void save(StateMachineModel model) {
        getSqlMapClientTemplate().insert("StateMachineModel.insert", model);
    }

    public void update(StateMachineModel model) {
        getSqlMapClientTemplate().update("StateMachineModel.update", model);
    }
    public StateMachineModel load(String id){
        Map<String,String> map=new HashMap<String, String>();
        map.put("id",id);
        return (StateMachineModel) getSqlMapClientTemplate().queryForObject("StateMachineModel.select", map);
    }
}
