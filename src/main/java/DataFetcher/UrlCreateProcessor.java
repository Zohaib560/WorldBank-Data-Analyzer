package DataFetcher;

import UserSelectionPackage.UserSelection;

public class UrlCreateProcessor {

	public static String UrlCreate(UserSelection us,String s) {
		
		String urlString = 	String.format("http://api.worldbank.org/v2/country/"
				+ "%s/indicator/%s?date=%s:%s&format=json", us.getCountryCode(),
				s, us.getFromList(),us.getToList());
		return urlString;
		
	}
}
