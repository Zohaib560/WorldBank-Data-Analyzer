package AnalysisPackage;

import java.util.ArrayList;

import DataFetcher.UrlCreateProcessor;
import UserSelectionPackage.UserSelection;

public class Methods6 implements MethodsCreator{
	
	private static ArrayList<String> method;
	
	public ArrayList<String> create(UserSelection us, resultData data) {
		method = new ArrayList<String>();
		method.add("SH.STA.MMRT");
		method.add("SP.DYN.IMRT.IN");
		
		ArrayList<String> result = new ArrayList<String>();
		result.add(UrlCreateProcessor.UrlCreate(us,method.get(0)));
		result.add(UrlCreateProcessor.UrlCreate(us,method.get(1)));
		
		
		ArrayList<String> methods = new ArrayList<String>();
		methods.add("Maternal mortality ratio (per 100,000 live births)");
		methods.add("Mortality rate, infant (per 1,000 live births)");
		data.setMethods(methods);
		
		
		ArrayList<Integer> offset = new ArrayList<Integer>();
		offset.add(1);
		offset.add(1);
		data.setOffset(offset);
		
		return result;
	}

}
