package com.massconnections.test;

import java.util.List;

import com.massconnections.Delegate.CrowdCrudDelegate;
import com.massconnections.Delegate.MessageDelegate;
import com.massconnections.Domains.Crowd;
import com.massconnections.Domains.Message;

public class MessageTest {

	public static void main(String[] args) {
		
		
		
		//MessageDelegate.SendMessage(CrowdCrudDelegate.getById(1), CrowdCrudDelegate.getById(2), "testObj3", "testcontent2");
		//System.out.println(MessageDelegate.getInboxMessages(CrowdCrudDelegate.getById(2)));
		List<Message> messages = MessageDelegate.getInboxMessages(CrowdCrudDelegate.getById(2));
		for ( Message m: messages){
			System.out.println(m.getContent());
		}
	}

}
