package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortableDataTablePage extends Page {

    public SortableDataTablePage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='content']//h3")
    private WebElement title;

    public String getTitleHeader() {
        return title.getText();
    }

    public Map<String, String> getTableRow(int rowNumber) {
        Map<String, String> rowData = new HashMap<>();
        String cellValue = "";
        String header = "";

        List<WebElement> tableHeader = driver.findElements(By.xpath("//table[@id='table1']//th"));
        // table number could also be a variable/parameter to be more flexible in the xpath
        String rowLoc = String.format("//table[@id='table1']/tbody/tr[%d]", rowNumber);
        List<WebElement> rowCells = driver.findElements(By.xpath(rowLoc + "/td"));

        //check if cells has value
        if (rowCells.isEmpty()) {
            return rowData; // test file will handle assertion if empty
        }

        //iterate through row values
        for (int i = 0; i < rowCells.size(); i++) {
            header = tableHeader.get(i).getText().trim();
            cellValue = rowCells.get(i).getText().trim();
            rowData.put(header, cellValue);
        }

        return rowData;
    }
}
