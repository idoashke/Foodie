package com.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.dm.Food;
import com.dm.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class NewUserScreen extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainView mainView;

	private JTextField NUS_id_input;
	private JTextField NUS_fullName_input;
	private JLabel NUS_fullName_label;
	private JTextField NUS_age_input;
	private JLabel NUS_age_label;
	private JLabel NUS_gender_label;
	private JTextField NUS_height_input;
	private JTextField NUS_weight_input;
	
	JRadioButton NUS_male_radioButton = new JRadioButton("Male");
	JRadioButton NUS_female_radioButton = new JRadioButton("Female");
	private JButton NUS_cancel_button;
	private JButton NUS_save_button;
	private JLabel NUS_alert_textField;
	
	public NewUserScreen(MainView mainView) {
		this.mainView = mainView;
		initNewUserScreen();
	}

	public void initNewUserScreen() {
		setPreferredSize(new Dimension(442, 351));
		setLayout(null);

		JLabel NUS_id_label = new JLabel("ID : ");
		NUS_id_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		NUS_id_label.setHorizontalAlignment(SwingConstants.CENTER);
		NUS_id_label.setBounds(72, 97, 73, 16);
		add(NUS_id_label);
		
		NUS_id_input = new JTextField();
		NUS_id_input.setBounds(166, 97, 129, 19);
		add(NUS_id_input);
		NUS_id_input.setColumns(10);
		
		NUS_fullName_input = new JTextField();
		NUS_fullName_input.setColumns(10);
		NUS_fullName_input.setBounds(166, 126, 129, 19);
		add(NUS_fullName_input);
		
		NUS_fullName_label = new JLabel("Full name :");
		NUS_fullName_label.setHorizontalAlignment(SwingConstants.CENTER);
		NUS_fullName_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		NUS_fullName_label.setBounds(72, 126, 73, 16);
		add(NUS_fullName_label);
		
		NUS_age_input = new JTextField();
		NUS_age_input.setColumns(10);
		NUS_age_input.setBounds(166, 155, 129, 19);
		add(NUS_age_input);
		
		NUS_age_label = new JLabel("Age :");
		NUS_age_label.setHorizontalAlignment(SwingConstants.CENTER);
		NUS_age_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		NUS_age_label.setBounds(72, 155, 73, 16);
		add(NUS_age_label);
		
		NUS_gender_label = new JLabel("Gender :");
		NUS_gender_label.setHorizontalAlignment(SwingConstants.CENTER);
		NUS_gender_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		NUS_gender_label.setBounds(72, 181, 73, 16);
		add(NUS_gender_label);
		
		NUS_male_radioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NUS_female_radioButton.setSelected(false);
			}
		});
		NUS_male_radioButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		NUS_male_radioButton.setBounds(166, 180, 63, 21);
		add(NUS_male_radioButton);
		
		NUS_female_radioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NUS_male_radioButton.setSelected(false);
			}
		});
		NUS_female_radioButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		NUS_female_radioButton.setBounds(231, 180, 73, 21);
		add(NUS_female_radioButton);
		
		JLabel NUS_height_label = new JLabel("Height (cm) :");
		NUS_height_label.setHorizontalAlignment(SwingConstants.CENTER);
		NUS_height_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		NUS_height_label.setBounds(72, 207, 73, 16);
		add(NUS_height_label);
		
		NUS_height_input = new JTextField();
		NUS_height_input.setColumns(10);
		NUS_height_input.setBounds(166, 207, 129, 19);
		add(NUS_height_input);
		
		JLabel NUS_weight_label = new JLabel("Weight (kg) :");
		NUS_weight_label.setHorizontalAlignment(SwingConstants.CENTER);
		NUS_weight_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		NUS_weight_label.setBounds(72, 233, 73, 16);
		add(NUS_weight_label);
		
		NUS_weight_input = new JTextField();
		NUS_weight_input.setColumns(10);
		NUS_weight_input.setBounds(166, 233, 129, 19);
		add(NUS_weight_input);
		
		JLabel NUS_headerTextField = new JLabel("Register Page");
		NUS_headerTextField.setHorizontalAlignment(SwingConstants.CENTER);
		NUS_headerTextField.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		NUS_headerTextField.setBounds(10, 24, 422, 43);
		add(NUS_headerTextField);
		
		NUS_cancel_button = new JButton("Cancel");
		NUS_cancel_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.exit(1);
				mainView.openMainView();
			}
		});
		NUS_cancel_button.setBounds(10, 320, 85, 21);
		add(NUS_cancel_button);
		
		NUS_save_button = new JButton("Save");
		NUS_save_button.addActionListener(this);
