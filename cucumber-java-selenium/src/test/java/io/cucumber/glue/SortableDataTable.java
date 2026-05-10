package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.pages.SortableDataTablePage;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class SortableDataTable extends Context {

    public SortableDataTable(Manager manager) {
        super(manager);
    }

    private final SortableDataTablePage sortableDataTablePage = new SortableDataTablePage(this.getDriver());

    @And("^the header title is '(.+)'$")
    public void getHeader(String expectedHeader) {
        Assert.assertEquals("Header validation", expectedHeader, sortableDataTablePage.getTitleHeader());
    }

    @Then("the Example table displays the following results:")
    public void validateTable(DataTable dataTable) {
        List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);
        Map<String, String> actualRowData;
        Map<String, String> expectedRowData;

        for (int i = 0; i < expectedData.size(); i++) {
            actualRowData = sortableDataTablePage.getTableRow(i+1);
            Assert.assertFalse("Actual row data validation", actualRowData.isEmpty());
            expectedRowData = expectedData.get(i);

            // Row values validation
            Assert.assertEquals("Last Name validation", actualRowData.get("Last Name"), expectedRowData.get("Last Name"));
            Assert.assertEquals("First Name validation", actualRowData.get("First Name"), expectedRowData.get("First Name"));
            Assert.assertEquals("Email validation", actualRowData.get("Email"), expectedRowData.get("Email"));
            Assert.assertEquals("Due validation", actualRowData.get("Due"), expectedRowData.get("Due"));
            Assert.assertEquals("Web Site validation", actualRowData.get("Web Site"), expectedRowData.get("Web Site"));
        }
    }
}
