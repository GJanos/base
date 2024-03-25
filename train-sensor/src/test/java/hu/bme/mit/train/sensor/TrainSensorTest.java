package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.interfaces.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainSensorImpl;
import hu.bme.mit.train.interfaces.TrainUserImpl;

public class TrainSensorTest {

    
    TrainUserImpl mockTrainUser;
    
    TrainControllerImpl mockController;

    TrainSensorImpl trainSensor;


    @Before
    public void setUp() {
        mockTrainUser = mock(TrainUserImpl.class);
        mockController = mock(TrainControllerImpl.class);
        trainSensor = new TrainSensor(mockController, mockTrainUser);
    }

    @Test
    public void TestOverBoundSpeedLimitFromReferenceSpeed() {
        
    }
}
