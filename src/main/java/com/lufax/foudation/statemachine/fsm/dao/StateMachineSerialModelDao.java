/**
 * Description: StateMachineSerialModelDao
 * Author: 
 * Update: (2015-06-25 18:06)
 */
package com.lufax.foudation.statemachine.fsm.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.lufax.foudation.statemachine.fsm.model.StateMachineModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.sql.SQLException;

/**
 * Created by wuchenlv565 on 6/25/15.
 */
public class StateMachineSerialModelDao {
    @Autowired
    protected SqlMapClient sqlMapClient;

    @Autowired
    protected SqlMapClientTemplate sqlMapClientTemplate;

    public void save(StateMachineModel model){
        try {
            sqlMapClient.insert("StateMachineSerial.insertStateMachineSerialModel", model);
        } catch (SQLException e) {

        }

    }

    public void update(StateMachineModel model){
        try {
            sqlMapClient.update("StateMachineSerial.updateStateMachineSerialModel", model);
        } catch (SQLException e) {

        }
    }
}
