package pl.tomasz_reda.praca_magisterska.soap_vs_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class AngularController {

    public static final String HOME_PAGE = "forward:/index.html";

    private String page() {
        return HOME_PAGE;
    }
}
