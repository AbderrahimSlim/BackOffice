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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

	public static JPanel contentPane;
	public static JPanel bodyPanel;
	

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("MassConnections");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(27,188,155));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		final JPanel bodyPanel = new JPanel();
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
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 445, Short.MAX_VALUE)
				.addComponent(bodyPanel, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
		);
		
		JButton lblMenu = new JButton("");
		lblMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/menu.png")));
		
		JButton labelProject = new JButton("");
		labelProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bodyPanel.removeAll();
				bodyPanel.add(new ConsultationPanel("projects"));
                repaint();
                printAll(getGraphics());//Extort print all content
			}
		});
		labelProject.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/project.png")));
		
		JButton labelChallenge = new JButton("");
		labelChallenge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bodyPanel.removeAll();
				bodyPanel.add(new ConsultationPanel("challenges"));
                repaint();
                printAll(getGraphics());//Extort print all content
			}
		});
		labelChallenge.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/challenge.png")));
		
		JButton labelUser = new JButton("");
		labelUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bodyPanel.removeAll();
				bodyPanel.add(new ConsultationPanel("crowds"));
                repaint();
                printAll(getGraphics());//Extort print all content
			}
		});
		labelUser.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/users.png")));
		
		JButton labelStat = new JButton("");
		labelStat.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/stat.png")));
		
		JButton labelMessage = new JButton("");
		labelMessage.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/msg.png")));
		
		JButton lblLogout = new JButton("");
		lblLogout.setIcon(new ImageIcon(MainFrame.class.getResource("/com/massconnections/img/signout.png")));
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(labelProject, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 219, Short.MAX_VALUE)
						.addComponent(labelUser, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 218, Short.MAX_VALUE)
						.addComponent(labelMessage, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 218, Short.MAX_VALUE)
						.addComponent(labelChallenge, GroupLayout.PREFERRED_SIZE, 218, Short.MAX_VALUE)
						.addComponent(lblLogout, GroupLayout.PREFERRED_SIZE, 219, Short.MAX_VALUE)
						.addComponent(labelStat, GroupLayout.PREFERRED_SIZE, 219, Short.MAX_VALUE)
						.addComponent(lblMenu, 0, 0, Short.MAX_VALUE))
					.addContainerGap(1, Short.MAX_VALUE))
		);
		gl_menuPanel.setVerticalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(labelProject, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(labelChallenge, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(labelUser, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(labelStat, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(labelMessage, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(lblLogout, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		menuPanel.setLayout(gl_menuPanel);
		bodyPanel.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(gl_contentPane);
		ConsultationPanel consultationPanel = new ConsultationPanel("projects");
		consultationPanel.setBackground(Color.WHITE);
		bodyPanel.add(consultationPanel);
	}
}
