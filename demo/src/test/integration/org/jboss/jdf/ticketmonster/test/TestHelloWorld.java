package org.jboss.jdf.ticketmonster.test;

import java.net.URL;

import junit.framework.Assert;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class TestHelloWorld {

    @Drone
    private WebDriver browser;

    @Before
    public void loadPage() {
        URL page = this.getClass().getClassLoader().getResource("org/jboss/arquillian/graphene/tutorial/helloworld.html");
        browser.get(page.toString());
    }

    @Test
    public void testHelloWorld() {
        Assert.assertEquals("Hello World!", browser.getTitle());
        Graphene.waitGui()
                .until()
                .element(By.tagName("h1"))
                .text()
                .equalTo("Hello Developer Conference!");
    }

}
