package UIPackage;

import java.util.ArrayList;

import javax.swing.JPanel;

import AnalysisPackage.resultData;

public class Publisher {
	private static Publisher instance;
	private ArrayList<ChartCreator> subscribers;
	
	public static Publisher getInstance() {
			if (instance == null)
				instance = new Publisher();

			return instance;
		}
	
	private Publisher() {
		this.subscribers = new ArrayList<ChartCreator>();
	}
	
	public void subscribe(ChartCreator s) {
		this.subscribers.add(s);
	}
	
	public void unsubscribe() {
		this.subscribers.remove(0);
	}
	
	public void notifySubscribers(JPanel west,resultData data) {
		for(ChartCreator i:subscribers) {
			i.create(west, data);
		}
	}
	public void unsubscribeAll() {
		this.subscribers.clear();
	}
	
}
