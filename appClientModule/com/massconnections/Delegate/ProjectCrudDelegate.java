package com.massconnections.Delegate;

import com.massconnections.Services.ProjectCrudEJBRemote;
import com.massconnections.locator.ServiceLocator;

public class ProjectCrudDelegate {
	private static ProjectCrudEJBRemote proj;

	private static ProjectCrudEJBRemote getRemoteEJB() {
		proj = (ProjectCrudEJBRemote) ServiceLocator
				.getInstance()
				.getProxy(
						"/massconnection-ejb/ProjectCrudEJB!com.massconnections.Services.ProjectCrudEJBRemote");
		return proj;
	}

	

	

}
