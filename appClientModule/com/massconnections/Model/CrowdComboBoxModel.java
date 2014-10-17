package com.massconnections.Model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import com.massconnections.Delegate.CrowdCrudDelegate;
import com.massconnections.Domains.Crowd;

public class CrowdComboBoxModel implements ComboBoxModel<Crowd> {
	List<Crowd> crowdList = new ArrayList<Crowd>();
	Crowd selection = new Crowd();

	public CrowdComboBoxModel() {
		crowdList = CrowdCrudDelegate.getCrowds();
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Crowd getElementAt(int index) {
		// TODO Auto-generated method stub
		return crowdList.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return crowdList.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return selection;
	}

	@Override
	public void setSelectedItem(Object arg0) {
		selection = (Crowd) arg0;
	}

}
