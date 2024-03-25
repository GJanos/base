package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Mock
    private TrainUser mockTrainUser;
    @Mock
    private TrainController mockController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TestOverBoundSpeedLimitFromReferenceSpeed() {
        
    }
}
