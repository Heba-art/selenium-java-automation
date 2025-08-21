package com.mycompany.selenium_automation_project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.base.BaseTest;

public class SanityTests extends BaseTest {

    @Test
    public void placeholder() {
        // مجرد تيست فارغ حتى ما يوقف البناء
        Assert.assertTrue(true);
    }
}
