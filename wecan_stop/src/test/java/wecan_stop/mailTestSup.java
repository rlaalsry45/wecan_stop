package wecan_stop;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class mailTestSup extends Authenticator{
	protected static String username = ""; 
	protected static String password = ""; 
	
	public mailTestSup(String user, String pwd) { 
		username = user; password = pwd; 
	} 
	public PasswordAuthentication getPasswordAuthentication() { 
		return new PasswordAuthentication(username, password); 
	}

}
