package com.massconnections.test;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.massconnections.Delegate.CrowdCrudDelegate;
import com.massconnections.Model.StatisticsModel;
import com.massconnections.gui.MainFrame;

public class CatPanelTest {

	public static void main(String[] args) {
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
					MainFrame.getInstance(CrowdCrudDelegate.getById(1)).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		/*MainFrame cf = new MainFrame(); 
		 cf.setVisible(true);*/
		 
		 
		//Crowd c = new Crowd();
		
		//CrowdCrudDelegate.getCrowds();
		//CrowdCrudDelegate.getById(1);

		
		
		//CrowdCrudDelegate.addCrowd(c);
		//c = CrowdCrudDelegate.getById(1);
		//System.out.println(c.getFirstName());
		// CrowdCrudDelegate.findCrowdByLogin("ahm");

	}

}
