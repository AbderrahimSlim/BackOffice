package com.massconnections.Delegate;

import java.util.List;

import com.massconnections.Domains.Project;
import com.massconnections.Services.ProjectCrudEJBRemote;
import com.massconnections.locator.ServiceLocator;

public class ProjectCrudDelegate {
	private static ProjectCrudEJBRemote proj;

	private static ProjectCrudEJBRemote getRemoteEJB() {
		proj = (ProjectCrudEJBRemote) ServiceLocator
				.getInstance()
				.getProxy(
						"/massconnection-ejb/ProjectCrudEJB!com.massconnections.Services.ProjectCrudEJBRemote/");
		return proj;
	}

	public static void approveProject(Project p){
		p.setState(1);
		getRemoteEJB().update(p);
	}
	public static void denieProject(Project p){
		p.setState(-1);
		getRemoteEJB().update(p);
	}
	public static List<Project> getAllProjects(){
		return getRemoteEJB().getProjects();
	}
	
	public static Project getById(int id){
		return getRemoteEJB().getById(id);
	}

}
