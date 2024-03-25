package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorTest {

    
    TrainUser mockTrainUser;
    
    TrainController mockController;

    TrainSensorImpl trainSensor;


    @Before
    public void setUp() {
        mockTrainUser = mock(TrainUser.class);
        mockController = mock(TrainController.class);
        trainSensor = new TrainSensorImpl(mockController, mockTrainUser);
    }

    @Test
    public void TestOverBoundSpeedLimit() {
        trainSensor.overrideSpeedLimit(600);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void TestUnderBoundSpeedLimit() {
        trainSensor.overrideSpeedLimit(-10);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }


    @Test
    public void TestSpeedLimitLowerThanHalfOfReferenceSpeed(){
        when(mockController.getReferenceSpeed()).thenReturn(200);
        trainSensor.overrideSpeedLimit(50);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void TestSpeedLimitHigherThanHalfOfReferenceSpeed(){
        when(mockController.getReferenceSpeed()).thenReturn(75);
        trainSensor.overrideSpeedLimit(50);
        verify(mockTrainUser, times(1)).setAlarmState(false);
    }
}
