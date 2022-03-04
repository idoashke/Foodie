package com.controller;

import java.util.Observable;
import java.util.Observer;

public interface IController extends Observer {
	public void update(Observable o, Object arg);

}
