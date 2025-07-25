package com.saucedemo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import com.saucedemo.utilities.ApiUtils;
import org.junit.Assert;

public class Api_Defs {

    @And("POST Data By API")
    public void post_data_by_api() {

        JsonPath petPostJson = ApiUtils.postPetWithPetid(99999);
        petPostJson.prettyPrint();

    }

    @And("GET Data By API")
    public void get_data_by_api() {
        JsonPath petJson = ApiUtils.getPetWithPetid(99999);

        String petName = petJson.getString("name");
        System.out.println("petNameAfterGET = " + petName);
        String petStatus = petJson.getString("status");
        System.out.println("petStatusAfterGET = " + petStatus);

        Assert.assertEquals("CuteFluffy",petName);
        Assert.assertEquals("available",petStatus);

    }

    @And("PUT Data By API")
    public void put_data_by_api() {
        JsonPath petPutJson = ApiUtils.putPetWithPetid(99999);
        petPutJson.prettyPrint();

        String petName = petPutJson.getString("name");
        System.out.println("petNameAfterPUT = " + petName);
        String petStatus = petPutJson.getString("status");
        System.out.println("petStatusAfterPUT = " + petStatus);

        Assert.assertEquals("FluffyCute",petName);
        Assert.assertEquals("sold",petStatus);

    }

    @And("DELETE Data By API")
    public void delete_data_by_api() {
        JsonPath petDelJson = ApiUtils.delPetWithPetid(99999);
        petDelJson.prettyPrint();

    }

    @Then("Verify data Deleted")
    public void verify_data_deleted() {
        JsonPath verifyPetDeletedJson = ApiUtils.verifyDeletedDataWithPetid(99999);
        verifyPetDeletedJson.prettyPrint();

        String message = verifyPetDeletedJson.getString("message");
        System.out.println("Message = " + message);

        Assert.assertEquals("Pet not found",message);

    }


}
