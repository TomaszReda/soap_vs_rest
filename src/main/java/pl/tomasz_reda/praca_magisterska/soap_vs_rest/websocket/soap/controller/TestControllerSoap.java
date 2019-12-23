package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TestControllerSoap {

    private static final String NAMESPACE_URI = "https://www.praca_magister/soap_vs_rest/test.com";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TestRequest")
    @ResponsePayload
    public void test(@RequestPayload soap.TestRequest request) {
        System.err.println("soap");
    }
}
