package parallel;

import com.pages.eServicePortal;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class EServiceSteps {
    private eServicePortal eServicePortal = new eServicePortal(DriverFactory.getDriver());
    private static String title;
    @Given("user has already logged in to eService application")
    public void userHasAlreadyLoggedInToEServiceApplication(DataTable credTable) {
        System.out.println("Code worked upto here....");
        DriverFactory.getDriver()
                .get("http://eservices.scd.gov.ae/");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Map<String,String>> credList = credTable.asMaps();
        String username = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        eServicePortal.doLogin(username, password);
    }
    @Given("user is on eService page")
    public void user_is_on_eService_page() {
        String title = eServicePortal.geteServicePageTitle();
        System.out.println("eService Page ; is: " + title);
    }
    @When("user gets the Title of the page")
    public void userGetsTheTitleOfThePage() {
        title = eServicePortal.geteServicePageTitle();
        System.out.println("Page title is: " + title);
    }
    @Then("page Title should be {string}")
    public void pageTitleShouldBe(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }


}
