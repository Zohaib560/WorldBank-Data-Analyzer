package AnalysisPackage;

import java.util.ArrayList;

import DataFetcher.UrlCreateProcessor;
import UserSelectionPackage.UserSelection;

public class Methods4 implements MethodsCreator{


	private static ArrayList<String> method;

	public ArrayList<String> create(UserSelection us,resultData data) {
		method = new ArrayList<String>();
		method.add("SH.XPD.CHEX.PC.CD");
		method.add("SH.MED.BEDS.ZS");
		method.add("NY.GDP.PCAP.CD");

		
		ArrayList<String> result = new ArrayList<String>();
		result.add(UrlCreateProcessor.UrlCreate(us,method.get(0)));
		result.add(UrlCreateProcessor.UrlCreate(us,method.get(1)));
		result.add(UrlCreateProcessor.UrlCreate(us,method.get(2)));
		
		
		ArrayList<String> methods = new ArrayList<String>();
		methods.add("Current health expenditure per capita (unit: 1000US$)");
		methods.add("Hospital beds (per 1,000 people)");
		methods.add("GDP/10000");	
		data.setMethods(methods);
		
		
		ArrayList<Integer> offset = new ArrayList<Integer>();
		offset.add(1000);
		offset.add(1);
		offset.add(10000);
		data.setOffset(offset);
		
		return result;
	}
}
