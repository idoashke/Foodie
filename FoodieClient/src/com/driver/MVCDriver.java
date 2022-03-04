package com.driver;

import com.controller.IController;
import com.controller.MyController;
import com.model.IModel;
import com.model.MyModel;
import com.view.IView;
import com.view.MainView;

public class MVCDriver {

	public static void main(String[] args) {
		
		IModel model = new MyModel();
		IView view = new MainView();
		IController controller = new MyController(model, view);
		
		((MyModel)model).addObserver(controller);
		((MainView)view).addObserver(controller);	
		
		view.start();
	}

}