package UserSelectionPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JComboBox;

public class UserSelection {
	private JComboBox<String> countriesList;
	private JComboBox<String> fromList;
	private JComboBox<String> toList;
	private JComboBox<String> viewsList;
	private JComboBox<String> methodsList;
	private String CountryCode;

	private static Map<String,String> countryMap = new TreeMap<String,String>();


	
	private static UserSelection instance;
	
	public static UserSelection getInstance() {
		if(instance == null) {
			instance = new UserSelection();
			countryMap.put("Canada", "CAN");
			countryMap.put("Brazil", "BRA");
			countryMap.put("USA", "USA");
			countryMap.put("France", "FRA");
			countryMap.put("China", "CHN");
			countryMap.put("Argentina", "ARG");
			countryMap.put("Belgium", "BEL");
			countryMap.put("Greece", "GRC");

		}
		return instance;
	}
	
	private UserSelection() {


	}


	public String getCountryCode() {
		this.CountryCode = countryMap.get((String)countriesList.getSelectedItem());
		return CountryCode;
	}

	public String getFromList() {
		return (String)fromList.getSelectedItem();
	}
	public String getToList() {
		return (String)toList.getSelectedItem();
	}
	public String getViewsList() {
		return (String)viewsList.getSelectedItem();
	}
	public String getMethodsList() {
		return (String)methodsList.getSelectedItem();
	}
	public void setCountriesList(JComboBox<String> countriesList) {
		this.countriesList = countriesList;
		this.CountryCode = countryMap.get((String)countriesList.getSelectedItem());
	}
	public void setFromList(JComboBox<String> fromList) {
		this.fromList = fromList;
	}
	public void setToList(JComboBox<String> toList) {
		this.toList = toList;
	}
	public void setViewsList(JComboBox<String> viewsList) {
		this.viewsList = viewsList;
	}
	public void setMethodsList(JComboBox<String> methodsList) {
		this.methodsList = methodsList;
	}

}
