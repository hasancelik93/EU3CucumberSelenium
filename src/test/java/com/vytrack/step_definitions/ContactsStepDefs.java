package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) throws InterruptedException {
       //go to login page

        Driver.get().get(ConfigurationReader.get("url"));

        //based on input enter that user information
        Thread.sleep(2000);
        String username = null;
        String password = null;

        if(userType.equals("driver")){
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        }else if (userType.equals("sales manager")){

            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");

        }else if (userType.equals("store manager")){

            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");

        }
        // send username and password and login
        new LoginPage().login(username,password);


    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {

        BrowserUtils.waitFor(2);
        //System.out.println(menuOptions.size());
        //System.out.println(menuOptions);
        //get the list of webelement and convert them to list of string and assert

        //this method gives you list of webelement you need to convert them to string to compare them
        //new DashboardPage().menuOptions + them use alt+enter it gives you list of web element
        // we need list of string so we change the type
        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);

        Assert.assertEquals(menuOptions,actualOptions);

        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);



    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userInfo) {
        System.out.println(userInfo);

        //use map information to login and also verify firstname and lastname

        //login with map info
        new LoginPage().login(userInfo.get("username"),userInfo.get("password"));
        // verify firstname and lastname
        String actualUsername = new DashboardPage().getUserName();
        String expectedUsername = userInfo.get("firstname")+" "+userInfo.get("lastname");

        Assert.assertEquals(expectedUsername,actualUsername);

        System.out.println("expectedUsername = " + expectedUsername);
        System.out.println("actualUsername = " + actualUsername);
    }




}
