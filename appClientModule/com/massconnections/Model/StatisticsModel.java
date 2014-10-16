package com.massconnections.Model;

import java.util.List;

import com.massconnections.Delegate.ProjectCrudDelegate;
import com.massconnections.Domains.Donation;
import com.massconnections.Domains.Project;

public class StatisticsModel {
	
	
	public static void projectDonationDone(){
		List<Project> projects = ProjectCrudDelegate.getAllProjects();
		for(Project project : projects){
			System.out.println(project.getDonations().size());
			for(Donation donation : project.getDonations()){
				System.out.println(project.getTitle()+" "+donation.getAmount());
			}
		}
	}
	

}
