package org.jboss.jdf.ticketmonster.test.page;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

public class TicketMonsterPage {

    @FindBy(id = "content")
    private WebElement content;
    @FindBy(className = "special-title")
    private WebElement pageHeader;

    public String getTitle() {
        return pageHeader.getText();
    }

    public void waitUntilPageIsLoaded() {
        Graphene.waitGui()
                .until()
                .element(content)
                .is()
                .present();
    }

}
