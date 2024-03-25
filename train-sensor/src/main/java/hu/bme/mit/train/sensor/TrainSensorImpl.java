package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private Table<Long, Integer, Integer> tachoGraphTable = HashBasedTable.create();

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);

		boolean notInAlarm = false;
		boolean inAlarm = true;

		if(this.speedLimit < 0 || this.speedLimit > 500){
			user.setAlarmState(inAlarm);
		}
		else if(this.speedLimit < (getReferenceSpeed() / 2)){
			user.setAlarmState(inAlarm);
		}
		else{
			user.setAlarmState(notInAlarm);
		}

	}

	@Override
	public void ModifyTachoGraph(Long time, Integer JoystickPosition, Integer ReferenceSpeed) {
		tachoGraphTable.put(time, JoystickPosition, ReferenceSpeed);
	}

	@Override
	public int getSize() {
		return tachoGraphTable.size();
	}
}