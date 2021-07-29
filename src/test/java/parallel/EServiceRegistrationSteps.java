package parallel;

import com.pages.eServiceRegistrationPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EServiceRegistrationSteps {
    private eServiceRegistrationPage eServiceRegistrationPage = new eServiceRegistrationPage(DriverFactory.getDriver());
    @Given("user navigates to eService Registration page")
    public void userNavigatesToEServiceRegistrationPage() {
        DriverFactory.getDriver().get("http://eservices.scd.gov.ae/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eServiceRegistrationPage.clickRegisterBtn1();

    }

    @And("user clicks on Register button")
    public void userClicksOnRegisterButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eServiceRegistrationPage.clickRegisterBtn();
    }

    @Then("it shows a successful message as {string}")
    public void itShowsASuccessfulMessageAs(String arg0) {
    }


    @When("Enter Registration details from sheetname {string} and rownumber {int}")
    public void enter_registration_details_from_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        String path = System.getProperty("user.dir");
        System.out.println("Path is:" +path);
        //List<Map<String,String>> testData =reader.getData(path+"\\SCDRegistration.xlsx",sheetName); ;
        List<Map<String,String>> testData =
                reader.getData("D:\\Selenium\\AUTOMATIONCODE\\LatestCucumber6WithPOM-master\\SCDRegistration.xlsx", sheetName);

        try {
            System.out.println("Hi");

        } catch (Exception e) {
            e.printStackTrace();

        }

        String Name = testData.get(rowNumber).get("Name");
        System.out.println("Name is : "+Name);
        String Surname = testData.get(rowNumber).get("Surname");
        System.out.println("Surname is : "+Surname);
        String EmailAddress = testData.get(rowNumber).get("EmailAddress");
        String UserName = testData.get(rowNumber).get("UserName");
        String Password = testData.get(rowNumber).get("Password");
        eServiceRegistrationPage.fillContactUsForm(Name,Surname,EmailAddress,UserName,Password);
        throw new io.cucumber.java.PendingException();
    }
}
