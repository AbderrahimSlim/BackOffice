package com.massconnections.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.massconnections.Delegate.ChallengeCategoryCrudDelegate;
import com.massconnections.Delegate.ProjectCategoryCrudDelegate;
import com.massconnections.Domains.ChallengeCategory;
import com.massconnections.Domains.ProjectCategory;
import com.massconnections.Model.ChallengeCategorieListModel;
import com.massconnections.Model.ProjectCategorieListModel;
import javax.swing.ImageIcon;

public class CategoriesPanel extends JPanel {
	private JTextField nameField;

	/**
	 * Create the panel.
	 */
	public CategoriesPanel() {

		JSeparator separator = new JSeparator();

		final JComboBox typeComboBox = new JComboBox();
		typeComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Project categories", "Challege Categories" }));

		JButton btnRefresh = new JButton("");
		btnRefresh.setIcon(new ImageIcon(CategoriesPanel.class
				.getResource("/com/massconnections/img/refresh.png")));

		nameField = new JTextField();
		nameField.setColumns(10);

		final JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(CategoriesPanel.class
				.getResource("/com/massconnections/img/ADD.png")));

		JLabel lblName = new JLabel("Name :");

		JScrollPane scrollPane = new JScrollPane();

		JButton btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(CategoriesPanel.class
				.getResource("/com/massconnections/img/delete.png")));

		JButton btnEdit = new JButton("");
		btnEdit.setIcon(new ImageIcon(CategoriesPanel.class
				.getResource("/com/massconnections/img/Edit.png")));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												typeComboBox,
																												GroupLayout.PREFERRED_SIZE,
																												128,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												327,
																												Short.MAX_VALUE)
																										.addComponent(
																												btnRefresh,
																												GroupLayout.PREFERRED_SIZE,
																												76,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								separator,
																								GroupLayout.PREFERRED_SIZE,
																								526,
																								Short.MAX_VALUE)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												scrollPane,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(18)
																										.addComponent(
																												lblName)
																										.addGap(18)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																groupLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				btnAdd,
																																				GroupLayout.PREFERRED_SIZE,
																																				76,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				btnEdit,
																																				GroupLayout.PREFERRED_SIZE,
																																				76,
																																				GroupLayout.PREFERRED_SIZE))
																														.addComponent(
																																nameField,
																																GroupLayout.DEFAULT_SIZE,
																																196,
																																Short.MAX_VALUE))))
																		.addGap(8))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				btnDelete,
																				GroupLayout.PREFERRED_SIZE,
																				76,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				462,
																				Short.MAX_VALUE)))));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(8)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																typeComboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnRefresh,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(separator,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				scrollPane,
																				GroupLayout.DEFAULT_SIZE,
																				233,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnDelete,
																				GroupLayout.PREFERRED_SIZE,
																				23,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(29))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblName)
																						.addComponent(
																								nameField,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								btnAdd,
																								GroupLayout.PREFERRED_SIZE,
																								23,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnEdit,
																								GroupLayout.PREFERRED_SIZE,
																								23,
																								GroupLayout.PREFERRED_SIZE))
																		.addContainerGap()))));

		final JList categList = new JList();
		categList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (typeComboBox.getSelectedIndex() == 0) {
					ProjectCategory cat = (ProjectCategory) ((categList
							.getModel()).getElementAt(categList
							.getSelectedIndex()));
					nameField.setText(cat.getName());
				} else {
					ChallengeCategory cat = (ChallengeCategory) ((categList
							.getModel()).getElementAt(categList
							.getSelectedIndex()));
					nameField.setText(cat.getName());
				}
			}
		});
		scrollPane.setViewportView(categList);
		setLayout(groupLayout);
		typeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (typeComboBox.getSelectedIndex() == 0) {
					categList.setModel(new ProjectCategorieListModel());
				} else {
					categList.setModel(new ChallengeCategorieListModel());
				}
			}
		});
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (typeComboBox.getSelectedIndex() == 0) {
					categList.setModel(new ProjectCategorieListModel());
				} else {
					categList.setModel(new ChallengeCategorieListModel());
				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (typeComboBox.getSelectedIndex() == 0) {
					ProjectCategory cat = (ProjectCategory) categList
							.getModel().getElementAt(
									categList.getSelectedIndex());
					ProjectCategoryCrudDelegate.delete(cat);
					categList.setModel(new ProjectCategorieListModel());
				} else {
					ChallengeCategory cat = (ChallengeCategory) categList
							.getModel().getElementAt(
									categList.getSelectedIndex());
					ChallengeCategoryCrudDelegate.delete(cat);
					categList.setModel(new ChallengeCategorieListModel());
				}
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (typeComboBox.getSelectedIndex() == 0) {
					ProjectCategory pCat = new ProjectCategory();
					pCat.setName(nameField.getText());
					ProjectCategoryCrudDelegate.addProjectCategory(pCat);
					categList.setModel(new ProjectCategorieListModel());
				} else {
					ChallengeCategory cCat = new ChallengeCategory();
					cCat.setName(nameField.getText());
					ChallengeCategoryCrudDelegate.addProjectCategory(cCat);
					categList.setModel(new ChallengeCategorieListModel());
				}
				nameField.setText("");
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (categList.getSelectedIndex() >= 0) {
					if (typeComboBox.getSelectedIndex() == 0) {
						ProjectCategory pCat = (ProjectCategory) (categList
								.getModel()).getElementAt(categList
								.getSelectedIndex());
						pCat.setName(nameField.getText());
						ProjectCategoryCrudDelegate.edit(pCat);
						categList.setModel(new ProjectCategorieListModel());
					} else {
						ChallengeCategory cCat = (ChallengeCategory) (categList
								.getModel()).getElementAt(categList
								.getSelectedIndex());
						cCat.setName(nameField.getText());
						ChallengeCategoryCrudDelegate.edit(cCat);
						categList.setModel(new ChallengeCategorieListModel());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Select a row !");
				}
				nameField.setText("");
			}
		});
	}
}
