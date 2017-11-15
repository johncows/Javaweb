package sendEmail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.kk.utils.MailUtils;

public class Email {

	public static void main(String[] args) throws AddressException, MessagingException {
		// TODO Auto-generated method stub
		MailUtils.sendMail("dick@kk.com", "情书",	 "今晚的月色可真美啊");
	}

}
