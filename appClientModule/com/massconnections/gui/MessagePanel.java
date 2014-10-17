package com.massconnections.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.massconnections.Delegate.CrowdCrudDelegate;
import com.massconnections.Delegate.ProjectCrudDelegate;
import com.massconnections.Model.GenericTableModel;
import com.massconnections.Model.InBoxMessageTableModel;
import com.massconnections.Model.OutBoxMessageTableModel;
import com.massconnections.Model.ProjectsTableModel;

public class MessagePanel extends JPanel {
	private JTextField searchTextField;
	private JTable table;
	public static GenericTableModel tableModel;
	JComboBox categComboBox = new JComboBox();
	private ListSelectionModel lsm;

	/**
	 * Create the panel.
	 */
	public MessagePanel() {
		tableModel = new GenericTableModel();
		setBackground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblRecherche = new JLabel("Search By:");

		searchTextField = new JTextField();

		searchTextField.setColumns(10);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.refresh();
				tableModel.fireTableDataChanged();
				lsm = null;
			}
		});

		JPanel optionPanel = new JPanel();
		optionPanel.setBackground(Color.WHITE);

		JLabel lblMessages = new JLabel("Messages :");

		final JComboBox MessagesComboBox = new JComboBox();
		String[] messageOptions = { "InBox", "OutBox" };

		MessagesComboBox.setModel(new DefaultComboBoxModel(messageOptions));

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
																scrollPane,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																576,
																Short.MAX_VALUE)
														.addComponent(
																optionPanel,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																576,
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
																		.addGap(18)
																		.addComponent(
																				lblMessages)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				MessagesComboBox,
																				GroupLayout.PREFERRED_SIZE,
																				66,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				63,
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
																searchTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																MessagesComboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMessages))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(scrollPane,
												GroupLayout.DEFAULT_SIZE, 200,
												Short.MAX_VALUE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(optionPanel,
												GroupLayout.PREFERRED_SIZE, 44,
												GroupLayout.PREFERRED_SIZE)
										.addGap(5)));

		JButton btnNewMessage = new JButton("New Message");

		GroupLayout gl_optionPanel = new GroupLayout(optionPanel);
		gl_optionPanel.setHorizontalGroup(gl_optionPanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_optionPanel.createSequentialGroup().addContainerGap()
						.addComponent(btnNewMessage)
						.addContainerGap(477, Short.MAX_VALUE)));
		gl_optionPanel.setVerticalGroup(gl_optionPanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_optionPanel
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnNewMessage)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		optionPanel.setLayout(gl_optionPanel);
		categComboBox.setMaximumRowCount(20);

		table = new JTable();

		categComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Sender", "Object", "Content" }));

		table.setModel(tableModel);
		table.setAutoCreateRowSorter(true);
		table.getSelectionModel().addListSelectionListener(
				new ConsultationTableListener());

		scrollPane.setViewportView(table);
		setLayout(groupLayout);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					// message info
				}
			}
		});
		MessagesComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MessagesComboBox.getSelectedIndex() == 0) {
					table.setModel(new InBoxMessageTableModel(CrowdCrudDelegate
							.getById(2)));
				} else {
					table.setModel(new OutBoxMessageTableModel(
							CrowdCrudDelegate.getById(2)));
				}
			}
		});

		btnNewMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// new message
			}
		});
		searchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (MessagesComboBox.getSelectedIndex() == 0) {
					((InBoxMessageTableModel) (table.getModel())).initSearch(
							searchTextField.getText(),
							categComboBox.getSelectedIndex());
					((InBoxMessageTableModel) (table.getModel()))
					.fireTableDataChanged();
				} else {
					((OutBoxMessageTableModel) (table.getModel())).initSearch(
							searchTextField.getText(),
							categComboBox.getSelectedIndex());
					((OutBoxMessageTableModel) (table.getModel()))
					.fireTableDataChanged();
				}
				
			}
		});

	}

	public class ConsultationTableListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			lsm = (ListSelectionModel) e.getSource();
		}
	}
}
