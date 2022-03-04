package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.dm.Food;
import com.dm.Meal;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class NewMealScreen extends JPanel implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private JTextField mealName_input;
	private JTextField foodName_input;
	private MainView mainView;
	private JButton saveButton;
	private JButton cancelButton;
	private Meal meal;
	private JList list;
	JLabel alertLabel;
	DefaultListModel<Food> demoList;
	JTextArea mealDetailsTextArea;
	private JPanel panel;
	private JComboBox comboBox;
	private JScrollPane scrollPane_1;
	private JButton showAllFoodButton;
	
	
	public NewMealScreen(MainView mainView) {
		this.mainView = mainView;
		meal = new Meal();
		initNewMealScreen();
	}

	public void initNewMealScreen() {
		setPreferredSize(new Dimension(627, 491));
		setLayout(null);
		
		JLabel userPageTtile_label = new JLabel("New Meal");
		userPageTtile_label.setBounds(10, 10, 610, 33);
		userPageTtile_label.setHorizontalAlignment(SwingConstants.CENTER);
		userPageTtile_label.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		add(userPageTtile_label);
		
		JLabel mealName_label = new JLabel("Meal name :");
		mealName_label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		mealName_label.setBounds(28, 82, 85, 13);
		add(mealName_label);
		
		mealName_input = new JTextField();
		mealName_input.setBounds(120, 79, 165, 19);
		add(mealName_input);
		mealName_input.setColumns(10);
		
		saveButton = new JButton("Save");

		saveButton.setBounds(523, 459, 85, 21);
		add(saveButton);
		
		cancelButton = new JButton("Cancel");

		cancelButton.setBounds(20, 459, 85, 21);
		add(cancelButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Foods", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(14, 152, 411, 213);
		add(panel_1);
		panel_1.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(6, 15, 399, 198);
//		panel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.gray));
		panel_1.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Search food by:");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(28, 121, 107, 21);
		add(lblNewLabel_1);
		
		foodName_input = new JTextField();
		foodName_input.setColumns(10);
		foodName_input.setBounds(300, 121, 165, 19);
		add(foodName_input);
		
		JButton searchFoodButton = new JButton("Search");

		searchFoodButton.setBounds(489, 120, 85, 21);
		add(searchFoodButton);
		
		JButton addFoodButton = new JButton("Add food");


		addFoodButton.setBounds(476, 228, 85, 59);
		add(addFoodButton);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		alertLabel = new JLabel("");
		alertLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		alertLabel.setHorizontalAlignment(SwingConstants.CENTER);
		alertLabel.setBounds(10, 462, 610, 13);
		add(alertLabel);

		
		list = new JList();
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		DefaultListModel<String> demoList = new DefaultListModel<String>();
		demoList = new DefaultListModel<Food>();
		demoList.setSize(5);
		list.setModel(demoList);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 375, 405, 56);
		add(scrollPane_1);
		
		mealDetailsTextArea = new JTextArea();
		mealDetailsTextArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane_1.setViewportView(mealDetailsTextArea);
		mealDetailsTextArea.setEditable(false);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(142, 121, 148, 21);
		comboBox.addItem("Name");
		comboBox.addItem("Calories - Max");
		comboBox.addItem("Calories - Min");
		comboBox.addItem("Protein - Max");
		comboBox.addItem("Protein - Min");
		comboBox.addItem("Carbs - Max");
		comboBox.addItem("Carbs - Min");
		comboBox.addItem("Fat - Max");
		comboBox.addItem("Fat - Min");
		comboBox.addItem("Sugars - Max");
		comboBox.addItem("Sugars - Min");
		add(comboBox);
		
		showAllFoodButton = new JButton("Show all food");
		showAllFoodButton.setBounds(476, 148, 113, 21);
		add(showAllFoodButton);
		
		
		showAllFoodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				demoList.clear();
				mainView.setRequest("getAllFoods" , null);
			}
		});


		searchFoodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				demoList.clear();
				if (!foodName_input.getText().isEmpty()) {
					String searchBy = comboBox.getSelectedItem().toString();
					String value = foodName_input.getText().toString();
					String header;
					switch(searchBy) {
					case "Name":
						header = "getFoodByName";
						break;
					case "Calories - Max":
						header = "getFoodByCalMax";
						break;
					case "Calories - Min":
						header = "getFoodByCalMin";
						break;
					case "Protein - Max":
						header = "getFoodByProMax";
						break;
					case "Protein - Min":
						header = "getFoodByProMin";
						break;
					case "Carbs - Max":
						header = "getFoodByCarbsMax";
						break;
					case "Carbs - Min":
						header = "getFoodByCarbsMin";
						break;
					case "Fat - Max":
						header = "getFoodByFatMax";
						break;
					case "Fat - Min":
						header = "getFoodByFatMin";
						break;
					case "Sugars - Max":
						header = "getFoodBySugMax";
						break;
					case "Sugars - Min":
						header = "getFoodBySugMin";
						break;
					default:
						header = "getFoodByName";
					}
					mainView.setRequest(header , value);
				}
			}
		});
		
		addFoodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Food food = (Food) list.getSelectedValue();
				meal.addFood(food);
				mealDetailsTextArea.setText(meal.toString());
				alertLabel.setText("Food was added successfully!");
			}
		});
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!mealName_input.getText().isEmpty()) {
					meal.setName(mealName_input.getText().toString());
				} else {
					meal.setName("DefaultMealName");
				}
				mainView.addNewMeal(meal);
				alertLabel.setText("Meal was added successfully!");
				saveButton.setEnabled(false);
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainView.returnToExistingUserView();
			}
		});

	}
	
	public void setFoods(ArrayList<Food> foods) {
		for (Food food : foods) {
			demoList.addElement(food);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
