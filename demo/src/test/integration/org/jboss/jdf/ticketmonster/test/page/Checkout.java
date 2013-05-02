package org.jboss.jdf.ticketmonster.test.page;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Checkout extends TicketMonsterPage {

    @FindBy(id = "sectionSelect")
    private Select sectionSelect;
    @FindBy(name = "tickets-1")
    private WebElement numberOfTickets;
    @FindBy(name = "add")
    private WebElement addButton;
    @FindBy(className = "icon-trash")
    private WebElement trash;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(name = "submit")
    private WebElement checkout;

    public void addTickets(String section, int number) {
        sectionSelect.selectByVisibleText(section);
        Graphene.waitGui().until().element(numberOfTickets).is().present();
        numberOfTickets.click();
        numberOfTickets.sendKeys(Integer.toString(number));
        addButton.click();
        Graphene.waitGui().until().element(trash).is().present();
    }

    public void checkout(String email) {
        emailInput.click();
        emailInput.sendKeys(email);
        Graphene.guardXhr(checkout).click();
    }

}
