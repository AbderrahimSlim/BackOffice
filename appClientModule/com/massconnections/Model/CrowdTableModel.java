package com.massconnections.Model;

import java.util.ArrayList;
import java.util.List;

import com.massconnections.Delegate.CrowdCrudDelegate;
import com.massconnections.Domains.Crowd;

public class CrowdTableModel extends GenericTableModel {

	String[] column = { "First Name", "Last Name", "Age", "sex", "Login",
			"Email", "Projects", "Challenges" };

	private List<Crowd> crowdList = new ArrayList<Crowd>();
	private List<Crowd> resultSearchList = new ArrayList<Crowd>();
	private boolean searching = false;

	public CrowdTableModel() {
		//crowdList.add(CrowdCrudDelegate.getCrowd(1));
		crowdList = CrowdCrudDelegate.getCrowds();
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
			return crowdList.size();
		}
	}

	@Override
	public Object getElementAt(int row) {
		return crowdList.get(row);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Crowd crowd = null;
		if (resultSearchList.size() > 0) {
			crowd = resultSearchList.get(rowIndex);
		} else {
			crowd = crowdList.get(rowIndex);
		}
		if (columnIndex == 0) {
			return crowd.getFirstName();
		} else if (columnIndex == 1) {
			return crowd.getLastName();
		} else if (columnIndex == 2) {
			if (crowd.getBirthDate() != null)
				return crowd.getAge();
			else
				return null;
		} else if (columnIndex == 3) {
			return crowd.getSex();
		} else if (columnIndex == 4) {
			return crowd.getLogin();
		} else if (columnIndex == 5) {
			return crowd.getEmail();
		} else if (columnIndex == 6) {
			if (crowd.getProjects() != null)
				return crowd.getProjects().size();
			else
				return null;
		} else if (columnIndex == 7) {
			if (crowd.getChallenges() != null)
				return crowd.getChallenges().size();
			else
				return null;
		}
		return null;
	}

	// bloc de methodes personalisées
	@Override
	public void refresh() {
		resultSearchList = new ArrayList<Crowd>();
		this.crowdList = CrowdCrudDelegate.getCrowds();
	}

	@Override
	public void removeRows(List elements) {
		List<Crowd> crowds = (List<Crowd>) elements;
		for (int i = 0; i < crowds.size(); i++) {
			CrowdCrudDelegate.delete(crowds.get(i));
			crowdList.remove(crowds.get(i));
		}
	}

	@Override
	public void initSearch(String searchString, int searchIndex) {
		resultSearchList = new ArrayList<Crowd>();
		if (searchString.length() > 0) {
			searching = true;
			for (Crowd crowd : crowdList) {
				if (searchIndex == 0) {
					if (crowd.getFirstName() != null) {
						if (crowd
								.getFirstName()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(crowd);
						}
					}
				} else if (searchIndex == 1) {
					if (crowd.getLastName() != null) {
						if (crowd
								.getLastName()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(crowd);
						}
					}
				} else if (searchIndex == 2) {
					if (crowd.getBirthDate() != null) {
						if ((crowd.getAge() + "").matches("(.*)" + searchString
								+ "(.*)")) {
							resultSearchList.add(crowd);
						}
					}
				} else if (searchIndex == 3) {
					if (crowd.getSex() + "" != null) {
						if (crowd
								.getLogin()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(crowd);
						}
					}
				} else if (searchIndex == 4) {
					if (crowd.getLogin() != null) {
						if (crowd
								.getLogin()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(crowd);
						}
					}
				} else if (searchIndex == 5) {
					if (crowd.getEmail() != null) {
						if (crowd
								.getEmail()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(crowd);
						}
					}
				} else if (searchIndex == 6) {
					if (crowd.getProjects() != null) {
						if (crowd.getProjects().size() == Integer
								.parseInt(searchString)) {
							resultSearchList.add(crowd);
						}
					}
				} else if (searchIndex == 7) {
					if (crowd.getChallenges() != null) {
						if (crowd.getChallenges().size() == Integer
								.parseInt(searchString)) {
							resultSearchList.add(crowd);
						}
					}
				}
			}
		} else {
			searching = false;
		}
	}

}
