package com.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.UserDao;
import com.entities.Users;

public class UsersDaoImpl implements UserDao{
	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(Users users) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(users);
		return true;
	}

	public List<Users> list() {
		return session.getCurrentSession().createQuery("from Users").list();
	}

	public boolean delete(Users users) {
		try{
			session.getCurrentSession().delete(users);
		}catch(Exception ex){
			return false;
		}	
		return true;
	}	
}
