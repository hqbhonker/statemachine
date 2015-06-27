package com.lufax.foudation.statemachine.fsm.dao;

import java.util.List;

import com.lufax.foudation.statemachine.fsm.model.User;

public interface UserDao {
	 
	//���  
    public void insertUser(User user);
    
    //ɾ��  
    public void deleteById(int id); 
    
    //����ID��ѯ  
    public User queryById(int id); 
    
    //��ѯȫ��  
    public List<User> queryAllUser();         

}
