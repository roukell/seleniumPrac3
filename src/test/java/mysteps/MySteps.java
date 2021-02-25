package mysteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MySteps {

    @Given("^I have (.+) of eggs$")
    public void i_have_of_eggs(String startingnumber) throws Throwable {
        System.out.println("print me");
    }

    @When("^I count the eggs$")
    public void i_count_the_eggs() throws Throwable {
        System.out.println("hello");
    }

    @Then("^I should have (.+) more eggs$")
    public void i_should_have_more_eggs(String finalnumber) throws Throwable {
        System.out.println("world");
    }

    @And("^I have had (.+) eggs$")
    public void i_have_had_eggs(String consumed) throws Throwable {
        System.out.println("hihi");
    }

}
