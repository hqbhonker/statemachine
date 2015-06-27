package com.lufax.foudation.statemachine.fsm.model;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -7407939090098266499L;
	
	private int userId;  
    private String name;  
    private int sex;
    
    public User(){  
        
    }  
    public User(int id,String name,int sex){  
        this.userId = id;  
        this.name = name;  
        this.sex = sex;  
    }  
    
	public int getId() {
		return userId;
	}
	public void setId(int id) {
		this.userId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}  

}
