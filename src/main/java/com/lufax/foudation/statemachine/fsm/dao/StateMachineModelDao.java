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
@Repository
public class StateMachineModelDao {
    @Autowired
    protected SqlMapClient sqlMapClient;

   @Autowired
    protected SqlMapClientTemplate sqlMapClientTemplate;
    public StateMachineModel findStateMachineByBizTpeAndBizRefNo(String bizType,String bizRefNo){
        Map<String,String> map=new HashMap<String, String>();
        map.put("bizType",bizType);
        map.put("bizRefNo",bizRefNo);

        try {
            return   (StateMachineModel)sqlMapClient.queryForObject("", map);
        } catch (SQLException e) {

        }
        return null;

    }
    public void save(StateMachineModel model){
        try {
            sqlMapClient.insert("", model);
        } catch (SQLException e) {

        }

    }

    public void update(StateMachineModel model){
        try {
            sqlMapClient.update("", model);
        } catch (SQLException e) {

        }
    }


}
