package AnalysisPackage;

import java.util.ArrayList;

import DataFetcher.UrlCreateProcessor;
import UserSelectionPackage.UserSelection;

public class Methods5 implements MethodsCreator {

	private static ArrayList<String> method;

	public ArrayList<String> create(UserSelection us,resultData data) {
		method = new ArrayList<String>();
		method.add("SE.XPD.TOTL.GD.ZS");
		
		ArrayList<String> result = new ArrayList<String>();
		result.add(UrlCreateProcessor.UrlCreate(us,method.get(0)));
		result.add(UrlCreateProcessor.UrlCreate(us,method.get(0)));
		
		ArrayList<String> methods = new ArrayList<String>();
		methods.add("Government expenditure on education, total (% of GDP)");
		methods.add("Others");
		data.setMethods(methods);
		
		
		ArrayList<Integer> offset = new ArrayList<Integer>();
		offset.add(1);
		offset.add(0);
		data.setOffset(offset);
		
		return result;
	}

}
