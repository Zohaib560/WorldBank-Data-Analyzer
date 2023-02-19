package DataFetcher;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class DataFetcher {
	public static String getData(String urlString){
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				return inline;
				}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public static Map<String,String> dataProcesser(String data,int offset) {
//		JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();
//		int size = jsonArray.size();
//		int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
//		int year;
//		Map<String,String> methodResult = new TreeMap<String,String>();
//		double result = 0;
//		for (int i = 0; i < sizeOfResults; i++) {
//			year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
//			if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull()) {
//				result = 0;
//			}
//			
//			else {
//				result = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value")
//					.getAsDouble();
//				}
//			methodResult.put(year+"", (result/offset)+"");
//
//			
//			}
//		return methodResult;
//
//	}
	
}
