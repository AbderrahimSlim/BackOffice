package com.massconnections.Delegate;

import java.util.List;

import com.massconnections.Domains.Crowd;
import com.massconnections.Services.CrowdCrudEJBRemote;
import com.massconnections.locator.ServiceLocator;

public class CrowdCrudDelegate {
	private static CrowdCrudEJBRemote cart;

	private static CrowdCrudEJBRemote getRemoteEJB() {
		cart = (CrowdCrudEJBRemote) ServiceLocator
				.getInstance()
				.getProxy(
						"/massconnection-ejb/CrowdCrudEJB!com.massconnections.Services.CrowdCrudEJBRemote/");
		return cart;
	}

	public static void addCrowd(Crowd crowd) {
		getRemoteEJB().addCrowd(crowd);
	}

	public static Crowd getCrowd(int id) {
		return getRemoteEJB().getById(id);
	}

	public static List<Crowd> getCrowds() {
		return getRemoteEJB().getCrowds();
	}

	public static void delete(Crowd c) {
		getRemoteEJB().delete(c);
	}

}
