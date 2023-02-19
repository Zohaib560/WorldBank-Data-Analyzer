package DataFetcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;

public class AccountInfoFetcher {
	
	public static Map<String, String> GrabData() {
		   String rootpath = System.getProperty("user.dir");
		   FileReader s = null;
		   String json = null;
		   try {
			s = new FileReader(rootpath+File.separator+"src"+File.separator+"main"+File.separator+
					"resources"+File.separator+"account.json");
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
		   Map<String, String> map = js2.fromJson(json, Map.class);
		   return map;
	}
}
