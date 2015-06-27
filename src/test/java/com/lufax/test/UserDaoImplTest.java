package com.lufax.test;
import java.util.Iterator;  
import java.util.List;  
  


import org.junit.Test;  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  

import com.lufax.foudation.statemachine.fsm.impl.UserDaoImpl;
import com.lufax.foudation.statemachine.fsm.model.User;

public class UserDaoImplTest {  
    private static ApplicationContext applicationContext = null;   //提供静态ApplicationContext  
    static{  
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml"); //实例化  
    }  
    //添加操作  
/*    @Test  
    public void testInsertUser(){  
    	UserDaoImpl s = (UserDaoImpl)applicationContext.getBean("userDao");  
        s.insertUser(new User(1,"zhangsan",2));  
    }  
      
    //删除操作  
    @Test  
    public void testDeleteUser(){  
    	UserDaoImpl s = (UserDaoImpl)applicationContext.getBean("userDao");  
        s.deleteById(1);  
    }  */
      
    //查询全部  
    @Test  
    public void testQueryAllUser(){  
    	UserDaoImpl s = (UserDaoImpl)applicationContext.getBean("userDao");  
        List<User> users = s.queryAllUser();  
        System.out.println(users.size());  
        Iterator<User> ite = users.iterator();  
        while(ite.hasNext()){  
            User user = ite.next();  
            System.out.print("ID: "+user.getId());  
            System.out.print(" Name: "+user.getName());  
            System.out.print(" Sex: "+user.getSex());  
            System.out.println();  
        }  
    }  
}  