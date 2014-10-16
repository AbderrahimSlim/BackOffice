package com.massconnections.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
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

import com.massconnections.Delegate.ChallengeCrudDelegate;
import com.massconnections.Delegate.CrowdCrudDelegate;
import com.massconnections.Delegate.ProjectCrudDelegate;
import com.massconnections.Domains.Challenge;
import com.massconnections.Domains.Crowd;
import com.massconnections.Domains.Project;
import com.massconnections.Model.ChallengesTableModel;
import com.massconnections.Model.CrowdTableModel;
import com.massconnections.Model.GenericTableModel;
import com.massconnections.Model.MessageTableModel;
import com.massconnections.Model.ProjectsTableModel;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

public class MessagePanel extends JPanel {
	private JTextField searchTextField;
	private JTable table;
	public static GenericTableModel tableModel;
	public static String type = "";
	JComboBox categComboBox = new JComboBox();
	private ListSelectionModel lsm;
	private JButton btnRight;

	/**
	 * Create the panel.
	 */
	public MessagePanel(String type) {
		setBackground(Color.WHITE);
		this.type = type;

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblRecherche = new JLabel("Search By:");

		searchTextField = new JTextField();
		searchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				tableModel.initSearch(searchTextField.getText(),
						categComboBox.getSelectedIndex());
				tableModel.fireTableDataChanged();
			}
		});
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

		JButton btnLeft = new JButton();
		btnLeft.setText("Send");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeft.setHorizontalAlignment(SwingConstants.RIGHT);

		btnRight = new JButton();
		btnRight.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout gl_optionPanel = new GroupLayout(optionPanel);
		gl_optionPanel.setHorizontalGroup(gl_optionPanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_optionPanel
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnLeft)
						.addGap(18)
						.addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 63,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(306, Short.MAX_VALUE)));
		gl_optionPanel.setVerticalGroup(gl_optionPanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_optionPanel
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_optionPanel
										.createParallelGroup(Alignment.LEADING)
										.addComponent(btnRight,
												GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLeft))
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		optionPanel.setLayout(gl_optionPanel);
		categComboBox.setMaximumRowCount(20);

		table = new JTable();

		tableModel = new ProjectsTableModel();
		String[] categOptions = { "Sender", "Object", "Content", "Date" };
		categComboBox.setModel(new DefaultComboBoxModel(categOptions));
		btnLeft.setText("Approve");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectCrudDelegate.approveProject(ProjectCrudDelegate
						.getById(((Integer) table.getValueAt(
								table.getSelectedRow(), 0)).intValue()));
				tableModel = new ProjectsTableModel();
				table.setModel(tableModel);
			}
		});

		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lsm == null) {
					JOptionPane.showMessageDialog(null,
							"At least select one row", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int p = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to delete this element",
							"Delete", JOptionPane.YES_NO_OPTION);
					if (p == 0) {
						int minIndex = lsm.getMinSelectionIndex();
						int maxIndex = lsm.getMaxSelectionIndex();
						List elements = new ArrayList();
						for (int i = minIndex; i <= maxIndex; i++) {
							if (lsm.isSelectedIndex(i)) {
								Object element = tableModel.getElementAt(i);
								elements.add(element);
							}
						}
						tableModel.removeRows(elements);
						tableModel.fireTableDataChanged();
					}
				}
			}
		});

		table.setModel(tableModel);
		table.setAutoCreateRowSorter(true);
		table.getSelectionModel().addListSelectionListener(
				new ConsultationTableListener());

		scrollPane.setViewportView(table);
		setLayout(groupLayout);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					if (lsm == null) {
						JOptionPane.showMessageDialog(null, "Select a row",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						int minIndex = lsm.getMinSelectionIndex();
						int maxIndex = lsm.getMaxSelectionIndex();
						if ((maxIndex - minIndex) == 0) {
							Object element = tableModel.getElementAt(minIndex);
							// appel de frame
						} else {
							JOptionPane.showMessageDialog(null, "Select a row",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		MessagesComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MessagesComboBox.getSelectedIndex() == 0) {
					table.setModel(new MessageTableModel(CrowdCrudDelegate.getById(2)));
				} else {
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
