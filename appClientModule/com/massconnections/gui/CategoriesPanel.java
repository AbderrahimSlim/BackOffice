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

		JButton btnRefresh = new JButton("Refresh");

		nameField = new JTextField();
		nameField.setColumns(10);

		final JButton btnAdd = new JButton("Add");

		JLabel lblName = new JLabel("Name :");

		JScrollPane scrollPane = new JScrollPane();

		JButton btnDelete = new JButton("Delete");

		JButton btnEdit = new JButton("Edit");

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
							.addComponent(btnRefresh))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane)
							.addGap(18)
							.addComponent(lblName)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAdd)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
							.addGap(2)))
					.addGap(8))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(104)
					.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(377))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRefresh))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(114)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAdd)
								.addComponent(btnEdit)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnDelete)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

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
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (typeComboBox.getSelectedIndex() >= 0) {
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
				}else{
					// jOptionpane !!
				}
			}
		});
	}
}
