package com.massconnections.Model;

import java.util.ArrayList;
import java.util.List;

import com.massconnections.Delegate.CrowdCrudDelegate;
import com.massconnections.Domains.Crowd;

public class CrowdTableModel extends GenericTableModel {

	String[] column = { "First Name", "Last Name", "Birth Date", "Login",
			"Projects", "Challenges", "Email" };

	private List<Crowd> crowdList = new ArrayList<Crowd>();
	private List<Crowd> resultSearchList = new ArrayList<Crowd>();
	private boolean searching = false;

	@Override
	public int getColumnCount() {
		return column.length;
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

	// bloc de methodes personalisées
	public void refresh() {
		resultSearchList = new ArrayList<Crowd>();
		this.crowdList = CrowdCrudDelegate.getCrowds();
	}
	
	public boolean removeRows(List elements) {
        boolean done = true;
        /* List<Crowd> utilisateurs = (List<Crowd>) elements;
        for (int i = 0; i < utilisateurs.size(); i++) {
            if (!utilisateurDao.deleteUser(utilisateurs.get(i).getId())) {
                done = false;
            } else {
                listCrowd.remove(utilisateurs.get(i));
            }
        }*/
        return done;
    }

}
