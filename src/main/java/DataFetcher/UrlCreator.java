package DataFetcher;

import java.util.ArrayList;

import AnalysisFactoryPackage.MethodsFactory;
import AnalysisPackage.MethodsCreator;
import AnalysisPackage.resultData;
import UserSelectionPackage.UserSelection;

public class UrlCreator {
	private static MethodsCreator strategy;
	
	public static ArrayList<String> CreateUrl(UserSelection us,resultData data){
		strategy=MethodsFactory.StrategyCreator(us.getMethodsList());
		return strategy.create(us,data);
	}

	
}
