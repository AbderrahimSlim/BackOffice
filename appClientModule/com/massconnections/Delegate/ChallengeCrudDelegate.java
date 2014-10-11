package com.massconnections.Delegate;

import java.util.List;

import com.massconnections.Domains.Challenge;
import com.massconnections.Services.ChallengeCrudEJBRemote;
import com.massconnections.locator.ServiceLocator;

public class ChallengeCrudDelegate {
	

	private static ChallengeCrudEJBRemote chal;

	private static ChallengeCrudEJBRemote getRemoteEJB() {
		chal = (ChallengeCrudEJBRemote) ServiceLocator
				.getInstance()
				.getProxy(
						"/massconnection-ejb/ChallengeCrudEJB!com.massconnections.Services.ChallengeCrudEJBRemote/");
		return  chal;
	}

	public static void addchallenge(Challenge challenge) {
		getRemoteEJB().addChallenge(challenge);
	}

	public static Challenge getChallenge(int id) {
		return getRemoteEJB().getById(id);
	}

	public static List<Challenge> getChallenges() {
		return getRemoteEJB().getChallenges();
	}

	public static void delete(Challenge challenge) {
		getRemoteEJB().delete(challenge);
	}


}
