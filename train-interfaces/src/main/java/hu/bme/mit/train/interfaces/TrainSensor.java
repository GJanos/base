package hu.bme.mit.train.interfaces;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	void ModifyTachoGraph(Long time, Integer JoystickPosition, Integer ReferenceSpeed);

	int getSize();
}
