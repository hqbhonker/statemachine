/**
 * Description: StateMachineSerialModelDao
 * Author: 
 * Update: (2015-06-25 18:06)
 */
package com.lufax.foudation.statemachine.fsm.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.lufax.foudation.statemachine.fsm.model.StateMachineModel;
import com.lufax.foudation.statemachine.fsm.model.StateMachineSerialModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.sql.SQLException;

/**
 * Created by wuchenlv565 on 6/25/15.
 */
public interface StateMachineSerialDao {
    public void save(StateMachineSerialModel model);
    public void update(String id ,String destState);
    public StateMachineSerialModel load(String id);
}
