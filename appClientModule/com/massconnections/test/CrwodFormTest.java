package com.massconnections.test;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.massconnections.gui.CrowdForm;
import com.massconnections.gui.MainFrame;

public class CrwodFormTest {

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
		MainFrame cf = new MainFrame();
		cf.setVisible(true);
	}

}
