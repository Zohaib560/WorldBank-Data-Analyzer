package UIPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;

import AnalysisPackage.resultData;

public class PieChart implements ChartCreator{

	public void create(JPanel west, resultData data) {
		// TODO Auto-generated method stub
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i = data.getStartYear(); i<=data.getEndYear();i++) {
			dataset.addValue(Double.parseDouble(data.getData().get(0).get((i+""))),
					data.getMethods().get(0), i+"");
			dataset.addValue(Double.parseDouble(data.getData().get(1).get((i+""))),
					data.getMethods().get(1), i+"");

		}
		JFreeChart pieChart = ChartFactory.createMultiplePieChart(data.getMethodsString(), dataset,
				TableOrder.BY_COLUMN, true, true, false);

		ChartPanel chartPanel = new ChartPanel(pieChart);
		chartPanel.setPreferredSize(new Dimension(450, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		
		if(data.getMethodsString().equals("Current health expenditure (% of GDP) vs Others")) {
			west.add(chartPanel);
		}else if (data.getMethodsString().equals("Government expenditure on education, total (% of GDP) vs Others")){
			west.add(chartPanel);
		}
		else {
			
		}
	}
	
}
