package com.massconnections.Delegate;

import com.massconnections.Domains.Crowd;
import com.massconnections.Services.CrowdCrudEJBRemote;
import com.massconnections.locator.ServiceLocator;

public class ProjectCrudDelegate {
	private static CrowdCrudEJBRemote proj;

	private static CrowdCrudEJBRemote getRemoteEJB() {
		proj = (CrowdCrudEJBRemote) ServiceLocator
				.getInstance()
				.getProxy(
						"/massconnection-ejb/ProjectCrudEJB!com.massconnections.Services.ProjectCrudEJBRemote");
		return proj;
	}

	

	

}
