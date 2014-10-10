package com.massconnections.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

import com.massconnections.Model.CrowdTableModel;
import com.massconnections.Model.GenericTableModel;
import com.massconnections.Model.ProjectsTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultationPanel extends JPanel {
	private JTextField textField;
	private JTable table;
	private GenericTableModel tableModel;
	public String type = "";

	/**
	 * Create the panel.
	 */
	public ConsultationPanel(String type) {

		if (type.equals("crowds")) {
			tableModel = new CrowdTableModel();
		}
		if (type.equals("projects")) {
			tableModel = new ProjectsTableModel();
		}
		this.type = type;

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblRecherche = new JLabel("Search By:");

		textField = new JTextField();
		textField.setColumns(10);

		JComboBox categComboBox = new JComboBox();

		JButton btnRefresh = new JButton("Refresh");
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
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																scrollPane,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																675,
																Short.MAX_VALUE)
														.addComponent(
																optionPanel,
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
																				textField,
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
																textField,
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
												GroupLayout.PREFERRED_SIZE, 27,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		JButton approveBtn = new JButton("Approve");
		approveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(table.getSelectedRow());
			}
		});
		optionPanel.add(approveBtn);
		JButton denieBtn = new JButton("Denie");
		optionPanel.add(denieBtn);

		table = new JTable();
		table.setModel(tableModel);

		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}
}