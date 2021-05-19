package dataAccess.concretes;

import java.util.ArrayList;
import java.util.Iterator;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	
	ArrayList<User> users = new ArrayList<User>();
	public InMemoryUserDao() {
		
		
		super();
		User user  = new User(1,"Merve", "ALKAN", "mervealkan@gmail.com","123456" , true);
		User user1 = new User(2, "Esra ","ALKAN", "esra@gmail.com","003", true );
		User user2 = new User(3, "Nilgün ","GÜNGÖR", "nilgn@gmail.com","52000" , true);
		User user3 = new User(4, "Fatma ","ARANCAK", "fatma@gmail.com","789" , true);
		User user4 = new User(5, "Sümeyye ","SAKÝN", "smyye@gmail.com","003", true);
		
		users.add(user);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
	}
	
	

	@Override
	public void add(User user) {
		this.users.add(user);
		System.out.println("Kullanýcý eklendi : " + user.getFirstName() +" "+ user.getLastName());
		
	}

	@Override
	public void update(User user) {
	
		User userToUpdate = get (user.getId());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getFirstName());
		//System.out.println("Kullanýcý bilgileri güncellendi");
		
	}

	@Override
	public void delete(User user) {
	
	
		System.out.println("Kullanýcý silindi");
		
	}

	@Override
	public User get(int id) {
		for (User user : users) {
			if(user.getId()==id)
				return user;
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		for (User user : users) {
			if(user.getEmail()==email)
				return user;
		}
		return null;
	}

	@Override
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return this.users;
	}



	@Override
	public User getByEmailAndPassword(String email, String password) {
		for (User user : users) {
			if(user.getEmail()==email && user.getPassword() == password)
				return user;
		}
		return null;
	}

}
