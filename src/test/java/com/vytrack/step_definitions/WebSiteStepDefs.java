package com.vytrack.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebSiteStepDefs {

    @Given("user is on the website")
    public void user_is_on_the_website() {
        System.out.println("user on the page");
    }

    @When("user search in website")
    public void user_search_in_website() {
        System.out.println("user is using search bar ");
    }

    @Then("user should be able to see results")
    public void user_should_be_able_to_see_results() {
        System.out.println("user sees results");
    }
}
