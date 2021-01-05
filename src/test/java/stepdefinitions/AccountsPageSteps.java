package stepdefinitions;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountsPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;
    private String title;

    @Given("User has already logged in to the Application")
    public void user_has_already_logged_in_to_the_application(DataTable credTable) {
        List<Map<String,String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accountsPage = loginPage.doLogin(userName,password);

    }

    @Given("User is on Accounts page")
    public void user_is_on_accounts_page() {
        title = accountsPage.getAccountsPageTitle();
        System.out.println("Tile of the page is: "+title);
    }

    @When("User gets the Title of the page")
    public void user_gets_the_title_of_the_page() {
        title = accountsPage.getAccountsPageTitle();
        System.out.println("Tile of the page is: "+title);
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        Assert.assertTrue(title.contains(expectedTitle));
    }

    @Then("User gets Accounts section")
    public void user_gets_accounts_section(DataTable sectionsTable) {
        List<String> expAccountSectionsList = sectionsTable.asList();
        System.out.println("Expected accounts section list: "+expAccountSectionsList);

        List<String> actualAccountSectionsList = accountsPage.getAccountsSectionList();

        Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));
    }

    @Then("Accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expectedSectionsCount) {
        Assert.assertTrue(accountsPage.getAccountSectionsCount() == expectedSectionsCount);
    }
}




















