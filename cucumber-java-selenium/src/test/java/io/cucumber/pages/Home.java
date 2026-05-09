package io.cucumber.pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class Home extends Page {

  public Home(ChromeDriver driver) {
    super(driver);
    //System.out.println("Homepage title is : " + getTitle().getText());
  }

}
