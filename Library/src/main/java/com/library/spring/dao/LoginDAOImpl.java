package com.library.spring.dao;
import com.library.spring.model.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import java.util.List;


@Repository
public class LoginDAOImpl implements LoginDAO{
     
			 
       //@Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory af) {
              this.sessionFactory = af;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }

       public Users checkLogin(String userName, String userPassword){
			System.out.println("In Check login");
			Session session = sessionFactory.openSession();
			Users u = null;
			//boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY =" from Users as o where o.userName=? and o.userPassword=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			query.setParameter(1,userPassword);
			List<Users> list = query.list();

			if ((list != null) && (list.size() > 0)) {
				//System.out.println(list.get(0).getUserName());
				//userFound= true;
				u = list.get(0);
			}
			
			//if (userFound == false)
			if (u == null)
			{
				System.out.println("ValidationFailed");
			}
			session.close();
			//return userFound;
			return u;
       }
}