//		NUS_save_button.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (!NUS_id_input.getText().isEmpty() && !NUS_fullName_input.getText().isEmpty() && !NUS_age_input.getText().isEmpty()
//						&& !NUS_height_input.getText().isEmpty() && !NUS_weight_input.getText().isEmpty()
//						&& (NUS_female_radioButton.isSelected() || NUS_male_radioButton.isSelected())) {
//					Long id = Long.parseLong(NUS_id_input.getText().toString());
//					System.out.println(id);
//					String fullName = NUS_fullName_input.getText().toString();
//					Integer age = Integer.parseInt(NUS_age_input.getText().toString());
//					Integer height = Integer.parseInt(NUS_height_input.getText().toString());
//					Double weight = Double.parseDouble(NUS_weight_input.getText().toString());
//					// gender -> 1 = male , 0 = female
//					Integer gender = 1;
//					if (NUS_male_radioButton.isSelected()) {
//						gender = 1;
//					} else if (NUS_female_radioButton.isSelected()){
//						gender = 0;
//					}
//					
//					User user = new User(id,  fullName, age, gender, height, weight);
//					Gson gson = new Gson();
//					Type type = new TypeToken<User>(){}.getType();
//					String jsonToSave = gson.toJson(user, type);
//					String header = "saveChanges";
//					System.out.println("jsontosave:  " +jsonToSave);
//					mainView.get(header, jsonToSave);
//					
//////					mainView.userFormatter();
////					JsonObject jsonObject = new JsonObject();
////					jsonObject.addProperty("header", "saveChanges");
////					JsonObject jsonData = new JsonObject();
////					jsonData.addProperty("id", id);
////					jsonData.addProperty("name", fullName);
////					jsonData.addProperty("age", age);
////					jsonData.addProperty("height", height);
////					jsonData.addProperty("weight", weight);
////					jsonData.addProperty("gender", gender);
////					jsonObject.addProperty("data", jsonData);
////
//////					String newUser = "{\"id\":"+id+",\"name\":\""+fullName+"\",\"age\":"+age+",\"gender\":"+gender+",\"height\":"+height+",\"weight\":"+weight+",\"bmr\":"+1941.3610000000003+",\"meals\":[]}";
////					mainView.saveNewUser(newUser);
//					
//				} else {
//					NUS_alert_textField.setVisible(true);
//				}
//			}
//		});
		NUS_save_button.setBounds(347, 320, 85, 21);
		add(NUS_save_button);
		
		NUS_alert_textField = new JLabel("Please fill all the fields before saving!");
		NUS_alert_textField.setVisible(false);
		NUS_alert_textField.setHorizontalAlignment(SwingConstants.CENTER);
		NUS_alert_textField.setBounds(10, 324, 422, 13);
		add(NUS_alert_textField);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed");
		try {
		if (!NUS_id_input.getText().isEmpty() && !NUS_fullName_input.getText().isEmpty() && !NUS_age_input.getText().isEmpty()
				&& !NUS_height_input.getText().isEmpty() && !NUS_weight_input.getText().isEmpty()
				&& (NUS_female_radioButton.isSelected() || NUS_male_radioButton.isSelected())) {
			Long id = Long.parseLong(NUS_id_input.getText().toString());
			System.out.println(id);
			String fullName = NUS_fullName_input.getText().toString();
			Integer age = Integer.parseInt(NUS_age_input.getText().toString());
			Integer height = Integer.parseInt(NUS_height_input.getText().toString());
			Double weight = Double.parseDouble(NUS_weight_input.getText().toString());
			// gender -> 1 = male , 0 = female
			Integer gender = 1;
			if (NUS_male_radioButton.isSelected()) {
				gender = 1;
			} else if (NUS_female_radioButton.isSelected()){
				gender = 0;
			}

			User user = new User(id,  fullName, age, gender, height, weight);
			Gson gson = new Gson();
			Type type = new TypeToken<User>(){}.getType();
			String jsonToSave = gson.toJson(user, type);
			String header = "saveChanges";
			System.out.println("jsontosave:  " +jsonToSave);
			mainView.setRequest(header, jsonToSave);
			NUS_alert_textField.setText("User data was successfully saved!");
			NUS_alert_textField.setVisible(true);
			NUS_save_button.setEnabled(false);


		} else {
			NUS_alert_textField.setText("Please fill all the fields before saving!");
			NUS_alert_textField.setVisible(true);
		}
		} catch (Exception d) {
			NUS_alert_textField.setText("Please enter a valid details!");
		}

	}

}
