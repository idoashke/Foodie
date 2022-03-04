package com.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.dm.Meal;
import com.dm.User;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.border.TitledBorder;

public class OpenUserScreen extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainView mainView;
	private JTextField OUD_userId_input;
	private JTextField id_input;
	private JTextField userId_input;
	private JPanel panel_mealsDetails;
	private JLabel MealsDetailsTtile_label;
	private JLabel id_user;
	private JLabel gender_user;
	private JLabel bmr_user;
	private JLabel name_user;
	private JLabel age_user;
	private JLabel height_user;
	private JLabel weight_user;
	private JLabel labelMeal_1;
	private JLabel labelMeal_2;
	private JLabel labelMeal_3;
	private JLabel labelMeal_4;
	private JLabel labelMeal_5;
	private JLabel labelMeal_6;
	private JButton editMealButton_1;
	private JButton editMealButton_2;
	private JButton editMealButton_3;
	private JButton editMealButton_4;
	private JButton editMealButton_5;
	private JButton editMealButton_6;
	private int numOfMeals;
	private JButton loadUserDataButton;
	private JButton addNewMealButton;
	private JLabel loadAlertLabel;

	

	public OpenUserScreen(MainView mainView) {
		setToolTipText("");
		this.mainView = mainView;
		this.numOfMeals = 0;
		initOpenUserScreen();
	}

	/**
	 * Create the panel.
	 */
	public void initOpenUserScreen() {
		setPreferredSize(new Dimension(882, 699));
		setLayout(null);
		
		panel_mealsDetails = new JPanel();
		panel_mealsDetails.setBounds(10, 372, 862, 298);
		add(panel_mealsDetails);
		panel_mealsDetails.setLayout(null);
		panel_mealsDetails.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.gray));
		
		MealsDetailsTtile_label = new JLabel("Meals Details");
		MealsDetailsTtile_label.setHorizontalAlignment(SwingConstants.CENTER);
		MealsDetailsTtile_label.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		MealsDetailsTtile_label.setBounds(0, 10, 862, 33);
		panel_mealsDetails.add(MealsDetailsTtile_label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 53, 852, 184);
		panel_mealsDetails.add(scrollPane);
		
		JPanel panel_meals = new JPanel();
		scrollPane.setViewportView(panel_meals);
		panel_meals.setLayout(new MigLayout("", "[723.00][102.00]", "[][][][][][]"));
		panel_meals.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(null, "Meal 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_meals.add(panel_12, "cell 0 0,grow");
		panel_12.setLayout(new MigLayout("", "[723.00]", "[]"));
		
		labelMeal_1 = new JLabel("-");
		panel_12.add(labelMeal_1, "cell 0 0,growx,aligny center");
		labelMeal_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		labelMeal_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(null, " Edit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_meals.add(panel_10, "cell 1 0,grow");
		panel_10.setLayout(new MigLayout("", "[102.00]", "[]"));
		
		editMealButton_1 = new JButton("Delete Meal");

		editMealButton_1.setEnabled(false);
		panel_10.add(editMealButton_1, "cell 0 0,alignx center,aligny center");
		editMealButton_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "Meal 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_meals.add(panel_11, "cell 0 1,grow");
		panel_11.setLayout(new MigLayout("", "[723.00]", "[]"));
		
		labelMeal_2 = new JLabel("-");
		panel_11.add(labelMeal_2, "cell 0 0,alignx center,aligny center");
		labelMeal_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		labelMeal_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "Edit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_meals.add(panel_9, "cell 1 1,grow");
		panel_9.setLayout(new MigLayout("", "[102.00]", "[]"));
		
		editMealButton_2 = new JButton("Delete Meal");
		editMealButton_2.setEnabled(false);
		panel_9.add(editMealButton_2, "cell 0 0,alignx center,aligny center");
		editMealButton_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Meal 3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_meals.add(panel_7, "cell 0 2,grow");
		panel_7.setLayout(new MigLayout("", "[723.00]", "[]"));
		
		labelMeal_3 = new JLabel("-");
		panel_7.add(labelMeal_3, "cell 0 0,alignx center,aligny center");
		labelMeal_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		labelMeal_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Edit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_meals.add(panel_8, "cell 1 2,grow");
		panel_8.setLayout(new MigLayout("", "[102.00]", "[]"));
		
		editMealButton_3 = new JButton("Delete Meal");
		editMealButton_3.setEnabled(false);
		panel_8.add(editMealButton_3, "cell 0 0,alignx center,aligny center");
		editMealButton_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Meal 4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_meals.add(panel_5, "cell 0 3,grow");
		panel_5.setLayout(new MigLayout("", "[723.00]", "[]"));
		
		labelMeal_4 = new JLabel("-");
		panel_5.add(labelMeal_4, "cell 0 0,alignx center,aligny center");
		labelMeal_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		labelMeal_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Edit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_meals.add(panel_6, "cell 1 3,grow");
		panel_6.setLayout(new MigLayout("", "[102.00]", "[]"));
		
		editMealButton_4 = new JButton("Delete Meal");
		editMealButton_4.setEnabled(false);
		panel_6.add(editMealButton_4, "cell 0 0,alignx center,aligny center");
		editMealButton_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Meal 5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_meals.add(panel_3, "cell 0 4,grow");
		panel_3.setLayout(new MigLayout("", "[723.00]", "[]"));
		
		labelMeal_5 = new JLabel("-");
		panel_3.add(labelMeal_5, "cell 0 0,alignx center,aligny center");
		labelMeal_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		labelMeal_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Edit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_meals.add(panel_4, "cell 1 4,grow");
		panel_4.setLayout(new MigLayout("", "[102.00]", "[]"));
		
		editMealButton_5 = new JButton("Delete Meal");
		editMealButton_5.setEnabled(false);
		panel_4.add(editMealButton_5, "cell 0 0,alignx center,aligny center");
		editMealButton_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Meal 6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_meals.add(panel_1, "cell 0 5,grow");
		panel_1.setLayout(new MigLayout("", "[723.00]", "[]"));
		
		labelMeal_6 = new JLabel("-");
		panel_1.add(labelMeal_6, "cell 0 0,alignx center,aligny center");
		labelMeal_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		labelMeal_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Edit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_meals.add(panel_2, "cell 1 5,grow");
		panel_2.setLayout(new MigLayout("", "[102.00]", "[]"));
		
		editMealButton_6 = new JButton("Delete Meal");
		editMealButton_6.setEnabled(false);
		panel_2.add(editMealButton_6, "cell 0 0,alignx center,aligny center");
		editMealButton_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		addNewMealButton = new JButton("Add New Meal ( Max. 6 )");
		addNewMealButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		addNewMealButton.setBounds(318, 255, 202, 21);
		addNewMealButton.setEnabled(false);
		panel_mealsDetails.add(addNewMealButton);
		
		JPanel panel_userDetails = new JPanel();
		panel_userDetails.setBounds(10, 145, 862, 173);
		add(panel_userDetails);
		panel_userDetails.setLayout(null);
		
		JLabel userDetailsTtile_label = new JLabel("User Details");
		userDetailsTtile_label.setHorizontalAlignment(SwingConstants.CENTER);
		userDetailsTtile_label.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		userDetailsTtile_label.setBounds(0, 10, 862, 33);
		panel_userDetails.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.gray));
		panel_userDetails.add(userDetailsTtile_label);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 53, 825, 104);
		panel_userDetails.add(panel);
		panel.setLayout(new MigLayout("", "[70.00][60][60][60][60][60][60][60][60][60][60][60][60][60][70]", "[][][][][]"));
		panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
		
		JLabel id_label = new JLabel("ID :");
		id_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		id_label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(id_label, "cell 1 0,alignx left,aligny center");
		
		id_user = new JLabel("");
		id_user.setForeground(Color.RED);
		id_user.setHorizontalAlignment(SwingConstants.CENTER);
		id_user.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel.add(id_user, "cell 3 0,alignx left,aligny baseline");
		
		JLabel gender_label = new JLabel("Gender :");
		gender_label.setHorizontalAlignment(SwingConstants.CENTER);
		gender_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel.add(gender_label, "cell 6 0,alignx left,aligny center");
		
		gender_user = new JLabel("");
		gender_user.setForeground(Color.RED);
		gender_user.setHorizontalAlignment(SwingConstants.CENTER);
		gender_user.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel.add(gender_user, "cell 8 0");
		
		JLabel bmr_label = new JLabel("BMR :");
		bmr_label.setHorizontalAlignment(SwingConstants.CENTER);
		bmr_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel.add(bmr_label, "cell 11 0");
		
		bmr_user = new JLabel("");
		bmr_user.setForeground(Color.RED);
		bmr_user.setHorizontalAlignment(SwingConstants.CENTER);
		bmr_user.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel.add(bmr_user, "cell 13 0");
		
		JLabel name_label = new JLabel("Name :");
		name_label.setHorizontalAlignment(SwingConstants.CENTER);
		name_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel.add(name_label, "cell 1 2,alignx left,aligny center");
		
		name_user = new JLabel("");
		name_user.setForeground(Color.RED);
		name_user.setHorizontalAlignment(SwingConstants.CENTER);
		name_user.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel.add(name_user, "cell 3 2,alignx left,aligny center");
		
		JLabel height_label = new JLabel("Height :");
		height_label.setHorizontalAlignment(SwingConstants.CENTER);
		height_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel.add(height_label, "cell 6 2,alignx left,aligny center");
		
		height_user = new JLabel("");
		height_user.setForeground(Color.RED);
		height_user.setHorizontalAlignment(SwingConstants.CENTER);
		height_user.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel.add(height_user, "cell 8 2");
		
		JLabel age_label = new JLabel("Age :");
		age_label.setHorizontalAlignment(SwingConstants.CENTER);
		age_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel.add(age_label, "cell 1 4,alignx left,aligny center");
		
		age_user = new JLabel("");
		age_user.setForeground(Color.RED);
		age_user.setHorizontalAlignment(SwingConstants.CENTER);
		age_user.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel.add(age_user, "cell 3 4,alignx left,aligny center");
		
		JLabel weight_label = new JLabel("Weight :");
		weight_label.setHorizontalAlignment(SwingConstants.CENTER);
		weight_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel.add(weight_label, "cell 6 4,alignx left,aligny center");
		
		weight_user = new JLabel("");
		weight_user.setForeground(Color.RED);
		weight_user.setHorizontalAlignment(SwingConstants.CENTER);
		weight_user.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel.add(weight_user, "cell 8 4");
		
		JLabel userPageTtile_label = new JLabel("User Page");
		userPageTtile_label.setHorizontalAlignment(SwingConstants.CENTER);
		userPageTtile_label.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		userPageTtile_label.setBounds(10, 23, 862, 33);
		add(userPageTtile_label);
		
		JPanel panel_userLoad = new JPanel();
		panel_userLoad.setBounds(10, 79, 862, 49);
		add(panel_userLoad);
		panel_userLoad.setLayout(new MigLayout("", "[][150][][][246.00]", "[33.00]"));
		panel_userLoad.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.gray));
		
		JLabel userId_label = new JLabel("Enter user ID :");
		userId_label.setHorizontalAlignment(SwingConstants.CENTER);
		userId_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel_userLoad.add(userId_label, "cell 0 0,alignx trailing,aligny center");
		
		userId_input = new JTextField();
		userId_input.setHorizontalAlignment(SwingConstants.CENTER);
		panel_userLoad.add(userId_input, "cell 1 0,alignx center,aligny center");
		userId_input.setColumns(15);
		
		
		
		loadUserDataButton = new JButton("Load");

		loadUserDataButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel_userLoad.add(loadUserDataButton, "cell 2 0,alignx center,aligny center");
		
		loadAlertLabel = new JLabel("Invalid input. Please enter digits only!");
		loadAlertLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		loadAlertLabel.setHorizontalAlignment(SwingConstants.LEFT);
		loadAlertLabel.setVisible(false);
		panel_userLoad.add(loadAlertLabel, "cell 4 0,aligny center");
		
		
		
		addNewMealButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainView.openNewMealView();
			}
		});
		
		loadUserDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!userId_input.getText().isEmpty()) {
					loadAlertLabel.setVisible(false);
					String id = userId_input.getText().toString();
					if (id.matches("[0-9]+")) {
						mainView.setRequest("getUserById", id);
					}else {
						loadAlertLabel.setVisible(true);
					}
					
				} else {
					loadAlertLabel.setVisible(true);
				}
			}
		});
		
		editMealButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Meal meal = mainView.user.getMeals().get(0);
