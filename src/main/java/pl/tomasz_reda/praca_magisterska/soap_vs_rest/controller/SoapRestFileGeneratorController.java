package pl.tomasz_reda.praca_magisterska.soap_vs_rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/api/generateTestFile")
@Slf4j
public class SoapRestFileGeneratorController {

    @GetMapping
    @ResponseBody
    public String generateFile() {
        List<Integer> czynniki = Arrays.asList(1, 10, 100, 1000, 10000, 25000, 50000, 100000);
        for (int c : czynniki) {
            log.info("czynnik:" + c);
            if (c != 0) {
                genereateSoap("TestRequestSendOnly", c + "TestRequestSendOnly", "body_send_soap/", c);
                genereateSoap("TestRequestSendAndReceivRequest", c + "TestRequestSendAndReceivRequest", "body_send_and_receive_soap/", c);
                generateRest(c);
            }
        }
        return "generated";
    }

    private static void genereateSoap(String nameRequest, String nameFile, String body, int czynnik) {
        String json = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:sch=\"https://www.praca_magister/soap_vs_rest/test.com\">\n" +
                "<soapenv:Header>\n" +
                "  <wsse:Security \n" +
                "    xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" \n" +
                "    xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"\n" +
                "    soapenv:mustUnderstand=\"1\">\n" +
                "    <wsse:UsernameToken xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "      <wsse:Username>admin</wsse:Username>\n" +
                "      <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">secret</wsse:Password>\n" +
                "    </wsse:UsernameToken>\n" +
                "\t<wsu:Timestamp xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "\t</wsu:Timestamp>\n" +
                "  </wsse:Security>\n" +
                "</soapenv:Header>\n" +
                "<soapenv:Body>\n" +
                "<sch:" + nameRequest + ">" +
                "<sch:testObjectMain>";
        String constText = "";
        for (int i = 0; i < czynnik; i++) {
            constText += " a";
        }
        for (int i = 1; i <= 100; i++) {
            json += "<sch:field" + i + ">" + constText + "</sch:field" + i + ">\n";
        }

        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j < 20; j++) {

                json += "<sch:list" + i + ">" + constText + "</sch:list" + i + ">\n";
            }
        }

        String testObjectTekst = "";
        for (int i = 0; i < czynnik; i++) {
            testObjectTekst += "a ";
        }
        for (int i = 1; i <= 2; i++) {
            json += "<sch:testOtherObject" + i + ">\n";
            for (int j = 1; j <= 4; j++) {
                if (j == 4) {
                    for (int e = 0; e < 20; e++) {

                        json += "<sch:list>" + testObjectTekst + "</sch:list>\n";

                    }
                } else {
                    json += "<sch:testField" + j + ">" + testObjectTekst + "</sch:testField" + j + ">\n";
                }
            }
            json += "</sch:testOtherObject" + i + ">\n";

        }
        json += "</sch:testObjectMain>\n";
        json += "\n</sch:" + nameRequest + ">\n" +
                "</soapenv:Body>\n" +
                "</soapenv:Envelope>";


        String yourfilename = "./jmeter/" + body + nameFile + "SOAP.txt";
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(yourfilename));
            writer.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
            }
        }

    }

    private static void generateRest(int czynnik) {
        String json = "";
        json += "{\n";
        String constText = "";
        Random random = new Random();
        for (int i = 0; i < czynnik; i++) {
            constText += " a";
        }
        for (int i = 1; i <= 100; i++) {
            json += "\"field" + i + "\": \"" + constText + "\",\n";
        }

        for (int i = 1; i <= 2; i++) {
            json += "\"list" + i + "\":[";
            for (int j = 0; j < 20; j++) {

                if (j == 19)
                    json += "\"" + constText + "\"";
                else {
                    json += "\"" + constText + "\",";
                }
            }
            json += "],\n";
        }

        String testObjectTekst = "";
        for (int i = 0; i < czynnik; i++) {
            testObjectTekst += "a ";
        }
        for (int i = 1; i <= 2; i++) {
            json += "\"testOtherObject" + i + "\": \n{\n";
            for (int j = 1; j <= 4; j++) {
                if (j == 4) {
                    json += "\"list\":[";
                    for (int e = 0; e < 20; e++) {

                        if (e == 19)
                            json += "\"" + testObjectTekst + "\"";
                        else {
                            json += "\"" + testObjectTekst + "\",";
                        }
                    }
                    json += "]\n}";
                } else {
                    json += "\"testField" + j + "\": \"" + testObjectTekst + "\",\n";
                }
            }
            if (i == 1) {
                json += ",\n";
            }
        }
        json += "\n}";


        String yourfilename = "./jmeter/body_rest/" + czynnik + "testREST.txt";
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(yourfilename));
            writer.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
            }
        }

    }




}
