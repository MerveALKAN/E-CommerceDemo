package googleAuth;

public class GoogleAuthManager {

	public void register (String email, String password) {
		System.out.println("Google hesabýyla kayýt olundu :" + " " +email);
	}
	
	
	public void login(String email,String password) {
		System.out.println("Google hesabý ile giriþ yapýldý: " + " " + email);
	}
}
