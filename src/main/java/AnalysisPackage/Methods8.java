package AnalysisPackage;

import java.util.ArrayList;

import DataFetcher.UrlCreateProcessor;
import UserSelectionPackage.UserSelection;

public class Methods8 implements MethodsCreator{

	private static ArrayList<String> method;
	
	public ArrayList<String> create(UserSelection us, resultData data) {
		method = new ArrayList<String>();
		method.add("NY.GDP.MKTP.KD.ZG");
		method.add("SH.XPD.CHEX.GD.ZS");
		
		ArrayList<String> result = new ArrayList<String>();
		result.add(UrlCreateProcessor.UrlCreate(us,method.get(0)));
		result.add(UrlCreateProcessor.UrlCreate(us,method.get(1)));
		
		
		ArrayList<String> methods = new ArrayList<String>();
		methods.add("GDP growth (annual %)");
		methods.add("Current health expenditure (% of GDP)");
		data.setMethods(methods);
		
		
		ArrayList<Integer> offset = new ArrayList<Integer>();
		offset.add(1);
		offset.add(1);
		data.setOffset(offset);
		
		return result;
	}

}
