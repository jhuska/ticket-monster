package org.jboss.jdf.ticketmonster.test;

import static junit.framework.Assert.assertEquals;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.jdf.ticketmonster.test.page.Events;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class ITTestHelloWorld {

    @Drone
    private WebDriver browser;

    @Page
    private Events eventsPage;
    
    @Test
    public void testHelloWorldFromGraphene() {
        browser.get("http://localhost:8080/ticket-monster");

        assertEquals("Ticket Monster", browser.getTitle());
    }
    
    @Test
    public void testTransitionToBookingPage() {
        browser.get("http://localhost:8080/ticket-monster/#events");
        
        eventsPage.waitUntilPageIsLoaded();
        eventsPage.toggleConcerts();
        eventsPage.goToConcert("Rock concert of the decade");

        
    }
}
