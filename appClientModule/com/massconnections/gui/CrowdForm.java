package com.massconnections.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import com.massconnections.Delegate.CrowdCrudDelegate;
import com.massconnections.Domains.Crowd;
import com.massconnections.util.FieldVerifier;
import com.toedter.calendar.JDateChooser;

public class CrowdForm extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JDateChooser birthDateChooser;
	private JTextField AdressTextField;
	private JTextField phoneTextField;
	private JTextField loginTextField;
	private JTextField emailTextField;
	private JTextField passTextField;
	private JComboBox sexComboBox;

	private JLabel firstNameError;
	private JLabel lastNameError;
	private JLabel sexError;
	private JLabel adressError;
	private JLabel phoneError;
	private JLabel emailError;
	private JLabel birthDateError;
	private JLabel loginError;
	private JLabel passError;

	private boolean modif;
	private Crowd crowd;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;

	private void initComponent() {
		setBounds(100, 100, 439, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Manage Crowd",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);

		JLabel lblFirstName = new JLabel("First Name :");

		JLabel lblLastName = new JLabel("Last Name :");

		firstNameTextField = new JTextField();
		firstNameTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				isValidFisrtName();
			}
		});
		firstNameTextField.setColumns(10);

		lastNameTextField = new JTextField();
		lastNameTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				isValidLastName();
			}
		});
		lastNameTextField.setColumns(10);

		JLabel lblAdress = new JLabel("Adress :");

		JLabel lblSex = new JLabel("Sex :");

		JLabel lblBirthDate = new JLabel("Birth Date :");

		sexComboBox = new JComboBox();
		sexComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Men", "Women" }));

		AdressTextField = new JTextField();
		AdressTextField.setColumns(10);

		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Phone :");

		JLabel lblLogin = new JLabel("Login :");

		loginTextField = new JTextField();
		loginTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				isValidLogin();
			}
		});
		loginTextField.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");

		emailTextField = new JTextField();
		emailTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				isValidMail();
			}
		});
		emailTextField.setColumns(10);

		JLabel lblPassword = new JLabel("Password :");

		passTextField = new JTextField();
		passTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				isValidPass();
			}
		});
		passTextField.setColumns(10);

		JSeparator separator = new JSeparator();

		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (isValidFisrtName() & isValidLastName() & isValidMail()
						& isValidPass() & isValidDate() & isValidLogin()) {
					if (!modif) {
						crowd = new Crowd();
					}
					crowd.setFirstName(firstNameTextField.getText());
					crowd.setLastName(lastNameTextField.getText());
					crowd.setSex(sexComboBox.getSelectedItem().toString()
							.charAt(0));
					crowd.setAdress(AdressTextField.getText());
					crowd.setBirthDate(birthDateChooser.getDate());
					crowd.setEmail(emailTextField.getText());
					crowd.setPhone(phoneTextField.getText());
					crowd.setLogin(loginTextField.getText());
					crowd.setPassword(passTextField.getText());
					if (!modif)
						CrowdCrudDelegate.addCrowd(crowd);
					else
						CrowdCrudDelegate.update(crowd);
					dispose();
					ConsultationPanel.tableModel.refresh();
					ConsultationPanel.tableModel.fireTableDataChanged();
				}
			}
		});

		JButton btnCancel = new JButton("Cancel");

		firstNameError = new JLabel("error");
		firstNameError.setVisible(false);
		firstNameError.setFont(new Font("Tahoma", Font.BOLD, 11));
		firstNameError.setForeground(Color.RED);

		lastNameError = new JLabel("error");
		lastNameError.setVisible(false);
		lastNameError.setForeground(Color.RED);
		lastNameError.setFont(new Font("Tahoma", Font.BOLD, 11));

		sexError = new JLabel("error");
		sexError.setVisible(false);
		sexError.setForeground(Color.RED);
		sexError.setFont(new Font("Tahoma", Font.BOLD, 11));

		adressError = new JLabel("error");
		adressError.setVisible(false);
		adressError.setForeground(Color.RED);
		adressError.setFont(new Font("Tahoma", Font.BOLD, 11));

		phoneError = new JLabel("error");
		phoneError.setVisible(false);
		phoneError.setForeground(Color.RED);
		phoneError.setFont(new Font("Tahoma", Font.BOLD, 11));

		emailError = new JLabel("error");
		emailError.setVisible(false);
		emailError.setForeground(Color.RED);
		emailError.setFont(new Font("Tahoma", Font.BOLD, 11));

		birthDateError = new JLabel("error");
		birthDateError.setVisible(false);
		birthDateError.setForeground(Color.RED);
		birthDateError.setFont(new Font("Tahoma", Font.BOLD, 11));

		loginError = new JLabel("error");
		loginError.setVisible(false);
		loginError.setForeground(Color.RED);
		loginError.setFont(new Font("Tahoma", Font.BOLD, 11));

		passError = new JLabel("error");
		passError.setVisible(false);
		passError.setForeground(Color.RED);
		passError.setFont(new Font("Tahoma", Font.BOLD, 11));

		birthDateChooser = new JDateChooser();

		JLabel lblRequire = new JLabel("(*)");
		lblRequire.setForeground(Color.RED);

		JLabel label = new JLabel("(*)");
		label.setForeground(Color.RED);

		JLabel label_1 = new JLabel("(*)");
		label_1.setForeground(Color.RED);

		label_2 = new JLabel("(*)");
		label_2.setForeground(Color.RED);

		label_3 = new JLabel("(*)");
		label_3.setForeground(Color.RED);

		label_4 = new JLabel("(*)");
		label_4.setForeground(Color.RED);

		label_5 = new JLabel("(*)");
		label_5.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_contentPane
																										.createParallelGroup(
																												Alignment.TRAILING)
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING,
																																false)
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addComponent(
																																				lblFirstName)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				lblRequire))
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addComponent(
																																				lblLastName)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED,
																																				GroupLayout.DEFAULT_SIZE,
																																				Short.MAX_VALUE)
																																		.addComponent(
																																				label,
																																				GroupLayout.PREFERRED_SIZE,
																																				14,
																																				GroupLayout.PREFERRED_SIZE)))
																										.addGroup(
																												gl_contentPane
																														.createSequentialGroup()
																														.addComponent(
																																lblSex)
																														.addPreferredGap(
																																ComponentPlacement.RELATED)
																														.addComponent(
																																label_1,
																																GroupLayout.PREFERRED_SIZE,
																																14,
																																GroupLayout.PREFERRED_SIZE)))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.TRAILING)
																														.addComponent(
																																lblNewLabel)
																														.addComponent(
																																lblLogin)
																														.addComponent(
																																lblAdress)
																														.addComponent(
																																lblBirthDate)
																														.addComponent(
																																lblEmail)
																														.addComponent(
																																lblPassword))
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																label_5,
																																GroupLayout.PREFERRED_SIZE,
																																14,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																label_4,
																																GroupLayout.PREFERRED_SIZE,
																																14,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																label_3,
																																GroupLayout.PREFERRED_SIZE,
																																14,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																label_2,
																																GroupLayout.PREFERRED_SIZE,
																																14,
																																GroupLayout.PREFERRED_SIZE))))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								passTextField,
																								GroupLayout.DEFAULT_SIZE,
																								124,
																								Short.MAX_VALUE)
																						.addComponent(
																								loginTextField,
																								GroupLayout.DEFAULT_SIZE,
																								124,
																								Short.MAX_VALUE)
																						.addComponent(
																								emailTextField,
																								GroupLayout.DEFAULT_SIZE,
																								124,
																								Short.MAX_VALUE)
																						.addComponent(
																								phoneTextField,
																								GroupLayout.DEFAULT_SIZE,
																								124,
																								Short.MAX_VALUE)
																						.addComponent(
																								AdressTextField)
																						.addComponent(
																								birthDateChooser,
																								Alignment.TRAILING,
																								GroupLayout.DEFAULT_SIZE,
																								121,
																								Short.MAX_VALUE)
																						.addComponent(
																								lastNameTextField)
																						.addComponent(
																								firstNameTextField,
																								GroupLayout.DEFAULT_SIZE,
																								121,
																								Short.MAX_VALUE)
																						.addComponent(
																								sexComboBox,
																								Alignment.TRAILING,
																								0,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addGap(17)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lastNameError,
																								GroupLayout.DEFAULT_SIZE,
																								167,
																								Short.MAX_VALUE)
																						.addComponent(
																								firstNameError,
																								GroupLayout.DEFAULT_SIZE,
																								167,
																								Short.MAX_VALUE)
																						.addComponent(
																								sexError,
																								GroupLayout.DEFAULT_SIZE,
																								167,
																								Short.MAX_VALUE)
																						.addComponent(
																								birthDateError,
																								GroupLayout.DEFAULT_SIZE,
																								167,
																								Short.MAX_VALUE)
																						.addComponent(
																								adressError,
																								GroupLayout.DEFAULT_SIZE,
																								167,
																								Short.MAX_VALUE)
																						.addComponent(
																								phoneError,
																								GroupLayout.DEFAULT_SIZE,
																								167,
																								Short.MAX_VALUE)
																						.addComponent(
																								emailError,
																								GroupLayout.DEFAULT_SIZE,
																								167,
																								Short.MAX_VALUE)
																						.addComponent(
																								loginError,
																								GroupLayout.DEFAULT_SIZE,
																								167,
																								Short.MAX_VALUE)
																						.addComponent(
																								passError,
																								GroupLayout.DEFAULT_SIZE,
																								167,
																								Short.MAX_VALUE)))
														.addComponent(
																separator,
																GroupLayout.DEFAULT_SIZE,
																401,
																Short.MAX_VALUE)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(112)
																		.addComponent(
																				btnSave)
																		.addGap(18)
																		.addComponent(
																				btnCancel)))
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblFirstName)
														.addComponent(
																firstNameTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																firstNameError)
														.addComponent(
																lblRequire))
										.addGap(17)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lastNameTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblLastName)
														.addComponent(
																lastNameError)
														.addComponent(label))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																sexComboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(sexError)
														.addComponent(
																lblSex,
																GroupLayout.PREFERRED_SIZE,
																14,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_1))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				lblBirthDate)
																		.addComponent(
																				birthDateError)
																		.addComponent(
																				label_2))
														.addComponent(
																birthDateChooser,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(12)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblAdress)
														.addComponent(
																AdressTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																adressError))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																phoneTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel)
														.addComponent(
																phoneError))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(lblEmail)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								emailTextField,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								emailError)
																						.addComponent(
																								label_3))
																		.addGap(18)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								loginTextField,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblLogin)
																						.addComponent(
																								loginError)
																						.addComponent(
																								label_4))))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblPassword)
														.addComponent(
																passTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(passError)
														.addComponent(label_5))
										.addGap(18)
										.addComponent(separator,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(btnSave)
														.addComponent(btnCancel))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	private boolean isValidDate() {
		if (FieldVerifier.isNotNull((birthDateChooser.getDate()))) {
			birthDateError.setVisible(false);
			return true;
		} else {
			birthDateError.setVisible(true);
			return false;
		}
	}

	private boolean isValidAdress() {
		if (FieldVerifier.isNotNull(AdressTextField.getText())) {
			adressError.setVisible(false);
			return true;
		} else {
			adressError.setVisible(true);
			return false;
		}
	}

	private boolean isValidFisrtName() {
		if (FieldVerifier.VerifOrdinaryField(firstNameTextField.getText(),
				"^([a-zA-Zéè0çôêâ' ]+)")) {
			firstNameError.setVisible(false);
			return true;
		} else {
			firstNameError.setText(FieldVerifier.getErrorMsg());
			firstNameError.setVisible(true);
			return false;
		}
	}

	private boolean isValidLastName() {
		if (FieldVerifier.VerifOrdinaryField(lastNameTextField.getText(),
				"^([a-zA-Zéè0çôêâ' ]+)")) {
			lastNameError.setVisible(false);
			return true;
		} else {
			lastNameError.setText(FieldVerifier.getErrorMsg());
			lastNameError.setVisible(true);
			return false;
		}
	}

	private boolean isValidLogin() {
		if (!modif) {
			if (FieldVerifier.VerifComplexField(loginTextField.getText(), 1)) {
				loginError.setVisible(false);
				return true;
			} else {
				loginError.setText(FieldVerifier.getErrorMsg());
				loginError.setVisible(true);
				return false;
			}
		} else {
			if (FieldVerifier.VerifComplexField(loginTextField.getText(),
					crowd.getLogin(), 1)) {
				loginError.setVisible(false);
				return true;
			} else {
				loginError.setText(FieldVerifier.getErrorMsg());
				loginError.setVisible(true);
				return false;
			}
		}
	}

	private boolean isValidPass() {
		if (FieldVerifier.VerifComplexField(passTextField.getText(), 3)) {
			passError.setVisible(false);
			return true;
		} else {
			passError.setText(FieldVerifier.getErrorMsg());
			passError.setVisible(true);
			return false;
		}
	}

	private boolean isValidMail() {
		/*
		 * if (!modif) { if
		 * (FieldVerifier.VerifOrdinaryField(emailTextField.getText())) { //
		 * mailTextfield.getText().length() // > if (FieldVerifier
		 * .VerifComplexField(emailTextField.getText(), 2)) {
		 * emailError.setVisible(false); return true; } else {
		 * emailError.setText(FieldVerifier.getErrorMsg());
		 * emailError.setVisible(true); return false; } } else {
		 * emailError.setText(FieldVerifier.getErrorMsg());
		 * emailError.setVisible(true); return false; } } else { if
		 * (FieldVerifier.VerifOrdinaryField(emailTextField.getText())) { //
		 * mailTextfield.getText().length() // > if
		 * (FieldVerifier.VerifComplexField(emailTextField.getText(),
		 * crowd.getEmail(), 2)) { emailError.setVisible(false); return true; }
		 * else { emailError.setText(FieldVerifier.getErrorMsg());
		 * emailError.setVisible(true); return false; } } else {
		 * emailError.setText(FieldVerifier.getErrorMsg());
		 * emailError.setVisible(true); return false; } }
		 */
		return true;
	}

	/**
	 * Create the frame.
	 */
	public CrowdForm() {
		setTitle("User Add");
		modif = false;
		initComponent();
	}

	public CrowdForm(Crowd crowd) {
		setTitle("User Modification");
		this.crowd = crowd;
		modif = true;
		initComponent();
		firstNameTextField.setText(crowd.getFirstName());
		lastNameTextField.setText(crowd.getLastName());
		birthDateChooser.setDate(crowd.getBirthDate());
		AdressTextField.setText(crowd.getAdress());
		phoneTextField.setText(crowd.getPhone());
		loginTextField.setText(crowd.getLogin());
		emailTextField.setText(crowd.getEmail());
		passTextField.setText(crowd.getPassword());

	}
}
