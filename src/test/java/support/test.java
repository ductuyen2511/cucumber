package support;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.notNullValue;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.verification.FindRequestsResult;
import com.github.tomakehurst.wiremock.verification.LoggedRequest;
import io.restassured.RestAssured;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test {
    public static WireMockServer wireMockServer;

    @Test
    public void TC_01(){
        RestAssured.given().body("{\n" +
                "    \"username\": \"test123\",\n" +
                "    \"password\": \"123456\"\n" +
                "}").post("/v1/one").then().extract().response();
        getRequestFromPath(wireMockServer, "/v1/one", 1);
    }


    public List<LoggedRequest> getRequestFromPath(WireMockServer wireMockServer, String path, int timeout){
        FindRequestsResult requestsResult = await().during(timeout, TimeUnit.SECONDS).until(() -> wireMockServer.findRequestsMatching(WireMock.anyRequestedFor(WireMock.urlMatching(path)).build()), notNullValue());
        return requestsResult.getRequests();
    }

    public static void main(String[] arg){
        wireMockServer = new WireMockServer(options().port(8989).usingFilesUnderClasspath("src/test/resources"));
        wireMockServer.start();
    }
}
