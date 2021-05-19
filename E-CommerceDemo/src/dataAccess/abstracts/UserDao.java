package dataAccess.abstracts;

import java.util.ArrayList;

import entities.concretes.User;

public interface UserDao {

	
	void add(User user);
	void update(User user);
	void delete(User user);
	User get(int id);
	User getByEmail(String email);
	User getByEmailAndPassword(String email, String password);	
	ArrayList<User> getAll();
}
