package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import java.util.*;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private Timer timer;
	private TimerTask timerTask;
	private boolean alarmState;

	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
		this.timer = new Timer();
		this.timerTask = new TimerTask() {  
			@Override  
			public void run() {  
				overrideJoystickPosition(getJoystickPosition());
			}
		};
		this.timer.scheduleAtFixedRate(this.timerTask,1000,1000); 
	}

	@Override
	public boolean getAlarmFlag() {
		return false;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;
		controller.setJoystickPosition(joystickPosition);	
	}

	@Override
	public void emergencyBreak() {
		controller.setSpeedLimit(0);
	}

	@Override
	public boolean getAlarmState(){
		return alarmState;
	}
	@Override
	public void setAlarmState(boolean alarmState){
		this.alarmState = alarmState;
	}

}
