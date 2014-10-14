package com.massconnections.Delegate;

import java.util.List;

import com.massconnections.Domains.Crowd;
import com.massconnections.Services.CrowdCrudEJBRemote;
import com.massconnections.Services.CrowdCrudEJBRemote;
import com.massconnections.locator.ServiceLocator;

public class CrowdCrudDelegate {

	private static CrowdCrudEJBRemote crowdEjb;

	private static CrowdCrudEJBRemote getRemoteEJB() {
		crowdEjb = (CrowdCrudEJBRemote) ServiceLocator
				.getInstance()
				.getProxy(
						"/massconnection-ejb/CrowdCrudEJB!com.massconnections.Services.CrowdCrudEJBRemote/");
		return crowdEjb;
	}

	
	
	public static void addCrowd(Crowd p) {
		System.out.println("add");
		getRemoteEJB().addCrowd(p);
	}

	
	public static List<Crowd> getCrowds() {
		return getRemoteEJB().getCrowds();
	}

	
	public static Crowd getById(int id) {
		return getRemoteEJB().getById(id);
	}

	
	public static void update(Crowd p) {
		System.out.println("update");
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
