package com.massconnections.gui;

import java.awt.Color;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.massconnections.Model.StatisticsModel;

public class StatPanel extends JPanel {
	
	private JComboBox comboBox;
	private JFreeChart charts;
	private ChartPanel bodyStatPanel;
	/**
	 * Create the panel.
	 */
	private void initializeComponents(){
		JLabel lblNewLabel = new JLabel("Statistic By:");
		
		comboBox = new JComboBox();
		String[] option = {"State per donations"};
		comboBox.setModel(new DefaultComboBoxModel(option));
		comboBox.setSelectedIndex(0);
		
		charts = createChart(createDatasetPerDonation());
		
		
		bodyStatPanel = new ChartPanel(charts);
		bodyStatPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(bodyStatPanel, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(bodyStatPanel, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		
		
		
		
	}
	
	private JFreeChart createChart(PieDataset dataset){
		 JFreeChart chart = ChartFactory.createPieChart3D((String) comboBox.getSelectedItem(), dataset);

		        PiePlot3D plot = (PiePlot3D) chart.getPlot();
		        plot.setStartAngle(290);
		        plot.setForegroundAlpha(0.5f);
		        return chart;
	}
	
	private PieDataset createDatasetPerDonation(){
		List result = StatisticsModel.projectDonationDone();
		int done = (Integer) result.get(0);
		int undone = (Integer) result.get(1);
		DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
		defaultPieDataset.setValue("Done",done );
		defaultPieDataset.setValue("Not Yet",undone );
		return defaultPieDataset;
	}
	
	public StatPanel() {
		initializeComponents();
	}
	
	
	
	
}
