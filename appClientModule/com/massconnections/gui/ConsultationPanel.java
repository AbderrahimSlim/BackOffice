package com.massconnections.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.massconnections.Delegate.ChallengeCrudDelegate;
import com.massconnections.Delegate.ProjectCrudDelegate;
import com.massconnections.Model.ChallengesTableModel;
import com.massconnections.Model.CrowdTableModel;
import com.massconnections.Model.GenericTableModel;
import com.massconnections.Model.ProjectsTableModel;
import java.awt.Font;

public class ConsultationPanel extends JPanel {
	private JTextField searchTextField;
	private JTable table;
	private GenericTableModel tableModel;
	public String type = "";
	JComboBox categComboBox = new JComboBox();

	/**
	 * Create the panel.
	 */
	public ConsultationPanel(String type) {

		this.type = type;

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblRecherche = new JLabel("Search By:");
		lblRecherche.setFont(new Font("Arial", Font.PLAIN, 12));

		searchTextField = new JTextField();
		searchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				tableModel = new ProjectsTableModel();

				tableModel.initSearch(searchTextField.getText(),
						categComboBox.getSelectedIndex());

				table.setModel(tableModel);
			}
		});
		searchTextField.setColumns(10);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ConsultationPanel.this.type == "projects") {
					tableModel = new ProjectsTableModel();
					table.setModel(tableModel);
				}
			}
		});

		JPanel optionPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																optionPanel,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																675,
																Short.MAX_VALUE)
														.addComponent(
																scrollPane,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																675,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblRecherche)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				categComboBox,
																				GroupLayout.PREFERRED_SIZE,
																				117,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				searchTextField,
																				117,
																				117,
																				117)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				304,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnRefresh)))
										.addContainerGap()));
		categComboBox.setMaximumRowCount(20);
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnRefresh)
														.addComponent(
																lblRecherche)
														.addComponent(
																categComboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																searchTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(scrollPane,
												GroupLayout.DEFAULT_SIZE, 345,
												Short.MAX_VALUE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(optionPanel,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(5)));

		table = new JTable();
		if (type.equals("projects")) {
			tableModel = new ProjectsTableModel();
			String[] options = { "Id", "Title", "Creator", "4", "5", "6", "7", "8", "9" };
			categComboBox.setModel(new DefaultComboBoxModel(options));
			JButton approveBtn = new JButton("Approve");
			approveBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProjectCrudDelegate.approveProject(ProjectCrudDelegate
							.getById(((Integer) table.getValueAt(
									table.getSelectedRow(), 0)).intValue()));
					tableModel = new ProjectsTableModel();
					table.setModel(tableModel);
				}
			});
			optionPanel.add(approveBtn);
			JButton denieBtn = new JButton("Deny");
			denieBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProjectCrudDelegate.denieProject(ProjectCrudDelegate
							.getById(((Integer) table.getValueAt(
									table.getSelectedRow(), 0)).intValue()));
					tableModel = new ProjectsTableModel();
					table.setModel(tableModel);
				}
			});
			optionPanel.add(denieBtn);
		}
		if (type.equals("crowds")) {
			tableModel = new CrowdTableModel();
		}
		if (type.equals("challenges")) {
			
			tableModel = new ChallengesTableModel();
			String[] options = { "Id", "Title", "Submitter", "Description", "Category", "State"};
			categComboBox.setModel(new DefaultComboBoxModel(options));
			

			JButton approveBtn = new JButton("Approve");
			approveBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ChallengeCrudDelegate.approveChalenge(ChallengeCrudDelegate
							.getChallenge(((Integer) table.getValueAt(
									table.getSelectedRow(), 0)).intValue()));
					tableModel = new ChallengesTableModel();
					table.setModel(tableModel);
				}
			});
			optionPanel.add(approveBtn);
			JButton denieBtn = new JButton("Deny");
			denieBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ChallengeCrudDelegate.denieChalenge(ChallengeCrudDelegate
							.getChallenge(((Integer) table.getValueAt(
									table.getSelectedRow(), 0)).intValue()));
					tableModel = new ChallengesTableModel();
					table.setModel(tableModel);
				}
			});
			optionPanel.add(denieBtn);
		}
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}
}
