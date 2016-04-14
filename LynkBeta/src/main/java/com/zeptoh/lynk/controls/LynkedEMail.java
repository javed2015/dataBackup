package com.zeptoh.lynk.controls;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LynkedEMail
 */
@WebServlet("/LynkedEMail")
public class LynkedEMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LynkedEMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lynk = request.getParameter("generatedUrl");
		String emailId = request.getParameter("recId");
		try {
			generateAndSendEmail(lynk,emailId);
			/*PrintWriter out = response.getWriter();
			
			out.print("success");*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 static Properties mailServerProperties;
	 static Session getMailSession;
	 static MimeMessage generateMailMessage; 
		
		 
		 
		 public static void generateAndSendEmail(String lynk, String email) throws AddressException, MessagingException {
			
		  String emailBody = lynk + "<br><br> Regards, <br>Factual Note Admin";
		  
		  
		  mailServerProperties = System.getProperties();
		  mailServerProperties.put("mail.smtp.from", "no-reply@factualnote.com");
		  mailServerProperties.put("mail.smtp.user",  "no-reply@factualnote.com");
		  mailServerProperties.put("mail.smtp.password","W='jH6g-JL^");
		  mailServerProperties.put("mail.smtp.port", "587");
		  mailServerProperties.put("mail.smtp.host", "smtp.factualnote.com");
		  mailServerProperties.put("mail.smtp.auth", "true");
		  mailServerProperties.put("mail.smtp.starttls.enable", "false");
		//  getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		  getMailSession = Session.getInstance(mailServerProperties,
				    new javax.mail.Authenticator() {
				     protected PasswordAuthentication getPasswordAuthentication() {
				      return new PasswordAuthentication(mailServerProperties
				        .getProperty("mail.smtp.from"),
				        mailServerProperties
				          .getProperty("mail.smtp.password"));
				     }
				    });
		  generateMailMessage = new MimeMessage(getMailSession);
		  generateMailMessage.setSubject("Greetings from Factual Note");
		  generateMailMessage.setContent(emailBody, "text/html");
		  generateMailMessage.setFrom(new InternetAddress(mailServerProperties
				        .getProperty("mail.smtp.from")));
		  generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		  generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("alert@factualnote.com"));
		 // generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("desingrajr@zeptoh.com"));
		 
		  
		  
	//	  Transport transport = getMailSession.getTransport("smtp");
		//  transport.connect("smtp.lynked.in","no-reply@lynked.in", "yoZicEw6" );
		  Transport.send(generateMailMessage);
	//	  transport.close();
		 }
		
	}


