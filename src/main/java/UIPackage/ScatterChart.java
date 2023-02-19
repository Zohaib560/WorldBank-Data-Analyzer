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
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import AnalysisPackage.resultData;

public class ScatterChart implements ChartCreator{

	public void create(JPanel west, resultData data) {
		// TODO Auto-generated method stub
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		for(int i = 0;i<data.getMethods().size();i++) {
			TimeSeries series = new TimeSeries(data.getMethods().get(i));


			for(int j = data.getStartYear();j<=data.getEndYear();j++) {
				series.add(new Year(j),Double.parseDouble(data.getData().get(i).get(j+"")));
			}
			dataset.addSeries(series);
		}
		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);


		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));



		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
//		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart scatterChart = new JFreeChart(data.getMethodsString(),
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		ChartPanel chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(450, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		if(data.getMethodsString().equals("Current health expenditure (% of GDP) vs Others")) {
			
		}else {
			west.add(chartPanel);
		}
		
	}
	
}
