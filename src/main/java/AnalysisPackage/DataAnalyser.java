package AnalysisPackage;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class DataAnalyser {
	public static Map<String,String> dataProcesser(String data,int offset) {
		JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();
		int size = jsonArray.size();
		int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
		int year;
		Map<String,String> methodResult = new TreeMap<String,String>();
		double result = 0;
		DecimalFormat formater = new DecimalFormat("0.00");
		for (int i = 0; i < sizeOfResults; i++) {
			
			year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
			if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull()) {
				result = 0;
			}
			
			else {
				result = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value")
						.getAsDouble();
				}
			
			if(offset==0) {
				if(result==0) {
					methodResult.put(year+"", (result)+"");
				}else {
					methodResult.put(year+"", (100-result)+"");
				}
			}else {
				methodResult.put(year+"", formater.format(result/offset));
			}

			
			}
		return methodResult;

	}
}
