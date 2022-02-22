package org.takacsbence.webclient;

import org.junit.Test;

public class WebAgentTest {

    @Test(expected = IllegalArgumentException.class)
    public void notSupportedHttpMethodUsed() {
        WebAgent target = new WebAgent("", 1);
        target.executeClientCall("/test", "POST");
    }
}
