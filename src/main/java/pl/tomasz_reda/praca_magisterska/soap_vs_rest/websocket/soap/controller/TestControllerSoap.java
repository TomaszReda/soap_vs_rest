package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap.TestRequest;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class TestControllerSoap {

    private static final String NAMESPACE_URI = "https://www.praca_magister/soap_vs_rest/test.com";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TestRequestSendOnly")
    public void test(@RequestPayload soap.TestRequestSendOnly request) {

    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TestRequestSendAndReceiv")
    @ResponsePayload
    public List<soap.TestRequestSendAndReceiv> test2(@RequestPayload soap.TestRequestSendAndReceiv request) {
        List<soap.TestRequestSendAndReceiv> testRequests = new ArrayList<>();
        testRequests.add(request);
        testRequests.add(request);
        return testRequests;
    }

}
