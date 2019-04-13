import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcercisePerformanceTest {

    @Test
    public void CheckDateIsNotNULL() {
      ExcercisePerformance ep=new ExcercisePerformance(5,"morning");
        Assert.assertNotNull(ep.getDate());
    }
}