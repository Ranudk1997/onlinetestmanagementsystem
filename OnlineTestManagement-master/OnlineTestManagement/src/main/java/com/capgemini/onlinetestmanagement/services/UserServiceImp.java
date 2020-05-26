package com.capgemini.onlinetestmanagement.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetestmanagement.dao.Userdao;
import com.capgemini.onlinetestmanagement.entity.User;


/***************************************************************************************************************************
 *  @author          SIDDHANT
 *  Description      It is a Service class that provides the services for adding a new user,showing all the users,
                     finding user by userID and deleting user by userId. 
 *  Version          1.0
 *  Created Date     
 **************************************************************************************************************************/


@Service
@Transactional
public class UserServiceImp implements UserServiceInterface {

	
	
	@Autowired
	private Userdao userdao;

	
	@Override
	public boolean addUser(User user) {
		User Result= userdao.save(user);
		if(Result!=null) {
			return true;
		}
		else
			return false;
	}
	
   
	@Override
	public Optional<User> findUserById(Long userId) {

		return userdao.findById(userId);
		
	}
	/*public boolean loginId(Long userId,String password)throws UserException{
	{
		Object obj=userdao.findById(userId);
		
		if(obj ==null) {
			throw new RecordNotFoundException("Wrong Id");
		}
		else if(((User) obj).getPassword().equals(password) && ((User) obj).getIsAdmin()==false) {
			return true;
		}
		else if(((User) obj).getPassword().equals(password) && ((User) obj).getIsAdmin()==true) {
			return false;
		}
		else {
		 throw new Error("Password Incorrect");
		}
	}
	}*/
	


	

	
	@Override
	public List<User> showAllUsers() 
	{
		return userdao.findAll();
	}
		
	

	@Override
    public void deleteuser(long userId) {
		userdao.deleteById(userId);
	}

	

	


	
}
