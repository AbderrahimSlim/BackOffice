package com.massconnections.Model;

import java.util.ArrayList;
import java.util.List;

import com.massconnections.Delegate.ProjectCrudDelegate;
import com.massconnections.Domains.Project;

public class ProjectsTableModel extends GenericTableModel {
	String[] column = { "Id", "Title", "Creator", "Description",
			"Creation Date", "Deadline", "Amount", "State", "Category" };

	private List<Project> projectList = new ArrayList<Project>();
	private List<Project> resultSearchList = new ArrayList<Project>();
	private boolean searching = false;

	public ProjectsTableModel() {
		projectList = ProjectCrudDelegate.getAllProjects();
	}

	@Override
	public int getColumnCount() {
		return column.length;
	}

	@Override
	public String getColumnName(int col) {
		return this.column[col];
	}

	@Override
	public int getRowCount() {
		if (searching && resultSearchList.size() > 0) {
			return resultSearchList.size();
		} else if (searching && resultSearchList.size() == 0) {
			return 0;
		} else {
			return projectList.size();
		}
	}

	@Override
	public Project getElementAt(int row) {
		return projectList.get(row);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Project project = null;
		if (resultSearchList.size() > 0) {
			project = resultSearchList.get(rowIndex);
		} else {
			project = projectList.get(rowIndex);
		}
		if (columnIndex == 0) {
			return project.getId();
		} else if (columnIndex == 1) {
			if (project.getTitle() != null)
				return project.getTitle();
			else
				return "";
		} else if (columnIndex == 2) {
			if (project.getUser() != null)
				return project.getUser().getFirstName() + " "
						+ project.getUser().getLastName();
			else
				return "";
		} else if (columnIndex == 3) {
			if (project.getDescription() != null)
				return project.getDescription();
			else
				return "";
		} else if (columnIndex == 4) {
			if (project.getCreationDate() != null)
				return project.getCreationDate().toString();
			else
				return "";
		} else if (columnIndex == 5) {
			if (project.getDeadLine() != null)
				return project.getDeadLine().toString();
			else
				return "";
		} else if (columnIndex == 6) {

			return project.getAmount();
		} else if (columnIndex == 7) {
			if (project.getState() == 0)
				return "Pending";
			else if (project.getState() == 1)
				return "Approved";
			else
				return "Denied";
		} else if (columnIndex == 8)
			if (project.getCategory() != null)
				return project.getCategory().getName();
			else
				return "";
		return null;
	}

	@Override
	public void refresh() {
		resultSearchList = new ArrayList<Project>();
		this.projectList = ProjectCrudDelegate.getAllProjects();
	}

	@Override
	public void removeRows(List elements) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void initSearch(String searchString, int searchIndex) {
		resultSearchList = new ArrayList<Project>();
		if (searchString.length() > 0) {
			searching = true;
			for (Project project : projectList) {
				if (searchIndex == 0) {
					if ("" + project.getId() != null) {
						if (("" + project.getId()).toUpperCase().matches(
								"(.*)" + searchString.toUpperCase() + "(.*)")) {
							resultSearchList.add(project);
						}
					}
				} else if (searchIndex == 2) {
					if (project.getUser().getFirstName() != null) {
						if (project
								.getUser()
								.getFirstName()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(project);
						}
					}
				} else if (searchIndex == 1) {
					if (project.getTitle() != null) {
						if (project
								.getTitle()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(project);
						}
					}
				} else if (searchIndex == 3) {
					if (project.getDescription() != null) {
						if (project
								.getDescription()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(project);
						}
					}

				}/*
				 * else if (searchIndex == 4) { if (project.getLogin() != null)
				 * { if (project .getLogin() .toUpperCase() .matches( "(.*)" +
				 * searchString.toUpperCase() + "(.*)")) {
				 * resultSearchList.add(project); } } } else if (searchIndex ==
				 * 5) { if (project.getEmail() != null) { if (project
				 * .getEmail() .toUpperCase() .matches( "(.*)" +
				 * searchString.toUpperCase() + "(.*)")) {
				 * resultSearchList.add(project); } } }
				 */else if (searchIndex == 6) {
					if (project.getAmount() + "" != null) {
						if ((project.getAmount() + "").toUpperCase().matches(
								"(.*)" + searchString.toUpperCase() + "(.*)")) {
							resultSearchList.add(project);
						}
					}
				} else if (searchIndex == 7) {
					String x[] = {"DENIED", "PENDING", "APPROVED"};
					if (x[project.getState() + 1].toUpperCase().matches(
							"(.*)" + searchString.toUpperCase() + "(.*)")){
						resultSearchList.add(project);
					}
				}
			}
		} else {
			searching = false;
		}
	}

}
