package com.massconnections.test;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.massconnections.Delegate.CrowdCrudDelegate;
import com.massconnections.Delegate.MessageDelegate;
import com.massconnections.Domains.Crowd;
import com.massconnections.Domains.Message;
import com.massconnections.Model.StatisticsModel;
import com.massconnections.Services.CrowdCrudEJB;
import com.massconnections.gui.MainFrame;
import com.massconnections.gui.SendMessage;

public class MessageTest {

	public static void main(String[] args) {

		// MessageDelegate.SendMessage(CrowdCrudDelegate.getById(1),
		// CrowdCrudDelegate.getById(2), "testObj3", "testcontent2");
		// System.out.println(MessageDelegate.getInboxMessages(CrowdCrudDelegate.getById(2)));
		// List<Message> messages =
		// MessageDelegate.getInboxMessages(CrowdCrudDelegate.getById(2));
		// for ( Message m: messages){
		// System.out.println(m.getContent());
		// }
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame.getInstance(CrowdCrudDelegate.getById(2)).setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
