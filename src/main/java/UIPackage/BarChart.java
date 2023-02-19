package UIPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import AnalysisPackage.resultData;

public class BarChart implements ChartCreator{


	public void create(JPanel west, resultData data) {
		CategoryPlot plot = new CategoryPlot();
//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		BarRenderer barrenderer = new BarRenderer();


		for(int i = 0; i<data.getMethods().size();i++) {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			BarRenderer barrenderer = new BarRenderer();
			barrenderer.setMaximumBarWidth(0.03+0.04*(i));
			

			
			for(int j = data.getStartYear();j<=data.getEndYear();j++) {
				dataset.setValue(Double.parseDouble(data.getData().get(i).get(j+""))
								,data.getMethods().get(i),(j+""));
			}

			plot.setDataset(i, dataset);
			plot.setRenderer(i, barrenderer);
			

		}
		

//		plot.setDataset(0, dataset);
//		plot.setRenderer(0, barrenderer);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));
//		plot.setRangeAxis(1,new NumberAxis("beds"));




		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
//		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis
		JFreeChart barChart = new JFreeChart(data.getMethodsString(),
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		// Different way to create bar chart
		/*
		 * dataset = new DefaultCategoryDataset();
		 * 
		 * dataset.addValue(3.946, "Unemployed", "Men"); dataset.addValue(96.054,
		 * "Employed", "Men"); dataset.addValue(3.837, "Unemployed", "Women");
		 * dataset.addValue(96.163, "Employed", "Women"); barChart =
		 * ChartFactory.createBarChart("Unemployment: Men vs Women", "Gender",
		 * "Percentage", dataset, PlotOrientation.VERTICAL, true, true, false);
		 */

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(450, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		if(data.getMethodsString().equals("Current health expenditure (% of GDP) vs Others")) {
		
		}else {
			west.add(chartPanel);
		}
		
	}
	
}
