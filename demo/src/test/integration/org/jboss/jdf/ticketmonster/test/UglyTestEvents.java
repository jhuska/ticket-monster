package org.jboss.jdf.ticketmonster.test;

import junit.framework.Assert;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@RunWith(Arquillian.class)
public class UglyTestEvents extends AbstractTicketMonsterTest {

    // events
    @FindBy(jquery = "a[data-target='#category-1-collapsible']")
    private WebElement concertHeader;
    @FindBy(css = "#category-1-collapsible")
    private WebElement concertMenu;
    @FindBy(jquery = "a[data-original-title='Rock concert of the decade']")
    private WebElement concertLink;

    // events/1
    @FindBy(css = "#venueSelector")
    private Select venueSelect;
    @FindBy(css = "#bookingWhen")
    private WebElement booking;
    @FindBy(name = "bookButton")
    private WebElement bookButton;

    // book/1/1
    @FindBy(id = "sectionSelect")
    private Select sectionSelect;
    @FindBy(name = "tickets-1")
    private WebElement numberOfTickets;
    @FindBy(name = "add")
    private WebElement addButton;
    @FindBy(className = "icon-trash")
    private WebElement trash;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(name = "submit")
    private WebElement checkout;

    @FindBy(className = "special-title")
    private WebElement pageHeader;

    @Override
    protected String getPagePath() {
        return "#events";
    }

    @Test
    public void testClickOnConcerts() {
        // wait until the page is loaded
        Graphene.waitGui()
                .until()
                .element(concertMenu)
                .is()
                .present();
        // test
        Assert.assertEquals(concertMenu.getAttribute("style"), "height: 0px;");
        concertHeader.click();
        Graphene.waitGui()
                .until()
                .element(concertMenu)
                .attribute("style")
                .not()
                .equalTo("height: 0px;");
    }

    @Test
    public void testBookConcert() {
        // wait until the page is loaded
//        Graphene.waitGui()
//                .until()
//                .element(concertMenu)
//                .is()
//                .present();
//        // show concerts submenu
        concertHeader.click();
//        Graphene.waitGui()
//                .until()
//                .element(concertMenu)
//                .attribute("style")
//                .not()
//                .equalTo("height: 0px;");
        // select concert
//        Graphene.guardAjax
        (concertLink).click();
        // select venue
        Assert.assertFalse(booking.isDisplayed());
        venueSelect.selectByVisibleText("Toronto : Roy Thomson Hall");
//        Graphene.waitGui()
//                .until()
//                .element(booking)
//                .is()
//                .visible();
        // book
//        Graphene.guardAjax
        (bookButton).click();
        // select tickets
        sectionSelect.selectByVisibleText("A - Premier platinum reserve");
//        Graphene.waitGui()
//                .until()
//                .element(numberOfTickets)
//                .is()
//                .present();
        numberOfTickets.click();
        numberOfTickets.sendKeys("2");
        addButton.click();
//        Graphene.waitGui()
//                .until()
//                .element(trash)
//                .is()
//                .present();
        // checkout
        email.click();
        email.sendKeys("example@example.com");
//        Graphene.guardAjax
        (checkout).click();
        // check correct page
        Assert.assertEquals("Booking #1 confirmed!", pageHeader.getText());
    }

}