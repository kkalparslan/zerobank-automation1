package com.zerobank.stepDefinitions;


import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){

        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }
    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        BrowserUtils.waitFor(3);
        Driver.closeDriver();

    }
    @Before("@db")
    public void setUpDb(){
        System.out.println("\t Connecting DB");
    }
    @After("@db")
    public void tearDownDb(){
        System.out.println("\t Disconnecting DB");
    }
}
