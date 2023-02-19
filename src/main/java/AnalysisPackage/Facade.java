package AnalysisPackage;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;

import DataFetcher.DataFetcher;
import DataFetcher.UrlCreator;
import UIPackage.ChartCreateFactory;
import UIPackage.Publisher;
import UserSelectionPackage.UserSelection;

public class Facade {
	
	private static resultData data = null;
		
	public static void Recalculate(UserSelection us,JPanel west,boolean checker) {
		if(checker) {
			RefreshData(us);
			west.removeAll();
			Publisher.getInstance().notifySubscribers(west, data);
		}else {
			RefreshData(us);
			west.removeAll();
			Publisher.getInstance().unsubscribeAll();
		}


	}
	
	private static void RefreshData(UserSelection us) {
		data = new resultData();
		data.setStartYear(Integer.parseInt(us.getFromList()));
		data.setEndYear(Integer.parseInt(us.getToList()));
		data.setMethodsString(us.getMethodsList());
		ArrayList<Map<String,String>> result = new ArrayList<Map<String,String>>();
		int k = 0;
		for(String i: UrlCreator.CreateUrl(us,data)) {
			result.add(DataAnalyser.dataProcesser(DataFetcher.getData(i), data.getOffset().get(k++))) ;
		}
		data.setData(result);
	}
	
	public static void AddViewer(Object item,JPanel west,UserSelection us) {
		RefreshData(us);
		ChartCreateFactory.create(item).create(west, data);
		Publisher.getInstance().subscribe(ChartCreateFactory.create(item));
	}
	
	public static void RemoveViewer(JPanel west) {
		west.remove(0);
		Publisher.getInstance().unsubscribe();
	}
	
	
	
}
