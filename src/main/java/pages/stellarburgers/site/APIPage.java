package pages.stellarburgers.site;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class APIPage {
    @Step("Create test user")
    public ValidatableResponse createUser(String email, String password, String name) {
        return given()
                .contentType(ContentType.JSON)
                .and()
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\", \"name\": \"" + name + "\"}")
                .when()
                .post("/api/auth/register").then();
    }
    @Step("Enter account test user")
    public ValidatableResponse loginUser(String email, String password) {
        return given()
                .contentType(ContentType.JSON)
                .and()
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                .when()
                .post("/api/auth/login").then();
    }
    @Step("Delete test user")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .contentType(ContentType.JSON)
                .auth().oauth2(accessToken)
                .when()
                .delete("/api/auth/user").then();
    }
}
