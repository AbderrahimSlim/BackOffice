package com.massconnections.util;

import com.massconnections.Delegate.CrowdCrudDelegate;

public class FieldVerifier {
	public static boolean VerifOrdinaryField(String champ, String regex) {
		if (champ.length() == 0) {
			errorMsg = "Le champ est obligatroire";
			return false;
		}
		if (champ.length() > 45) {
			errorMsg = "Le champ est trop long";
			return false;
		}
		if (!champ.matches(regex)) {
			errorMsg = "Le champ contient des carractères spéciaux";
			return false;
		}
		return true;
	}

	public static boolean isNotNull(Object obj) {
		if (obj == null) {
			errorMsg = "Le champ est obligatoire";
			return false;
		}
		return true;
	}

	public static boolean VerifOrdinaryField(String champ) {
		if (champ.length() == 0) {
			errorMsg = "Le champ est obligatoire";
			return false;
		}
		if (champ.length() > 45) {
			errorMsg = "Le champ est trop long";
			return false;
		}
		return true;
	}

	public static boolean VerifComplexField(String champ, String currentValue,
			int type) {
		if (VerifOrdinaryField(champ)) {
			if (type == 1) { // type login
				if (existeLogin(champ, currentValue)) {
					errorMsg = "Ce Pseudo est déjà utilisé";
					return false;
				}
				return true;
			} else if (type == 2) {// type mail
				if (!champ
						.matches("^[a-zA-Z0-9\\.\\-\\_]+@([a-zA-Z0-9\\-\\_\\.]+\\.)+([a-zA-Z]{2,4})$")) {
					errorMsg = "Ce Mail est invalide";
					return false;
				}
				if (existeMail(champ, currentValue)) {
					errorMsg = "Ce Mail est déjà utilisé";
					return false;
				}
				return true;
			} else if (type == 3) {// confirmation mot de passe
				if (!validePassword(champ, currentValue)) {
					errorMsg = "Le mot de passe ne corréspond pas";
					return false;
				}
			} else {
				System.err.println("type non valide");
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
					errorMsg = "Ce Pseudo est déjà utilisé";
					return false;
				}
				return true;
			} else if (type == 2) {// type mail
				if (!champ
						.matches("^[a-zA-Z0-9\\.\\-\\_]+@([a-zA-Z0-9\\-\\_\\.]+\\.)+([a-zA-Z]{2,4})$")) {
					errorMsg = "Ce Mail est invalide";
					return false;
				}
				if (existeMail(champ)) {
					errorMsg = "Ce Mail est déjà utilisé";
					return false;
				}
			} else if (type == 3) {// confirmation mot de passe
				if (champ.length() < 3) {
					errorMsg = "Le mot de passe est trop court";
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
