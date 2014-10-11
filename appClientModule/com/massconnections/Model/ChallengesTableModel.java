package com.massconnections.Model;

import java.util.ArrayList;
import java.util.List;

import com.massconnections.Delegate.ChallengeCrudDelegate;
import com.massconnections.Domains.Challenge;

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
				return challenge.getCategory();
			else
				return "";
		} else if (columnIndex == 7) {
			if (challenge.getState() == 0)
				return "Wating";
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
	public void initSearch(String text, int selectedIndex) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void removeRows(List elements) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
