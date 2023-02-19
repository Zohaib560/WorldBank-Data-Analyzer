package AnalysisPackage;

import java.util.ArrayList;

import DataFetcher.UrlCreateProcessor;
import UserSelectionPackage.UserSelection;

public class Methods1 implements MethodsCreator{
	
	private static String method = "SH.MED.BEDS.ZS";

	public ArrayList<String> create(UserSelection us,resultData data) {
		
		ArrayList<String> result = new ArrayList<String>();
		result.add(UrlCreateProcessor.UrlCreate(us,method));
		
		
		ArrayList<String> methods = new ArrayList<String>();
		methods.add("Hospital beds (per 1,000 people)");
		data.setMethods(methods);
		
		ArrayList<Integer> offset = new ArrayList<Integer>();
		offset.add(1);
		data.setOffset(offset);
		
		return result;
	}

}
