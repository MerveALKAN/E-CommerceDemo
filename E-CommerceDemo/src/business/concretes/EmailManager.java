package business.concretes;

import business.abstracts.EmailService;

public class EmailManager implements EmailService{

	@Override
	public void send(String message, String to) {
	System.out.println("E- posta : " + message + "mesajý" + to + "adresine gönderildi");
		
	}

}
