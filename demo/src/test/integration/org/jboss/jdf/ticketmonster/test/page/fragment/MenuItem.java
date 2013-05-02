package org.jboss.jdf.ticketmonster.test.page.fragment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuItem {

    @FindBy(tagName = "a")
    private WebElement menuItemLink;

    public void toggle() {
        menuItemLink.click();
    }
    
    public String getText() {
        return menuItemLink.getText();
    }
}
