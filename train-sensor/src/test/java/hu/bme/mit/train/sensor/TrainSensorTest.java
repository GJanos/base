package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.TrainControllerImpl;
import hu.bme.mit.train.TrainSensorImpl;
import hu.bme.mit.train.TrainUserImpl;

public class TrainSensorTest {

    
    TrainUser mockTrainUser;
    
    TrainController mockController;

    TrainSensorImpl trainSensor;


    @Before
    public void setUp() {
        mockTrainUser = mock(TrainUser.class);
        mockController = mock(TrainController.class);
        trainSensor = new TrainSensor(mockController, mockTrainUser);
    }

    @Test
    public void TestOverBoundSpeedLimitFromReferenceSpeed() {
        
    }
}
