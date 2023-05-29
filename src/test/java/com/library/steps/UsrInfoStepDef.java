package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class UsrInfoStepDef {

    String expectedUserCount;
    String actualUserCount;

    List<String> actualList;

    @Given("Establish the database connection")
    public void establish_the_database_connection() {

        //mAKE COON WITH DATABASE
        // DB_Util.createConnection();

        System.out.println("*********************************************");
        System.out.println("***CONNECTION WILL BE DONE WITH HOOK CLASS***");
        System.out.println("*********************************************");
    }

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {

        String query = "select count(id) from users";
        DB_Util.runQuery(query);

        actualUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualUserCount = " + actualUserCount);

    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {

        String query = "select count(distinct id) from users";

        expectedUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedUserCount = " + expectedUserCount);

        //MAKE ASSERTIONS
        Assert.assertEquals(expectedUserCount, actualUserCount);


        //CLOSE CONNECTION
        //DB_Util.destroy();

        System.out.println("*********************************************");
        System.out.println("***DESTROY CONN WILL BE DONE WITH HOOK CLASS***");
        System.out.println("*********************************************");

    }

    //US01-2
    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        DB_Util.runQuery("select * from users");
        actualList = DB_Util.getAllColumnNamesAsList();
        System.out.println("actualList = " + actualList);


    }


    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> expectedList) {

        System.out.println("expectedList = " + expectedList);
        //Assertions
        Assert.assertEquals(expectedList,actualList);

    }


}
