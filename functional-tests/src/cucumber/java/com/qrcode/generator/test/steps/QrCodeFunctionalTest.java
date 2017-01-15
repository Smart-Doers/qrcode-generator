package com.qrcode.generator.test.steps;

import com.qrcode.web.services.generator.Application;
import com.qrcode.web.services.generator.model.Pillar;
import com.qrcode.web.services.generator.model.PillarQrCodeInformation;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by grijesh - 14/1/17.
 */

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
public class QrCodeFunctionalTest {

    private PillarQrCodeInformation pillarQrCodeInformation;
    private String base64String;
    @Autowired
    private TestRestTemplate restTemplate;

    @When("^I create PillarQrCodeInformation with pillar details \"([^\"]*)\" (\\d+) and qr code details (\\d+) (\\d+)$")
    public void i_create_PillarQrCodeInformation_with_pillar_details_and_qr_code_details(String name, int capacity, int width, int height) throws Throwable {
        Pillar pillar = new Pillar();
        pillar.setPillarName(name);
        pillar.setCapacity(capacity);

        pillarQrCodeInformation = new PillarQrCodeInformation();
        pillarQrCodeInformation.setImageHeight(height);
        pillarQrCodeInformation.setImageWidhth(width);
        pillarQrCodeInformation.setPillar(pillar);

    }


    @When("^I hit the webservice with above details$")
    public void i_hit_the_webservice_with_above_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.base64String = restTemplate.postForObject("/qrcode/base64", pillarQrCodeInformation, String.class);
    }

    @Then("^Result should be \"([^\"]*)\"$")
    public void result_should_be(String result) throws Throwable {
        System.out.println(" Testing,,,,,,,,,,,,,,,asdasdas"+base64String);
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(base64String.equals(result));

    }

}
