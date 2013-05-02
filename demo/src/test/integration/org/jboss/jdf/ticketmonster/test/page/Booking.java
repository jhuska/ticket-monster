package org.jboss.jdf.ticketmonster.test.page;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Booking extends TicketMonsterPage {

    @FindBy(css = "#venueSelector")
    private Select venueSelect;
    @FindBy(css = "#bookingWhen")
    private WebElement booking;
    @FindBy(name = "bookButton")
    private WebElement bookButton;

    public void book() {
        Graphene.guardXhr(bookButton).click();
    }

    public void selectVenue(String venue) {
        venueSelect.selectByVisibleText("Toronto : Roy Thomson Hall");
        Graphene.waitGui()
                .until()
                .element(booking)
                .is()
                .visible();
    }

}
