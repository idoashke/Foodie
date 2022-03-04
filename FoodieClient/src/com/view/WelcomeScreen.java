package com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class WelcomeScreen extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	private MainView mainView;


	public WelcomeScreen(MainView mainView) {
		this.mainView = mainView;
		initWelcomeScreen();
	}
	
	public void initWelcomeScreen() {
//		setTitle("Foodie");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 870, 551);
//		contentPane = new JPanel();zz
//		setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		setPreferredSize(new Dimension(434, 228));
		setLayout(null);
		
		JButton MS_new_button = new JButton("New");
		JButton MS_open_button = new JButton("Open");


		MS_new_button.setBounds(116, 138, 80, 21);
		add(MS_new_button);
		

		MS_open_button.setBounds(233, 138, 80, 21);
		add(MS_open_button);
		
		JLabel MS_header_label = new JLabel("Welcome to Foodie App !");
		MS_header_label.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		MS_header_label.setHorizontalAlignment(SwingConstants.CENTER);
		MS_header_label.setBounds(10, 10, 414, 33);
		add(MS_header_label);
		
		JLabel MS_subHeader1_label = new JLabel("<html>\r\nPlease open your existing account data by entering your user id\r\n<br/>\r\nor create a new one easily by pressing the \"New\" button ☺\r\n</html>");
		MS_subHeader1_label.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		MS_subHeader1_label.setHorizontalAlignment(SwingConstants.CENTER);
		MS_subHeader1_label.setBounds(10, 53, 414, 60);
		add(MS_subHeader1_label);
		
		
		MS_new_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainView.openNewUserView();
			}
		});
		
		MS_open_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainView.openExistingUserView();
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		mainView.getAllFoods();
		
	}

}
