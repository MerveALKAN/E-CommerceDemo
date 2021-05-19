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
			System.out.println("Ýþlem baþarýsýz. Lütfen tekrar deneyiniz" );
			return;
		}
		if(!BusinessRules.run(checkIfUserExists(email))) {
			System.out.println("Ýþlem baþarýsýz. Bu mail ile kayýt oluþturulmuþ" );
			return;
		}
		
		System.out.println("Baþarýyla kayýt olundu. Lütfen size gönderdiðimiz mailden hesabýnýzý doðrulayýnýz.");
		emailService.send("Doðrulama mesajýdýr. lütfen liinkteki adrese gidiniz.", userToRegister.getEmail());
		userService.add(userToRegister);
		
	}

	@Override
	public void login(String email, String password) {

		if(!BusinessRules.run(checkIfAllFieldsFilled(email,password))) {
			System.out.println("Ýþlem baþarýsýz. Lütfen tekrar deneyiniz" );
			return;
		}
        
		User userToLogin = userService.getByEmailAndPassword(email,password);
		if(userToLogin==null) {
			System.out.println("Giriþ baþarýsýz. E-posta veya þifre yanlýþ");
			return;
		}
				
		
		if(!checkIfUserVerified(userToLogin)) {
			System.out.println("Ýþlem baþarýsýz. Hesabýnýzý doðrulayýnýz" );
			return;
		}
		System.out.println("Ýþlem baþarýlý." + userToLogin.getFirstName() + " " + userToLogin.getLastName());
		
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
