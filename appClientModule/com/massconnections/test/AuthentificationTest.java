package com.massconnections.test;

import java.awt.EventQueue;

import com.massconnections.Model.StatisticsModel;
import com.massconnections.gui.AuthentificationFrame;

public class AuthentificationTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthentificationFrame cf = new AuthentificationFrame(); 
					 cf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
