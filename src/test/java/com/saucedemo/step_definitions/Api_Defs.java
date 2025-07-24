package com.saucedemo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import com.saucedemo.utilities.ApiUtils;

public class Api_Defs {
    @And("Get api response")
    public void getApiResponse() {
        JsonPath petJson = ApiUtils.getPetWithPetid(3);

        //String petName = petJson.getString("category.name");
        String petName = petJson.getString("name");
        System.out.println("petName = " + petName);

        JsonPath petPostJson = ApiUtils.postPetWithPetid(1);


    }

    @And("post api response")
    public void postApiResponse() {

        JsonPath petPostJson = ApiUtils.postPetWithPetid(1);

        petPostJson.prettyPrint();

    }

    @Then("verify data")
    public void verifyData() {
        System.out.println("Wip");
    }
}
