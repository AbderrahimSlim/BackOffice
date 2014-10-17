package com.massconnections.Model;

import java.util.ArrayList;
import java.util.List;

import com.massconnections.Delegate.ChallengeCrudDelegate;
import com.massconnections.Delegate.CrowdCrudDelegate;
import com.massconnections.Delegate.MessageDelegate;
import com.massconnections.Domains.Challenge;
import com.massconnections.Domains.Crowd;
import com.massconnections.Domains.Message;
import com.massconnections.Domains.Project;

public class OutBoxMessageTableModel extends GenericTableModel {

	String[] column = { "reciever", "Object", "Content"};

	private List<Message> MessageList = new ArrayList<Message>();
	private List<Message> resultSearchList = new ArrayList<Message>();
	private boolean searching = false;
	private Crowd r;

	public OutBoxMessageTableModel(Crowd r) {
		MessageList = MessageDelegate.getInboxMessages(r);
		this.r=r;
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
			return MessageList.size();
		}
	}

	@Override
	public Object getElementAt(int row) {
		return MessageList.get(row);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Message msg = null;
		if (resultSearchList.size() > 0) {
			msg = resultSearchList.get(rowIndex);
		} else {
			msg = MessageList.get(rowIndex);
		}
		if (columnIndex == 0) {
			return msg.getRecever().getFirstName().concat(" "+msg.getRecever().getLastName());
		} else if (columnIndex == 1) {
			if (msg.getSubject() != null)
				return msg.getSubject();
			else
				return "";
		} else if (columnIndex == 2) {
			if (msg.getContent() != null)
				return msg.getContent();
			else
				return "";
		}
			
		return null;
	}

	@Override
	public void refresh() {
		resultSearchList = new ArrayList<Message>();
		this.MessageList = MessageDelegate.getInboxMessages(r);
	}

	/*@Override
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
	}*/
	

	@Override
	public void removeRows(List elements) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
