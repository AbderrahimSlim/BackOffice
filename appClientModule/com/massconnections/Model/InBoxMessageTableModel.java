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

public class InBoxMessageTableModel extends GenericTableModel {

	String[] column = { "Sender", "Object", "Content"};

	private List<Message> MessageList = new ArrayList<Message>();
	private List<Message> resultSearchList = new ArrayList<Message>();
	private boolean searching = false;
	private Crowd r;

	public InBoxMessageTableModel(Crowd r) {
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
			return msg.getSender().getFirstName().concat(" "+msg.getSender().getLastName());
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

	@Override
	public void initSearch(String searchString, int searchIndex) {

		resultSearchList = new ArrayList<Message>();
		if (searchString.length() > 0) {
			searching = true;
			for (Message msg : MessageList) {
				if (searchIndex == 0) {
					if (msg.getSender() != null) {
						if ((msg.getSender().getFirstName() + " " + msg
								.getSender().getLastName()).toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(msg);
						}
					}
				} else if (searchIndex == 1) {
					if (msg.getSubject() != null) {
						if (msg.getSubject()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(msg);
						}
					}
				} else if (searchIndex == 2) {
					if (msg.getContent() != null) {
						if (msg.getContent()
								.toUpperCase()
								.matches(
										"(.*)" + searchString.toUpperCase()
												+ "(.*)")) {
							resultSearchList.add(msg);
						}
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
