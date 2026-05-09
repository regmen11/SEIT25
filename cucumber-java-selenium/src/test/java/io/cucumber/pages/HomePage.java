package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Page {

    public HomePage(ChromeDriver driver) {
        super(driver);
        //System.out.println("Homepage title is : " + getTitle().getText());
    }

    @FindBy(xpath = "//h1[@class='heading']")
    private WebElement title;

    private By listOfExamples = By.xpath("//div[@id='content']//ul//li");

    public void refresh() {
        driver.navigate().refresh();
        System.out.println("Refreshed page");
    }

    public void navigateToHomePage(String url) {
        driver.get(url);
    }

    public String getTitleHeader() {
        return title.getText();
    }

    public List<String> getAvailableExamples() {
        List<WebElement> elements = driver.findElements(listOfExamples);
        List<String> textList = new ArrayList<>();
        //int ctr = 0;

        for (WebElement element : elements) {
            //System.out.println("***ACTUAL " + ctr + ": " + element.getText().trim());
            //ctr++;
            textList.add(element.getText().trim());
        }

        return textList;
    }

    public boolean validateExampleName(String exampleName) {
        String exampleLoc = "//a[contains(text(),'" + exampleName + "')]";
        return driver.findElement(By.xpath(exampleLoc)).isDisplayed();
    }

    // Since Basic Auth is a browser prompt, navigate using the URL format
    // Unable to inspect browser prompt
    public void loginWithCredentials(String username, String password, String exampleName) {
        String url = "https://" + username + ":" + password + "@the-internet.herokuapp.com/" + exampleName;
        driver.get(url);
    }

}
