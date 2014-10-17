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

import com.massconnections.Domains.Crowd;
import com.massconnections.Domains.Project;
import com.massconnections.Domains.ProjectCategory;
import com.massconnections.Domains.ProjectDocument;
import com.massconnections.Model.ProjectDocumentListModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;

public class ProjectView extends JFrame {
	static Project p;

	public ProjectView(Project pr) {
		p = pr;
		setTitle("Project View");
		setBounds(100, 100, 800, 600);
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

		JLabel lblCategoryValue = new JLabel("");

		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Arial", Font.PLAIN, 16));

		lblState.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCategory.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAmount.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDeadline.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCreationDate.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCreator.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCategoryValue.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCategoryValue.setText(p.getCategory() instanceof ProjectCategory ? p
				.getCategory().getName() : "");
		lblTitle.setText(p.getTitle());
		final JList docList = new JList();
		if (p.getProjectDocuments().size() > 0) {
			docList.setModel(new ProjectDocumentListModel(p));
		}

		JLabel lblDocuments = new JLabel("Documents :");
		lblDocuments.setFont(new Font("Arial", Font.PLAIN, 16));

		JButton btnDownload = new JButton("Download");
		btnDownload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for (int i = 0; i < docList.getSelectedIndices().length; i++) {
					System.out.println(docList.getModel().getElementAt(
							docList.getSelectedIndices()[i]));
				}
			}
		});
		
		JSeparator separator = new JSeparator();

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(5)
									.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblCreationDate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblCreator, Alignment.LEADING)
										.addComponent(lblDeadline, Alignment.LEADING)
										.addComponent(lblAmount, Alignment.LEADING)
										.addComponent(lblCategory, Alignment.LEADING)
										.addComponent(lblState, Alignment.LEADING))
									.addGap(18)
									.addComponent(lblCategoryValue, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblDocuments, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(33)
									.addComponent(docList, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(132)
							.addComponent(btnDownload)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblCreator)
					.addGap(18)
					.addComponent(lblCreationDate)
					.addGap(18)
					.addComponent(lblDeadline)
					.addGap(18)
					.addComponent(lblAmount)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory)
						.addComponent(lblCategoryValue, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblState)
					.addGap(18)
					.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDocuments, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(docList, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addComponent(btnDownload)
					.addContainerGap(107, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					try {
						UIManager.setLookAndFeel(UIManager
								.getSystemLookAndFeelClassName());
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

					/*
					 * Project pr = new Project(); pr.setAmount(100);
					 * pr.setCreationDate(new Date(104, 11, 11));
					 * pr.setDeadLine(new Date(2011, 11, 11)); pr.setState(0);
					 * pr.setDescription(
					 * "svkhgsdfklghqgkljwhsdflhqgsk\nslfhlqsdgfkjhlqsdgqdglgqdg \n sqdfkghlqsdfjqhlsdg \n jhwsdfkgh;wf"
					 * ); pr.setId(-1); pr.setTitle("jskvdfgljhkkhjfkg");
					 * Set<ProjectDocument> pDSet = new
					 * HashSet<ProjectDocument>(); ProjectDocument d1 = new
					 * ProjectDocument(); ProjectDocument d2 = new
					 * ProjectDocument(); ProjectDocument d3 = new
					 * ProjectDocument(); d1.setName("1"); d1.setType('e');
					 * d2.setName("1"); d2.setType('x'); d3.setName("2");
					 * d3.setType('x'); pDSet.add(d1); pDSet.add(d2);
					 * pDSet.add(d3); pr.setProjectDocuments(pDSet);
					 */

					ProjectView frame = new ProjectView(p);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}