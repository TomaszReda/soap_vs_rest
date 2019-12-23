package pl.tomasz_reda.praca_magisterska.soap_vs_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
@EnableCaching
public class SoapVsRestApplication {

    public static void main(String[] args) throws Exception {

        String json = "";
//        json += "{\n";
//        String constText = "";
//        for (int i = 0; i < 15000; i++) {
//            constText += " a";
//        }
//        for (int i = 1; i <= 300; i++) {
//            if (i == 300) {
//                json += "\"field" + i + "\": \"" + constText + "\"";
//            } else {
//                json += "\"field" + i + "\": \"" + constText + "\",\n";
//            }
//        }
//        json += "\n}";
//        System.err.println(json);


        json += "{\n";
        String constText = "";
        for (int i = 0; i < 15000; i++) {
            constText += " a";
        }
        for (int i = 1; i <= 300; i++) {
            json += "<sch:field" + i + ">" + constText + "</sch:field" + i + ">\n";
        }
        json += "\n}";
        System.err.println(json);

        System.err.println(json);


        String yourfilename = "test.txt";
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
