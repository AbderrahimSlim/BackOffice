package com.massconnections.Model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import com.massconnections.Delegate.ChallengeCategoryCrudDelegate;
import com.massconnections.Domains.ChallengeCategory;

public class ChallengeCategorieListModel extends AbstractListModel {
	List<ChallengeCategory> strings = new ArrayList<ChallengeCategory>();

	public ChallengeCategorieListModel() {
		strings = ChallengeCategoryCrudDelegate.getChallengeCategories();

	}

	@Override
	public Object getElementAt(int index) {
		return strings.get(index);
	}

	@Override
	public int getSize() {
		return strings.size();
	}

	public ChallengeCategory getValueAt(int index) {
		return strings.get(index);
	}
}
