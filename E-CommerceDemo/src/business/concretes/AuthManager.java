package business.concretes;

import business.abstracts.EmailService;
import business.abstracts.UserService;
import business.abstracts.UserValidationService;
import core.AuthService;
import core.utils.BusinessRules;
import entities.concretes.User;

public class AuthManager implements AuthService {
	
	
	UserService userService;
	UserValidationService userValidationService;
    EmailService emailService;
    
    public AuthManager (UserService userService, UserValidationService userValidationService, 
    		EmailService emailService) {
    	
		super();
		this.userService = userService;
		this.userValidationService = userValidationService;
		this.emailService = emailService;
	}
    
    
	@Override
	public void register(int id, String email, String password, String firstName, String lastName) {
		User userToRegister = new User(id,email,password,firstName,lastName,false);
		
		if(!userValidationService.validate(userToRegister)) {
			System.out.println("��lem ba�ar�s�z. L�tfen tekrar deneyiniz" );
			return;
		}
		if(!BusinessRules.run(checkIfUserExists(email))) {
			System.out.println("��lem ba�ar�s�z. Bu mail ile kay�t olu�turulmu�" );
			return;
		}
		
		System.out.println("Ba�ar�yla kay�t olundu. L�tfen size g�nderdi�imiz mailden hesab�n�z� do�rulay�n�z.");
		emailService.send("Do�rulama mesaj�d�r. l�tfen liinkteki adrese gidiniz.", userToRegister.getEmail());
		userService.add(userToRegister);
		
	}

	@Override
	public void login(String email, String password) {

		if(!BusinessRules.run(checkIfAllFieldsFilled(email,password))) {
			System.out.println("��lem ba�ar�s�z. L�tfen tekrar deneyiniz" );
			return;
		}
        
		User userToLogin = userService.getByEmailAndPassword(email,password);
		if(userToLogin==null) {
			System.out.println("Giri� ba�ar�s�z. E-posta veya �ifre yanl��");
			return;
		}
				
		
		if(!checkIfUserVerified(userToLogin)) {
			System.out.println("��lem ba�ar�s�z. Hesab�n�z� do�rulay�n�z" );
			return;
		}
		System.out.println("��lem ba�ar�l�." + userToLogin.getFirstName() + " " + userToLogin.getLastName());
		
	}
	
	private boolean checkIfUserExists(String mail) {
		return userService.getByEmail(mail)==null;
		
	}
	private boolean checkIfUserVerified(User user) {
		return user.isVerify();
		
	}
	
	private boolean checkIfAllFieldsFilled(String email, String password) {
		if(email.length()<=0 || password.length() <=0 ) {
			return false;
		}
		return true;
		
	}
	
	
	
	
	
	

}
