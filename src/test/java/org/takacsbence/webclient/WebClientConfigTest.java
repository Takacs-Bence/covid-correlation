package org.takacsbence.webclient;

import org.junit.Assert;
import org.junit.Test;

public class WebClientConfigTest {

    @Test
    public void testCovidConfigRead() {
        WebClientConfig target = WebClientConfig.getInstance();
        Assert.assertTrue(target.getVersion("covidClient") > 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notExistingClientItemException() {
        WebClientConfig target = WebClientConfig.getInstance();
        ClientItem notExisting = target.get("notExisting");
    }

}
