package business.concretes;

import java.util.ArrayList;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		
		userDao.add(user);
	
	
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public User get(int id) {
		
		return userDao.get(id);
	}

	@Override
	public User getByEmail(String email) {
		
		return userDao.getByEmail(email);
	}

	@Override
	public ArrayList<User> getAll() {
	
		return userDao.getAll();
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		
		
		return userDao.getByEmailAndPassword(email, password);
	}

	@Override
	public void verifyUser(int id) {
	User user = userDao.get(id);
	user.setVerify(true);
	System.out.println("Kullanýcý doðrulandý");
		
	}
	

}
