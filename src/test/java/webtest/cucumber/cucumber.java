package webtest.cucumber;

import webtest.base.BaseStepdef;
import org.junit.After;

public class cucumber {
    @After
    public void tearDown() {
        if (BaseStepdef.driver != null) {
            BaseStepdef.driver.quit();
        }
    }
}