//				mainView.user.removeMeal(meal);
				labelMeal_1.setText("");
				editMealButton_1.setEnabled(false);
				mainView.deleteMeal(0);

			}
		});
		
		editMealButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelMeal_2.setText("");
				editMealButton_2.setEnabled(false);
				mainView.deleteMeal(1);
			}
		});
		
		editMealButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelMeal_3.setText("");
				editMealButton_3.setEnabled(false);
				mainView.deleteMeal(2);
			}
		});
		
		editMealButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelMeal_4.setText("");
				editMealButton_4.setEnabled(false);
				mainView.deleteMeal(3);
			}
		});
		
		editMealButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelMeal_5.setText("");
				editMealButton_5.setEnabled(false);
				mainView.deleteMeal(4);
			}
		});
		
		editMealButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelMeal_6.setText("");
				editMealButton_6.setEnabled(false);
				mainView.deleteMeal(5);
			}
		});

	}
	
	public void setUser(User user) {
		if (user != null) {
			String id = user.getId().toString();
			String name = user.getName();
			Integer intAge = user.getAge();
			String age = intAge.toString();
			Integer intheight = user.getHeight();
			String height = intheight.toString();
			String weight = user.getWeight().toString();
			Integer gender = user.getGender();
			String bmr = user.getBmr().toString();

			this.id_user.setText(id);
			this.name_user.setText(name);
			this.age_user.setText(age);
			this.height_user.setText(height);
			this.weight_user.setText(weight);
			this.bmr_user.setText(bmr);
			if (gender == 1) this.gender_user.setText("Male");
			if (gender == 0) this.gender_user.setText("Female");

			numOfMeals = user.getMeals().size();
			if (numOfMeals < 6) this.loadUserDataButton.setEnabled(true);
			if (numOfMeals >= 1) {
				this.editMealButton_1.setEnabled(true);
				this.labelMeal_1.setText(user.getMeals().get(0).toString());
			}
			if (numOfMeals >= 2) {
				this.editMealButton_2.setEnabled(true);
				this.labelMeal_2.setText(user.getMeals().get(1).toString());

			}
			if (numOfMeals >= 3) {
				this.editMealButton_3.setEnabled(true);
				this.labelMeal_3.setText(user.getMeals().get(2).toString());

			}
			if (numOfMeals >= 4) {
				this.editMealButton_4.setEnabled(true);
				this.labelMeal_4.setText(user.getMeals().get(3).toString());

			}
			if (numOfMeals >= 5) {
				this.editMealButton_5.setEnabled(true);
				this.labelMeal_5.setText(user.getMeals().get(4).toString());

			}
			if (numOfMeals >= 6) {
				this.editMealButton_6.setEnabled(true);
				this.labelMeal_6.setText(user.getMeals().get(5).toString());

			}
			addNewMealButton.setEnabled(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
