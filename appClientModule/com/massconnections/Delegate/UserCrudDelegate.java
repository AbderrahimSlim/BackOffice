package com.massconnections.Delegate;

import com.massconnections.Domains.Crowd;
import com.massconnections.Services.CrowdCrudEJBRemote;
import com.massconnections.locator.ServiceLocator;

public class UserCrudDelegate {
	private static CrowdCrudEJBRemote cart;

	private static CrowdCrudEJBRemote getRemoteEJB() {
		cart = (CrowdCrudEJBRemote) ServiceLocator
				.getInstance()
				.getProxy(
						"/massconnection-ejb/UserCrudEJB!com.massconnections.Services.UserCrudEJBRemote");
		return cart;
	}

	public static void addCrowd(Crowd crowd) {
		getRemoteEJB().addCrowd(crowd);
	}

	public static Crowd getCrowd(int id) {
		return getRemoteEJB().getById(id);
	}

	public static void main(String[] args) {

		Crowd c = new Crowd();
		c.setLastName("aaa");
		

	}

}
