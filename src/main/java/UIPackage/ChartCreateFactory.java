package UIPackage;

import java.util.ArrayList;

import javax.swing.JPanel;

public class ChartCreateFactory {
	public static ChartCreator create(Object item) {
		if(((String)item).equals("Pie Chart")) {
			return new PieChart();
		}else if(((String)item).equals("Bar Chart")){
			return new BarChart();
		}else if(((String)item).equals("Scatter Chart")) {
			return new ScatterChart();
		}else if(((String)item).equals("Line Chart")) {
			return new LineChart();
		}else{
			return new Report();
		}
	}
}
