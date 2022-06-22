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
		Frame f = new Frame();
		TextField t = new TextField();
    //input text field position, x : 50, y : 70, width : 120, height : 20
		t.setBounds(50,70,180,20);
		Label label = new Label();
    //display output position, x : 50, y : 100, width : 200, height : 30
		label.setBounds(50, 100, 200,30);
    //adding functionality to aour app
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
					label.setText("Ip of host " + host + " is " + a);
				}catch(Exception ex) {
          //if the given url is incorrect
					label.setText("Check url again");
				}	
			}
		});
		f.setLayout(null);  //to align everything manually
		f.setSize(400,200); //size of app height : 200, width : 400
		f.setVisible(true); //show the app
		
	}
  //driver method
	public static void main(String[] args) {
		new IPAddress();
	}
}
