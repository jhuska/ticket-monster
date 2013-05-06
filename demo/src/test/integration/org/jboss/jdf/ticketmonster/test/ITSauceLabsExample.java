package org.jboss.jdf.ticketmonster.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class ITSauceLabsExample {

    @Drone
    private WebDriver driver;
    
    @Test
    public void webDriver() throws Exception {
        driver.get("http://ticketmonster-jdf.rhcloud.com/#about");
    }
}
