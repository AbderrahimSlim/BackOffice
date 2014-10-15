package com.massconnections.util;

import com.massconnections.Delegate.CrowdCrudDelegate;

public class FieldVerifier {
	public static boolean VerifOrdinaryField(String champ, String regex) {
		if (champ.length() == 0) {
			errorMsg = "This field is required";
			return false;
		}
		if (champ.length() > 45) {
			errorMsg = "this field is too long";
			return false;
		}
		if (!champ.matches(regex)) {
			errorMsg = "this field contains special caractaires";
			return false;
		}
		return true;
	}

	public static boolean isNotNull(Object obj) {
		if (obj == null) {
			errorMsg = "This field is required";
			return false;
		}
		return true;
	}

	public static boolean VerifOrdinaryField(String champ) {
		if (champ.length() == 0) {
			errorMsg = "This field is required";
			return false;
		}
		if (champ.length() > 45) {
			errorMsg = "This field is required";
			return false;
		}
		return true;
	}

	public static boolean VerifComplexField(String champ, String currentValue,
			int type) {
		if (VerifOrdinaryField(champ)) {
			if (type == 1) { // type login
				if (existeLogin(champ, currentValue)) {
					errorMsg = "This username is already used";
					return false;
				}
				return true;
			} else if (type == 2) {// type mail
				if (!champ
						.matches("^[a-zA-Z0-9\\.\\-\\_]+@([a-zA-Z0-9\\-\\_\\.]+\\.)+([a-zA-Z]{2,4})$")) {
					errorMsg = "Invalid Mail";
					return false;
				}
				if (existeMail(champ, currentValue)) {
					errorMsg = "This mail is already used";
					return false;
				}
				return true;
			} else if (type == 3) {// confirmation mot de passe
				if (!validePassword(champ, currentValue)) {
					errorMsg = "invalid Password";
					return false;
				}
			} else {
				System.err.println("Invalid Type");
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	public static boolean VerifComplexField(String champ, int type) {
		if (VerifOrdinaryField(champ)) {
			if (type == 1) { // type login
				if (existeLogin(champ)) {
					errorMsg = "This username is already used";
					return false;
				}
				return true;
			} else if (type == 2) {// type mail
				if (!champ
						.matches("^[a-zA-Z0-9\\.\\-\\_]+@([a-zA-Z0-9\\-\\_\\.]+\\.)+([a-zA-Z]{2,4})$")) {
					errorMsg = "Invalid Mail";
					return false;
				}
				if (existeMail(champ)) {
					errorMsg = "This Mail is already used";
					return false;
				}
			} else if (type == 3) {// confirmation mot de passe
				if (champ.length() < 3) {
					errorMsg = "Invalid Password";
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	private static boolean validePassword(String pass, String confirmPass) {
		return pass.equals(confirmPass);
	}

	private static boolean existeMail(String mail, String currentMail) {
		if (!mail.equals(currentMail)) {
			if (CrowdCrudDelegate.findCrowdByMail(mail) != null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private static boolean existeLogin(String login, String currentLogin) {
		if (!currentLogin.equals(login)) {
			if (CrowdCrudDelegate.findCrowdByLogin(login) != null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private static boolean existeMail(String mail) {
		if (CrowdCrudDelegate.findCrowdByMail(mail) != null) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean existeLogin(String login) {
		if (CrowdCrudDelegate.findCrowdByLogin(login) != null) {
			return true;
		} else {
			return false;
		}
	}

	public static String errorMsg = "";

	public static String getErrorMsg() {
		return errorMsg;
	}
}
