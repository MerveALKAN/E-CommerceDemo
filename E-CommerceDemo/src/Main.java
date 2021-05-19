import business.abstracts.UserService;
import business.concretes.AuthManager;
import business.concretes.EmailManager;
import business.concretes.UserManager;
import business.concretes.UserValidationManager;
import core.AuthManagerAdapter;
import core.AuthService;
import dataAccess.concretes.InMemoryUserDao;
import googleAuth.GoogleAuthManager;

public class Main {

	public static void main(String[] args) {
		
		
		UserService userService = new UserManager(new InMemoryUserDao());
		AuthService authService = new AuthManager(userService, new UserValidationManager(), new EmailManager());
		authService.register(1, "mervealkan@gmail.com", "123456789", "Merve", "ALKAN");
		authService.register(2, "esraalkan@gmail.com", "456123789", "Esra", "ALKAN");
		//authService.register(3, "nilgungungr@gmail.com", "456546852", "Nilgün", "GÜNGÖR");
		//authService.register(4, "fatmaarancak@gmail.com", "785421456", "Fatma", "ARANCAK");
		//authService.register(5, "smyysakin@gmail.com", "456321789", "Sümeyye", "SAKÝN");
		
		
		
		authService.login("mervealkan@gmail.com", "123456789");
		userService.verifyUser(1);
		authService.login("mervealkan@gmail.com", "12345678");
		authService.login("...", "12345678");
		
		
		AuthService googAuthService = new AuthManagerAdapter();
		googAuthService.register(6, "mervealkan@gmail.com", "123456789", "Merve", "ALKAN");
		
		
		
		
		
		
	}

}
