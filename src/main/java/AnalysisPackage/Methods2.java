package AnalysisPackage;

import java.util.ArrayList;

import DataFetcher.UrlCreateProcessor;
import UserSelectionPackage.UserSelection;

public class Methods2 implements MethodsCreator{


	private static ArrayList<String> method;

	public ArrayList<String> create(UserSelection us,resultData data) {
		method = new ArrayList<String>();
		method.add("NY.GDP.PCAP.CD");
		method.add("SH.MED.BEDS.ZS");
		
		ArrayList<String> result = new ArrayList<String>();
		result.add(UrlCreateProcessor.UrlCreate(us,method.get(0)));
		result.add(UrlCreateProcessor.UrlCreate(us,method.get(1)));
		
		
		ArrayList<String> methods = new ArrayList<String>();
		methods.add("GDP/10000");
		methods.add("Hospital beds (per 1,000 people)");
		data.setMethods(methods);
		
		
		ArrayList<Integer> offset = new ArrayList<Integer>();
		offset.add(10000);
		offset.add(1);
		data.setOffset(offset);
		
		return result;
	}

}
