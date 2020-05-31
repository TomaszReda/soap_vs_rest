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
        SpringApplication.run(SoapVsRestApplication.class, args);
    }
}
