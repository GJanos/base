package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import java.lang.Thread;
import java.lang.InterruptedException;

public class TrainSystem extends Thread{

	private TrainController controller = new TrainControllerImpl();
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);

	public TrainSystem() {
		
			start();
		
	}

	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}

	@Override
    public void run()
    {
		try {
			while(true) {
			user.overrideJoystickPosition(user.getJoystickPosition());
        	Thread.sleep(2000);
        }
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
        
    }
	

}
