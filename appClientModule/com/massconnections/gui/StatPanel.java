package com.massconnections.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import com.massconnections.Domains.Crowd;
import com.massconnections.Model.StatisticsModel;

public class StatPanel extends JPanel {

	private JComboBox statComboBox;
	private JFreeChart charts;
	private ChartPanel bodyStatPanel;
	private JComboBox typeComboBox;

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame.getInstance(new Crowd()).show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the panel.
	 */
	private void initializeComponents() {
		JLabel lblNewLabel = new JLabel("Statistic By:");

		statComboBox = new JComboBox();
		String[] statOption = { "Stat per donations", "Stat Per Category", "Stat per Project State "};
		statComboBox.setModel(new DefaultComboBoxModel(statOption));
		statComboBox.setSelectedIndex(0);

		JLabel lblTypeOfChart = new JLabel("Type of chart:");

		String[] typeOption = { "Pie Chart", "Bar Chart" };
		typeComboBox = new JComboBox();
		typeComboBox.setModel(new DefaultComboBoxModel(typeOption));
		typeComboBox.setSelectedIndex(0);
		
		
		charts = createPieChart(StatisticsModel.createPieDatasetPerDonation());
		bodyStatPanel = new ChartPanel(charts);
		bodyStatPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		

		typeComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				initState();
				
			}
		});
		
		statComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				initState();
			}
		});

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
							.addComponent(statComboBox, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(lblTypeOfChart)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(statComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTypeOfChart))
					.addGap(18)
					.addComponent(bodyStatPanel, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}

	private JFreeChart createPieChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart3D(
				(String) statComboBox.getSelectedItem(), // chart title
				dataset, // data
				true, // include legend
				true, false);
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;
	}

	private JFreeChart createBarChart(CategoryDataset dataset, String axeX,
			String axeY) {
		JFreeChart chart = ChartFactory.createBarChart(
				(String) statComboBox.getSelectedItem(), axeX, axeY, dataset); // createBarChart3D((String)
																				// statComboBox.getSelectedItem(),
																				// axeX,
																				// axeY,
																				// dataset);
		return chart;
	}

	private void initState(){
		System.out.println(typeComboBox.getSelectedIndex()+" "+statComboBox.getSelectedIndex());
		if (typeComboBox.getSelectedIndex() == 0 && statComboBox.getSelectedIndex() == 0) { //pie //donation
				charts = createPieChart(StatisticsModel.createPieDatasetPerDonation());
			
		} else if (typeComboBox.getSelectedIndex() == 0 && statComboBox.getSelectedIndex() == 1) {   //pie //category
			charts = createPieChart(StatisticsModel.createPieDatasetPerCategory());
		} else if(typeComboBox.getSelectedIndex() == 1 && statComboBox.getSelectedIndex() == 0){ //bar //donation
			charts = createBarChart(StatisticsModel.createBarDatasetPerDonation(),"Categories","");
		} else if(typeComboBox.getSelectedIndex() == 1 && statComboBox.getSelectedIndex() == 1){ //bar //categ
			charts = createBarChart(StatisticsModel.createBarDatasetPerCategory(),"Categories","");
		} else if(typeComboBox.getSelectedIndex() == 0 && statComboBox.getSelectedIndex() == 2){ //pie //state
			charts = createPieChart(StatisticsModel.createPieDatasetPerState());
		} else if(typeComboBox.getSelectedIndex() == 1 && statComboBox.getSelectedIndex() == 2){ //bar //state
			charts = createBarChart(StatisticsModel.createBarDatasetPerState(),"State","");
		} 
		bodyStatPanel.setChart(charts);
	}
	
	/*
	 * private CategoriesPanel createPerCategory(){
	 * 
	 * }
	 */

	public StatPanel() {
		initializeComponents();
	}
}
