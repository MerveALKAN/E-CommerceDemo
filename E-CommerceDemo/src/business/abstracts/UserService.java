package business.abstracts;

import java.util.ArrayList;

import entities.concretes.User;

public interface UserService {

	void add(User user);
	void update(User user);
	void delete(User user);
	void verifyUser(int id);
	User get(int id);
	User getByEmail(String email);
	ArrayList<User> getAll();
	User getByEmailAndPassword(String email, String password);
}
