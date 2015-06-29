/**
 * Description: StateMachineDao
 * Author: 
 * Update: (2015-06-25 17:15)
 */
package com.lufax.foudation.statemachine.fsm.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.lufax.foudation.statemachine.fsm.model.StateMachineModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuchenlv565 on 6/25/15.
 */
//@Repository
public interface StateMachineDao  {
    public StateMachineModel findStateMachineByBizTpeAndBizRefNo(String bizType,String bizRefNo);
    public void save(StateMachineModel model);
    public void update(StateMachineModel model);
    public StateMachineModel load(String id);

}
