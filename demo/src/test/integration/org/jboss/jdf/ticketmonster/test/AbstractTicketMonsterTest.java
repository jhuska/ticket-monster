package org.jboss.jdf.ticketmonster.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class AbstractTicketMonsterTest {

    // @ArquillianResource
    protected URL contextRoot;

    @Drone
    protected WebDriver browser;

    // @Deployment(testable = false)
    public static WebArchive createTestArchive() {

        WebArchive war = ShrinkWrap.createFromZipFile(WebArchive.class, new File("target/ticket-monster.war"));
        return war;
    }

    @Before
    public void initializePageUrl() throws MalformedURLException {
        browser.get("http://localhost:8080/ticket-monster/" + getPagePath());
    }

    protected abstract String getPagePath();

}
