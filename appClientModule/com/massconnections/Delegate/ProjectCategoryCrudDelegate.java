package com.massconnections.Delegate;

import java.util.List;

import com.massconnections.Domains.ProjectCategory;
import com.massconnections.Services.ProjectCategoryCrudEJBRemote;
import com.massconnections.locator.ServiceLocator;

public class ProjectCategoryCrudDelegate {

	private static ProjectCategoryCrudEJBRemote pCat;

	private static ProjectCategoryCrudEJBRemote getRemoteEJB() {
		pCat = (ProjectCategoryCrudEJBRemote) ServiceLocator
				.getInstance()
				.getProxy(
						"/massconnection-ejb/ProjectCategoryCrudEJB!com.massconnections.Services.ProjectCategoryCrudEJBRemote/");
		return pCat;
	}

	public static void addProjectCategory(ProjectCategory pCat) {
		getRemoteEJB().addProjectCategory(pCat);
	}

	public static ProjectCategory getProjectCategoryById(int id) {
		return getRemoteEJB().getById(id);
	}

	public static List<ProjectCategory> getProjectCategories() {
		return getRemoteEJB().getProjectCategorys();
	}

	public static void delete(ProjectCategory pCat) {
		getRemoteEJB().delete(pCat);
	}

	public static void edit(ProjectCategory pCat) {
		getRemoteEJB().update(pCat);
	}

}
