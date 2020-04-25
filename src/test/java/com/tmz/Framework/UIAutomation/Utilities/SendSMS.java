package com.tmz.Framework.UIAutomation.Utilities;
//Install the Java helper library from twilio.com/docs/java/install

//Install the Java helper library from twilio.com/docs/java/install

import com.twilio.rest.api.v2010.account.Message;

public class SendSMS {
	
	public void sendMessage(String mssge) {
		Message message = Message.creator(new com.twilio.type.PhoneNumber("+XXXXXXXXXXX"),
		new com.twilio.type.PhoneNumber("+19099069833"), mssge).create();

		System.out.println(message.getSid());
	}


}
