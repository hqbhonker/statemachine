package com.lufax.foudation.statemachine.fsm.dao.impl;

import com.lufax.foudation.statemachine.fsm.dao.StateMachineSerialDao;
import com.lufax.foudation.statemachine.fsm.model.StateMachineSerialModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/6/29.
 */
@Repository
public class StateMachineSerialDaoImpl extends  BaseDao  implements StateMachineSerialDao {
    public void save(StateMachineSerialModel model) {
        getSqlMapClientTemplate().insert("StateMachineSerialModel.insert", model);
    }

    public void update(String id ,String destStatus) {
        Map<String ,String> map=new HashMap<String,String>();
        map.put("id",id);
        map.put("destState",destStatus);
        getSqlMapClientTemplate().update("StateMachineSerialModel.updateDestState", map);
    }

    @Override
    public StateMachineSerialModel load(String id) {
        Map<String ,String> map=new HashMap<String,String>();
        map.put("id",id);
      return  (StateMachineSerialModel) getSqlMapClientTemplate().queryForObject("StateMachineSerialModel.select", map);
    }
}
