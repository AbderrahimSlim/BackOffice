package com.massconnections.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.massconnections.Delegate.ProjectCrudDelegate;
import com.massconnections.Domains.Crowd;
import com.massconnections.Domains.Project;
import com.massconnections.Domains.ProjectCategory;
import com.massconnections.Domains.ProjectDocument;
import com.massconnections.Model.ProjectDocumentListModel;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class ProjectView extends JFrame {
	static Project p;

	public ProjectView(final Project pr) {
		p = pr;
		setTitle("Project View");
		setBounds(100, 100, 800, 493);
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 22));

		JLabel lblCreator = new JLabel("Creator :");

		JLabel lblCreationDate = new JLabel("Creation date :");

		JLabel lblDeadline = new JLabel("Deadline :");

		JLabel lblAmount = new JLabel("Amount :");

		JLabel lblCategory = new JLabel("Category :");

		JLabel lblState = new JLabel("State :");

		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Arial", Font.PLAIN, 16));

		lblState.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCategory.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAmount.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDeadline.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCreationDate.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCreator.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTitle.setText(p.getTitle());
		
		
		JSeparator separator = new JSeparator();
		
		JLabel lblValueCreator = new JLabel("");
		
		JLabel lblValueCreationDate = new JLabel("");
		
		JLabel lblValueDeadline = new JLabel("");
		
		JLabel lblValueAmount = new JLabel("");
		
		JLabel lblValueCategory = new JLabel("");
		
		JLabel lblValueState = new JLabel("");
		
		JLabel lblValueDescription = new JLabel("");
		
		JButton approveBtn = new JButton("");
		
		approveBtn.setIcon(new ImageIcon(ProjectView.class.getResource("/com/massconnections/img/approve.png")));
		
		JButton denybtn = new JButton("");
		
		denybtn.setIcon(new ImageIcon(ProjectView.class.getResource("/com/massconnections/img/deny.png")));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(5)
									.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblCreationDate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblCreator, Alignment.LEADING)
												.addComponent(lblDeadline, Alignment.LEADING)
												.addComponent(lblAmount, Alignment.LEADING)
												.addComponent(lblCategory, Alignment.LEADING)
												.addComponent(lblState, Alignment.LEADING))
											.addGap(18))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblValueDescription, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblValueState, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblValueCategory, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblValueAmount, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblValueDeadline, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblValueCreationDate, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblValueCreator)))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(approveBtn, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(denybtn, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGap(629))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCreator)
						.addComponent(lblValueCreator))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCreationDate)
						.addComponent(lblValueCreationDate))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDeadline)
						.addComponent(lblValueDeadline))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount)
						.addComponent(lblValueAmount))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory)
						.addComponent(lblValueCategory))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblState)
						.addComponent(lblValueState))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblValueDescription, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(approveBtn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(denybtn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		approveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProjectCrudDelegate.approveProject(pr);
				dispose();
			}
		});
		
		denybtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProjectCrudDelegate.denieProject(pr);
				dispose();
			}
		});
		
		lblValueAmount.setText(pr.getAmount() + "");
		if (pr.getCategory() != null)
		lblValueCategory.setText(pr.getCategory().getName());
		if (pr.getCreationDate() != null)
		lblValueCreationDate.setText(pr.getCreationDate().toLocaleString());
		if (pr.getUser() != null)
		lblValueCreator.setText(pr.getUser().toString());
		if (pr.getDeadLine() != null)
		lblValueDeadline.setText(pr.getDeadLine().toLocaleString());
		lblValueDescription.setText(pr.getDescription());
		lblValueState.setText(pr.getState()+"");
		
	}
}