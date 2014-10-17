package com.massconnections.Model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import com.massconnections.Delegate.ProjectCategoryCrudDelegate;
import com.massconnections.Domains.ChallengeCategory;
import com.massconnections.Domains.Project;
import com.massconnections.Domains.ProjectCategory;
import com.massconnections.Domains.ProjectDocument;

public class ProjectCategorieListModel extends AbstractListModel {
	List<ProjectCategory> strings = new ArrayList<ProjectCategory>();

	public ProjectCategorieListModel() {
		strings = ProjectCategoryCrudDelegate.getProjectCategories();		
	}

	@Override
	public Object getElementAt(int index) {
		return strings.get(index);
	}

	@Override
	public int getSize() {
		return strings.size();
	}
	
	public ProjectCategory getValueAt(int index) {
		return strings.get(index);
	}

}
