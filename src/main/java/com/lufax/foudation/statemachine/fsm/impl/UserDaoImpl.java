package com.lufax.foudation.statemachine.fsm.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lufax.foudation.statemachine.fsm.dao.UserDao;
import com.lufax.foudation.statemachine.fsm.model.User;

public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao{

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("insertUser",user);  
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		 getSqlMapClientTemplate().delete("deleteById", id);  
		
	}
 
	@Override
	public User queryById(int id) {
		// TODO Auto-generated method stub
		User user = (User) getSqlMapClientTemplate().queryForObject("queryById", id);  
		return user;
	}

	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		List<User> users = getSqlMapClientTemplate().queryForList("queryAllUser");  
		return users;
	}

}
