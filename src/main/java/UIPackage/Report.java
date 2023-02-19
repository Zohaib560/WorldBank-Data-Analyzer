package UIPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import AnalysisPackage.resultData;

public class Report implements ChartCreator{

	public void create(JPanel west, resultData data) {
		JTextArea report = new JTextArea();
		report.setEditable(false);
		report.setPreferredSize(new Dimension(450, 300));
		report.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		report.setBackground(Color.white);
		String reportMessage = "";
		String title1 =data.getMethodsString();
		if(data.getMethodsString().length()>54) {
			title1 = data.getMethodsString().substring(0, 54)+"\n"+ 
					data.getMethodsString().substring(54);
		}
		reportMessage = title1 + "\n"+"==============================\n";
				for(int j = data.getStartYear();j<=data.getEndYear();j++) {
					reportMessage+="Year "+j+":\n";
					for(int i = 0;i<data.getMethods().size();i++) {
						reportMessage+="\t"+data.getMethods().get(i)+" => "+
								data.getData().get(i).get(j+"")+"\n";
					}

				}
				
				report.setText(reportMessage);
				JScrollPane outputScrollPane = new JScrollPane(report);
	//			west.add(outputScrollPane);
				if(data.getMethodsString().equals("Current health expenditure (% of GDP) vs Others")) {
					
				}else {
					west.add(outputScrollPane);
				}
	}
	
}
