package com.massconnections.Delegate;

import java.util.List;

import com.massconnections.Domains.ChallengeCategory;
import com.massconnections.Domains.ProjectCategory;
import com.massconnections.Services.ChallengeCategoryCrudEJBRemote;
import com.massconnections.locator.ServiceLocator;

public class ChallengeCategoryCrudDelegate {

	private static ChallengeCategoryCrudEJBRemote cCat;

	private static ChallengeCategoryCrudEJBRemote getRemoteEJB() {
		cCat = (ChallengeCategoryCrudEJBRemote) ServiceLocator
				.getInstance()
				.getProxy(
						"/massconnection-ejb/ChallengeCategoryCrudEJB!com.massconnections.Services.ChallengeCategoryCrudEJBRemote/");
		return cCat;
	}

	public static void addProjectCategory(ChallengeCategory cCat) {
		getRemoteEJB().addChallengeCategory(cCat);
	}

	public static ChallengeCategory getChallengeCategoryById(int id) {
		return getRemoteEJB().getById(id);
	}

	public static List<ChallengeCategory> getChallengeCategories() {
		return getRemoteEJB().getChallengeCategorys();
	}

	public static void delete(ChallengeCategory cCat) {
		getRemoteEJB().delete(cCat);
	}

	public static void edit(ChallengeCategory pCat) {
		getRemoteEJB().update(pCat);
	}

}
