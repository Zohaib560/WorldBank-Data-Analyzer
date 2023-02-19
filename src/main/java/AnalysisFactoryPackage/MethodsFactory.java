package AnalysisFactoryPackage;

import java.util.ArrayList;

import AnalysisPackage.Methods1;
import AnalysisPackage.Methods2;
import AnalysisPackage.Methods3;
import AnalysisPackage.Methods4;
import AnalysisPackage.Methods5;
import AnalysisPackage.Methods6;
import AnalysisPackage.Methods7;
import AnalysisPackage.Methods8;
import AnalysisPackage.MethodsCreator;

public class MethodsFactory {
	
	public static MethodsCreator StrategyCreator(String s){
		
		if(s.equals("Hospital beds (per 1,000 people)")) {
			return new Methods1();
		}
		else if(s.equals("GDP (unit: 10000US$) & Hospital beds (per 1,000 people)")) {
			return new Methods2();
		}
		else if(s.equals("Current health expenditure (% of GDP) vs Others")) {
			return new Methods3();
		}
		else if(s.equals("Current health expenditure per capita (unit: 1000US$) vs"
				+ " Hospital beds (per 1,000 people) vs GDP (unit: 10000US$)")) {
			return new Methods4();
		}
		else if (s.equals("Government expenditure on education, total (% of GDP) vs Others")) {
			return new Methods5();
		}
		else if (s.equals("Maternal mortality ratio (per 1,000,000 live births) vs Mortality rate, infant (per 1,000 live births)")) {
			return new Methods6();
		}
		else if (s.equals("Mortality rate, under-5 (per 1,000 live births) vs Mortality rate, infant (per 1,000 live births)")) {
			return new Methods7();
		}
		else if (s.equals("GDP growth (annual %) vs Current health expenditure (% of GDP)")) {
			return new Methods8();
		}
		return null;
		
		
	}
}
