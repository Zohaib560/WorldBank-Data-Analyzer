package DataFetcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class UnavailableCountryFetcher {
	
		
		public static ArrayList<String> GrabData() {
			   String rootpath = System.getProperty("user.dir");
			   FileReader s = null;
			   String json = null;
			   try {
				s = new FileReader(rootpath+File.separator+"src"+File.separator+"main"+File.separator+
						"resources"+File.separator+"UnavailableCountry.json");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			   BufferedReader buffer = new  BufferedReader(s);
			   try {
				 json = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			   Gson js2 = new Gson();
				JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
			   ArrayList<String> list = new ArrayList<String>();
			   for(int i = 0; i <jsonArray.size();i++) {
				   list.add(jsonArray.get(i).getAsString());
			   }
			   return list;
		}
	
}
