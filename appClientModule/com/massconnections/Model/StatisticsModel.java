package com.massconnections.Model;

import java.util.ArrayList;
import java.util.List;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.massconnections.Delegate.ProjectCategoryCrudDelegate;
import com.massconnections.Delegate.ProjectCrudDelegate;
import com.massconnections.Domains.Donation;
import com.massconnections.Domains.Project;
import com.massconnections.Domains.ProjectCategory;

public class StatisticsModel {

	private static List projectDonationDone() {
		int undone = 0;
		int done = 0;
		List result = new ArrayList();

		List<Project> projects = ProjectCrudDelegate.getAllProjects();
		for (Project project : projects) {
			float ammountTotal = 0f;
			for (Donation donation : project.getDonations()) {
				ammountTotal += donation.getAmount();
			}
			if (ammountTotal >= project.getAmount()) {
				done++;
			} else {
				undone++;
			}
		}
		result.add(done);
		result.add(undone);
		return result;

	}
	
	private static List projectState() {
		int aprouved = 0;
		int denied = 0;
		int pending = 0;
		
		List result = new ArrayList();

		List<Project> projects = ProjectCrudDelegate.getAllProjects();
		for (Project project : projects) {
			if(project.getState() == -1)
				denied++;
			else if(project.getState() == 0)
				pending++;
			else
				aprouved++;
		}
		result.add(aprouved);
		result.add(denied);
		result.add(pending);
		
		return result;

	}
	
	
	

	public static PieDataset createPieDatasetPerCategory() {

		DefaultPieDataset defaultPieDataset = new DefaultPieDataset();


		List<ProjectCategory> projectCategories = ProjectCategoryCrudDelegate
				.getProjectCategories();

		for (ProjectCategory projectCategory : projectCategories) {
			defaultPieDataset.setValue(projectCategory.getName(), projectCategory.getProjects().size());
		}
		
		return defaultPieDataset;

	}
	
	
	
	public static DefaultCategoryDataset createBarDatasetPerCategory() {

		DefaultCategoryDataset DefaultCategoryDataset = new DefaultCategoryDataset();


		List<ProjectCategory> projectCategories = ProjectCategoryCrudDelegate
				.getProjectCategories();

		for (ProjectCategory projectCategory : projectCategories) {
			DefaultCategoryDataset.setValue(projectCategory.getProjects().size(),projectCategory.getName(), "");
		}
		
		return DefaultCategoryDataset;
	}
	
	
	

	public static PieDataset createPieDatasetPerDonation() {
		List result = projectDonationDone();
		int done = (Integer) result.get(0);
		int undone = (Integer) result.get(1);
		DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
		defaultPieDataset.setValue("Done", done);
		defaultPieDataset.setValue("Not Yet", undone);
		return defaultPieDataset;
	}
	

	public static DefaultCategoryDataset createBarDatasetPerDonation() {
		List result = projectDonationDone();
		int done = (Integer) result.get(0);
		int undone = (Integer) result.get(1);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(done, "Done", "");
		dataset.setValue(undone, "Not Yet", "");
		return dataset;
	}
	
	public static PieDataset createPieDatasetPerState() {
		List result = projectState();
		int aprouved = (Integer) result.get(0);
		int denied = (Integer) result.get(1);
		int pending = (Integer) result.get(2);
		DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
		defaultPieDataset.setValue("Approuved", aprouved);
		defaultPieDataset.setValue("Denied", denied);
		defaultPieDataset.setValue("Pending", pending);
		
		return defaultPieDataset;
	}
	

	public static DefaultCategoryDataset createBarDatasetPerState() {
		List result = projectState();
		int aprouved = (Integer) result.get(0);
		int denied = (Integer) result.get(1);
		int pending = (Integer) result.get(2);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.setValue(aprouved, "Approuved", "");
		dataset.setValue(denied, "Denied", "");
		dataset.setValue(pending, "Pending", "");
		return dataset;
	}
	
	

}
