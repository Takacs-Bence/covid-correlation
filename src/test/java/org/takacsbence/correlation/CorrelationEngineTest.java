package org.takacsbence.correlation;

import org.junit.Assert;
import org.junit.Test;

public class CorrelationEngineTest {

    @Test
    public void testBlackBox() {
        // arrange
        double[] x = {0.1, 0.2, 0.3, 0.4};
        double[] y = {0.2, 0.4, 0.6, 0.8};
        double[][] xy = {x, y};
        // act
        double correlation = CorrelationEngine.doCalculate(xy);
        // assert
        Assert.assertEquals(1.0, correlation, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkDimensions() {
        // arrange
        double[] x = {0.1, 0.2, 0.3, 0.4};
        double[] y = {0.2, 0.4, 0.6, 0.8};
        double[] z = {0.05, 0.3, 0.45, 0.6};
        double[][] xyz = {x, y, z};
        // act
        CorrelationEngine.doCalculate(xyz);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInputArrayLengths() {
        // arrange
        double[] x = {0.1, 0.2, 0.3, 0.4};
        double[] y = {0.2, 0.4, 0.6, 0.8, 1.0};
        double[][] xyz = {x, y};
        // act
        CorrelationEngine.doCalculate(xyz);
    }

}
