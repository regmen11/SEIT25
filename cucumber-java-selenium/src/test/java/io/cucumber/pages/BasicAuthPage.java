package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class BasicAuthPage extends Page{

    public BasicAuthPage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='content']//h3[contains(text(),'Basic Auth')]/following-sibling::p")
    private WebElement message;

    public String getMessage() {
        return message.getText();
    }
}
