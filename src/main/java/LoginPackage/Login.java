package LoginPackage;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.google.gson.Gson;

import DataFetcher.AccountInfoFetcher;
import UIPackage.MainUI;

public class Login{
	
	private JTextField UsernameBox = null;
	private JPasswordField PasswordBox = null;
	private Map<String,String> DataBase = null;
	private JFrame f = null;
	private Container c = null;
	private static Login instance;
	
	public static Login getInstance() {
		if(instance == null) {
			instance = new Login();
		}
		return instance;
	}
	
	private Login() {
		f = new JFrame("Login");
		InitialFrame();
        GridBagLayout gridBag = new GridBagLayout();   
		c.setLayout(new GridLayout(2,1));
		JPanel p1 = new JPanel(gridBag);
		JPanel p2 = new JPanel(new FlowLayout());
		DataBase = AccountInfoFetcher.GrabData();
		CreateAndSetComponent(p1,p2);
		c.add(p1);
		c.add(p2);
		f.setVisible(true);
	}

	public class Error extends JDialog {
		public Error(JFrame j) {
			super(j,"error",true);
			setSize(300,100);
			setLocationRelativeTo(null);
			Container c = getContentPane();
			c.setLayout(new FlowLayout());
			JLabel error = new JLabel("incorrect password");
			c.add(error);
		}

	}
	private void InitialFrame() {
		f.setSize(400, 150);
		f.setLocationRelativeTo(null);
		c = f.getContentPane();
	}
	private void GridBagConstraintsSetter(GridBagConstraints c, int gridx, int gridy, int ipadx) {
		c.gridx = gridx;
		c.gridy = gridy;
		c.ipadx = ipadx;
	}
	private void CreateAndSetComponent(JPanel p1, JPanel p2) {
		UsernameBox = new JTextField();
		UsernameBox.setColumns(10);
		GridBagConstraints c1 = new GridBagConstraints();
		GridBagConstraintsSetter(c1,4,1,70);

		JLabel Username = new JLabel("Username:");
		GridBagConstraints c2 = new GridBagConstraints();
		GridBagConstraintsSetter(c2,0,1,0);
		
		PasswordBox = new JPasswordField();
		PasswordBox.setColumns(10);
		GridBagConstraints c3 = new GridBagConstraints();
		GridBagConstraintsSetter(c3,4,2,70);

		JLabel Password = new JLabel("Password:");
		GridBagConstraints c4 = new GridBagConstraints();
		GridBagConstraintsSetter(c4,0,2,0);
		
		JLabel fill1 = new JLabel(" ");
		GridBagConstraints cf1 = new GridBagConstraints();
		GridBagConstraintsSetter(cf1,0,0,0);
		
		JButton submit = new JButton("Submit!");
		
		submit.addActionListener(new AccessListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(AccessChecker()) {
					JFrame frame = MainUI.getInstance();
					f.setVisible(false);
				}
				else {
					Error error = new Error(f);
					error.setVisible(true);
					System.exit(0);

				}
			}
		});
		
		p1.add(fill1,cf1); 
		p1.add(UsernameBox,c1); 
		p1.add(Username,c2); 
		p1.add(PasswordBox,c3); 
		p1.add(Password,c4);
		p2.add(submit);
	}
	
	

	private boolean AccessChecker() {

		if(DataBase.get(UsernameBox.getText())!=null) {
		if(DataBase.get(UsernameBox.getText()).equals(new String(PasswordBox.getPassword()))) {
	

			return true;
		}
		}

		return false;
		
	}
	
	private class AccessListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
		}
		
		
		
	}



}


