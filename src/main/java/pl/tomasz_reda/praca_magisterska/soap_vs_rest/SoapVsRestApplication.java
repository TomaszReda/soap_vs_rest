package pl.tomasz_reda.praca_magisterska.soap_vs_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableCaching
public class SoapVsRestApplication {

    public static void main(String[] args) throws Exception {
        List<Integer> czynniki = Arrays.asList(1, 10, 100, 1000, 10000);
//        List<Integer> czynniki = Arrays.asList(0);
        for (int c : czynniki) {
            System.err.println(c);
            if (c != 0) {
                genereateSoap("TestRequestSendOnly", c + "TestRequestSendOnly", "body_send_soap/", c);
                genereateSoap("TestRequestSendAndReceivRequest", c + "TestRequestSendAndReceivRequest", "body_send_and_receive_soap/", c);
                generateRest(c);
            }
        }
        SpringApplication.run(SoapVsRestApplication.class, args);
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
