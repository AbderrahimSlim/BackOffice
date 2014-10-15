package com.massconnections.Model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import com.massconnections.Domains.Project;
import com.massconnections.Domains.ProjectDocument;

public class ProjectDocumentListModel extends AbstractListModel {
	List<ProjectDocument> strings = new ArrayList<ProjectDocument>();

	public ProjectDocumentListModel(Project p) {
		for(ProjectDocument d : p.getProjectDocuments()){
			strings.add(d);
		}
	}

	@Override
	public Object getElementAt(int index) {
		return strings.get(index);
	}

	@Override
	public int getSize() {
		return strings.size();
	}

}
