package com.qrcode.generator.test.steps;

import com.qrcode.web.services.generator.Application;
import com.qrcode.web.services.generator.model.Pillar;
import com.qrcode.web.services.generator.model.PillarQrCodeInformation;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.InputStreamResource;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by grijesh - 14/1/17.
 */

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
public class QrCodeFunctionalTest {

    private static final Logger logger = LoggerFactory.getLogger(QrCodeFunctionalTest.class);
    private PillarQrCodeInformation pillarQrCodeInformation;
    private String base64String;
    private InputStreamResource streamResource;


    @Autowired
    private TestRestTemplate restTemplate;

    @When("^I create PillarQrCodeInformation with pillar details \"([^\"]*)\" (\\d+) and qr code details (.+) (.+)$")
    public void i_create_PillarQrCodeInformation_with_pillar_details_and_qr_code_details(String name, int capacity, int width, int height) throws Throwable {
        Pillar pillar = new Pillar();
        pillar.setPillarName(name);
        pillar.setCapacity(capacity);

        pillarQrCodeInformation = new PillarQrCodeInformation();
        pillarQrCodeInformation.setImageHeight(height);
        pillarQrCodeInformation.setImageWidhth(width);
        pillarQrCodeInformation.setPillar(pillar);
    }

    @When("^I create PillarQrCodeInformation with qr code details (.+) (.+)$")
    public void i_create_PillarQrCodeInformation_with_qr_code_details(int width, int height) throws Throwable {
        pillarQrCodeInformation = new PillarQrCodeInformation();
        pillarQrCodeInformation.setImageHeight(height);
        pillarQrCodeInformation.setImageWidhth(width);
    }

    @When("^I hit the webservice with above details$")
    public void i_hit_the_webservice_with_above_details() throws Throwable {
            this.base64String = restTemplate.postForObject("/qrcode/base64", pillarQrCodeInformation, String.class);
    }

    @Then("^Result should be \"([^\"]*)\"$")
    public void result_should_be(String result) throws Throwable {
        Assert.assertTrue(base64String.equals(result));
    }

    @Then("^webservice should throw an exception \"([^\"]*)\"$")
    public void webservice_should_throw_an_exception(String result) throws Throwable {
        JSONObject apiResponse = (JSONObject) new JSONParser().parse(this.base64String);
        logger.debug("Exception From API is : {}",apiResponse.get("message"));
        Assert.assertTrue(String.valueOf(apiResponse.get("message")).equalsIgnoreCase(result));
    }

    @When("^I hit the stream webservice with above details$")
    public void i_hit_the_stream_webservice_with_above_details() throws Throwable {
        streamResource = restTemplate.postForObject("/qrcode/image", pillarQrCodeInformation, InputStreamResource.class);
    }

    @Then("^Result should not be null$")
    public void result_should_not_be_null() throws Throwable {
        Assert.assertNotNull(streamResource);
    }
}
