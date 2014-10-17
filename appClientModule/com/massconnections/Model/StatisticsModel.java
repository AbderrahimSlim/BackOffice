package com.massconnections.Model;

import java.util.ArrayList;
import java.util.List;

import com.massconnections.Delegate.ProjectCrudDelegate;
import com.massconnections.Domains.Donation;
import com.massconnections.Domains.Project;

public class StatisticsModel {
	
	
	public static List projectDonationDone(){
		int undone = 0;
		int done = 0;
		List result = new ArrayList();
		
		List<Project> projects = ProjectCrudDelegate.getAllProjects();
		for(Project project : projects){
			float ammountTotal = 0f;
			for(Donation donation : project.getDonations()){
				ammountTotal+=donation.getAmount();
			}
			if(ammountTotal >= project.getAmount()){
				done++;
			}else{
				undone++;
			}
		}
		result.add(done);
		result.add(undone);
		return result;
		
	}
	

}
