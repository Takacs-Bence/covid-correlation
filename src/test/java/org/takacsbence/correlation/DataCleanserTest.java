package org.takacsbence.correlation;

import org.junit.Assert;
import org.junit.Test;
import org.takacsbence.model.Cases;
import org.takacsbence.model.Vaccines;

import java.util.HashMap;
import java.util.Map;

public class DataCleanserTest {

    DataCleanser<Cases, Vaccines> target = new DataCleanser<Cases, Vaccines>() {
    };

    @Test
    public void testClean() {

        // arrange
        Map<String, Cases> subCase = new HashMap<>();
        subCase.put("JustTest", new Cases());
        subCase.put("JustTest2", new Cases());

        Map<String, Map<String, Cases>> cases = new HashMap<>();
        cases.put("Key1", subCase);
        cases.put("Key2", subCase);
        cases.put("Key5", subCase);
        cases.put("World", subCase);

        Map<String, Vaccines> subVacc = new HashMap<>();
        subVacc.put("JustTest", new Vaccines());
        subVacc.put("JustTest2", new Vaccines());

        Map<String, Map<String, Vaccines>> vaccines = new HashMap<>();
        vaccines.put("Key1", subVacc);
        vaccines.put("Key2", subVacc);
        vaccines.put("Key3", subVacc);
        vaccines.put("Key4", subVacc);
        vaccines.put("Key5", subVacc);
        vaccines.put("Global", subVacc);

        // act
        target.clean(cases, vaccines);

        // assert
        Assert.assertEquals(cases.size(), vaccines.size());
        Assert.assertEquals(cases.size(), 3);
    }

}
