package com.network.IPFinder;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IPAddress {
	IPAddress() {
		Frame f = new Frame("IPFinder");
		Label url = new Label("Input URL : ");
		//label for input position, x : 50, y : 50, width : 50, height :20
		url.setBounds(50,50,50,20);
	    //input text field position, x : 50, y : 70, width : 120, height : 20
		TextField t = new TextField();
		t.setBounds(50,70,120,20);
		Label output = new Label("Output");
	    //label for output position, x : 50, y : 100, width : 50, height : 20
		output.setBounds(50,100,50,20);
		TextField label = new TextField();
	    //display output position, x : 50, y : 120, width : 120, height : 20
		label.setBounds(50,120,120,20);
	    //adding functionality to our app
		f.add(url);
		f.add(output);
		f.add(t);
		f.add(label);
	    //method to close app
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
	    //action listener over textfield
		t.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//input url
					String host = t.getText();
			        //identify ip address of url
					String a = java.net.Inet4Address.getByName(host).getHostAddress();
					label.setText("Ip : " + a);
				}catch(Exception ex) {
			        //if the given url is incorrect
					label.setText("Check url again");
				}
			}
		});
		f.setLayout(null);  //to align everything manually
		f.setSize(220,200); //size of app width : 220, height : 200
		f.setVisible(true); //set the app visible
		
	}
	public static void main(String[] args) {
		new IPAddress();
	}
}
