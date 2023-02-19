/*************************************************
 * FALL 2022
 * EECS 3311 GUI SAMPLE CODE
 * ONLT AS A REFERENCE TO SEE THE USE OF THE jFree FRAMEWORK
 * THE CODE BELOW DOES NOT DEPICT THE DESIGN TO BE FOLLOWED 
 */

package UIPackage;



import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import AnalysisPackage.Facade;
import DataFetcher.UnavailableCountryFetcher;
import LoginPackage.Login.Error;
import UserSelectionPackage.UserSelection;

public class MainUI extends JFrame {
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	private JPanel south;
	private JPanel north;
	private JPanel west;
	private JPanel east;
	public static ArrayList<String> UnavailableCountryDatabase;

	
	private static MainUI instance;
	

	public static MainUI getInstance() {
		if (instance == null)
			instance = new MainUI();

		return instance;
	}

	private MainUI() {
		
		
		// Set window title
		super("Country Statistics");
		

		UnavailableCountryDatabase = UnavailableCountryFetcher.GrabData();
		
		final UserSelection us = UserSelection.getInstance();

		// Set top bar
		JLabel chooseCountryLabel = new JLabel("Choose a country: ");
		Vector<String> countriesNames = new Vector<String>();
		countriesNames.add("USA");
		countriesNames.add("France");
		countriesNames.add("China");
		countriesNames.add("Brazil");
		countriesNames.add("Argentina");
		countriesNames.add("Belgium");
		countriesNames.add("Greece");
		countriesNames.add("Iceland");
		countriesNames.add("India");
		countriesNames.add("Canada");
		countriesNames.sort(null);
		final JComboBox<String> countriesList = new JComboBox<String>(countriesNames);
		us.setCountriesList(countriesList);
		countriesList.addActionListener(new ActionListenerI() {
			@Override
			public void actionPerformed(ActionEvent e){
				if(((String)countriesList.getSelectedItem()).equals(UnavailableCountryDatabase.get(0))||
						((String)countriesList.getSelectedItem()).equals(UnavailableCountryDatabase.get(1))) {
					Error error = new Error(MainUI.getInstance(),"This country is not allow for now.");
					error.setVisible(true);
					countriesList.setSelectedItem("Canada");
				}
			}
		});
		
		
		
		JLabel from = new JLabel("From");
		JLabel to = new JLabel("To");
		Vector<String> years = new Vector<String>();
		for (int i = 2021; i >= 2010; i--) {
			years.add("" + i);
		}
		JComboBox<String> fromList = new JComboBox<String>(years);
		JComboBox<String> toList = new JComboBox<String>(years);
		
		us.setFromList(fromList);
		us.setToList(toList);

		north = new JPanel();
		north.add(chooseCountryLabel);
		north.add(countriesList);
		north.add(from);
		north.add(fromList);
		north.add(to);
		north.add(toList);

		// Set bottom bar
		JButton recalculate = new JButton("Recalculate");
		

		JLabel viewsLabel = new JLabel("Available Views: ");

		Vector<String> viewsNames = new Vector<String>();
		viewsNames.add("Pie Chart");
		viewsNames.add("Line Chart");
		viewsNames.add("Bar Chart");
		viewsNames.add("Scatter Chart");
		viewsNames.add("Report");
		final JComboBox<String> viewsList = new JComboBox<String>(viewsNames);
		JButton addView = new JButton("+");
		JButton removeView = new JButton("-");


		JLabel methodLabel = new JLabel("        Choose analysis method: ");

		Vector<String> methodsNames = new Vector<String>();
		methodsNames.add("Hospital beds (per 1,000 people)");
		methodsNames.add("Current health expenditure (% of GDP) vs Others");
		methodsNames.add("GDP (unit: 10000US$) & Hospital beds (per 1,000 people)");
		methodsNames.add("Current health expenditure per capita (unit: 1000US$) vs"
				+ " Hospital beds (per 1,000 people) vs GDP (unit: 10000US$)");
		methodsNames.add("Government expenditure on education, total (% of GDP) vs Others");
		methodsNames.add("Maternal mortality ratio (per 1,000,000 live births) vs Mortality rate, infant (per 1,000 live births)");
		methodsNames.add("Mortality rate, under-5 (per 1,000 live births) vs Mortality rate, infant (per 1,000 live births)");
		methodsNames.add("GDP growth (annual %) vs Current health expenditure (% of GDP)");
		final JComboBox<String> methodsList = new JComboBox<String>(methodsNames);

		us.setMethodsList(methodsList);
		
		south = new JPanel();
		south.add(viewsLabel);
		south.add(viewsList);
		south.add(addView);
		south.add(removeView);

		south.add(methodLabel);
		south.add(methodsList);
		south.add(recalculate);

		east = new JPanel();

		// Set charts region
		west = new JPanel();
		west.setLayout(new GridLayout(2, 0));
		
		recalculate.addActionListener(new ActionListenerI(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = 0;
				if(((String)viewsList.getSelectedItem()).equals("Pie Chart")){
					index++;
				}
				if(((String)methodsList.getSelectedItem()).
						equals("Current health expenditure (% of GDP) vs Others") || ((String)methodsList.getSelectedItem()).
						equals("Government expenditure on education, total (% of GDP) vs Others")){
					index++;
				}
				if(index%2==1) {
					Error error = new Error(MainUI.getInstance(),"Current viewer was removed"
							+" due to uncompatible method.");
					error.setVisible(true);
					Facade.Recalculate(us,west,false);					
				}else {
					Facade.Recalculate(us,west,true);
				}

				pack();
				setVisible(true);
			}
		});
		
		addView.addActionListener(new ActionListenerI() {
			@Override
			public void actionPerformed(ActionEvent e){
				int index = 0;
				if(((String)viewsList.getSelectedItem()).equals("Pie Chart")){
					index++;
				}
				if(((String)methodsList.getSelectedItem()).
						equals("Current health expenditure (% of GDP) vs Others") || ((String)methodsList.getSelectedItem()).
						equals("Government expenditure on education, total (% of GDP) vs Others")){
					index++;
				}
				if(index%2==1) {
					Error error = new Error(MainUI.getInstance(),"This methods can't use this chart.");
					error.setVisible(true);
				}else {
					Facade.AddViewer(viewsList.getSelectedItem(),west, us);
					pack();
					setVisible(true);
				}

			}
		});
		removeView.addActionListener(new ActionListenerI() {
			@Override
			public void actionPerformed(ActionEvent e){
				Facade.RemoveViewer(west);
				pack();
				setVisible(true);
			}
		});
		

		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(south, BorderLayout.SOUTH);
		getContentPane().add(west, BorderLayout.WEST);
		setSize(900, 600);
		pack();
		setVisible(true);
	}
	

	
	private class Error extends JDialog {
		public Error(JFrame j,String m) {
			super(j,"error",true);
			setSize(450,150);
			setLocationRelativeTo(null);
			Container c = getContentPane();
			c.setLayout(new FlowLayout());
			JLabel error = new JLabel(m);
			c.add(error);
		}

	}

	private class ActionListenerI implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
		}
		
		
		
	}


	// TODO Auto-generated method stub

}