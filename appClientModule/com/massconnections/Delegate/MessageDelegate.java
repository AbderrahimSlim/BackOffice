package com.massconnections.Delegate;

import java.util.List;

import com.massconnections.Domains.Crowd;
import com.massconnections.Domains.Message;
import com.massconnections.Services.CrowdCrudEJBRemote;
import com.massconnections.Services.MessageCrudEJBRemote;
import com.massconnections.locator.ServiceLocator;

public class MessageDelegate {
	private static MessageCrudEJBRemote messageEjb;

	private static MessageCrudEJBRemote getRemoteEJB() {
		messageEjb = (MessageCrudEJBRemote) ServiceLocator
				.getInstance()
				.getProxy(
						"/massconnection-ejb/MessageCrudEJB!com.massconnections.Services.MessageCrudEJBRemote/");
		return messageEjb;
	}

	
	
	public static void SendMessage (Crowd sender, Crowd reciever, String subject,String content){
		System.out.println("sent");
		getRemoteEJB().SendMessage(sender, reciever, subject, content);
	}
	

	public static List<Message> getInboxMessages(Crowd reciever){
		return getRemoteEJB().getInboxMessages(reciever);
	}
	
	public static List<Message> getOutboxMessages(Crowd sender){
		return getRemoteEJB().getOutboxMessages(sender);
	}
	
	
	public static void delete (Message msg){
		System.out.println("deleted");
		getRemoteEJB().delete(msg);
	}
}
