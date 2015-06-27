package com.lufax.foudation.statemachine.fsm.dao;

import java.util.List;

import com.lufax.foudation.statemachine.fsm.model.User;

public interface UserDao {
	 
	//添加  
    public void insertUser(User user);
    
    //删除  
    public void deleteById(int id); 
    
    //根据ID查询  
    public User queryById(int id); 
    
    //查询全部  
    public List<User> queryAllUser();         

}
