package com.massconnections.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.massconnections.Delegate.CrowdCrudDelegate;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("MassConnections");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(bodyPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(bodyPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
				.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 441, Short.MAX_VALUE)
		);
		
		JLabel lblMenu = new JLabel("");
		lblMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/menu.png")));
		
		JLabel labelProject = new JLabel("");
		labelProject.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/project.png")));
		
		JLabel labelChallenge = new JLabel("");
		labelChallenge.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/challenge.png")));
		
		JLabel labelUser = new JLabel("");
		labelUser.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/users.png")));
		
		JLabel labelStat = new JLabel("");
		labelStat.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/stat.png")));
		
		JLabel labelMessage = new JLabel("");
		labelMessage.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/msg.png")));
		
		JLabel lblLogout = new JLabel("");
		lblLogout.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/signout.png")));
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(labelProject, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
						.addComponent(labelUser, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 218, Short.MAX_VALUE)
						.addComponent(labelMessage, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 218, Short.MAX_VALUE)
						.addComponent(lblMenu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(labelChallenge, GroupLayout.PREFERRED_SIZE, 218, Short.MAX_VALUE)
						.addComponent(lblLogout, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelStat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_menuPanel.setVerticalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(0)
					.addComponent(labelProject, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(labelChallenge, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(labelUser, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(labelStat, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(labelMessage, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(lblLogout, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1, Short.MAX_VALUE))
		);
		menuPanel.setLayout(gl_menuPanel);
		bodyPanel.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(gl_contentPane);
		bodyPanel.add(new ConsultationPanel("projects"));
	}
}
