package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap.ObjectFactory;
import soap.SecureResponseTest;

@Endpoint
public class SecureControllerSoap {

    private static final String NAMESPACE_URI = "https://www.praca_magister/soap_vs_rest/secure.com";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SecureRequestTest")
    @ResponsePayload
    public SecureResponseTest secure(@RequestPayload soap.SecureRequestTest request) {
        soap.ObjectFactory objectFactory=new ObjectFactory();
        SecureResponseTest secureResponseTest = new SecureResponseTest();
        secureResponseTest.setMessage("SECURED");
        return secureResponseTest;
    }


}


