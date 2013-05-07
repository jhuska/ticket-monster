package org.jboss.jdf.ticketmonster.test.page;

import static org.jboss.arquillian.graphene.Graphene.guardAjax;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.jdf.ticketmonster.test.page.fragment.MenuGroup;
import org.jboss.jdf.ticketmonster.test.page.fragment.NavigationMenu;
import org.openqa.selenium.WebElement;

public class Events extends TicketMonsterPage {

    @FindBy(id = "itemMenu")
    private NavigationMenu verticalMenu;

    @FindBy(className = "special-title")
    private WebElement titleOfTheConcert;

    @Override
    public void waitUntilPageIsLoaded() {
        verticalMenu.waitUntilMenuIsLoaded();
    }

    public void toggleConcerts() {
        verticalMenu.getMenuGroup(0).expand();
    }

    public boolean areConcertsExpanded() {
        return verticalMenu.getMenuGroup(0).isExpanded();
    }

    public void goToConcert(final String concert) {
        MenuGroup concerts = verticalMenu.getMenuGroup(0);
        guardAjax(concerts.getMenuItem(concert)).toggle();
    }

}
