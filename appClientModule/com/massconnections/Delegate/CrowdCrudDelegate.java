package com.massconnections.Delegate;

import java.util.List;

import com.massconnections.Domains.Crowd;
import com.massconnections.Services.CrowdCrudEJBRemote;
import com.massconnections.Services.CrowdCrudEJBRemote;
import com.massconnections.locator.ServiceLocator;

public class CrowdCrudDelegate {

	private static CrowdCrudEJBRemote proj;

	private static CrowdCrudEJBRemote getRemoteEJB() {
		proj = (CrowdCrudEJBRemote) ServiceLocator
				.getInstance()
				.getProxy(
						"/massconnection-ejb/CrowdCrudEJB!com.massconnections.Services.CrowdCrudEJBRemote/");
		return proj;
	}

	
	
	public static void addCrowd(Crowd p) {
		getRemoteEJB().addCrowd(p);
	}

	
	public static List<Crowd> getCrowds() {
		return getRemoteEJB().getCrowds();
	}

	
	public Crowd getById(int id) {
		return getRemoteEJB().getById(id);
	}

	
	public static void update(Crowd p) {
		getRemoteEJB().update(p);
	}

	
	public static void delete(Crowd p) {
		getRemoteEJB().delete(p);
	}

	
	public static Crowd findCrowdByLogin(String login) {
		return getRemoteEJB().findCrowdByLogin(login);
	}

	
	public static Crowd findCrowdByMail(String email) {
		return getRemoteEJB().findCrowdByMail(email);
	}

}
