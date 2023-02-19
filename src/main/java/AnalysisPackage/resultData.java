package AnalysisPackage;

import java.util.ArrayList;
import java.util.Map;

public class resultData {

	private String methodsString ;
	private int StartYear ;
	private int EndYear;
	private ArrayList<String> methods;
	private ArrayList<Map<String,String>> data;
	private ArrayList<Integer> offset;
	

	
	public String getMethodsString() {
		return methodsString;
	}
	public void setMethodsString(String methodsString) {
		this.methodsString = methodsString;
	}
	public int getStartYear() {
		return StartYear;
	}
	public void setStartYear(int startYear) {
		StartYear = startYear;
	}
	public int getEndYear() {
		return EndYear;
	}
	public void setEndYear(int endYear) {
		EndYear = endYear;
	}
	public ArrayList<String> getMethods() {
		return methods;
	}
	public void setMethods(ArrayList<String> methods) {
		this.methods = methods;
	}
	public ArrayList<Map<String, String>> getData() {
		return data;
	}
	public void setData(ArrayList<Map<String, String>> data) {
		this.data = data;
	}
	public ArrayList<Integer> getOffset() {
		return offset;
	}
	public void setOffset(ArrayList<Integer> offset) {
		this.offset = offset;
	}
	
	
	
}
