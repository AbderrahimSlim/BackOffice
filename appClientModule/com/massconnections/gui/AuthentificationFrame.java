package com.massconnections.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.massconnections.Delegate.CrowdCrudDelegate;
import com.massconnections.Domains.Crowd;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AuthentificationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField Login;
	private JPasswordField Password;
	private JLabel Singninn;
	
	
	
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
					//MainFrame.getInstance(new Crowd()).show();
					new AuthentificationFrame().show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AuthentificationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Singninn = new JLabel("");
		Singninn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Crowd crowd = CrowdCrudDelegate.authentification(Login.getText(), Password.getText());
				if (crowd!=null){
					dispose();
					MainFrame.getInstance(crowd).show();
				}else{
					JOptionPane.showMessageDialog(null,
							"Invalid Login Or Password",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Singninn.setBounds(123, 214, 126, 50);
		contentPane.add(Singninn);
		
		Login = new JTextField();
		Login.setBounds(48, 59, 234, 45);
		contentPane.add(Login);
		Login.setColumns(10);
		
		Password = new JPasswordField();
		Password.setBounds(48, 127, 234, 45);
		contentPane.add(Password);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AuthentificationFrame.class.getResource("/com/massconnections/img/nn.png")));
		lblNewLabel.setBounds(12, 0, 326, 364);
		
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(56, 260, 56, 16);
		contentPane.add(lblNewLabel_1);
	}
}
