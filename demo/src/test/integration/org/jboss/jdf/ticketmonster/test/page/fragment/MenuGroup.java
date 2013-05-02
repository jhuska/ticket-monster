package org.jboss.jdf.ticketmonster.test.page.fragment;

import java.util.List;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.spi.annotations.Root;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.base.Predicate;

public class MenuGroup {

    @Root
    public WebElement root;

    @FindBy(tagName = "p")
    private List<MenuItem> menuItems;

    @FindBy(className = "accordion-heading")
    private WebElement groupHeading;

    @FindBy(className = "accordion-toggle")
    private WebElement groupToggler;

    public void expand() {
        if (!isExpanded()) {
            groupToggler.click();
            Graphene.waitGui().until(new Predicate<WebDriver>() {
                @Override
                public boolean apply(WebDriver input) {
                    return isExpanded();
                }
            });
        }
    }

    public void collapse() {
        if (isExpanded()) {
            groupToggler.click();
            Graphene.waitGui().until(new Predicate<WebDriver>() {
                @Override
                public boolean apply(WebDriver input) {
                    return isExpanded();
                }
            });
        }
    }

    public boolean isExpanded() {
        try {
            root.findElement(By.className("in"));
        } catch (NoSuchElementException ex) {
            //expanded menu group contains element with class in
            return false;
        }
        return true;
    }

    public MenuItem getMenuItem(String linkText) {
        MenuItem result = null;
        for (MenuItem i : menuItems) {
            if (i.getText().trim().equals(linkText)) {
                result = i;
            }
        }
        return result;
    }

    public MenuItem getMenuItem(int order) {
        return menuItems.get(order);
    }

    public String getHeader() {
        return groupHeading.getText();
    }
}
