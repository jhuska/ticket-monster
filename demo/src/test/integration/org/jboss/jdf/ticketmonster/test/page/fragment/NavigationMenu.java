package org.jboss.jdf.ticketmonster.test.page.fragment;

import java.util.List;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

public class NavigationMenu {

    @FindBy(className = "accordion-group")
    private WebElement toWait;

    @FindBy(className = "accordion-group")
    private List<MenuGroup> menuGroups;

    public void waitUntilMenuIsLoaded() {
        Graphene.waitGui()
                .until()
                .element(toWait)
                .is()
                .present();
    }

    public MenuGroup getMenuGroup(int order) {
        return menuGroups.get(order);
    }

    public MenuGroup getMenuGroup(String header) {
        MenuGroup result = null;
        for (MenuGroup i : menuGroups) {
            if (i.getHeader().trim().equals(header)) {
                result = i;
            }
        }
        return result;
    }
}