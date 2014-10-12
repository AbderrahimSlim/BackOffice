package com.massconnections.Model;

import java.util.ArrayList;
import java.util.List;

import com.massconnections.Delegate.ChallengeCrudDelegate;
import com.massconnections.Domains.Challenge;
import com.massconnections.Domains.Project;

public class ChallengesTableModel extends GenericTableModel {

	String[] column = { "Id", "Title", "Creator", "Description","Category","State" };

	private List<Challenge> ChallengeList = new ArrayList<Challenge>();
	private List<Challenge> resultSearchList = new ArrayList<Challenge>();
	private boolean searching = false;

	public ChallengesTableModel() {
		ChallengeList = ChallengeCrudDelegate.getChallenges();
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
			return ChallengeList.size();
		}
	}

	@Override
	public Object getElementAt(int row) {
		return ChallengeList.get(row);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Challenge challenge = null;
		if (resultSearchList.size() > 0) {
			challenge = resultSearchList.get(rowIndex);
		} else {
			challenge = ChallengeList.get(rowIndex);
		}
		if (columnIndex == 0) {
			return challenge.getId();
		} else if (columnIndex == 1) {
			if (challenge.getTitle() != null)
				return challenge.getTitle();
			else
				return "";
		} else if (columnIndex == 2) {
			if (challenge.getUser() != null)
				return challenge.getUser().getFirstName() + " "
						+ challenge.getUser().getLastName();
			else
				return "";
		} else if (columnIndex == 3) {
			if (challenge.getDescription() != null)
				return challenge.getDescription();
			else
				return "";
		} else if (columnIndex == 4) {
			if (challenge.getCategory() != null)
				return challenge.getCategory().getName();
			else
				return "";
		} else if (columnIndex == 5) {
			if (challenge.getState() == 0)
				return "Pending";
			else if (challenge.getState() == 1)
				return "Approved";
			else
				return "Denied";
		}
			
		return null;
	}

	@Override
	public void refresh() {
		resultSearchList = new ArrayList<Challenge>();
		this.ChallengeList = ChallengeCrudDelegate.getChallenges();
	}

	@Override
	public void initSearch(String searchString, int searchIndex) {
		
					resultSearchList = new ArrayList<Challenge>();
		if (searchString.length() > 0) {
			searching = true;
			for (Challenge challenge : ChallengeList) {
				if (searchIndex == 0) {
					if ("" + challenge.getId() != null) {
						if (("" + challenge.getId()).toUpperCase().matches(
								"(.*)" + searchString.toUpperCase() + "(.*)")) {
							resultSearchList.add(challenge);
						}
					}
				} else if (searchIndex == 2) {
					if (challenge.getUser().getFirstName() != null) {
						if (challenge
								.getUser()
								.getFirstName()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(challenge);
						}
					}
				} else if (searchIndex == 1) {
					if (challenge.getTitle() != null) {
						if (challenge
								.getTitle()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(challenge);
						}
					}
				} else if (searchIndex == 3) {
					if (challenge.getDescription() != null) {
						if (challenge
								.getDescription()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(challenge);
						}
					}

				}
				 else if (searchIndex == 4) {

if (challenge.getCategory().getName() != null) {
						if (challenge.getCategory().getName()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(challenge);
						}
					}
				} else if (searchIndex == 5) {
					String x[] = {"DENIED", "PENDING", "APPROVED"};
					if (x[challenge.getState() + 1].toUpperCase().matches(
							"(.*)" + searchString.toUpperCase() + "(.*)")){
						resultSearchList.add(challenge);
					}
				}
			}
		} else {
			searching = false;
		}
	}
	

	@Override
	public void removeRows(List elements) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
