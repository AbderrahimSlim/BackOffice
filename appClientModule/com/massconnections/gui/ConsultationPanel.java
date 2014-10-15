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
import com.massconnections.Domains.Crowd;
import com.massconnections.Model.ChallengesTableModel;
import com.massconnections.Model.CrowdTableModel;
import com.massconnections.Model.GenericTableModel;
import com.massconnections.Model.ProjectsTableModel;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultationPanel extends JPanel {
	private JTextField searchTextField;
	private JTable table;
	public static GenericTableModel tableModel;
	public String type = "";
	JComboBox categComboBox = new JComboBox();
	private ListSelectionModel lsm;
	private JButton btnRight;

	/**
	 * Create the panel.
	 */
	public ConsultationPanel(String type) {
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
												GroupLayout.DEFAULT_SIZE, 381,
												Short.MAX_VALUE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(optionPanel,
												GroupLayout.PREFERRED_SIZE, 44,
												GroupLayout.PREFERRED_SIZE)
										.addGap(5)));

		JButton btnLeft = new JButton();
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeft.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnMiddle = new JButton();

		btnRight = new JButton();
		GroupLayout gl_optionPanel = new GroupLayout(optionPanel);
		gl_optionPanel.setHorizontalGroup(gl_optionPanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_optionPanel.createSequentialGroup().addContainerGap()
						.addComponent(btnLeft)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnMiddle)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnRight)
						.addContainerGap(378, Short.MAX_VALUE)));
		gl_optionPanel.setVerticalGroup(gl_optionPanel.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						gl_optionPanel
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_optionPanel
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(btnLeft)
												.addComponent(btnMiddle)
												.addComponent(btnRight))
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		optionPanel.setLayout(gl_optionPanel);
		categComboBox.setMaximumRowCount(20);

		table = new JTable();
		if (type.equals("projects")) {
			tableModel = new ProjectsTableModel();
			String[] options =  { "Id", "Title", "Creator", "Description",
					"Creation Date", "Deadline", "Amount", "State", "Category" };
			categComboBox.setModel(new DefaultComboBoxModel(options));
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
			btnMiddle.setText("Denie");
			btnMiddle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProjectCrudDelegate.denieProject(ProjectCrudDelegate
							.getById(((Integer) table.getValueAt(
									table.getSelectedRow(), 0)).intValue()));
					tableModel = new ProjectsTableModel();
					table.setModel(tableModel);
				}
			});

		}
		if (type.equals("crowds")) {
			
			String[] options =  { "First Name", "Last Name", "Age", "sex", "Login",
					"Email", "Projects", "Challenges" };
			categComboBox.setModel(new DefaultComboBoxModel(options));
			
			btnLeft.setText("Add");
			btnLeft.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CrowdForm().show();
				}
			});

			btnMiddle.setText("Modify");
			btnMiddle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lsm.getMinSelectionIndex();
					if (lsm == null) {
						JOptionPane.showMessageDialog(null,
								"Selectionner une ligne",
								"Erreur de Selection",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int minIndex = lsm.getMinSelectionIndex();
						int maxIndex = lsm.getMaxSelectionIndex();
						if ((maxIndex - minIndex) == 0) {
							Object element = tableModel.getElementAt(minIndex);
							new CrowdForm((Crowd) element).show();
						} else {
							JOptionPane.showMessageDialog(null,
									"Selectionner une seul ligne",
									"Erreur de Selection",
									JOptionPane.ERROR_MESSAGE);
						}
					}

				}
			});

			
			
			tableModel = new CrowdTableModel();
		}
		if (type.equals("challenges")) {
			String[] options = { "Id", "Title", "Submitter", "Description",
					"Category", "State" };
			categComboBox.setModel(new DefaultComboBoxModel(options));

			tableModel = new ChallengesTableModel();

			btnLeft.setText("Approve");
			btnLeft.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ChallengeCrudDelegate.approveChalenge(ChallengeCrudDelegate
							.getChallenge(((Integer) table.getValueAt(
									table.getSelectedRow(), 0)).intValue()));
					tableModel = new ChallengesTableModel();
					table.setModel(tableModel);
				}
			});
			btnMiddle.setText("Denie");
			btnMiddle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ChallengeCrudDelegate.denieChalenge(ChallengeCrudDelegate
							.getChallenge(((Integer) table.getValueAt(
									table.getSelectedRow(), 0)).intValue()));
					tableModel = new ChallengesTableModel();
					table.setModel(tableModel);
				}
			});
		}
		
		btnRight.setText("Delete");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lsm == null) {
					JOptionPane.showMessageDialog(null,
							"Selectionner au moin une ligne",
							"Erreur de Selection",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int p = JOptionPane
							.showConfirmDialog(
									null,
									"!voulez-vous vraiment supprimer  cet élément?",
									"Supprimer", JOptionPane.YES_NO_OPTION);
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

	}

	public class ConsultationTableListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			lsm = (ListSelectionModel) e.getSource();
		}
	}
}
