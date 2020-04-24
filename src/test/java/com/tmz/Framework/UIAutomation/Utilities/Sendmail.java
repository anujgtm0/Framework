package com.tmz.Framework.UIAutomation.Utilities;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sendmail {
	  String Filepath="D:\\Flamingo\\UIAutomation\\src\\Reports\\Test_Report_2020-04-23T06_17_48.html";
	 
    public void sendReport(String Filename,String Manager_ID,String FilePath ,String Body_Message) {

        // Recipient's email ID needs to be mentioned.
        String to = Manager_ID;

        // Sender's email ID needs to be mentioned
        String from = "anujgtm0@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("anujgtm0@gmail.com", "April@2019");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Automation Status Report");
            Multipart multipart = new MimeMultipart();  
            // Now set the actual message
            
            MimeBodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText(Body_Message);
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
            
            String filename = FilePath;//change accordingly  
            DataSource source = new FileDataSource(filename);  
            messageBodyPart2.setDataHandler(new DataHandler(source));  
            messageBodyPart2.setFileName(Filename);  
            multipart.addBodyPart(messageBodyPart2);
            multipart.addBodyPart(messageBodyPart1);
            message.setContent(multipart);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
   
    @Test
        public void WSClient1() {
    	String Mail_Body="Hi Below is your Test Summary \n "+"Total Test Cases==>"+Constants.TotalTC+"\n"+"  Total PASS==>"+Constants.PassTC+"\n"+"  Total FAIL==>"+Constants.FailTC+"\n"+"  Total SKIPPED==>"+Constants.SkipTC+"\n"+
    			"For Full Detail please find attached Status report    \n\n\n\n\n\n\n"+"Regards,\n"+"Anuj Kumar Gautam";
    	//System.out.println("Url from external file is ===>"+url);
    	sendReport("File Name",Constants.MGR_ID, Filepath, Mail_Body);
       }
    }

