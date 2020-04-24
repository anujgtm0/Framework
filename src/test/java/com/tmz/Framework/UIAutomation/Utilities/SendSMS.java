package com.tmz.Framework.UIAutomation.Utilities;
//Install the Java helper library from twilio.com/docs/java/install

//Install the Java helper library from twilio.com/docs/java/install

import com.twilio.rest.api.v2010.account.Message;

public class SendSMS {
	// Find your Account Sid and Token at twilio.com/console
	// DANGER! This is insecure. See http://twil.io/secure
	/*
	 * public static final String ACCOUNT_SID =
	 * "ACac7aef4c8d53889180312b64f82a6538"; public static final String AUTH_TOKEN =
	 * "85082fe40e32779eefef9b97dc8de68f";
	 */
	public void sendMessage(String mssge) {
		Message message = Message.creator(new com.twilio.type.PhoneNumber("+919620544877"),
		new com.twilio.type.PhoneNumber("+19099069833"), mssge).create();

		System.out.println(message.getSid());
	}


}
