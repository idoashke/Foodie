import java.util.ArrayList;
import java.util.Scanner;

import com.dao.UserFileDao;
import com.dm.Food;
import com.dm.Meal;
import com.dm.User;
import com.service.FoodService;
import com.service.UserService;


public class tempMain {

	public static void main(String[] args) {
		FoodService foodService = new FoodService();
		UserService userService = new UserService();
//	    Scanner input = new Scanner(System.in);
//		System.out.println("Please enter your ID: ");
//		Long userId = input.nextLong();
//		System.out.println("Please enter your name: ");
//		String userName = input.next();
//		System.out.println("Please enter your age: ");
//		int userAge = input.nextInt();
//		System.out.println("Please enter your gender - Male = 1, Female = 0 : ");
//		Integer userGender = input.nextInt();
//		System.out.println("Please enter your height in cm: ");
//		int userHeight = input.nextInt();
//		System.out.println("Please enter your weight in kg: ");
//		Double userWeight = input.nextDouble();

		// User user = new User(userId, userName, userAge, userGender, userHeight,
		// userWeight);
		
		System.out.println();
		System.out.println("--------------- User save ---------------");
		long id = 313580458;
		User user = new User(id, "ido", 27, 1, 180, 74.0);
		userService.saveChanges(user);
		long anotherId = 45555555;
		User forJson = new User(anotherId, "david", 23, 1, 190, 80.0);
		userService.saveChanges(forJson);

		
//		System.out.println();
//		System.out.println("--------------- All foods ---------------");
//		ArrayList<Food> foods = new ArrayList<Food>(foodService.getAllFoods());
//		for (Food food : foods) {
//			System.out.println(food);
//		}

		System.out.println();
		System.out.println("--------------- Food by name ---------------");
		ArrayList<Food> foodsByName = new ArrayList<Food>(foodService.getFoodByName("chicken"));
		if (foodsByName.isEmpty()) {
			System.out.println("Food not found");
		} else {
			for (Food food : foodsByName) {
				System.out.println(food);
			}
		}
		
		
		System.out.println();
		System.out.println("--------------- Food by id ---------------");
		Food foodByid = new Food(foodService.getFoodById((long)1));
		System.out.println(foodByid);
		
		
		System.out.println();
		System.out.println("--------------- create a new meal and add it to user ---------------");
		Meal meal_1 = new Meal("BreakFast");
		ArrayList<Food> foodsForMeal_1 = new ArrayList<Food>(foodService.getFoodByName("chicken"));
		if (!foodsForMeal_1.isEmpty()) {
			for (Food food : foodsForMeal_1) meal_1.addFood(food);
		}
		System.out.println(meal_1);
		user.addMeal(meal_1);
		userService.saveChanges(user);
		
		
		System.out.println();
		System.out.println("--------------- read user data from users.json file (with meals) ---------------");
		System.out.println(userService.getUserById((long) 313580458));

	}

}
