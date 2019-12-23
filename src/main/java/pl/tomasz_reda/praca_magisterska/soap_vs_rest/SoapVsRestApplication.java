package pl.tomasz_reda.praca_magisterska.soap_vs_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

@SpringBootApplication
@EnableCaching
public class SoapVsRestApplication {

    public static void main(String[] args) throws Exception {

        String json = "";
        json += "{\n";
        String constText = "";
        Random random = new Random();
        int czynnik=100000;
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
            if(i==1){
                json+=",\n";
            }
        }


        json += "\n}";
        System.err.println(json);


        String yourfilename = "testRest.txt";
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

        SpringApplication.run(SoapVsRestApplication.class, args);
    }

}
