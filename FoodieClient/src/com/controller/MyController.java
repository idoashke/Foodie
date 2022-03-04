package com.controller;

import java.util.Observable;

import com.model.IModel;
import com.model.MyModel;
import com.view.IView;
import com.view.IView;

@SuppressWarnings("deprecation")
public class MyController implements IController {

	private IModel model;
//	private IView view;
	private IView view;
	
	public MyController(IModel model, IView view) {
		this.model = model;
		this.view = view;
	}
	
	public void update(Observable o, Object arg) {
		if(o instanceof IView) {
			((MyModel)model).transferData((String) arg);
		}else if(o instanceof MyModel){
			view.setReturnedData((String) arg);
		}
	
	}
}
