package googleAuth;

public class GoogleAuthManager {

	public void register (String email, String password) {
		System.out.println("Google hesab�yla kay�t olundu :" + " " +email);
	}
	
	
	public void login(String email,String password) {
		System.out.println("Google hesab� ile giri� yap�ld�: " + " " + email);
	}
}
