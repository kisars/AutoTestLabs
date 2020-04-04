package org.kiselev;

import static org.hamcrest.Matchers.*;

import io.restassured.config.EncoderConfig;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private  String url = "https://chat.kiselevaa.ru/api/v1";
    @Test
    public void TestVersion()
    {
       given().
               when().get(url+"/info").
                    then().
                        assertThat().
                        body("info.version",equalTo("3.0.4"));
    }


    @Test
    public void TestLogin()
    {
        RestAssured.baseURI=url;
        ValidatableResponse request = RestAssured.given().config(RestAssured.config()
                .encoderConfig(EncoderConfig.encoderConfig()
                        .encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("user", "test")
                .formParam("password","uniquepass").
        request().post("/login").
                        then().assertThat().body("status",equalTo("success"));
    }
}

